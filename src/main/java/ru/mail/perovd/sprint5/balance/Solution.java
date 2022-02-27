package ru.mail.perovd.sprint5.balance;

public class Solution {
    public static boolean treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (head == null){
            return true;
        }
        int l = height(head.left);
        int r = height(head.right);
        if (Math.abs(l - r) <= 1 ){
            return treeSolution(head.left) && treeSolution(head.right);
        } else {
            return false;
        }
    }

    private static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int heightLeft = 0;
        int heightRight = 0;
        if (node.left != null) {
            heightLeft = height(node.left);
        }
        if (node.right != null) {
            heightRight = height(node.right);
        }
        int max = Math.max(heightLeft, heightRight);
        return max + 1;
    }

    /**
     * Comment it before submitting
     **/
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        boolean res = treeSolution(node5);
        assert res;
    }

}
