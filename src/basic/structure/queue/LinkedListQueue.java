package basic.structure.queue;

import java.util.stream.IntStream;

/**
 * 带尾指针的链表实现队列
 *
 * @author bingo
 * @since 2018/9/15
 */

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        E e;
        Node next;
        public Node(E e, Node next) {
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

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从队尾入队
     * @param e 元素值
     */
    @Override
    public void enqueue(E e) {
        Node node = new Node(e);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            // 维护tail
            tail = tail.next;
        }
        ++size;

    }

    /**
     * 从队首出队
     * @return 队首元素
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        --size;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        IntStream.rangeClosed(0, 5).forEach(queue::enqueue);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
