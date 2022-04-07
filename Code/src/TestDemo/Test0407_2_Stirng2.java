package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-07 13:48
 */
public class Test0407_2_Stirng2 {
    public static void main(String[] args) {
        String str1 = "abc123";
        char[] arr = str1.toCharArray();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        char[] arr2 = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr2);
        System.out.println(str2);
    }
    public static void main1(String[] args) {
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);

        String str2 = String.valueOf(num);
        System.out.println(str2);
        String str3 = num + "";
        System.out.println(str3);
    }
}
