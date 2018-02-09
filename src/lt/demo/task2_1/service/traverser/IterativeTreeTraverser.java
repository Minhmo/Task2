package lt.demo.task2_1.service.traverser;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.def.TreeTraverser;

import java.util.*;

/**
 * Class, that can traverse a tree iteratively.
 */
public class IterativeTreeTraverser implements TreeTraverser {
    private Printer printer;
    private Formatter treeFormatter;

    private boolean printOutput = true;

    public IterativeTreeTraverser(Printer printer, Formatter treeFormatter) {
        this.printer = printer;
        this.treeFormatter = treeFormatter;

        treeFormatter.clear();
    }

    /**
     * high level code wrapper.
     *
     * @param root root node of a tree.
     */
    @Override
    public Collection<String> traverse(Node root) {
        Objects.requireNonNull(root, "root cannot be null");

        if (!isTreeCorrect(root)) {
            throw new IllegalArgumentException("given tree is incorrect!");
        }

        final Collection<String> visited = traverseInternal(root);

        if (printOutput) {
            printer.print(treeFormatter.getFormattedText());
        }

        return visited;
    }

    @Override
    public void setPrintOutput(boolean printOutput) {
        this.printOutput = printOutput;
    }

    /**
     * Iterative Depth firs tree traversal.
     * @param root root of the tree.
     */
    private Collection<String> traverseInternal(Node root) {
        Stack<Node> nodesToVisit = new Stack<Node>();
        List<String> visited = new ArrayList<>();

        nodesToVisit.push(root);
        int depth = 0;

        treeFormatter.append(root.getName(), depth, 1);

        while (!nodesToVisit.empty()) {
            Node currentNodeToVisit = nodesToVisit.pop();

            // back from lower level, should decrease counter.
            if (visited.contains(currentNodeToVisit.getName())) {
                depth--;
                continue;
            }

            visited.add(currentNodeToVisit.getName());
            List<Node> children = currentNodeToVisit.getChildren();

            if (children.isEmpty()) {
                continue;
            }

            depth++;

            // puts itself back, in order to know when decrease depth
            nodesToVisit.push(currentNodeToVisit);

            pushToStackInReverseOrder(nodesToVisit, children);
            appendChildren(children, depth);
        }

        return visited;
    }

    /**
     * Pushes children to stack in reverse order, so it would start next level from
     * the actual first element;
     * @param nodesToVisit
     * @param children
     */
    private void pushToStackInReverseOrder(Stack<Node> nodesToVisit, List<Node> children) {
        for (int i = children.size() - 1; i >= 0; i--) {
            nodesToVisit.push(children.get(i));
        }
    }

    private void appendChildren(List<Node> children, int depth) {
        int index = 1;
        for (Node child : children) {
            treeFormatter.append(child.getName(), depth, index);
            index++;
        }
    }

    /**
     * Checks, whether given tree is correct tree.
     *
     * @param root root element of a tree
     * @return true if tree is correct.
     */
    private boolean isTreeCorrect(Node root) {
        Stack<Node> nodesToVisit = new Stack<Node>();
        List<String> visited = new ArrayList<>();

        nodesToVisit.push(root);


        while (!nodesToVisit.empty()) {
            Node currentNodeToVisit = nodesToVisit.pop();

            // back from lower level, should decrease counter.
            if (visited.contains(currentNodeToVisit.getName())) {
                return false;
            }

            visited.add(currentNodeToVisit.getName());
            List<Node> children = currentNodeToVisit.getChildren();

            if (children.isEmpty()) {
                continue;
            }

            children.forEach(node -> nodesToVisit.push(node));

        }

        return true;
    }
}
