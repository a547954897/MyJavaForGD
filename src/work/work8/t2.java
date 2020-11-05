package work.work8;

import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        /*
        日暮苍山兰舟小
本无落霞缀清泉
去年叶落缘分定
死水微漾人却亡
         */
        char[][] ts = new char[4][7];
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.println("输入诗句：");
        for (int i = 0; i < ts.length; i++) {
            str = scanner.nextLine();
            ts[i] = str.toCharArray();
        }
        System.out.println("\n藏头：");
        for (int i = 0; i < ts.length; i++) {
            for (int j = 0; j < ts[i].length; j++) {
                if (j == 0) {
                    System.out.print(ts[i][j]);
                }
            }
        }
        System.out.println();
        System.out.println("藏尾：");
        for (int i = 0; i < ts.length; i++) {
            for (int j = 0; j < ts[i].length; j++) {
                if (j == ts[i].length - 1) {
                    System.out.print(ts[i][j]);
                }

            }

        }
        System.out.println("181603010819 赵开强");

    }

}
