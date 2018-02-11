package lt.demo.task2_1.service.generator;

import lt.demo.task2_1.model.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TreeGenerator {
    // created for assigning unique tree names.
    private static int generatedCounter = 1;

    public static Node generateRandom(int numberOfNodes) {
        Node root = new Node("root");
        Node result = generateRandomInternal(root, numberOfNodes - 1);

        generatedCounter = 1;

        return result;
    }

    private static Node generateRandomInternal(Node root, int numberOfNodes) {
        Random random = new Random();
        int generated = 0;

        for (; generated < numberOfNodes; generated++) {
            // let's say prob. to generate branch is 1/3
            int randomNumber = random.nextInt(3);
            boolean generateBranch = randomNumber == 1;

            if (generateBranch) {
                generatedCounter++;
                Node childBranchRoot = new Node("Branch " + generatedCounter);

                int howMuchToGenerate = random.nextInt(numberOfNodes - generated) + 1;
                childBranchRoot = generateRandomInternal(childBranchRoot, howMuchToGenerate);

                generatedCounter++;
                root.addChild(childBranchRoot);
                generated += howMuchToGenerate;
            } else {
                generatedCounter++;
                Node childNode = new Node(String.valueOf(generatedCounter));
                root.addChild(childNode);
            }
        }

        return root;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 structure.
    public static Node getSimpleDeepStructure() {
        Node child1 = new Node("1");
        Node child2 = new Node("2");
        Node child3 = new Node("3");
        Node child4 = new Node("4");
        Node child5 = new Node("5");
        Node child6 = new Node("6");

        child1.setChildren(Collections.singletonList(child2));
        child2.setChildren(Collections.singletonList(child3));
        child3.setChildren(Collections.singletonList(child4));
        child4.setChildren(Collections.singletonList(child5));
        child5.setChildren(Collections.singletonList(child6));

        return child1;
    }

    //           root
    // A          B            C
    //                   D     E     F
    public static Node getSimpleThreeLevelRoot() {
        Node root = new Node("root");

        Node child1 = new Node("A");
        Node child2 = new Node("B");
        Node child3 = new Node("C");

        Node child21 = new Node("D");
        Node child22 = new Node("E");
        Node child23 = new Node("F");

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

    /**
     * Structure sent in an example output
     * @return root node.
     */
    public static Node getExampleStructure() {
        Node root = new Node("root");

        Node child1 = new Node("A");
        Node child2 = new Node("B");
        Node child3 = new Node("C");
        Node child4 = new Node("D");

        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);
        root.addChild(child4);


        // first node branch
        Node child11 = new Node("E");
        Node child12 = new Node("F");

        child1.addChild(child11);
        child1.addChild(child12);

        Node child121 = new Node("G");

        child12.addChild(child121);

        // second node branch
        Node child21 = new Node("H");
        Node child22 = new Node("I");

        child2.addChild(child21);
        child2.addChild(child22);

        // third node branch
        Node child32 = new Node("J");
        Node child33 = new Node("K");
        Node child31 = new Node("L");

        child3.addChild(child31);
        child3.addChild(child32);
        child3.addChild(child33);

        Node child321 = new Node("M");
        Node child322 = new Node("N");

        child32.addChild(child321);
        child32.addChild(child322);

        return root;
    }
}
