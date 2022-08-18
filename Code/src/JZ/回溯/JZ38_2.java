package JZ.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-08-18 16:00
 */
public class JZ38_2 {
    public String[] res = null;
    public List<String> ans = new ArrayList<>();
    public String[] permutation(String s) {
        if(s.length() == 0) return new String[0];
        back(s, 0);
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    StringBuilder str = new StringBuilder();

    public void back(String s, int lev){
        if(str.length() == ans.size()) {
            ans.add(new String(str));
            return;
        }
        for(int i = 0; i < s.length(); i++) {
            if(!str.toString().contains(s.substring(i, i + 1))){
                str.append(s.charAt(i));
                back(s,lev);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}
