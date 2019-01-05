package basic.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * 思路
 * 1）压栈:直接压入data队列
 * 2）弹栈:将data队列中的元素依次取出压入help队列中，直至data队列剩一个元素，记录该元素，改变data和help队列的引用，将该元素返回
 * 3）获取栈顶元素:将data队列中的元素依次取出压入help队列中，直至data队列剩一个元素，记录该元素，将该元素添加至help队列，改变data和help队列的引用，将该元素返回
 *
 * 注意
 * 改变data与help队列引用的好处就是:每次都可以从data队列中压入元素
 *
 * @author bingo
 */
public class TwoQueuesToStack {

    public static class MyStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public MyStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        // 获取栈顶元素
        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }

            while (data.size() > 1) {
                help.add(data.poll());
            }

            int res = data.poll();
            help.add(res);
            swap();
            return res;

        }

        // 改变data和help栈的引用
        private void swap() {
            Queue<Integer> tmp = data;
            data = help;
            help = tmp;
        }

        // 压栈
        public void push(int val) {
            data.add(val);
        }

        // 弹栈
        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("The stack is empty");
            }

            while (data.size() > 1) {
                help.add(data.poll());
            }

            int res = data.poll();
            swap();
            return res;
        }
    }
}