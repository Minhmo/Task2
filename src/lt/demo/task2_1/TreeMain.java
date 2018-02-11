package lt.demo.task2_1;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.factory.NumberFormatterFactory;
import lt.demo.task2_1.service.def.Formatter;
import lt.demo.task2_1.service.def.FormatterFactory;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.generator.TreeGenerator;
import lt.demo.task2_1.service.printer.ConsolePrinter;
import lt.demo.task2_1.service.traverser.IterativeTreeTraverser;
import lt.demo.task2_1.service.traverser.RecursiveTreeTraverser;
import lt.demo.task2_1.service.def.TreeTraverser;

/**
 * Responsible for dependencies and running.
 */
public class TreeMain {

    // simple main, to showcase functionality.
    public static void main(String[] args) {
        // init dependencies.
        FormatterFactory numberFormatterFactory = new NumberFormatterFactory();
        Printer printer = new ConsolePrinter();
        Formatter treeFormatter = numberFormatterFactory.getFormatter();

        //get simple structure.
        Node root = TreeGenerator.getExampleStructure();

        //firstly, traversing recursively.
        printer.print("Traversing recursively");
        TreeTraverser traverser = new RecursiveTreeTraverser(treeFormatter);
        traverser.traverse(root);
        printer.print(treeFormatter.getFormattedText());
        printer.print("\n");

        printer.print("Traversing iteratively");
        traverser = new IterativeTreeTraverser(treeFormatter);
        traverser.traverse(root);
        printer.print(treeFormatter.getFormattedText());
        printer.print("\n");

        printer.print("Traversing randomly generated tree iteratively");
        Node generatedTree = TreeGenerator.generateRandom(70);
        traverser.traverse(generatedTree);
        printer.print(treeFormatter.getFormattedText());
        printer.print("\n");
    }
}
