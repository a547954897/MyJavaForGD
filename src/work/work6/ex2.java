package work.work6;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        double a;
        int[] array = new int[2];
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("��������");
            a = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("�������ָ�ʽ��ƥ���쳣");
        }

        try {
            array[2] = 8;

        } catch (Exception e) {
            System.out.println("��������쳣");
            System.out.println(e.getStackTrace().toString());
        }
    }
}
