package work.work5;
interface B {
    void f(int x);

    void g(int x, int y);

    double h(double x);
}
class B1 implements B{

    @Override
    public void f(int x) {
        System.out.println("调用f方法，传入整数为"+x);
    }

    @Override
    public void g(int x, int y) {
        System.out.println("调用g方法，传入整数的和为"+(x+y));

    }

    @Override
    public double h(double x) {

        return x*x;
    }
}
public class Example2 {

    public static void main(String[] args) {
        B b = new B1();
        b.f(10);
        b.g(10,20);
        System.out.println("调用h方法，传入整数的平方为"+b.h(100));


    }
}

