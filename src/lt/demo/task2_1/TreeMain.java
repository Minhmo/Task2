package lt.demo.task2_1;

import lt.demo.task2_1.model.Node;
import lt.demo.task2_1.service.def.Printer;
import lt.demo.task2_1.service.format.TreeFormatter;
import lt.demo.task2_1.service.printer.ConsolePrinter;
import lt.demo.task2_1.service.traverser.IterativeTreeTraverser;
import lt.demo.task2_1.service.traverser.RecursiveTreeTraverser;
import lt.demo.task2_1.service.def.TreeTraverser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Responsible for dependencies and running.
 */
public class TreeMain {

    // simple main, to showcase functionality.
    public static void main(String[] args) {
        // init dependencies.
        Printer printer = new ConsolePrinter();
        TreeFormatter treeFormatter = new TreeFormatter();

        //get simple structure.
        Node root = getSimpleThreeLevelRoot();

        //firstly, traversing recursively.
        printer.print("Traversing recursively");
        TreeTraverser traverser = new RecursiveTreeTraverser(printer, treeFormatter);
        traverser.traverse(root);
        printer.print("\n");

        printer.print("Traversing iteratively");
        traverser = new IterativeTreeTraverser(printer, treeFormatter);
        traverser.traverse(root);
        printer.print("\n");
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 structure.
    public static Node getSimpleDeepStructure() {

        Node child1 = new Node();
        Node child2 = new Node();
        Node child3 = new Node();
        Node child4 = new Node();
        Node child5 = new Node();
        Node child6 = new Node();

        child1.setName("1");
        child2.setName("2");
        child3.setName("3");
        child4.setName("4");
        child5.setName("5");
        child6.setName("6");

        child1.setChildren(Collections.singletonList(child2));
        child2.setChildren(Collections.singletonList(child3));
        child3.setChildren(Collections.singletonList(child4));
        child4.setChildren(Collections.singletonList(child5));
        child5.setChildren(Collections.singletonList(child6));

        return child1;
    }

    //                 root
    // first          second            third
    //                    third first third second third third
    public static Node getSimpleThreeLevelRoot() {
        Node root = new Node();
        root.setName("root");

        Node child1 = new Node();
        Node child2 = new Node();
        Node child3 = new Node();

        Node child21 = new Node();
        Node child22 = new Node();
        Node child23 = new Node();

        child21.setName("third first");
        child22.setName("third sec");
        child23.setName("third third");

        child1.setName("first");
        child2.setName("sec");
        child3.setName("third");

        List<Node> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        children.add(child3);

        List<Node> children2 = new ArrayList<>();
        children2.add(child21);
        children2.add(child22);
        children2.add(child23);

        child3.setChildren(children2);
        root.setChildren(children);

        return root;
    }
}
