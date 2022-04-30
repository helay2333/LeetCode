package OR;

import java.util.Scanner;

/**
 * @author Green写代码
 * @date 2022-04-30 17:11
 * https://www.nowcoder.com/practice/b6edb5ca15d34b1eb42e4725a3c68eba?tpId=179&&tqId=34268&rp=1&ru=/activity/oj&qru=/ta/exam-other/question-ranking
 */
public class OR170 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        while((count--) != 0){
            StringBuffer str = new StringBuffer(scan.next());
            int[] start = new int[1];
            int[] end = new int[1];
            if(IsPalindrome(str, start, end)){
                System.out.println(-1);
            }else{
                str.deleteCharAt(end[0]);
                if(IsPalindrome(str,null,null)){
                    System.out.println(end[0]);
                }else{
                    System.out.println(start[0]);
                }
            }
        }
    }
    public static boolean IsPalindrome(StringBuffer str, int[] start, int[] end){
        int left = 0;
        int right = str.length() - 1;
        boolean result = true;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                result = false;
                break;
            }
            left++;
            right--;
        }
        if(start!=null) start[0] = left;
        if(end!= null) end[0] = right;
        return result;
    }
}
