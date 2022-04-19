package _DS.Set;


public interface Set<E> {
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    void add(E element);
    void remove(E element);
    void traversal(Visitor<E> visitor);//遍历
    public static abstract class Visitor<E>{
        boolean stop;//true，表示停止
        abstract boolean visit(E element);
    }
}