package work.work14.t4;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        System.out.println("181603010819 赵开强");
        Scanner scanner = new Scanner(System.in);
        System.out.println("程序已开始，请提问：");
        while (true) {
            String question = scanner.nextLine();
            if (question.equals("exit")) {
                System.out.println("程序已退出");
                System.exit(0);
            }
            Thread thread = new Thread(new GetNet(question));
            thread.start();

        }
    }
}
