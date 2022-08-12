package leetcode;

public class code203 {
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode cur = newHead;
        ListNode next = cur.next;
        while(next != null){
            if(next.val == val){
                next = next.next;
                cur.next = next;
            }else{
                cur = cur.next;
                next = next.next;
            }

        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        removeElements(node1,2);
        System.out.println(node1);
    }
}
