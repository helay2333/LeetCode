package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-03 13:07
 */
class Person2{
    String name;
    int age;

    public Person2() {
    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("吃饭");
    }
    public void walk(int distance){
        System.out.println("走路，距离是"+distance);
    }

}
class Student1 extends Person2{
    String major;
    public Student1(){

    }

    public Student1(String major) {
        this.major = major;
    }
    public void study(){
        System.out.println("学习，专业是"+major);
    }
    public void eat(){
        System.out.println("我是学生，我在吃饭");
    }
}
public class Test0403_1 {
    public static void main(String[] args) {
        Student1 stu = new Student1("计算机科学与技术");
        stu.walk(10);
        stu.eat();
    }
}
