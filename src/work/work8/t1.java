package work.work8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class t1 {


    public static void main(String[] args) {
        Random random = new Random();
        int[] A = new int[20];
        int[] B = new int[10];

        System.out.println("�������20��������������A��");
        for (int i = 0; i < 20; i++) {
            A[i] = random.nextInt(100);
            System.out.print(A[i] + "   ");
        }
        System.out.println();
        System.out.println("������A�ĺ�ʮ���������Ƶ�����b��");

        for (int i = 0; i < B.length; i++) {
            System.arraycopy(A, 10, B, 0, 10);
            System.out.print(B[i] + "   ");
        }
        System.out.println();
        System.out.println("������B��������");
        Arrays.sort(B);
        for (int n : B) {
            System.out.print(n + "   ");
        }
        System.out.println();
        System.out.println("����Ҫ���ҵ�����");
        int num = new Scanner(System.in).nextInt();
        System.out.println("ʹ�ö�����ҷ���������B�в��ң�" + num);
        int index = Arrays.binarySearch(B, num);
        if (index > -1) {
            System.out.println(num + "���±��ǣ�" + index);
        } else {
            System.out.println(num + "����������");
        }
        System.out.println("181603010819 �Կ�ǿ");
    }

}
