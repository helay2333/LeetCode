package _DS.Tree;

import java.util.Comparator;

/**
 * @author Green写代码
 * @date 2022-04-18 13:52
 */
public class AVLTree<E> extends BinarySearchTree<E>{
    public AVLTree(Comparator<E> comparator){
        super(comparator);
    }
    private static class AVLNode<E> extends Node<E>{
        int height = 1;
        AVLNode(E element, Node<E> parent){
            super(element, parent);
        }
        public int balnaceFactor(){
            int leftHeight = left == null ? 0 :((AVLNode<E>)left).height;
            int rightHeight = left == null ? 0 :((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }
        public void updateHeight(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }
        public Node<E> tallerChild(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if(leftHeight > rightHeight) return left;
            if(leftHeight < rightHeight) return right;
            return isLeftChild() ? left : right;
        }
    }

    /**
     *
     * @param node -> 高度最低的那个不平衡点
     *             ll --- 左边的左边让不平衡
     *             lr --- 左边的右边导致不平衡
     */
    private void rebalance(Node<E> node) {
        Node<E> parent = ((AVLNode<E>) node).tallerChild();
        Node<E> pchild = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (pchild.isLeftChild()) {//LL
                rotateRight(node);
            } else {//LR
                rotateLeft(parent);
                rotateRight(node);
            }
        } else {//R
            if (node.isLeftChild()) {//RL
                rotateRight(parent);
                rotateLeft(node);
            } else {//RR
                rotateLeft(node);
            }
        }
    }
    private void rotateLeft(Node<E>node){
        Node<E> parent = node.right;
        Node<E> child = parent.left;
        node.right = parent.left;
        parent.left = node;

        parent.parent = node.parent;
        if(node.isLeftChild()){
            node.parent.left = parent;
        }else if(node.isRightChild()){
            node.parent.right = parent;
        }else{// node是根节点
            root = parent;
        }
        //更新child
        if(child != null){
            child.parent = node;
        }
        //更新node的parent
        node.parent = parent;
        //更新高度
        updateHeight(node);
        updateHeight(parent);
    }
    private void rotateRight(Node<E>node){
        Node<E> parent = node.left;
        Node<E> child = parent.right;

        node.left = child;
        parent.right = node;

        parent.parent = node.parent;
        if(node.isLeftChild()){
            node.parent.left = parent;
        }else if(node.isRightChild()){
            node.parent.right = parent;
        }else{// node是根节点
            root = parent;
        }
        //更新child
        if(child != null){
            child.parent = node;
        }
        //更新node的parent
        node.parent = parent;

        //更新高度
        updateHeight(node);
        updateHeight(parent);
    }
    private boolean isBalance(Node<E> node){
      return Math.abs(((AVLNode<E>)node).balnaceFactor()) <= 1;
    }
    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    public AVLTree(){
        this(null);
    }
    private void updateHeight(Node<E> node){
        ((AVLNode<E>)node).updateHeight();
    }
    public  void afterAdd(Node<E> node){
        //最先找到的节点就是第一个失衡的
        while((node = node.parent)!=null){
            if(isBalance(node)){
                //更新高度
                //创建出来一定先是1,叶子节点，所以叶子节点上移的时候需要维护这个高度
                updateHeight(node);
            }else{
                //恢复平衡
                rebalance(node);
                break;//恢复完毕
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        //最先找到的节点就是第一个失衡的
        while((node = node.parent)!=null){
            if(isBalance(node)){
                //更新高度
                //创建出来一定先是1,叶子节点，所以叶子节点上移的时候需要维护这个高度
                updateHeight(node);
            }else{
                //恢复平衡
                rebalance(node);
            }
        }
    }
}
