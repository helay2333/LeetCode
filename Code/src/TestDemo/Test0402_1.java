package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-02 14:53
 */
public class Test0402_1 {
    public static void main(String[] args) {
        String s1 = "Hello";
        Test0402_1 test = new Test0402_1();
        test.change(s1);
        System.out.println(s1);
    }
    public void change(String s){
        s = "h9~~";
    }
    Animal a = new Animal("小花",12);;

}
class Animal{
    String name;
    int age;
    Animal(String name, int age){
        System.out.println("=====");
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("动物吃东西");
    }
}