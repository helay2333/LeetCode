package _DS.Tree;

import java.util.Comparator;

/**
 * @author Green写代码
 * @date 2022-04-19 20:11
 */
public class RBTree<E> extends BinarySearchTree{
    private static final boolean BLACK = true;
    private static final boolean RED = false;
    public RBTree(){
        this(null);
    }
    private Node<E> color(Node<E> node, boolean color){
        if(node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }
    private Node<E> red(Node<E>node){
        return color(node, RED);
    }
    private Node<E> Black(Node<E>node){
        return color(node, BLACK);
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
