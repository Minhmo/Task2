package lt.demo.tests.test;

import lt.demo.task2_1.TreeMain;
import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.def.TreeTraverser;
import lt.demo.task2_1.service.format.TreeFormatter;
import lt.demo.task2_1.service.printer.ConsolePrinter;
import lt.demo.task2_1.service.traverser.IterativeTreeTraverser;
import lt.demo.task2_1.service.traverser.RecursiveTreeTraverser;

import java.util.Arrays;
import java.util.Collection;

public class TreeTests extends TestBase {

    private TreeFormatter formatter = new TreeFormatter();
    private Printer printer = new ConsolePrinter();

    @Override
    public void run() {
        testRecursiveTraversal();
        testIterativeTraversal();
        testIterativeThreeLevelStructureTraversal();
        testRecursiveThreeLevelStructureTraversal();
    }

    private void testRecursiveTraversal() {
        printer.print("Running Recursive tree test with deep structure.");
        Node root = TreeMain.getSimpleDeepStructure();
        TreeFormatter treeFormatter = new TreeFormatter();

        //firstly, traversing recursively.
        TreeTraverser traverser = new RecursiveTreeTraverser(printer, treeFormatter);
        traverser.setPrintOutput(false);

        final Collection<String> visited = traverser.traverse(root);

        assert visited.equals(Arrays.asList("1", "2", "3", "4", "5", "6")) : "Expected and actual paths are not equal!";

        printer.print("Success!");
    }

    private void testIterativeTraversal() {
        printer.print("Running Iterative tree test with deep structure.");
        Node root = TreeMain.getSimpleDeepStructure();

        //firstly, traversing recursively.
        TreeTraverser traverser = new IterativeTreeTraverser(printer, formatter);
        traverser.setPrintOutput(false);

        final Collection<String> visited = traverser.traverse(root);
        traverser.setPrintOutput(false);

        assert visited.equals(Arrays.asList("1", "2", "3", "4", "5", "6"));

        printer.print("Success!");
    }

    private void testRecursiveThreeLevelStructureTraversal() {
        printer.print("Running Recursive tree test with three level structure.");
        Node root = TreeMain.getSimpleThreeLevelRoot();
        TreeFormatter treeFormatter = new TreeFormatter();

        //firstly, traversing recursively.
        TreeTraverser traverser = new RecursiveTreeTraverser(printer, treeFormatter);
        traverser.setPrintOutput(false);

        final Collection<String> visited = traverser.traverse(root);

        assert visited.equals(Arrays.asList("root", "first", "sec", "third", "third first", "third sec", "third third"));

        printer.print("Success!");
    }

    private void testIterativeThreeLevelStructureTraversal() {
        printer.print("Running Iterative tree test with three level structure.");
        Node root = TreeMain.getSimpleThreeLevelRoot();

        //firstly, traversing recursively.
        TreeTraverser traverser = new IterativeTreeTraverser(printer, formatter);
        traverser.setPrintOutput(false);

        final Collection<String> visited = traverser.traverse(root);
        traverser.setPrintOutput(false);

        assert visited.equals(Arrays.asList("root", "first", "sec", "third", "third first", "third sec", "third third"));

        printer.print("Success!");
    }
}
