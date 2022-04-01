package DS.Huffmantree;

/**
 * @author 你得写代码
 * @date 2022-03-28 15:40
 */
public class HuffmanTree {
    public static void main(String[] args) {
        print(1);
    }
    public static void print(int n){
        if(n == 5){
            return;
        }
        print(n + 1);
        System.out.println("=====");
    }
}
