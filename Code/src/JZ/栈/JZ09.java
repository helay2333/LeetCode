package JZ.栈;

import java.util.Stack;

/**
 * @author Green写代码
 * @date 2022-08-04 15:04
 */
class CQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer>s2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        if(s2.empty()){
            s1.push(value);
        }else{
            while(!s2.empty()){
                int val = s2.pop();
                s1.push(val);
            }
            s1.push(value);
        }
    }

    public int deleteHead() {
        if(s1.empty() && s2.empty()){
            return -1;
        }
        while(!s1.empty()){
            int val = s1.pop();
            s2.push(val);
        }
        return s2.pop();
    }
}
public class JZ09 {
}
