package ru.mail.perovd.sprint5.deletenode;
/**
 * ID 65121190 https://contest.yandex.ru/contest/24810/run-report/65121190/
 *
 * Удалении узла из бинарного дерева нужно рассмотреть три случая:  удаляемый элемент находится в левом поддереве текущего поддерева,
 *  удаляемый элемент находится в правом поддереве или удаляемый элемент находится в корне.
 *  В двух первых случаях нужно рекурсивно удалить элемент из нужного поддерева.
 *  Если удаляемый элемент находится в корне текущего поддерева и имеет два дочерних узла, то нужно заменить его минимальным элементом
 *  из правого поддерева и рекурсивно удалить этот минимальный элемент из правого поддерева.
 *  Иначе, если удаляемый элемент имеет один дочерний узел, нужно заменить его потомком.
 *
 * Я вдохновился идеей решения из статьи https://neerc.ifmo.ru/wiki/index.php?title=Дерево_поиска,_наивная_реализация
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Сложность работы алгоритма удаления в среднем: O(log n)
 *
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Т.к. мы не используем дополнительных структур данных пространственная сложность алгоритма удаления O(log n).
 *
 */
public class Solution {
    public static Node remove(Node root, int key) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (root == null) {
            return root;
        }
        if (key < root.getValue()) {
            root.setLeft(remove(root.getLeft(), key));
        }  else if (key > root.getValue()) {
            root.setRight(remove(root.getRight(), key));
        }  else if (root.getLeft() != null && root.getRight() != null) {
            root.setValue(minimum(root.getRight()).getValue());
            root.setRight(remove(root.getRight(), root.getValue()));
        } else {
            if (root.getLeft() != null) {
                root = root.getLeft();
            } else if (root.getRight() != null) {
                root = root.getRight();
            } else {
                root = null;
            }
        }
        return root;
    }

    /**
     * Чтобы найти минимальный элемент в бинарном дереве поиска, необходимо просто следовать указателям left от корня дерева, пока не встретится значение null
     */
    private static Node minimum(Node node) {
        if (node.getLeft() == null) {
            return node;
        }
        return minimum(node.getLeft());
    }

    /**
     * Comment it before submitting
     */
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }

}