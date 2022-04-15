package _DS.Stack;

import _DS.arrrayList.ArrayList;

/**
 * @author Green写代码
 * @date 2022-04-15 16:01
 */
public class Stack <E> extends ArrayList {
    public void push(E value){
        add(value);
    }
    public E pop(){
        return (E) remove(size - 1);
    }
    public  E top(){
        return (E) get(size - 1);
    }
}
