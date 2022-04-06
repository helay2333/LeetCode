package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-06 20:35
 */
public class Test0406_11_String {
    public static void main(String[] args) {
        //方式一：字面量
        String s1 = "JavaSE";
        String s2 = "JavaSE";
        //方式二：构造器:此时保存地址值，是数据在堆空间开辟的空间对应的地址
        String s3 = new String("JavaSE");
        String s4 = new String("JavaSE");
    }
    public static void main1(String[] args) {
        String s1 = "abc";//字面量定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);//表示比较地址值  -  true
        s1 = "hello";
        System.out.println(s1 == s2);//表示比较地址值  -  false
        System.out.println(s1);//hello
        System.out.println(s2);//abc
        s2+="def";
        System.out.println(s2);
        String s3 = s2.replace("a","rrr");
        System.out.println(s2);
        System.out.println(s3);
    }
}
