package work.work9;

import java.io.*;
import java.util.Scanner;

public class t4 {
    public static void main(String args[]) {
        RandomAccessFile rf = null;  //�����ļ������ȡ��
        Scanner reader = new Scanner(System.in);
        int num;
        try {
            rf = new RandomAccessFile("D:\\study\\java\\file\\ch8\\tom.txt", "rw");//��ʼ���ļ������ȡ�ֵ࣬Ϊ"D:/ch8/tom.dat","rw"
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("�������������");
            for (int i = 0; i < 5; i++) {
                num = reader.nextInt();  //�����������5������
                rf.writeInt(num);   //д��5���������ļ�
            }

            for (int i = 0; i < 5; i++) {//����
                //Ѱ�ҵ���i�������Ŀ�ʼλ��
                rf.seek(4*(4-i));
                num = rf.readInt(); //��ȡ������
                System.out.print(num + " ");

            }
            System.out.println();
            rf.seek(8);//Ѱ�ҵ���3�������Ŀ�ʼλ��
            rf.writeInt(0);//�����޸�Ϊ0
            for (int i = 0; i < 5; i++) { //˳�����
                rf.seek(4 * i);
                num = rf.readInt();
                System.out.print(num + " ");
            }
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("181603010819 �Կ�ǿ");
    }
}