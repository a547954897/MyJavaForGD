package work.work8;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        /*
        ��ĺ��ɽ����С
������ϼ׺��Ȫ
ȥ��Ҷ��Ե�ֶ�
��ˮ΢����ȴ��
         */
        char[][] ts = new char[4][7];
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.println("����ʫ�䣺");
        for (int i = 0; i < ts.length; i++) {
            str = scanner.nextLine();
            ts[i] = str.toCharArray();
        }
        System.out.println("\n��ͷ��");
        for (int i = 0; i < ts.length; i++) {
            for (int j = 0; j < ts[i].length; j++) {
                if (j == 0) {
                    System.out.print(ts[i][j]);
                }
            }
        }
        System.out.println();
        System.out.println("��β��");
        for (int i = 0; i < ts.length; i++) {
            for (int j = 0; j < ts[i].length; j++) {
                if (j == ts[i].length - 1) {
                    System.out.print(ts[i][j]);
                }

            }

        }
        System.out.println("181603010819 �Կ�ǿ");

    }

}
