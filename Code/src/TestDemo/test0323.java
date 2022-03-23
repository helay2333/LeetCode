package TestDemo;

public class test0323 {
    public static void main(String[] args) {
        int[] array;
        array = new int[10];
//        for(int i = 0; i < array.length; i++){
//            System.out.println(array[i]);
//        }
        //字符串
        String name = "zhouyu";
        System.out.println(name.length());
        System.out.println(name.equals("zhouyu"));
        System.out.println(name.substring(2));
        System.out.println(name.substring(2,4));
        System.out.println(name.charAt(4));
        System.out.println(name.indexOf("o"));
        System.out.println(name.replace('o', 'z'));
        System.out.println(name);
        String name2 = "  ssee  sa";
        System.out.println(name2.trim());
    }
}
