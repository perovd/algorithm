package ru.mail.perovd.sprint5.searchtree;

//https://ru.stackoverflow.com/questions/771612/проверка-двоичного-дерева-поиска-на-корректность
public class Solution {

    public static boolean treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head.left == null && head.right == null){
            return false;
        }
        return checkTreeInRange(head,Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static boolean checkTreeInRange(Node head, int lo, int hi)
    {
        if (head == null) {
            return true;
        }
        if (head.value <= lo || head.value > hi) {
            return false;
        }
        return checkTreeInRange(head.left, lo, head.value) && checkTreeInRange(head.right, head.value, hi);
    }

    /**
     * Comment it before submitting**/

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        test2();
    }

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        boolean b = treeSolution(node5);
        assert b;
        node2.value = 5;
        b = !treeSolution(node5);
        assert b;
    }

    private static void test2() {
         Node node6 = new Node(9, null, null);
        Node node5 = new Node(6, null, null);
        Node node4 = new Node(3, null, null);
        Node node3 = new Node(1, null, null);
        Node node2 = new Node(8, node5, node6);
        Node node1 = new Node(3, node3, node4);
        Node node0 = new Node(5, node1, node2);
        System.out.println(treeSolution(node0));
    }

}
