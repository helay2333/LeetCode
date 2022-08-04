package JZ.链表;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-08-03 12:35
 */
public class JZ06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        int i = list.size() - 1;
        for(Integer e : list){
            ans[i--] = e;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
