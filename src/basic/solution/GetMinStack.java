package basic.solution;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈基本功能的基础上，再实现返回栈中最小元素的操作
 *
 * 要求
 * 1）pop、push、getMin操作的时间复杂度都是O(1)
 * 2）可以使用现成的栈结构
 *
 * 思路
 * 1）准备两个栈，data栈用于存放数据，min栈用于存放最小值
 * 2）每次压栈，元素压入data栈，而对于min栈，若min栈为空，或者待压入元素小于栈顶元素，则将元素压入栈顶；否则重复压入栈顶元素
 * 3）弹栈，直接弹出栈顶元素
 * 4）getMin，直接获取min栈栈顶元素
 *
 * @author bingo
 */
public class GetMinStack {

    public static class MyStack {
        private Stack<Integer> data;
        private Stack<Integer> min;

        public MyStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public Integer peek() {
            if (data.empty()) {
                return null;
            }
            return data.peek();
        }

        public void push(int val) {
            if (min.empty()) {
                min.push(val);
            } else if (val < data.peek()) {
                min.push(val);
            } else {
                // 重复压入min栈顶元素
                min.push(min.peek());
            }
            data.push(val);
        }

        public int pop() {
            if (data.empty()) {
                throw new RuntimeException("The stack is empty");
            }
            min.pop();
            return data.pop();
        }

        // 获取栈中元素的最小值
        public int getMin() {
            if (min.empty()) {
                throw new RuntimeException("The stack is empty");
            }
            return min.peek();
        }
    }
}
