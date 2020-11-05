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
        System.out.println("���"+x);
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
        System.out.println("A����A1,A2,A3�ĸ��࣬��A�Ķ���a��������ķ���");
        System.out.println("\n����A1�����������ϴ�ת�Ͷ���a�������ķ���");
        A a = new A1();
        a.f(10);// ��ӡ���������ֵ
        a.g(12, 20);// ��ӡ�������ĺ�
        System.out.println(a.h(100)); //ƽ��

        System.out.println("\n����A2�����������ϴ�ת�Ͷ���a�������ķ���");
        a = new A2();
        a.f(10); // ��ӡ���������ֵ
        a.g(12, 20);// ��ӡ�������Ĳ�
        System.out.println(a.h(100)); //ƽ����

        System.out.println("\n����A3�����������ϴ�ת�Ͷ���a�������ķ���");
        a = new A3();
        a.f(10); // ��ӡ���������ֵ
        a.g(12, 20); // ��ӡ����������
        System.out.println(a.h(100)); //����
        System.out.println("181603010819 �Կ�ǿ");

    }
}
