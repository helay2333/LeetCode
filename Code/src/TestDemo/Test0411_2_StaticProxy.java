package TestDemo;/**
 * @author: Green
 * @date: 2022/4/11 11:09
 * @description:
 */

/**
 * @author Green写代码
 * @date 2022-04-11 11:09
 */
interface ClothFactory{
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象进行实例化
    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些工作");
        factory.produceCloth();
        System.out.println("代理工厂做收尾工作");
    }
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
}
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("生产Nike运动服");
    }
}

public class Test0411_2_StaticProxy {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();

        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
