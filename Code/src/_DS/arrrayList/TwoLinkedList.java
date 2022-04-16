package _DS.arrrayList;

import _DS.LinkedList.LinkedList;

/**
 * @author Green写代码
 * @date 2022-04-16 19:37
 */
public class TwoLinkedList<E> {
    private int size;
    private Node<E> firstNode;
    private Node<E> lastNode;
    private static class Node<E>{
        E element;
        Node<E> next;
        Node<E> pre;
        public Node(Node<E>pre ,E element, Node<E> next){
            this.pre = pre;
            this.element = element;
            this.next = next;
        }
    }
    public int size(){
        return size;
    }
    public void add(E value){
        add(size, value);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean contains(E value){
        return indexOf(value) != -1;
    }
    public void clear(){
        size = 0;
        firstNode = null;
        lastNode = null;
        //后面的每一条线就自动断开了
    }
    //获取index位置的节点对象
    private Node<E> node(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        if(index < (size >> 1)){
            Node<E> node = firstNode;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
            return node;
        }else{
            Node<E> node = lastNode;
            for(int i = size - 1; i > index; i--){
                node = node.pre;
            }
            return node;
        }
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        return node(index).element;
    }
    public E set(int index, E value){
        Node<E> node = node(index);
        E old = node.element;
        node.element = value;
        return old;
    }

    public void add(int index, E value){
        if(index == size){
            Node<E> oldLast = lastNode;
            lastNode = new Node<E>(oldLast, value, null);
            if(oldLast.next == null){
                firstNode = lastNode;
            }else{
                oldLast.next = lastNode;
            }
        }else{
            Node<E> next = node(index);
            Node<E> prev = next.pre;
            Node<E> node = new Node<>(prev, value, next);
            next.pre = node;
            if(prev == null){
                firstNode = node;
            }else{
                prev.next = node;
            }
        }
        size++;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;
        if(pre == null){
            firstNode = next;
        }else{
            pre.next = next;
        }
        if(next == null){
            lastNode = pre;
        }else{
            next.pre = pre;
        }
        size--;
        return node.element;
    }
    public int indexOf(E value){
        Node<E> node = firstNode;
        for(int i = 0; i < size; i++){
            if(node.element.equals(value)) return i;
            node = node.next;
        }
        return -1;
    }
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append("size=").append(size).append(",[");
        Node<E> node = firstNode;
        for(int i = 0; i < size; i++){
            if(i != 0){
                string.append(",");
            }
            string.append(node.element);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
