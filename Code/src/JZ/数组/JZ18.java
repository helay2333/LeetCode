package JZ.数组;

import leetcode.ListNode;

/**
 * @author Green写代码
 * @date 2022-08-10 19:44
 */
public class JZ18 {
    static class  ListNode{
        int val;

        public ListNode(int val) {
            this.val = val;
        }

        ListNode next;

    }
     static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        while(head != null && cur.val == val){
            head = head.next;
        }
        cur = head;
        while(cur.next != null){
            if(cur.next.val == val){
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp = null;
            }else{
                cur = cur.next;

            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode cur = deleteNode(head, 2);
    }
}
