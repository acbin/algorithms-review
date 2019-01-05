package basic.structure.stack;

import basic.structure.linkedlist.LinkedList;

import java.util.stream.IntStream;

/**
 * 利用链表实现栈
 *
 * @author bingo
 * @since 2018/9/15
 */

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty() ;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        IntStream.rangeClosed(0, 10).forEach(stack::push);
        stack.pop();
        stack.push(11);
        System.out.println(stack);

    }
}
