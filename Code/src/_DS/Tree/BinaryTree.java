package _DS.Tree;

import _DS.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Green写代码
 * @date 2022-04-18 12:42
 */
public class BinaryTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        public boolean isLeaf(){
            return left == null && right == null;
        }
        public  boolean hasTwoChild(){
            return left != null && right != null;
        }
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void preorderTraversal(){
        preorderTraversal(root);
    }
    private void preorderTraversal(Node<E> node){
        if(node == null) return;
        System.out.println(node.element + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    //二叉搜索树中序遍历就会从小到大遍历

    public void inorderTraversal(){
        inorderTraversal(root);
    }
    private void inorderTraversal(Node<E> node){
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.element + " ");
        inorderTraversal(node.right);
    }
    public int height2(){
        if(root == null){
            return 0;
        }
        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize--;
//            System.out.println(node.element);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if(levelSize == 0) {
                //即将访问下一层，此时高度++
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }
    public int height(){
        return height(root);
    }
    private int height(Node<E> node){
        if(node == null) return 0;
        return 1 + Math.max(height(node.left),height(node.right));
    }
    /**
     * 判断完全二叉树：除了最一层可以缺元素
     */
    public boolean isComplete(){
        if(root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while(!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if(leaf && !node.isLeaf()){
                return false;
            }
            if(node.hasTwoChild()){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if(node.left == null && node.right != null){
                return false;
            }else{
                //后面遍历的都是叶子节点
                leaf = true;
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return true;
    }
    public boolean isComplete2(){
        if(root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while(!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if(leaf && !node.isLeaf()) return false;
            if(node.left != null){
                queue.offer(node.left);
            }else if(node.right != null){
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            }else{
                leaf = true;
                //左空，左不空
            }
        }
        return true;
    }
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return (((Node<E>)node).element);
    }


}
