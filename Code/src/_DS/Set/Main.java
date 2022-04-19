package _DS.Set;

/**
 * @author Green写代码
 * @date 2022-04-19 19:38
 */
public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new ListSet<>()
                ;
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(12);
        set.add(10);
        set.add(17);
        set.traversal(new Set.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
