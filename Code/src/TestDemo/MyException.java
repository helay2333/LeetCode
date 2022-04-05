package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-05 14:19
 */
public class MyException extends Exception{
    static final long serialVersionUID = -7034897193246939L;//序列号

    public MyException(){

    }

    public MyException(String msg){
        super(msg);
    }
}