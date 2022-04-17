package _DS.Tree;

/**
 * @author Green写代码
 * @date 2022-04-17 16:35
 */
public class Person1 implements java.lang.Comparable<Person1> {
    public int age;

    public Person1(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Person1 o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return "age=" + age ;
    }
}
