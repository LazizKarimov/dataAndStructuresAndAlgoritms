public class Nodes {
    private Nodes() {
    }

    public static <T> Node<T> create(T element) {
        Node<T> node = new Node<T>();
        node.element = element;
        node.next = null;
        return node;
    }

    public static <T> void link(Node<T> first, Node<T> second) {
        if (first != null || second != null) {
            first.next = second;
        }
    }

    public static <T> Node<T> pairOf(T firstElement, T secondElement) {
        Node<T> node = new Node<T>(firstElement);
        link(node, new Node<T>(secondElement));
        return node;
    }

    public static <T> Node<T> closedPairOf(T firstElement, T secondElement) {
        Node<T> node1 = new Node<T>(firstElement);
        Node<T> node2 = new Node<T>(secondElement);

        node1.next = node2;
        node2.next = node1;

        return node1;
    }

    public static <T> Node<T> chainOf(T... elements) {
        if (elements == null || elements.length == 0) {
            return null;
        }

        Node<T> firstNode = new Node<>(elements[0]);

        Node<T> currentNode = firstNode;

        for (int i = 1; i < elements.length; i++) {
            currentNode.next = new Node<>(elements[i]);
            currentNode = currentNode.next;
        }
        return firstNode;
    }

    public static <T> Node<T> circleOf(T... elements) {

        Node<T> firstNode = new Node<>(elements[0]);

        Node<T> currentNode = firstNode;

        for (int i = 1; i < elements.length; i++) {
            currentNode.next = new Node<>(elements[i]);
            currentNode = currentNode.next;
        }

        currentNode.next = firstNode;
        return firstNode;
    }
}
