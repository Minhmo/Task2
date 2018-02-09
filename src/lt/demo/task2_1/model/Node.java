package lt.demo.task2_1.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Node {
    private List<Node> children = Collections.emptyList();
    private String name;

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
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
