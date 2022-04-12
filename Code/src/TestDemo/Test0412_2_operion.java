package TestDemo;

import java.util.Optional;

/**
 * @author Green写代码
 * @date 2022-04-12 11:29
 */
public class Test0412_2_operion {
    public static void main(String[] args) {
        Girl g = new Girl();
        g = null;
        Optional<Girl> g1 = Optional.of(g);
    }
}

class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
