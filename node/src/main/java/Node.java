package node.src.main.java;

public class Node<T> {
    // todo:
    public T element;
    public Node<T> next;

    public Node (){

    }

    public Node(T element) {
        this.element = element;
    }
}