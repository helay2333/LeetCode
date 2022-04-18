package _DS.Tree;

import _DS.arrrayList.Person;
import _DS.printer.BinaryTrees;
import javafx.css.PseudoClass;

/**
 * @author Green写代码
 * @date 2022-04-17 15:37
 */
public class Main {
    public static class PersonComparator implements Comparator<Person>{
        public int compare(Person e1, Person e2){
            return e1.age - e2.age;//年龄大的比较da
        }
    }
    public static class PersonComparator2 implements Comparator<Person>{
        public int compare(Person e1, Person e2){
            return e2.age - e1.age;//年龄小的比较da
        }
    }
    public static void main(String[] args) {
        //自定义比较规则，传递比较器
//        BinarySearchTree<Person> bst = new BinarySearchTree<Person>(new PersonComparator());
//        BinarySearchTree<Person> bst2 = new BinarySearchTree<Person>(new PersonComparator2());
//        //匿名类
//        BinarySearchTree<Person> bst3 = new BinarySearchTree<Person>(new Comparator<Person>() {
//            @Override
//            public int compare(Person e1, Person e2) {
//                return 0;
//            }
//        });
        Integer []data= new Integer[]{
                7,4,9,2,5,8,11,3,12,1
        };
        BinarySearchTree<Integer> bbb = new BinarySearchTree<>();
        for(int i = 0; i < data.length; i++){
            bbb.add(data[i]);
        }
//        bbb.preorderTraversal();
//        bbb.inorderTraversal();
//        bbb.postorderTraversal();
//        bbb.levelOrderTraversal();
//        bbb.levelOrder(new BinarySearchTree.Visitor<Person1>() {
//            @Override
//            public void visit(Person1 element) {
//                System.out.println(element.age + 1);
//            }
//        });
//        BinarySearchTree<Integer>bbb = new BinarySearchTree<>();
//        for(int i = 0; i < data.length; i++){
//            bbb.add(data[i]);
//        }
        BinaryTrees.println(bbb);

        System.out.println();
        bbb.toString();
        System.out.println(bbb.height());
        System.out.println(bbb.height2());
        System.out.println(bbb.isComplete());
        bbb.remove(1);
        BinaryTrees.println(bbb);
        bbb.remove(9);
        BinaryTrees.println(bbb);


    }
}
