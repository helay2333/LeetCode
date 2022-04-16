package _DS.Queue;

/**
 * @author Green写代码
 * @date 2022-04-16 22:00
 */
public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);
        while(!q.isEmpty()){
            System.out.println(q.deQueue());
        }
    }
}
