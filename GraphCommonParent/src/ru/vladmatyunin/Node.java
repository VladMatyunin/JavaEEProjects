package ru.vladmatyunin;

/**
 * Created by Vlad on 14.09.2017.
 */
public class Node {

    Node(int value){
        this.value = value;
    }
    private Node firstChild;

    private Node secondChild;

    private int value;

    public Node getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(Node firstChild) {
        this.firstChild = firstChild;
    }

    public Node getSecondChild() {
        return secondChild;
    }

    public void setSecondChild(Node secondChild) {
        this.secondChild = secondChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
