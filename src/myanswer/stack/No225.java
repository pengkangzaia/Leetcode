package myanswer.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No225.java
 * @Description: 队列实现栈
 * @Author: admin
 * @Date: 2020/11/6 14:06
 */
public class No225 {

    class MyStack {

        private Queue<Integer> q1;
        private Queue<Integer> q2;

        // 1 , 2 , 3
        //

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            // 优先向非空队列插入，如果都为空，则选择q1队列进行插入
            if (!q1.isEmpty()) {
                q1.offer(x);
            } else if (!q2.isEmpty()) {
                q2.offer(x);
            } else {
                q1.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int tem = 0;
            if (q1.isEmpty()) {
                while (!q2.isEmpty()) {
                    tem = q2.poll();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.offer(tem);
                }
            } else {
                while (!q1.isEmpty()) {
                    tem = q1.poll();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.offer(tem);
                }
            }
            return tem;
        }

        /** Get the top element. */
        public int top() {
            int tem = 0;
            if (q1.isEmpty()) {
                while (!q2.isEmpty()) {
                    tem = q2.poll();
                    q1.offer(tem);
                }
            } else {
                while (!q1.isEmpty()) {
                    tem = q1.poll();
                    q2.offer(tem);
                }
            }
            return tem;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }


}
