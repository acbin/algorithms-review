package basic.structure.queue;

import basic.structure.array.Array;

import java.util.stream.IntStream;

/**
 * 利用数组实现队列
 * 有局限性，出队操作时间复杂度O(n)
 *
 * @author bingo
 * @since 2018/9/13
 */

public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队，此操作复杂度为O(n)
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" + array + '}';
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        IntStream.range(0, 5).forEach(queue::enqueue);
        queue.dequeue();
        System.out.println(queue);
    }
}
