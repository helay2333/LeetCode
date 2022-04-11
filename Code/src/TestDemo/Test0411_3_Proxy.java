package TestDemo;/**
 * @author: Green
 * @date: 2022/4/11 11:15
 * @description:
 */

import java.time.Year;

/**
 * @author Green写代码
 * @date 2022-04-11 11:15
 */
interface Human{
    String getBelief();
    void eat(String food);
}
class SuperMan implements Human{
    public String food;
    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }

    @Override
    public String getBelief() {
        return "I can do it";
    }
}
public class Test0411_3_Proxy {
}
