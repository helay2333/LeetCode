package TestDemo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 你得写代码
 * @date 2022-04-07 19:28
 */
public class Test0407_5_Calender {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());
        int i = calendar.get(Calendar.DAY_OF_MONTH);//这个月第几天
        System.out.println(i);
        int i1 = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(i1);
        //set
        calendar.set(Calendar.DAY_OF_MONTH,10);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //add
        calendar.add(Calendar.DAY_OF_MONTH,10);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //getTime
        //日历类---->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime
        //Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
    }
}
