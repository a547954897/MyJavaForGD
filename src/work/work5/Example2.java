package work.work5;
interface B {
    void f(int x);

    void g(int x, int y);

    double h(double x);
}
class B1 implements B{

    @Override
    public void f(int x) {
        System.out.println("����f��������������Ϊ"+x);
    }

    @Override
    public void g(int x, int y) {
        System.out.println("����g���������������ĺ�Ϊ"+(x+y));

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
        System.out.println("����h����������������ƽ��Ϊ"+b.h(100));


    }
}

