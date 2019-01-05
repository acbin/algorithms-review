package basic.solution;

/**
 * 用数组实现固定大小的栈和队列
 *
 * @author bingo
 */

public class ArrayToStackAndQueue {

    /**
     * 用数组实现固定大小的栈
     */
    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int val) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[size++] = val;
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--size];
        }
    }


    /**
     * 用数组实现固定大小的队列
     */
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer begin; // begin指示可以从该位置取出数
        private Integer end; // end指示可以从该位置插入数
        private Integer size; // 实际有效存放的数的个数

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            begin = 0;
            end = 0;
            size = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[begin];
        }

        public void push(int val) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            ++size;
            arr[end] = val;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            --size;
            int tmp = arr[begin];
            begin = begin == arr.length - 1 ? 0 : begin + 1;
            return tmp;
        }

    }
}
