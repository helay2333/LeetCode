package JZ.字符串;

/**
 * @author Green写代码
 * @date 2022-08-12 23:20
 */
public class JZ20 {
    public boolean isNumber(String s) {
        s = s.trim();
        try{
            double a = Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
