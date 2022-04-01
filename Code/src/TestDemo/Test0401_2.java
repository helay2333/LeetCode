package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-01 16:41
 */


public class Test0401_2 {
    public static void main(String[] args) {
        new Student().score = 99;
        System.out.println(new Student().score);
//        Student s1 = new Student();
//        Student s2 = new Student();
//        Student s3 = new Student();
//        Student s4 = new Student();
        //声明一个Student的数组
        Student[] stu = new Student[20];//对象数组
        for(int i = 0; i < stu.length; i++){
            stu[i] = new Student();//将null变成new Student()
            //给Student对象属性赋值
            stu[i].number = (i + 1);
            //年纪【1-6】
            stu[i].state = (int)(Math.random()*(6-1+1)+1);
//            成绩
            stu[i].score = (int)(Math.random() * (100 - 0 + 1));
        }
        //遍历
//        for(int i = 0; i < stu.length; i++) {
//            //System.out.println(stu[i]);//引用对象不是null就是地址值
//            System.out.println(stu[i].info());
//        }
        //打印三年级学生信息
//        for(int i = 0; i < stu.length; i++) {
//            if(stu[i].state == 3){
//                System.out.println(stu[i].info());
//            }
//        }
        //学生成绩排序，然后遍历信息
        for (int i = 0; i < stu.length - 1; i++){
            for(int j = 0; j < stu.length - 1 - i; j++) {
                if(stu[j].score > stu[j + 1].score) {
                    Student s = new Student();
                    s = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = s;
                }
            }
        }
        for(int i = 0; i < stu.length; i++) {
            //System.out.println(stu[i]);//引用对象不是null就是地址值
            System.out.println(stu[i].info());
        }

    }
//    public static void main(String[] args) {
//        method();
//    }
//    public static void method(){
//        System.out.println("this is method");
//    }
}
class Student{
    int number;//学号
    int state;//年级
    int score;
    //显示方法
    public String info(){
        return "学号"+number+" 年纪" + state +" 分数"+score;
    }
}

