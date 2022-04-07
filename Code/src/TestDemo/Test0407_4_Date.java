package TestDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 你得写代码
 * @date 2022-04-07 15:07
 */
public class Test0407_4_Date {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期 ----> 字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ----> 日期
        String str = "22-4-7 下午6:38";
        Date date1 = null;
        try {
            date1 = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        String format2 = sdf2.format(date);
        System.out.println(format1);
        System.out.println(format2);
        //解析
        String str11 = "2022.四月.07 公元 06:51 下午";
        Date date11 = null;
        try {
            date11 = sdf1.parse(str11);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date11);
    }
    public static void main1(String[] args) {
        //时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
        //构造器--创建当前时间的对象
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
        //创建指定时间的对象
        Date date1 = new Date(1649315348806L);//指定毫秒数对象，一些指定年月日的构造方法已经过时了，不建议用了
        System.out.println(date1.toString());

        //

    }
}
