package _DS.LinkedList;

/**
 * @author Green写代码
 * @date 2022-04-15 15:55
 */
public class LinkedList<E> {
    private int size;
    private Node firstNode;
    private static class Node<E>{
        E element;
        Node<E> next;
        public Node(E element, Node<E> next){
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
        //后面的每一条线就自动断开了
    }
    //获取index位置的节点对象
    private Node<E> node(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        Node<E> node = firstNode;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        return node(index).element;
    }
    public void add(int index, E value){
        if(index == 0){
            firstNode = new Node<>(value, firstNode);
        }
        else{
            Node<E> pre = node(index - 1);
            pre.next = new Node<>(value,pre.next);
        }
        size++;
    }
    public E set(int index, E value){
        Node<E> node = node(index);
        E old = node.element;
        node.element = value;
        return old;
    }
    public E remove(int index){
        Node<E> node = firstNode;
        if(index == 0){
            firstNode = firstNode.next;
        }else{
            Node<E> pre = node(index - 1);
            node = pre.next;
            pre.next = pre.next.next;
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
