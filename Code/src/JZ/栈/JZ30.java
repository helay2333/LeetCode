package JZ.栈;

import java.util.Stack;

/**
 * @author Green写代码
 * @date 2022-04-27 15:00
 */
public class JZ30 {
    private Stack<Integer> data_stack;
    private Stack<Integer> min_stack;//辅助栈
    public void push(int node) {
        if(min_stack.isEmpty() && node < min_stack.peek()){
            min_stack.push(node);
        }else{
            min_stack.push(min_stack.peek());
        }
        data_stack.push(node);
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        return data_stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}
