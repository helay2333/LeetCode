package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-03 16:35
 */
public class Test0403_3 {
    public static void main(String[] args) {
        Test0403_3 test = new Test0403_3();
        test.func(new Dog());
    }
    public void func(Animal1 animal){//Animal animal = new Dog()
        animal.eat();
        animal.shout();
    }

}
class Animal1{
    public void eat(){
        System.out.println("动物，进食");
    }

    public void shout(){
        System.out.println("动物：叫");
    }
}

class Dog extends Animal1{

    public void eat(){
        System.out.println("狗吃骨头");
    }

    public void shout() {
        System.out.println("汪！汪！汪！");
    }
}

class Cat extends Animal1{
    public void eat(){
        System.out.println("猫吃鱼");
    }

    public void shout() {
        System.out.println("喵！喵！喵！");
    }
}
