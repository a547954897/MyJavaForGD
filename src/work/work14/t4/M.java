package work.work14.t4;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        System.out.println("181603010819 �Կ�ǿ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("�����ѿ�ʼ�������ʣ�");
        while (true) {
            String question = scanner.nextLine();
            if (question.equals("exit")) {
                System.out.println("�������˳�");
                System.exit(0);
            }
            Thread thread = new Thread(new GetNet(question));
            thread.start();

        }
    }
}
