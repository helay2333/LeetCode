package _DS.Tree;

import _DS.printer.BinaryTrees;

/**
 * @author Green写代码
 * @date 2022-04-18 13:53
 */
public class Main2 {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] data = new int[]{
                83, 88, 27, 8, 77, 82, 60, 31, 22, 79, 55, 69, 11, 46
        };
        for(int i = 0; i < data.length; i++){
            avl.add(data[i]);
        }
        BinaryTrees.println(avl);
    }
}
