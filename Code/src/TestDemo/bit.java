package TestDemo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Green写代码
 * @date 2022-04-20 18:42
 */
public class bit {
    public void merge(int A[], int m, int B[], int n) {
        for(int i = m,j = 0; i < m + n; i++){
            A[i] = B[j++];
        }
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            StringBuffer ans = new StringBuffer();
            for(int i = 0; i < str.length(); i++){
                if(ans.indexOf(str.substring(i, i + 1)) == -1){
                    ans.append(str.substring(i, i + 1));
                }
            }
            System.out.println(ans);
        }
    }
}
