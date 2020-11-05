package work.work5;

abstract class A {
    abstract void f(int x);

    abstract void g(int x, int y);

    abstract double h(double x);
}



class A1 extends A {
    @Override
    void f(int x) {
        System.out.println(x);
    }

    @Override
    void g(int x, int y) {
        System.out.println(x+y);
    }

    @Override
    double h(double x) {
        return x*x;
    }


}

class A2 extends A {

    @Override
    void f(int x) {
        System.out.println("hello"+x);
    }

    @Override
    void g(int x, int y) {
        System.out.println(x-y);
    }

    @Override
    double h(double x) {
        return Math.sqrt(x);

    }
}

class A3 extends A {

    @Override
    void f(int x) {
        System.out.println("你好"+x);
    }

    @Override
    void g(int x, int y) {
        System.out.println(1.0*x/y);
    }

    @Override
    double h(double x) {
        return 1/x;

    }
}
public class Example {
    public static void main(String[] args) {
        System.out.println("A类是A1,A2,A3的父类，用A的对象a调用子类的方法");
        System.out.println("\n创建A1对象，用它的上传转型对象a调用它的方法");
        A a = new A1();
        a.f(10);// 打印出输入的数值
        a.g(12, 20);// 打印出两数的和
        System.out.println(a.h(100)); //平方

        System.out.println("\n创建A2对象，用它的上传转型对象a调用它的方法");
        a = new A2();
        a.f(10); // 打印出输入的数值
        a.g(12, 20);// 打印出两数的差
        System.out.println(a.h(100)); //平方根

        System.out.println("\n创建A3对象，用它的上传转型对象a调用它的方法");
        a = new A3();
        a.f(10); // 打印出输入的数值
        a.g(12, 20); // 打印出两数的商
        System.out.println(a.h(100)); //倒数
        System.out.println("181603010819 赵开强");

    }
}
