package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-03 16:18
 */
class Person3{
    String name;
    int age;
    int id = 1001;
    public void eat(){
        System.out.println("人，吃饭");
    }

    public void walk(){
        System.out.println("人，走路");
    }
}
class Man extends Person3{
    boolean isSmoking;
    int id = 1002;
    public void earnMoney(){
        System.out.println("男人负责工作养家");
    }

    public void eat() {
        System.out.println("男人多吃肉，长肌肉");
    }

    public void walk() {
        System.out.println("男人霸气的走路");
    }
}
class woman extends Person3{
    boolean isBeauty;
    public void goShopping(){
        System.out.println("女人喜欢购物");
    }
    public void eat(){
        System.out.println("减肥");
    }
    public void walk(){
        System.out.println("苗条的走路");
    }
}
public class Test0403_2 {
    public static void main(String[] args) {
        Person3 p1 = new Person3();
//        p1.eat();
//        Man man = new Man();
//        man.eat();
//        man.earnMoney();
        //多态性：声明的变量和右边的对象是多种形态,父类的引用指向子类的对象
        Person3 p2 = new Man();
        p2.eat();//当子类调用父类的同名方法的时候，实际上执行的是子类中重写的方法，这叫做虚拟方法调用
//        p2.earnMoney();
        System.out.println(p2.id);
        if(p2 instanceof  Man){
            Man m1 = (Man)p2;
            m1.earnMoney();
        }
        if(p2 instanceof woman){
            woman w1 = (woman)p2;//ClassCastException,因为我们是new Man()创建的p2
            w1.goShopping();
        }
    }
}
