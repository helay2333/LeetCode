package DS.LinkList;

class LinkNode {
    public int data;
    public String name;
    public String nickname;
    public  LinkNode nextNode;
    public LinkNode(int data, String name, String nickname) {
        this.data = data;
        this.name = name;
        this.nickname = nickname;
    }
}
//实现单链表
class SingleLinkList {
    //初始化头节点
    LinkNode head = new LinkNode(0,"","");
    //添加节点
    public void addNode(LinkNode newNode) {
        LinkNode tmp = head;
        while(tmp.nextNode != null){
            tmp = tmp.nextNode;
        }
        tmp.nextNode = newNode;
    }
    //以排名插入特定位置
    public void addByOrder(LinkNode newNode) {
        LinkNode tmp = head.nextNode;
        boolean flag = false;//标识编号是否编号存在
        while(true){
            if (tmp.nextNode == null) {
                break;
            }
            if(newNode.data < tmp.nextNode.data) {
                break;
            }else if(newNode.data == tmp.nextNode.data){
                flag = true;
                break;
            }
            tmp = tmp.nextNode;
        }
        if(flag) {
            System.out.printf("序号%d为节点已经存在，不能添加了",newNode.data);
        }else{
            newNode.nextNode = tmp.nextNode;
            tmp.nextNode = newNode;
        }

    }
    //修改节点信息
    public void update(LinkNode newNode) {
        if(head.nextNode == null) {
            System.out.println("链表为空");
            return;
        }
        LinkNode tmp = head.nextNode;
        boolean flag = false;
        while(tmp!=null) {
            if(tmp.data != newNode.data){
                tmp = tmp.nextNode;
            }else {
                flag = true;
                break;
            }
        }
        if(flag) {
            tmp.name = newNode.name;
            tmp.nickname = newNode.nickname;
        }else{
            System.out.printf("没有找到编号为%d的节点，无法修改\n",newNode.data);
        }
    }
    //删除
    public void del(int data) {
        LinkNode tmp = head;
        boolean flag = false;
        while(tmp.nextNode!=null){
            if(tmp.nextNode.data != data){
                tmp = tmp.nextNode;
            }else{
                flag = true;
                break;
            }
        }
        if(flag) {
            tmp.nextNode = tmp.nextNode.nextNode;
        }else {

            System.out.printf("没有找到编号为%d的节点，无法删除\n",data);
        }
    }
    //展示，遍历
    public void list() {
        if(head.nextNode == null) {
            System.out.println("链表为空");
            return ;
        }
        LinkNode tmp = head.nextNode;
        while(tmp != null) {
            System.out.printf("节点%d，名字为%s,昵称为%s",tmp.data,tmp.name,tmp.nickname);
            System.out.println();
            tmp = tmp.nextNode;
        }
    }

}

class SingleLinkDemo {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1, "111","1");
        LinkNode node2 = new LinkNode(2, "222","2");
        LinkNode node3 = new LinkNode(3, "333","3");
        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addNode(node1);
        singleLinkList.addNode(node2);
        singleLinkList.addNode(node3);
        singleLinkList.list();
        getLength(singleLinkList.head);
        //修改
        LinkNode newNode = new LinkNode(2,"002","222");
        singleLinkList.update(newNode);
        singleLinkList.list();
        //删除
        singleLinkList.del(2);
        singleLinkList.del(4);
        singleLinkList.list();
    }
    public static int getLength(LinkNode head) {
        if(head.nextNode == null) {
            return 0;
        }
        int len = 0;
        LinkNode tmp = head;
        while(tmp.nextNode !=null) {
            len++;
            tmp = tmp.nextNode;
        }
        System.out.println("长度为"+len);
        return len;
    }
}



