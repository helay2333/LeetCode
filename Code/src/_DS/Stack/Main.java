package _DS.Stack;

/**
 * @author Green写代码
 * @date 2022-04-15 16:07
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer>stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
