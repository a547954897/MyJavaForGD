package work.work8;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class t1 {


    public static void main(String[] args) {
        Random random = new Random();
        int[] A = new int[20];
        int[] B = new int[10];

        System.out.println("随机生成20个整数放入数组A中");
        for (int i = 0; i < 20; i++) {
            A[i] = random.nextInt(100);
            System.out.print(A[i] + "   ");
        }
        System.out.println();
        System.out.println("将数组A的后十个整数复制到数组b中");

        for (int i = 0; i < B.length; i++) {
            System.arraycopy(A, 10, B, 0, 10);
            System.out.print(B[i] + "   ");
        }
        System.out.println();
        System.out.println("将数组B升序排序：");
        Arrays.sort(B);
        for (int n : B) {
            System.out.print(n + "   ");
        }
        System.out.println();
        System.out.println("输入要查找的数：");
        int num = new Scanner(System.in).nextInt();
        System.out.println("使用二叉查找方法在数组B中查找：" + num);
        int index = Arrays.binarySearch(B, num);
        if (index > -1) {
            System.out.println(num + "的下标是：" + index);
        } else {
            System.out.println(num + "不在数组中");
        }
        System.out.println("181603010819 赵开强");
    }

}
