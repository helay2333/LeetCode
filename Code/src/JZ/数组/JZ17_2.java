package JZ.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-08-10 19:06
 */
public class JZ17_2 {
    public static List<String> res = new ArrayList<>();
    public static StringBuilder cur = new StringBuilder();
    public static List<String> printNumbers(int n) {
        for(int i = 1; i <= n; i++) {
            dfs(0, i);
        }
        return res;
    }
    //构建长度为len的字符串
    public static void dfs(int x, int len){
        if(x == len){
            res.add(cur.toString());
            return;
        }
        int ans = x == 0 ? 1 : 0;
        //ans表示开始的字符
        for(int i = ans; i <= 9; i++){
            cur.append(i);
            dfs(x + 1, len);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static void main(String[] args){
        List<String> ans = printNumbers(2);
        int num = (int)Math.pow(10,2);
        int[] resArr = new int[num - 1];
        for(int i = 0; i < ans.size(); i++){
            resArr[i] = Integer.parseInt(ans.get(i));
        }
        System.out.println(Arrays.toString(resArr));
    }
}
