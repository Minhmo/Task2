package lt.demo.task2_1.service.def;

import lt.demo.task2_1.model.Node;

import java.util.Collection;

public interface TreeTraverser {
    Collection<String> traverse(Node root);
    void setPrintOutput(boolean printOutput);
}
