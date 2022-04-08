package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-08 12:07
 */
public class Test0408_1 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
class Season{
    //1声明Season对象属性:需要使用private final修饰----->枚举类属性定义都是这样
    private final String seasonName;
    private final String seasonDesc;
    //2final使用构造器初始化
    private Season(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3提供对外的创建对象方法
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SSUMMER = new Season("春天","春暖花开");
    public static final Season AUTUMN = new Season("春天","春暖花开");
    public static final Season WINNER = new Season("春天","春暖花开");
    //4其他要求

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
