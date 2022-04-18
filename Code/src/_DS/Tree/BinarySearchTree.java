package _DS.Tree;

import _DS.printer.BinaryTreeInfo;
import _DS.printer.BinaryTrees;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Green写代码
 * @date 2022-04-17 14:372                                                             52
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    protected int size;
    protected Node<E> root;
    protected java.util.Comparator<E> comparator;

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

    protected static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        public boolean isLeftChild(){
            return parent != null && this == parent.left;
        }
        public boolean isRightChild(){
            return parent != null && this == parent.right;
        }
        public boolean isLeaf(){
            return left == null && right == null;
        }
        public  boolean hasTwoChild(){
            return left != null && right != null;
        }
    }
    protected Node<E> createNode(E element, Node<E>parent){
        return new Node<>(element, parent);
    }
    public BinarySearchTree(){
        this(null);//表示比较器为空
    }
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E element){
        elementNotNullCheck(element);
        //添加的第一个节点
        if(root == null){
            root = createNode(element,null);
            size++;
            afterAdd(root);
            return;
        }
        //添加的不是第一个节点
        //找到父节点
        Node<E> node = root;
        Node<E> parent = null;
        int cmp = 0;
        while(node != null){
            cmp = compare(element, node.element);
            parent = node;
            if(cmp > 0){
                node = node.right;
            }else if(cmp < 0){
                node = node.left;
            }else{
                //相同
                node.element = element;
                return;
            }
        }

        Node<E>newNode = createNode(element,parent);
        if(cmp > 0){
            parent.right = newNode;
        }else{
            parent.left = newNode;
        }
        afterAdd(newNode);
        size++;
    }

    protected void afterAdd(Node<E> node){};
    public Node<E> predecessor(Node<E> node){
        if(node == null) return null;
        Node<E> p = node.left;
        //前去在左子树中
        if(node.left != null){
            while(p.right != null){
                p = p.right;
            }
            return p;
        }
        //父节点中找
        while(node.parent != null && node == node.parent.left){
            node = node.parent;
        }
        //node.parent == null
        //node == node.parent.right
        return node.parent;
    }


    //是右子树中找左
    public Node<E> postdecessor(Node<E> node){
        if(node == null) return null;
        Node<E> p = node.right;
        //前去在左子树中
        if(node.right != null){
            while(p.left != null){
                p = p.left;
            }
            return p;
        }
        //父节点中找
        while(node.parent != null && node == node.parent.right){
            node = node.parent;
        }
        //node.parent == null
        //node == node.parent.right
        return node.parent;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }
    private void toString(Node<E>node, StringBuilder sb){
        if(node == null) return;
        sb.append(node.element).append("\n");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    /**
     * @param e1
     * * @param e2
     * @return 返回值是0表示e1和e2相等，返回值大于0，代表e1 > e2, 返回值小于0，代表e1小于e2
     */
    private int compare(E e1, E e2){
//        return e1.compareTo(e2);
        if(comparator != null){
            return comparator.compare(e1,e2);
        }
        return ((java.lang.Comparable<E>)e1).compareTo(e2);//强制转化，使用compareTo
        //上面就不用写死了，因为传递比较器的时候，不需要实现Comparable，如果上面写死，那么类中一定需要重写CompareTo
    }

    /**
     * 前序遍历，可以弄打印器
     * 中序遍历比如从小到大遍历节点
     * 后序遍历，先子后父
     */
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

    /**
     * 高度：--->非递归的就是层序遍历---->每访问完一层,队列size就是下一层的元素数量，因为此时下一层都入队了
     * @return
     */
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
    public void postorderTraversal(){
        postorderTraversal(root);
    }
    private void postorderTraversal(Node<E> node){
        if(node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.element + " ");

    }

    /**
     * 层序遍历--->采用队列
     * @param
     */
    public void levelOrderTraversal(){
        if(root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    /**
     * 外部操作接口,想干什么在main函数自己定义，就不用我们内部类里面提供相关的操作接口了
     * @param
     */
    public void levelOrder(Visitor<E> visitor){
        if(root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            System.out.println(node.element);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }
    public static interface Visitor<E>{
        void visit(E element);
    }
    public Node<E> node(E element){
        Node<E> node = root;
        while(node != null){
            int cmp = compare(element, node.element);
            if(cmp == 0) return node;
            if(cmp > 0){
                node = node.right;
            }else{//cmp < 0
                node = node.left;
            }

        }
        return null;
    }
    public void remove(E element){
        remove(node(element));

    }
    protected void afterRemove(Node<E> node){

    }
//    public Node<E> predecessor(Node<E> node){
//        if(node == null) return null;
//        //前去节点在左子树(left.right.right.right
//        if(node.left != null){
//            Node<E> p = node.left;
//            while(p.right != null){
//                p = p.right;
//            }
//            return p;
//        }
//        //从祖父节点中寻找
//        while(node.parent != null && node == node.parent.left){
//            node = node.parent;
//        }
//        //node.parent == null
//
//        //node = node.parent.right
//        return node.parent;
//    }
    public void remove(Node<E> node){
        if(node == null){
            return;
        }
        size--;
        if(node.hasTwoChild()){
            //找到后记节点
            Node<E> s = postdecessor(node);
            //使用后继节点覆盖度为2的值
            node.element = s.element;
            //删除后继节点
            node = s;
        }

        //删除node节点,node的度是1或者0
        Node<E> replacement = node.left != null ? node.left :node.right;
        if(replacement != null){//node是度为1的
            //更改parent
            replacement.parent = node.parent;
            //更改parent的let和right指向
            if(node.parent == null){//node度为1且是根节点
                root = replacement;
            }else if(node == node.parent.left){
                node.parent.left = replacement;
            }else{
                node.parent.right = replacement;
            }
            //应该在删除节点之后处理
            afterRemove(node);
        }else if(node.parent == null){//node是叶子系欸但并且是根节点
            root = null;
            afterRemove(node);
        }else{//Node是叶子节点但不是根节点
            if(node == node.parent.right){
                node.parent.right = null;
                afterRemove(node);
            }else{
                node.parent.left = null;
                afterRemove(node);
            }
        }
    }

    public  boolean contains(E element){
        return node(element) != null;
    }

    private void elementNotNullCheck(E element){
        if(element == null){
            throw new IllegalArgumentException("element不能为空");
        }
    }

}
