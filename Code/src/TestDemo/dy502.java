package TestDemo;

import java.util.Scanner;

/**
 * @author 你得写代码
 * @date 2022-04-05 00:09
 */
public class dy502 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        UseCompute use = new UseCompute();
        Com1er c1 = new Com1er();
        Com2er c2 = new Com2er();

        use.useCom(c1,m,n);
        use.useCom(c2,m,n);

    }
}
interface Compute{
    void computer(int n, int m);
}
class Com1er implements Compute{
    public void computer(int n, int m){
        System.out.println(n + "+" + m +"="+(n + m));
    }
}
class Com2er implements Compute{
    public void computer(int n , int m){
        System.out.println(n + "-" + m +"="+(n - m));
    }
}
class UseCompute{
    public void useCom(Compute com, int one, int two){
        com.computer(one,two);
    }
}
