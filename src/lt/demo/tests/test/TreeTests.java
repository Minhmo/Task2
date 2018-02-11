package lt.demo.tests.test;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.FormatterFactory;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.def.TreeTraverser;
import lt.demo.task2_1.service.generator.TreeGenerator;
import lt.demo.task2_1.service.printer.ConsolePrinter;
import lt.demo.task2_1.service.traverser.IterativeTreeTraverser;
import lt.demo.task2_1.service.traverser.RecursiveTreeTraverser;

import java.util.Arrays;
import java.util.Collection;

public class TreeTests extends TestBase {
    public static final int NO_OF_TESTS = 100;
    public static final int NUMBER_OF_NODES = 20;

    private FormatterFactory formatterFactory;
    private Formatter formatter;
    private Printer printer = new ConsolePrinter();

    public TreeTests(FormatterFactory factory) {
        formatterFactory = factory;
        formatter = factory.getFormatter();
    }

    @Override
    public void run() {
        testRecursiveTraversal();
        testIterativeTraversal();
        testIterativeThreeLevelStructureTraversal();
        testRecursiveThreeLevelStructureTraversal();
        testTraverseOrderProperty();
    }

    private void testRecursiveTraversal() {
        printer.print("Running Recursive tree test with deep structure.");
        Node root = TreeGenerator.getSimpleDeepStructure();

        //firstly, traversing recursively.
        TreeTraverser traverser = new RecursiveTreeTraverser(formatter);

        final Collection<String> visited = traverser.traverse(root);

        assert visited.equals(Arrays.asList("1", "2", "3", "4", "5", "6")) : "Expected and actual paths are not equal!";

        printer.print("Success!");
    }

    private void testIterativeTraversal() {
        printer.print("Running Iterative tree test with deep structure.");
        Node root = TreeGenerator.getSimpleDeepStructure();

        //firstly, traversing recursively.
        TreeTraverser traverser = new IterativeTreeTraverser(formatter);

        final Collection<String> visited = traverser.traverse(root);

        assert visited.equals(Arrays.asList("1", "2", "3", "4", "5", "6"));

        printer.print("Success!\n");
    }

    private void testRecursiveThreeLevelStructureTraversal() {
        printer.print("Running Recursive tree test with three level structure.");
        Node root = TreeGenerator.getSimpleThreeLevelRoot();

        //firstly, traversing recursively.
        TreeTraverser traverser = new RecursiveTreeTraverser(formatter);

        final Collection<String> visited = traverser.traverse(root);

        assert visited.equals(Arrays.asList("root", "A", "B", "C", "D", "E", "F"));

        printer.print("Success!\n");
    }

    private void testIterativeThreeLevelStructureTraversal() {
        printer.print("Running Iterative tree test with three level structure.");
        Node root = TreeGenerator.getSimpleThreeLevelRoot();

        //firstly, traversing recursively.
        TreeTraverser traverser = new IterativeTreeTraverser(formatter);

        final Collection<String> visited = traverser.traverse(root);

        assert visited.equals(Arrays.asList("root", "A", "B", "C", "D", "E", "F"));

        printer.print("Success!\n");
    }

    /**
     * Simple property test for traverse order property.
     */
    private void testTraverseOrderProperty() {
        printer.print(String.format("Running quickcheck to test traverse order property with %d number of tests" +
                "with %d number of nodes in each tree.", NO_OF_TESTS, NUMBER_OF_NODES));

        TreeTraverser recursiveTreeTraverser = new RecursiveTreeTraverser(formatter);
        TreeTraverser iterativeTreeTraverser = new IterativeTreeTraverser(formatter);

        for (int i = 0; i < NO_OF_TESTS; i++) {
            Node root = TreeGenerator.generateRandom(NUMBER_OF_NODES);
            assert recursiveTreeTraverser.traverse(root).equals(iterativeTreeTraverser.traverse(root)) : "Traverse order is not the same!";
        }

        printer.print("Test is successful!\n");
    }
}
