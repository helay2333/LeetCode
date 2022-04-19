package _DS.Set;

import _DS.Tree.RBTree;

/**
 * @author Green写代码
 * @date 2022-04-19 20:10
 */
//使用红黑树存储，必须是具有可比较性的元素，没有比较性的元素不能用红黑叔存储，因为红红黑树是基于二叉搜索树的
public class TreeSet<E> implements Set<E> {
    private RBTree<E> tree = new RBTree();
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public void add(E element) {
        tree.add(element);
    }

    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        tree.inorder(visitor);//按照值从小到大
    }
}
