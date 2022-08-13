package JZ.链表;

/**
 * @author Green写代码
 * @date 2022-08-13 18:15
 */
public class JZ25 {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode  mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode res = newHead;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val){
                res.next = h1;
                h1 = h1.next;
                res = res.next;

            }else{
                res.next = h2;
                h2 = h2.next;
                res = res.next;

            }
        }
        res.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    public static void main(String[] args) {
        
    }
}
