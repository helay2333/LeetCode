package _DS.Heap;

import _DS.printer.BinaryTreeInfo;
import _DS.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @author Green写代码
 * @date 2022-05-06 19:30
 */
public class Main {
    public static void main(String[] args) {
        int[] data = {55,2,77,22,88,99,23,121,54};
        BinaryHeap<Integer> heap = new BinaryHeap<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int k = 3;
        for(int i = 0; i < data.length; i++) {
            if(heap.size() < k) {
                heap.add(data[i]);
            } else if(data[i] > heap.get()) {
                heap.replace(data[i]);//每一次替换都将堆中小的数字剔除了
            }
        }
        BinaryTrees.println(heap);
    }
    public static void main1(String[] args) {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(68);
        heap.add(72);
        heap.add(43);
        heap.add(50);
        heap.add(38);
        heap.add(10);
        heap.add(90);
        heap.add(65);
        BinaryTrees.println(heap);
                heap.remove();
        BinaryTrees.println(heap);

    }
}
