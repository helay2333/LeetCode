package JZ.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-08-10 19:34
 */
public class JZ17_3 {
    static List<String> ans = new ArrayList<>();
    public static int[] printNumbers(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(char j = '1'; j <= '9'; j++) {
                sb.append(j);
                dfs(i, 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        int num = (int)Math.pow(10,n);
        int[] resArr = new int[num - 1];
        for(int i = 0; i < ans.size(); i++){
            resArr[i] = Integer.parseInt(ans.get(i));
        }
        return resArr;
    }
    public static void dfs(int len, int idx, StringBuilder sb){
        if(idx == len){
            ans.add(sb.toString());
            return ;
        }
        for(char j = '0'; j <='9'; j++) {
            sb.append(j);
            dfs(len, idx+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] resArr = printNumbers(1);
        System.out.println(Arrays.toString(resArr));
    }
}
