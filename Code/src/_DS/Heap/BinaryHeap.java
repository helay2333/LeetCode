package _DS.Heap;

import _DS.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @author Green写代码
 * @date 2022-05-06 19:28
 * 获取最大值很方便
 * 删除最大值也很方便
 * 就是一种偏序
 *父节点：floor(i-1)/2
 */
public class BinaryHeap<E> implements Heap<E>, BinaryTreeInfo {
    private E[] elements;
    private int size;
    private Comparator<E> comparator;
    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap(Comparator<E> comparator){
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];

    }
    public BinaryHeap(){
        this(null);
    }
    private int compare(E e1, E e2){
        return comparator != null ? comparator.compare(e1,e2) :((Comparable<E>)e1).compareTo(e2) ;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
    }
    public void addCapcity(int capacity){
        if(elements.length >= capacity){
            return;
        }else{
            int newCapcity = elements.length * 2;
            E[] newElement = (E[]) new Object[newCapcity];
            for(int i = 0; i < size; i++){
                newElement[i] = elements[i];
            }
            elements = newElement;
        }
    }

    /**
     *
     * @param index 让index的元素上移
     */
    private void siftUp(int index){
//        E e = elements[index];
//        while(index > 0) {
//            int pindex = (index - 1) >> 1;
//            E p = elements[pindex];//父节点
//            if(compare(e, p ) <= 0){
//                //小于等于父节点
//                return;
//            }else{
//                //交换
//                E tmp = elements[index];
//                elements[index] = elements[pindex];
//                elements[pindex] = tmp;
//                index = pindex;//重新赋值
//            }
//        }
        //优化3*logN ---> logN + 1
        E e = elements[index];
        while(index > 0) {
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];//父节点
            if(compare(e, p ) <= 0){
                //小于等于父节点
                break;
            }else{
                //父元素在index位置
                elements[pindex] = p;
                index = pindex;//重新赋值index
            }
        }
        elements[index] = e;
    }
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        addCapcity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }
    private void emptyCheck(){
        if(size == 0){
            throw new IndexOutOfBoundsException("数组无内容");
        }
    }
    private void elementNotNullCheck(E element){
        if(element == null){
            throw new IllegalArgumentException("数组内容不能为空");
        }
    }
    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        Integer index = (Integer) node;
        index = (index << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        Integer index = (Integer) node;
        index = (index << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        Integer index = (Integer) node;

        return elements[index];
    }
}
