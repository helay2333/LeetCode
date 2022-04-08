package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-08 12:18
 */
public class Test0408_2_enum {
    public static void main(String[] args) {
        Season1 sum = Season1.SSUMMER;
        System.out.println(sum);//打印发现不是地址值，那么toString是重写过的，不是object的
        System.out.println(Season1.class.getSuperclass());//class java.lang.Enum ---->  所以说是继承了enum的toString

        //values():查看枚举类的状态
        Season1[] values = Season1.values();
        for(int i = 0; i < values.length; i++){
            System.out.println(values[i]);
            values[i].show();
        }
        //valueOf(objName):根据提供的字符串objName，返回枚举类中对象名是objName的对象
        //如果没有找到，会报错
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}
interface Info{
    void show();
}
enum Season1 implements Info{
    //1.创建当前枚举类的对象，多个对象之间使用，隔开，末尾的对象使用;结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天");
        }
    },
    SSUMMER("夏天","春暖花开"){
        @Override
        public void show() {
            System.out.println("夏天");

        }
    },
    AUTUMN("秋天","春暖花开"){
        @Override
        public void show() {
            System.out.println("秋天");

        }
    },
    WINTER("冬天","春暖花开"){
        @Override
        public void show() {
            System.out.println("冬天");

        }
    };
    //声明Season对象属性:需要使用private final修饰----->枚举类属性定义都是这样
    private final String seasonName;
    private final String seasonDesc;
    //final使用构造器初始化
    private Season1(String seasonName, String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //其他要求

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("季节");
//    }
}