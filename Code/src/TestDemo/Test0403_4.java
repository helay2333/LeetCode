package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-03 20:00
 */
public class Test0403_4 {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);
        System.out.println(i == d);
        char c = 10;
        System.out.println(i == c);
        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);
        Order o1 = new Order("aaa");
        Order o2 = new Order("aaa");
        System.out.println(o1 == o2);
        System.out.println(o1.equals(o2));
        String str1 = new String("aaa");
        String str2 = new String("aaa");
        String str3 = "bbb";
        String str4 = "bbb";
        System.out.println(str1.equals(str2));//true
        System.out.println(str1==str2);//false
        System.out.println(str3==str4);//true

    }
}
class Order{
    String name;
    Order(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Order){
            Order o = (Order)obj;
            if(this.name.equals(o.name)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
