package JZ.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Green写代码
 * @date 2022-08-18 16:00
 */
public class JZ38_2 {
//    public String[] res = null;
//    public List<String> ans = new ArrayList<>();
//    public String[] permutation(String s) {
//        if(s.length() == 0) return new String[0];
//        back(s, 0);
//        for(int i = 0; i < ans.size(); i++){
//            res[i] = ans.get(i);
//        }
//        return res;
//    }
//    StringBuilder str = new StringBuilder();
//
//    public void back(String s, int lev){
//        if(str.length() == ans.size()) {
//            ans.add(new String(str));
//            return;
//        }
//        for(int i = 0; i < s.length(); i++) {
//            if(!str.toString().contains(s.substring(i, i + 1))){
//                str.append(s.charAt(i));
//                back(s,lev);
//                str.deleteCharAt(str.length() - 1);
//            }
//        }
//    }
public String[] permutation(String s) {
    Set<String> list = new HashSet<>();
    char[] arr = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    boolean[] visited = new boolean[arr.length];
    dfs(arr, "", visited, list);
    return list.toArray(new String[0]);
}
    public void dfs(char[] arr, String s, boolean [] visited, Set<String> list){
        if(s.length() == arr.length){
            list.add(s);
            return ;
        }
        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, s + String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }
    }
}
