package JZ.回溯;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Green写代码
 * @date 2022-04-29 21:52
 */
public class JZ38 {

    public class Solution {
        public ArrayList<String> Permutation(String str) {
            ArrayList<String> result = new ArrayList<>();
            if(str != null && str.length() > 0){
                PermutationHelper(str.toCharArray(), 0, result);
                Collections.sort(result);
            }
            return result;
        }
        public void Swap(char[] str, int i, int j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        public boolean isExist(ArrayList<String>result, char[] str){
            return result.contains(String.valueOf(str));
        }
        public void PermutationHelper(char[] str, int start, ArrayList<String>result){
            if(start == str.length - 1){
                if(!isExist(result, str)){
                    result.add(new String(str));
                }
                return ;
            }
            for(int i = start; i < str.length; i++){
                Swap(str, start, i);
                PermutationHelper(str, start + 1, result);
                Swap(str, start, i);
            }
        }
    }
}
