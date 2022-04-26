package leetcode.贪心;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-04-26 19:51
 */
public class _406_根据身高重建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    //降序
                    return o2[0] - o1[0];
                }else{
                    //升序
                    return o1[1] - o2[1];
                }
            }
        });

        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            if(arr.size() > people[i][1]){
                arr.add(people[i][1],people[i]);
            }else{
                arr.add(arr.size(),people[i]);
            }
        }
        return arr.toArray(new int[arr.size()][]);

    }

    public static void main(String[] args) {
        int [][]people = new int[][]{
                {7,0},{5,0},{6,1}
        };
        System.out.println("=====");
        reconstructQueue(people);
    }
}
