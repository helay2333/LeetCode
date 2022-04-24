package _DS.Tree;

import java.util.Comparator;

/**
 * @author Green写代码
 * @date 2022-04-19 20:11
 * 平衡二叉搜索数，和AVL一样也是这种树
 */
public class RBTree<E> extends BinarySearchTree{
    private static final boolean BLACK = true;
    private static final boolean RED = false;
    public RBTree(){
        this(null);
    }

    @Override
    protected void afterAdd(Node node) {
        Node<E> parent = node.parent;
        //成为根节点
        if(parent == null) {
            Black(node);
            return ;
        }
        //如果父节点是黑色，直接返回
        if(isBlack(parent)){
            return;
        }
        //叔父节点
        Node<E> uncle = parent.sibling();
        //祖父节点
        Node<E> grand = parent.parent;
        if(isRed(uncle)){
            Black(parent);
            Black(uncle);
            //祖父节点当作新添加的节点
            Red(grand);
            afterAdd(grand);
            return;
        }
        //叔父节点不是红色

    }

    private Node<E> color(Node<E> node, boolean color){
        if(node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }
    private Node<E> Red(Node<E>node){
        return color(node, RED);
    }
    private Node<E> Black(Node<E>node){
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }
    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }

    public RBTree(Comparable<E> comparable){
        super((Comparator) comparable);
    }
    private static class RBNode<E> extends Node<E>{
        boolean color;
        public RBNode(E element, Node<E> parent){
            super(element, parent);
        }
    }
}
