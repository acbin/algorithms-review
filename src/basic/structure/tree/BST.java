package basic.structure.tree;

/**
 * Binary Search Tree 二分搜索树
 * 存储的元素必须有可比较性
 * 对于二分搜索树的每一个结点，比左子树每个结点都大，而比右子树每个结点都小。
 * 所以该二分搜索树不包含重复元素。
 *
 * 如果想包含重复元素的话，只需要定义：
 * 左子树<=结点 or 右子树>= 结点
 *
 * @author bingo
 * @since 2018/9/19
 */

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加新的元素e
     * @param e 元素值
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            ++size;
        } else {
            add(root, e);
        }
    }

    /**
     * 向以node为根的二分搜索树插入元素E，递归算法
     * @param node
     * @param e
     */
    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            // 说明该结点已存在
            return;
        }

        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            ++size;
            return;
        }

        if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            ++size;
            return;
        }
        /* 以上是递归终止条件 */



        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }


    }
}
