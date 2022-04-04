package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-04 02:12
 */
public class Test0404_1 {
    public static void main(String[] args) {
        int num1 = 10;
        String str1 = num1 + "";
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);
        Double d1 = new Double(12.4);
        String str3 = String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3);	//"12.4"


        String str4 = "123";
//		Integer in1 = (Integer)str1;//两个毫无关系的对象，无法强转成功。这里没有子父类关系
        int i = Integer.parseInt(str4);//如果str4里面有不是数字字符，就可能报错
        //boolean转换只要不是true就是false----True都是false
    }
}
