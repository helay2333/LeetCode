package TestDemo;

import java.time.*;

/**
 * @author 你得写代码
 * @date 2022-04-07 19:59
 */
public class Test0407_6_Jdk8API {
    public static void main(String[] args) {

    }
    public static void main3(String[] args) {
        //本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //toEpochMilli：获取1970年对应的毫秒数 --- 时间戳
        long milli = instant.toEpochMilli();
        System.out.println(milli);
        //ofEpochMilli:通过毫秒数获取时间
        Instant instant1 = Instant.ofEpochMilli(1649333886443L);
        System.out.println(instant1);
    }
    public static void main2(String[] args) {
        //now()获取当前日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()指定年月日时分秒。没有偏移量
        LocalDateTime LocalDateTime1 = LocalDateTime.of(2020, 1, 1, 10, 10, 10);
        System.out.println(LocalDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //withXxx   ----  体现不可变性
        //设置相关属性
        LocalDate loc = localDate.withDayOfMonth(10);
        System.out.println(localDate);        //2022-04-07
        System.out.println(loc);        //2022-04-10

        LocalDateTime ll = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(ll);

        //不可变性
        //加
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
        //减
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }
}
