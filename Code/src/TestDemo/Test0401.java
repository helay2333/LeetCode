package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-01 16:10
 *
 */
public class Test0401 {
    public static void main(String[] args) {
        Person1 p = new Person1();
        p.age = 12;
        p.name = "小花";
        p.sex = 1;
        p.showAge();
        p.study();
        p.addAge(12);
        p.showAge();
        System.out.println("======");
        Circle c = new Circle();
        c.radius = 1;
        System.out.println(c.getArea());
    }
}

/**
 * age:年龄
 * sex:性别
 */
class Person{
    String name;
    int age;
    int sex;
    public void study(){
        System.out.println("studying");
    }
    public void showAge(){
        System.out.println("age"+age);
    }
    public int addAge(int i) {
        age+=i;
        return age;
    }
}
//圆
class Circle{
    double radius;
    public double getArea(){
        //注意此处就不要参数了
        return 3.14*radius*radius;
    }
}