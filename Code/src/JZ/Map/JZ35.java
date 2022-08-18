package JZ.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Green写代码
 * @date 2022-08-18 14:55
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class JZ35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null) {
            Node newCur = new Node(cur.val);
            map.put(cur, newCur);
        }
        for(Node key : map.keySet()){
            map.get(key).next = map.get(key.next);
            map.get(key).random = map.get(key.random);
        }
        return map.get(1);
    }
}
