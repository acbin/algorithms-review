package basic.structure.linkedlist;

import java.util.stream.IntStream;

/**
 * 链表(动态数据结构)
 * 链表的增删改查都是O(n)复杂度
 * 如果只对链表头进行操作，那么是O(1)
 *
 * @author bingo
 * @since 2018/9/13
 */

public class LinkedList<E> {

    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedList() {
        // 对于空的链表，存在一个虚拟头结点
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index位置添加新的元素e
     * @param index 位置
     * @param e 元素值
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        // 注意，由于这里有虚拟头结点，所以需要循环index次
        for (int i = 0; i < index; ++i) {
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(e, prev.next);
        ++size;

    }

    /**
     * 在链表头部添加元素
     * @param e 元素值
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加元素
     * @param e 元素值
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取index位置处的元素值
     * @param index 位置
     * @return 元素值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(int index) {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove fail. Illegal index.");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; ++i) {
            cur = cur.next;
        }
        Node node = cur.next;
        cur.next = node.next;
        node.next = null;
        --size;
        return node.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        // 新元素添加在链表头部，是O(1)复杂度
        IntStream.range(0, 10).forEach(list::addFirst);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

    }
}
