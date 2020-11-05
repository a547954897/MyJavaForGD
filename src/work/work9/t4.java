package work.work9;

import java.io.*;
import java.util.Scanner;

public class t4 {
    public static void main(String args[]) {
        RandomAccessFile rf = null;  //声明文件随机读取类
        Scanner reader = new Scanner(System.in);
        int num;
        try {
            rf = new RandomAccessFile("D:\\study\\java\\file\\ch8\\tom.txt", "rw");//初始化文件随机读取类，值为"D:/ch8/tom.dat","rw"
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("请输入五个整数");
            for (int i = 0; i < 5; i++) {
                num = reader.nextInt();  //键盘随机输入5个整数
                rf.writeInt(num);   //写入5个整数到文件
            }

            for (int i = 0; i < 5; i++) {//倒序
                //寻找到第i个整数的开始位置
                rf.seek(4*(4-i));
                num = rf.readInt(); //读取该整数
                System.out.print(num + " ");

            }
            System.out.println();
            rf.seek(8);//寻找到第3个整数的开始位置
            rf.writeInt(0);//将其修改为0
            for (int i = 0; i < 5; i++) { //顺序输出
                rf.seek(4 * i);
                num = rf.readInt();
                System.out.print(num + " ");
            }
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("181603010819 赵开强");
    }
}