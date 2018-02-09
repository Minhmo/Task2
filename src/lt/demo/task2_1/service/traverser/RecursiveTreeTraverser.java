package lt.demo.task2_1.service.traverser;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.def.TreeTraverser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Class that traverse the tree recursively.
 */
public class RecursiveTreeTraverser implements TreeTraverser {
    private Printer printer;
    private Formatter formatter;
    private boolean printOutput = true;

    public RecursiveTreeTraverser(Printer printer, Formatter formatter) {
        this.printer = printer;
        this.formatter = formatter;

        formatter.clear();
    }

    @Override
    public Collection<String> traverse(Node root) {
        Objects.requireNonNull(root, "root node cannot be null.");

        ArrayList<String> visited = new ArrayList<>();
        traverseInternal(root, 0, visited, 1);

        if (printOutput) {
            printer.print(formatter.getFormattedText());
        }
        return visited;
    }

    /**
     * Internal method for recursion
     * @param root of tree
     * @param depth current depth
     * @param visited already visited nodes
     * @param index current index of node.
     */
    private void traverseInternal(Node root, int depth, List<String> visited, int index) {

        // tree definition broken.
        // def: "n mathematics, and more specifically in graph theory, a tree is an undirected graph in which
        // any two vertices are connected by exactly one path.
        // In other words, any acyclic connected graph is a tree."
        if (visited.contains(root.getName())) {
            // todo implement ex handler.
            throw new IllegalStateException("incorrect tree.");
        }

        visited.add(root.getName());

        formatter.append(root.getName(), depth, index);

        if (root.getChildren().size() == 0) {
            return;
        }

        // as there is children, increasing depth.
        depth++;
        // as there is children, allocating new index.
        int newIndex = 1;

        for(Node childNode : root.getChildren()) {
            traverseInternal(childNode, depth, visited, newIndex);
            newIndex++;
        }
    }

    public void setPrintOutput(boolean printOutput) {
        this.printOutput = printOutput;
    }
}
