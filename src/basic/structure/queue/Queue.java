package basic.structure.queue;

/**
 * @author bingo
 * @since 2018/9/13
 */

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
