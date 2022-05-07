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
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap(Comparator<E> comparator){
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];

    }
    public BinaryHeap() {
        this((Comparator<E>) null);
    }
    public BinaryHeap(E[] elements, Comparator<E> comparator){
        super(comparator);
        if(elements == null) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[])new Object[DEFAULT_CAPACITY];
            for(int i = 0; i < elements.length; i++){
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }
    //批量建队
    public void heapify(){
        //自上而下上滤
//        for (int i= 1; i < size; i++) {
//            siftUp(i);
//        }
        //自下而上上滤
        for(int i = (size >> 1) - 1; i >=0; i--) {
            siftDown(i);
        }
    }
    public BinaryHeap(E[] elements){
        this(elements, null);
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
            if(compare(e, p) <= 0){
                //小于等于父节点
                break;
            }else{
                //父元素在index位置
                elements[index] = p;
                index = pindex;//重新赋值index
            }
        }
        elements[index] = e;
    }
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        addCapcity(size + 1);
        elements[size] = element;
        siftUp(size);
        size++;
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
        emptyCheck();
        E root = elements[0];
        elements[0] = elements[size - 1];
        elements[size - 1] = null;
        size--;
        siftDown(0);
        return root;
    }

    private void siftDown(int index){
        E element = elements[index];
        System.out.println(element);
        //保证index是非叶子节点才可下溢,<第一个叶子节点的索引
        while(index < size / 2){
            //1.只有左子节点
            //同时左右节点
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int childIndex = left;
            if(right < size  && compare(elements[right] , elements[left]) >= 0){
                childIndex = right;
            }
            E child = elements[childIndex];
            if(compare(element, child) >= 0){
                break;
            }
            elements[index] = child;
            index = childIndex;
        }
        elements[index] = element;
    }
    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if(size == 0){
            elements[0] = element;
            size++;
        }
        else{
            elements[0] = element;
            siftDown(0);
        }
        return root;
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
