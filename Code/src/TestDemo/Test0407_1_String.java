package TestDemo;

import java.util.Locale;

/**
 * String的使用
 */
public class Test0407_1_String {

    /**
     * 结论
     *     1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
     *     2.只要其中有一个是变量，结果就在堆中
     *     3.如果拼接的结果调用intern()方法，返回值就在常量池中
     *
     */

    public static void main(String[] args) {
        String s1 = "helloworld";
//        System.out.println(s1.length());
//        System.out.println(s1.charAt(0));
//        System.out.println(s1.toUpperCase());
        System.out.println(s1.indexOf("lo"));

        System.out.println(s1.indexOf("lo",5));
        String str3 = "hellorworld";

        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or",6));
    }
    public static void main1(String[] argc){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);//false

        final String s4 = "javaEE";//s4:常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);//true

    }

    public static void main2(String[] argc){
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s5.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true
    }
}

