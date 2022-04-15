package _DS.arrrayList;

/**
 * @author Green写代码
 * @date 2022-04-14 18:40
 */
public class ArrayList<E> {
    private E[] element;
    private int size;
    private static final int Default_Capacity = 10;
    public ArrayList(int capacity){
        capacity = (capacity > Default_Capacity ? capacity : Default_Capacity);
        element = (E[]) new Object[capacity];
    }
    public ArrayList(){
        this(Default_Capacity);
    }
    public int indexOf(E value){
        for(int i = 0; i < size; i++){
            if(element[i].equals(value)) return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(E value){
        return indexOf(value) != -1;
    }
    public int size(){
        return size;
    }
    public void add(E value){
        /*element[size] = value;
        size++;*/
        add(size, value);
    }
    public void addCapcity(int capacity){
        if(element.length >= capacity){
            return;
        }else{
            int newCapcity = element.length * 2;
            E[] newElement = (E[]) new Object[newCapcity];
            for(int i = 0; i < size; i++){
                newElement[i] = element[i];
            }
            element = newElement;
        }
    }

    public void add(int index, E value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        addCapcity(size + 1);
        for(int i = size - 1; i >=index; i--){
            element[i+1] = element[i];
        }
        element[index] = value;
        size++;
    }

    public void clear(){
        //销毁指向的引用数据变量
        //不压迫element = null--->循环利用
        for(int i = 0; i < element.length; i++){
            element[i] = null;
        }
        size = 0;
    }
    public E set(int index, E value){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        E tmp = element[index];
        element[index] = value;
        return tmp;
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        return element[index];
    }
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size+",下标越界");
        }
        E tmp = element[index];
        for(int i = index + 1; i < size; i++){
            element[i - 1] = element[i];
        }
        size--;
        element[size] = null;
        return tmp;
    }

    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append("size=").append(size).append(",[");
        for(int i = 0; i < size; i++){
            if(i != 0){
                string.append(",");
            }
            string.append(element[i]);
        }
        string.append("]");
//        System.out.println(string.toString());
        return string.toString();
    }
}
