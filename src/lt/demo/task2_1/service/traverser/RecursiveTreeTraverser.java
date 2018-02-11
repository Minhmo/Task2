package lt.demo.task2_1.service.traverser;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.def.TreeTraverser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Class, that traverses the tree recursively.
 */
public class RecursiveTreeTraverser implements TreeTraverser {
    private Formatter formatter;

    public RecursiveTreeTraverser(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Collection<String> traverse(Node root) {
        Objects.requireNonNull(root, "root node cannot be null.");

        ArrayList<String> visited = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
//        indexes.add(1);

        traverseInternal(root, 0, visited, indexes);

        return visited;
    }

    /**
     * Internal method for recursion
     *
     * @param root    of tree
     * @param depth   current depth
     * @param visited already visited nodes
     * @param indexes current index of node.
     */
    private void traverseInternal(Node root, int depth, List<String> visited, List<Integer> indexes) {
        checkTreeCorrectness(root, visited);

        // processing currently visited node.
        visited.add(root.getName());

        if (root.getParent() != null) {
            formatter.append(root.getName(), indexes);
        }

        if (root.getChildren().size() == 0) {
            return;
        }

        // as there are children, increasing depth.
        depth++;
        // as there are children, allocating new index.
        int newIndex = 1;
        indexes.add(newIndex);
        // continue recursion for children.
        for (Node childNode : root.getChildren()) {
            traverseInternal(childNode, depth, visited, new ArrayList<>(indexes));
            newIndex++;
            indexes.set(depth - 1, newIndex);
        }
    }

    /**
     * Method, that checks if a current node of tree traversing does not brake the rules of a correct tree.
     *
     * @param visited list of visited nodes
     * @param root    the node, algorithm currently visiting.
     */
    private void checkTreeCorrectness(Node root, List<String> visited) {
        // tree definition broken.
        // def: "n mathematics, and more specifically in graph theory, a tree is an undirected graph in which
        // any two vertices are connected by exactly one path.
        // In other words, any acyclic connected graph is a tree."
        if (visited.contains(root.getName())) {
            throw new IllegalStateException("incorrect tree.");
        }
    }
}
