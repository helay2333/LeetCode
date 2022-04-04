package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-04 16:25
 */
public class Test0404_4 {
//    Person11 p1 = new Person11();
}

abstract class Person11{
    String name;
    int age;

    public Person11(){

    }

    public Person11(String name,int age){
        this.name = name;
        this.age = age;
    }
//   抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("人走路");
    }
}

class Student11 extends Person11{
    public Student11(String name,int age){
        super(name,age);
    }
    public  void eat(){
        System.out.println("子类需要重写eat");
    }
}