package lt.demo.task2_1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Node {
    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    private Node parent;
    private List<Node> children = new ArrayList<>();
    private String name;

    public void addChild(Node child) {
        Objects.requireNonNull(child, "child cannot be null in addChild.");

        children.add(child);
        child.setParent(this);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;

        if (children == null) {
            return;
        }

        for (Node child : children) {
            child.setParent(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(getName(), node.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
