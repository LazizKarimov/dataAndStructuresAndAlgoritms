package node.src.test.java;

import node.src.main.java.Node;
import node.src.main.java.Nodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

public class NodesTest {

    @Test
    public void testCreate() {
        Integer element = 5;
        Node<Integer> node = Nodes.create(element);

        Assertions.assertEquals(element, node.element);
        Assertions.assertNull(node.next);
    }

    @Test
    public void testLink() {
        Integer firstElement = 5;
        Integer secondElement = 10;

        Node<Integer> firstNode = Nodes.create(firstElement);
        Node<Integer> secondNode = Nodes.create(secondElement);

        Nodes.link(firstNode, secondNode);

        Assertions.assertEquals(secondNode, firstNode.next);
    }

    @Test
    public void testPairOf() {
        Integer firstElement = 5;
        Integer secondElement = 10;

        Node<Integer> node = Nodes.pairOf(firstElement, secondElement);

        Assertions.assertEquals(firstElement, node.element);
        Assertions.assertEquals(secondElement, node.next.element);
        Assertions.assertNull(node.next.next);
    }

    @Test
    public void testClosedPairOf() {
        Integer firstElement = 5;
        Integer secondElement = 10;

        Node<Integer> node = Nodes.closedPairOf(firstElement, secondElement);

        Assertions.assertEquals(firstElement, node.element);
        Assertions.assertEquals(secondElement, node.next.element);
        Assertions.assertEquals(node, node.next.next);
    }

    @Test
    public void testChainOf() {
        Integer[] elements = {5, 10, 15};

        Node<Integer> node = Nodes.chainOf(elements);

        for (int i = 0; i < elements.length; i++) {
            Assertions.assertEquals(elements[i], node.element);
            node = node.next;
        }

        Assertions.assertNull(node);
    }

    @Test
    public void testCircleOf() {
        Integer[] elements = {5, 10, 15};

        Node<Integer> node = Nodes.circleOf(elements);

        for (int i = 0; i < elements.length; i++) {
            Assertions.assertEquals(elements[i], node.element);
            node = node.next;
        }

        Assertions.assertEquals(node.element, elements[0]);
    }
}
