package lt.demo.task2_1.service.traverser;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.def.TreeTraverser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Class, that can traverse a tree iteratively.
 */
public class IterativeTreeTraverser implements TreeTraverser {
    private Formatter treeFormatter;

    public IterativeTreeTraverser(Formatter treeFormatter) {
        this.treeFormatter = treeFormatter;
    }

    /**
     * high level code wrapper.
     *
     * @param root root node of a tree.
     */
    @Override
    public Collection<String> traverse(Node root) {
        Objects.requireNonNull(root, "root cannot be null");

        final Collection<String> visited = traverseInternal(root);

        return visited;
    }

    /**
     * Iterative Depth firs tree traversal.
     *
     * @param root node of the tree.
     */
    private Collection<String> traverseInternal(Node root) {
        Stack<Node> nodesToVisit = new Stack<>();
        List<String> visited = new ArrayList<>();

        nodesToVisit.push(root);

        while (!nodesToVisit.empty()) {
            Node currentNodeToVisit = nodesToVisit.pop();

            checkForCorrectness(visited, currentNodeToVisit);
            visited.add(currentNodeToVisit.getName());

            // append node to formatter.
            if (currentNodeToVisit.getParent() != null) {
                appendToFormatter(currentNodeToVisit);
            }

            pushChildrenToStack(nodesToVisit, currentNodeToVisit);
        }

        return visited;
    }

    private void appendToFormatter(Node currentNodeToVisit) {
        treeFormatter.append(currentNodeToVisit.getName(), getFullNodeIndex(currentNodeToVisit));
    }

    private Collection<Integer> getFullNodeIndex(Node node) {
        ArrayList<Integer> result = new ArrayList<>();

        Node parent = node.getParent();
        result.add(getNodeIndex(node));

        while (parent != null) {
            result.add(getNodeIndex(parent));
            parent = parent.getParent();
        }

        // removing root index.
        result.remove(result.size() - 1);
        Collections.reverse(result);

        return result;
    }

    /**
     * Method, that checks if a current node of tree traversing does not brake the rules of a correct tree.
     *
     * @param visited            list of visited nodes
     * @param currentNodeToVisit the node, algorithm currently visiting.
     */
    private void checkForCorrectness(Collection<String> visited, Node currentNodeToVisit) {
        if (visited.contains(currentNodeToVisit.getName())) {
            throw new IllegalStateException("Incorrect tree! One node is accessible from more than one way.");
        }
    }

    /**
     * Method, that pushes children of currently traversed node to stack.
     *
     * @param nodesToVisit       stack of all nodes, that needs to be visited.
     * @param currentNodeToVisit the node, algorithm currently visiting.
     */
    private void pushChildrenToStack(Stack<Node> nodesToVisit, Node currentNodeToVisit) {
        List<Node> children = currentNodeToVisit.getChildren();

        if (children.isEmpty()) {
            return;
        }

        pushChildrenToStackInReverseOrder(nodesToVisit, children);
    }

    /**
     * Helper function, that gets the order index of currently visited node.
     *
     * @param node currently visited node
     * @return index of currently visited node.
     */
    private int getNodeIndex(Node node) {
        Objects.requireNonNull(node, "Node cannot be null in getNodeIndex.");

        Node parent = node.getParent();

        if (parent == null) {
            return 1;
        }

        int index = 1;

        for (Node childNode : parent.getChildren()) {
            if (childNode.equals(node)) {
                return index;
            }

            index++;
        }

        throw new IllegalStateException("Illegal state of a tree. Parent does not contain children");
    }

    /**
     * Helper function, that gets the level of currently visited node in a tree.
     *
     * @param node currently visited node
     * @return level of currently visited node.
     */
    private int getNodeLevel(Node node) {
        int depth = 0;
        Node parent = node.getParent();

        while (parent != null) {
            parent = parent.getParent();
            depth++;
        }

        return depth;
    }

    /**
     * Pushes children to stack in reverse order, so it would start next level from
     * the actual first element;
     *
     * @param nodesToVisit
     * @param children
     */
    private void pushChildrenToStackInReverseOrder(Stack<Node> nodesToVisit, List<Node> children) {
        for (int i = children.size() - 1; i >= 0; i--) {
            nodesToVisit.push(children.get(i));
        }
    }
}
