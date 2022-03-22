package DS.LinkList;
class DoubleNode{
    public int data;
    public String name;
    public String nickname;
    public DoubleNode next;
    public DoubleNode pre;
    public DoubleNode(int data, String name, String nickname){
        this.data = data;
        this.name = name;
        this.nickname = nickname;
    }

}
public class DoubleLinkedList {
    private DoubleNode head = new DoubleNode(0,"","");
    public DoubleNode getHead(){
        return head;
    }
    //遍历
    public void list(){
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode tmp = head.next;
        while(tmp.next!=null) {
            System.out.println(tmp.data+" "+tmp.name+" "+tmp.nickname);
            tmp = tmp.next;
        }
    }
    //add
    public  void add(DoubleNode Node) {
        DoubleNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = Node;
        Node.pre = tmp;
    }
    //修改
//    public void update(DoubleNode Node) {
//        if(head.next == null){
//            System.out.println("链表为空");
//            return;
//        }
//        DoubleNode tmp = head.next;
//        boolean flag = false;
//        while(tmp != null){
//            if()
//        }
//    }
}
