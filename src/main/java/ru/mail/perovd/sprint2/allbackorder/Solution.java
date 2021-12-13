package ru.mail.perovd.sprint2.allbackorder;

//Comment it before submitting
class Node<V> {
    public V value;
    public Node<V> next;
    public Node<V> prev;

    public Node(V value, Node<V> next, Node<V> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}


public class Solution {
    public static Node<String> solution(Node<String> head) {
        // Your code
        // ヽ(´▽`)/
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        Node<String> newNode = solution(node0);

        /*
        result is : newNode == node3
        node3.next == node2
        node2.next == node1
        node2.prev == node3
        node1.next == node0
        node1.prev == node2
        node0.prev == node1
        */
    }

    public static void main(String[] args) {
        Solution.test();
    }
}
