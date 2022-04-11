package TestDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 你得写代码
 * @date 2022-04-10 16:06
 */
public class Test0410_3_reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取Class实例的方式
        //方式一：调用运行时类的属性 .class
        Class clazz1 = Person12.class;
        System.out.println(clazz1);//class TestDemo.Person12

        //方式二:通过运行时类的对象,调用getClass()
        Person12 p1 = new Person12();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三:调用Class的静态方法：forName(String.path)
        Class clazz3 = Class.forName("class TestDemo.Person12");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
        //方式四:使用类加载器ClassLoader
//        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
//        Class clazz4 = classLoader.loadClass("class TestDemo.Person12");
//        System.out.println(clazz4);
    }
    public static void main2(String[] args) throws Exception {
        Class clazz = Person12.class;//作为Class类的一个实例对象
        //通过反射创建一个Person12类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom",12);
        Person12 p = (Person12) obj;
        System.out.println(obj);
        System.out.println(p.toString());
        //通过反射，调用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");//空参
        show.invoke(p);
        System.out.println("=======");
        //通过反射可以调用Person12的私有结构：私有方法，构造器，属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person12 p1 = (Person12)cons1.newInstance("Jey");
        System.out.println(p1);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"asasas");
        System.out.println(p1);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");//invoke--->相当于调用
    }
    public static void main1(String[] args) {
        //
        Person12 p1 = new Person12("Tom",12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();
//        p1.name =
    }

}
class Person12 {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person12() {
    }

    public Person12(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person12(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show(){
        System.out.println("你好，我是🔔");
    }

    private String showNation(String nation){
        System.out.println("我的国籍" + nation);
        return nation;
    }
}
