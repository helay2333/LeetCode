package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-03 13:07
 */
class Person2{
    private String name;
    private int age;
    int id = 123456;//身份证号
    public Person2() {
        System.out.println("斯奥用");
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
        eat();
        show();
    }
    private void show(){
        System.out.println("我是父类的show");
    }

}
class Student1 extends Person2{
    String major;
    int id = 2020;//学号
    public Student1(){

    }

    public Student1(String major) {
        this.major = major;
    }
    public Student1(String name,int age,String major){
        super(name,age);
        this.major = major;
    }
    public void study(){
        System.out.println("学习，专业是"+major);
    }
    public void eat(){
        System.out.println("我是学生，我在吃饭");
    }
    public void show(){
        System.out.println("我是子类的show" + "身份证号是"+super.id+",学号是"+id);
        System.out.println("我是子类的show" + "身份证号是"+super.id+",学号是"+this.id);//这个this可以省略
    }
}
public class Test0403_1 {
    public static void main(String[] args) {
        Student1 stu = new Student1("计算机科学与技术");
//        stu.walk(10);
        stu.show();
        Student1 stu2 = new Student1("小花",18,"计算机");
        stu2.show();
    }
}
