package basic.structure.stack;

import basic.structure.array.Array;

import java.util.stream.IntStream;

/**
 * 利用数组实现栈
 *
 * @author bingo
 * @since 2018/9/12
 */

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return "ArrayStack{" + array + '}';
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        IntStream.range(0, 5).forEach(stack::push);
        System.out.println(stack);
        stack.pop();
        stack.push(12);
        stack.push(11);
        System.out.println(stack);
    }
}
