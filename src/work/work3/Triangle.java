package work.work3;

import java.util.Scanner;

public class Triangle {
    double sideA;
    double sideB;
    double sideC;
    boolean isTriangle;
    public void setLength(double a, double b, double c) {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
    }

    public boolean isTriangle() {
        if (sideA + sideB - sideC > 0 && sideA + sideC - sideB > 0 && sideB + sideC - sideA > 0) {
            this.isTriangle = true;
            return true;
        } else {
            this.isTriangle = false;
            return false;
        }
    }

    public void getArea() {
        System.out.println("���������������ε�����:");
        Scanner scanner = new Scanner(System.in);
        this.sideA = scanner.nextDouble();
        this.sideB = scanner.nextDouble();
        this.sideC = scanner.nextDouble();
        if (isTriangle()) {
            double p = (sideA + sideB + sideC) / 2;
            double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
            System.out.println("����һ�����������Ϊ" + area);
        } else {
            System.out.println("���벻������������,����������");
            getArea();
        }
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        triangle.getArea();
        System.out.println("181603010819 �Կ�ǿ");
    }


}
