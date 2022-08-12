package JZ.数组;

/**
 * @author Green写代码
 * @date 2022-08-10 13:53
 */
public class JZ17 {
    static StringBuilder res;
    static int count = 0, n;
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static String printNumbers(int n) {
        JZ17.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    static void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }

    public static void main(String[] args) {
        System.out.println(printNumbers(1));
    }
//    public int[] printNumbers(int n) {
//        int num =(int)Math.pow(10,n);
//        System.out.println(num);
//        int [] arr = new int[num - 1];
//        for(int i = 0,j = 1; i < num - 1; i++){
//            arr[i] = j;
//            j++;
//        }
//        return arr;
//    }
}
