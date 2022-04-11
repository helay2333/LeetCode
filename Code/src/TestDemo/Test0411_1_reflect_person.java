package TestDemo;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author 你得写代码
 * @date 2022-04-11 08:33
 */
abstract class Creature <T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("太阳系");
    }

    public void eat(){
        System.out.println("银河系");
    }
}
interface MyInterface {
    void info();
}
public class Test0411_1_reflect_person {
    public static void main(String[] args) throws Exception {
        //调用运行时类中指定的结构：属性，方法
        Class clazz = Person222.class;
        //创建运行时类的对象
        Person222 p = (Person222) clazz.newInstance() ;

        //获取指定的属性：要求运行时类中属性为public的方法
        Field id = clazz.getField("id");

        /*
        set() :参数1 ：指明设置哪个对象的属性  参数2：此属性值设置为多少
        get() : 参数1 ：获取那个对象当前的属性
         */
        id.set(p,100);
        int pid = (int)id.get(p);
        System.out.println(pid);

        //getDeclaredField(String name) :获取指定变量名的一个属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);//-----> 必须写上这个表示当前属性是可以访问的
        name.set(p,"Tom");
        System.out.println(name.get(p));

        //获取指定方法
        //getDeclaredMethod():参数1：指定虎丘方法的名称  参数2：指明获取的方法的形参列表
        Method show = clazz.getDeclaredMethod("show",String.class);
        show.setAccessible(true);
        //调用invoke：参数1：方法调用者，参数2，给方法形参赋值
        //返回值就是这个对应类中调用方法的返回值
        show.invoke(p,"CHN");

        //调用静态方法
        Method showDec = clazz.getDeclaredMethod("showDec");
        showDec.setAccessible(true);
        showDec.invoke(p);
        showDec.invoke(null);//静态方法可以不指定是谁调用的，因为知道是什么类里的静态方法
        showDec.invoke(Person222.class);

        //构造器
        //private Person(String name)
        //1.获取指定的构造器
        //getDeclaredConstructor():参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person222 per = (Person222) constructor.newInstance("Tom");
        System.out.println(per);
    }
    public static void main5(String[] args) {
        Class clazz = Person.class;
        //获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
        System.out.println("++++++++++++++++++++++");

        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
        //获取运行时类所在的包
        Package pack = clazz.getPackage();
        System.out.println(pack);

        //获取运行时类声明的注解
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }
    public static void main4(String[] args) {
        Class clazz = Person222.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //获取运行时类带泛型的父类
        Type superclass2 = clazz.getGenericSuperclass();
        System.out.println(superclass2);

        //获取运行时类的带泛型的父类的泛型
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());
    }
    public static void main3(String[] args) {
        //获取构造器结构
        Class clazz = Person222.class;
        //getConstructors:获取当前运行时类中声明的public构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        System.out.println();
        //getDeclaredConstructors()获取当前运行时类中，声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c :declaredConstructors){
            System.out.println(c);
        }
    }
    public static void main2(String[] args) {
        Class clazz = Person222.class;
        //getMethods() ：获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        //getDeclaredMethods():获取当前运行时类中声明的所有方法(不包含父类中声明的方法)
        Method[] declaredMethod = clazz .getDeclaredMethods();
        for(Method m : declaredMethod){
            System.out.println(m);
        }
        //权限修饰符，返回值类型 方法名(参数类型 形参) throws XxxException

        for(Method m : declaredMethod){
            //获取权限修饰符
            System.out.println(Modifier.toString(m.getModifiers()));
            //获取返回值类型
            System.out.printf(m.getReturnType().getName() + " ");
            //获取方法名
            System.out.println(m.getName());
            //获取形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null && parameterTypes.length == 0)){
                for(Class p : parameterTypes){
                    int i = 1;
                    System.out.println(p.getName() + "args_" + i);
                    i++;
                }
            }
            //获取抛出的异常
            Class[] exceptionType =  m.getExceptionTypes();
            if(!(exceptionType == null && exceptionType.length == 0)){
                System.out.println("throws");
                for(int i = 0; i < exceptionType.length; i++){
                    System.out.println(exceptionType[i].getName());
                }
            }

        }

    }
    public static void main1(String[] args) {
        Class clazz = Person222.class;
        //获取属性结构
        //getFileds():获取当前运行时类及其父类中为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }

        //getDeclaredFields():获取当前运行时类当前的属性
        Field[] dec =  clazz.getDeclaredFields();
        for(Field f : dec){
            System.out.println(f);
        }
        for(Field f : dec){
            //获取权限修饰符
            int mod = f.getModifiers();
            System.out.println(Modifier.toString(mod));
            //获取数据类型
            Class type = f.getType();
            System.out.println(type);
            //获取变量名
            String fName = f.getName();
            System.out.println(fName);
        }

    }
}
class Person222 extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person222() {
    }


    Person222(String name){
        this.name = name;
    }

    private Person222(String name,int age){
        this.name = name;
        this.age = age;
    }


    private String show(String nation){
        System.out.println("我来自" + nation + "星系");
        return nation;
    }


    public void info() {
        System.out.println("火星喷子");
    }

    public String display(String play){
        return play;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static  void showDec(){
        System.out.println("静态方法");
    }
}