package ru.mail.perovd.sprint5;
//bulbs
public class Solution {
    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        int max = Integer.MIN_VALUE;
        if (head != null ) {
            int headValue = head.value;
            int left = treeSolution(head.left);
            int right = treeSolution(head.right);

            max = Math.max(headValue,Math.max(left,right));
        }
        return max;
    }

    /** Comment it before submitting**/
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

//    public static void main(String[] args) {
//        test();
//    }

//    private static void test() {
//        Node node1 = new Node(1);
//        Node node2 = new Node(-5);
//        Node node3 = new Node(3);
//        node3.left = node1;
//        node3.right = node2;
//        Node node4 = new Node(2);
//        node4.left = node3;
//        int max = treeSolution(node4);
//        assert  max == 3;
//    }

}
