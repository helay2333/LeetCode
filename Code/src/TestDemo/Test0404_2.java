package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-04 11:06
 */
public class Test0404_2 {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4};
        print(arr);
        System.out.println(arr.getClass().getSuperclass());
    }
    public static void print(Object obj){
        System.out.println(obj);
    }
}
