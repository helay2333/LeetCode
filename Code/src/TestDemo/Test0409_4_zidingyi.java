package TestDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 你得写代码
 * @date 2022-04-09 15:44
 */
public class Test0409_4_zidingyi{
    public static void main(String[] args) {
        //如果定义泛型类，实例化的时候没有指明泛型，则认为此泛型类型是Object
        //那么就可以传递很多类型的值->一般建议如果定义的类是泛型的，实例化的时候就之名类的泛型
        Order22 order22 = new Order22();
        order22.setOrderT(123);
        order22.setOrderT("ABC");

        Order22<String>order221 = new Order22<>("order",18,"这是order");//jdk7之后可以自动检测。前面写了，后面就可以不写了
        System.out.println(order221.getOrderT());

        order221.setOrderT("12212");
        System.out.println(order221.getOrderT());

        Order22<String> order222 = new Order22<>();
        Integer[] arr = new Integer[]{1,2,3};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> integers = order222.copyFromArrayToList(arr);
        System.out.println(integers);
    }
}
class Order22<T>{
    String orderName;
    int orderId;
    T orderT;//T--->类的泛型
    public Order22(){};

    public Order22(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT = orderT;
    }
    //泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系
    //也就是泛型方法所属的类是不是泛型类都没有关系
    //泛型方法：可以声明为静态的。原因：泛型参数是在调用方法的时候确定的。并非是实例化类时候确定的
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr){
            list.add(e);
        }
        return list;

    }
}
class subOrder extends Order22<Integer>{
    //子类继承带泛型的父类时，指明了泛型类型。所以子类就实例化就可以不带<>
}
class subOrder2<T> extends Order22<T>{
    //此时subOrder2依旧是泛型类
}

