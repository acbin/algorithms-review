package basic.structure.stack;

/**
 * @author bingo
 * @since 2018/9/12
 */

public interface Stack<E> {
    int getSize();
    void push(E e);
    E pop();
    E peek();
    boolean isEmpty();
}
