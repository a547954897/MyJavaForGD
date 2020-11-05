package work.work14.t2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    static int win = 0;
    static int lose = 0;
    static int draw = 0;
    static int score = 0;

    public static String chuzhao(int player) {
        if (player == 1) {
            int i = ((int) (Math.random() * 10) % 3) + 1;
            switch (i) {
                case 2:
                    lose++;
                    return "������������Գ�ʯͷ�����ź������ˣ�";
                case 1:
                    draw++;
                    return "������������Գ�������ƽ�֣�";
                case 3:
                    win++;
                    return "������������Գ�������ϲ��Ӯ�ˣ�";
            }
        } else if (player == 2) {
            int i = ((int) (Math.random() * 10) % 3) + 1;
            switch (i) {
                case 2:
                    draw++;
                    return "���ʯͷ�����Գ�ʯͷ��ƽ�֣�";
                case 1:
                    win++;
                    return "���ʯͷ�����Գ���������ϲ��Ӯ�ˣ�";
                case 3:
                    lose++;
                    return "���ʯͷ�����Գ��������ź������ˣ�";
            }

        } else if (player == 3) {
            int i = ((int) (Math.random() * 10) % 3) + 1;
            switch (i) {
                case 2:
                    win++;
                    return "����������Գ�ʯͷ����ϲ��Ӯ�ˣ�";
                case 1:
                    lose++;
                    return "����������Գ����������ź������ˣ�";
                case 3:
                    draw++;
                    return "����������Գ�����ƽ�֣�";
            }
        } else if (player == 0) {
            win = 0;
            draw = 0;
            lose = 0;
            score = 0;
        } else {
            return "������벻��ȷ";
        }

        score = win - lose;
        return "";

    }

    public static void main(String args[]) {
        ServerSocket server = null;//��������Socket
        Socket you = null; //�ͻ���Socket
        DataOutputStream out = null;//���������
        DataInputStream in = null;//����������
        System.out.println("181603010819 �Կ�ǿ");

        try {
            server = new ServerSocket(4331);//�������������˿�Ϊ4331
        } catch (IOException e1) {
            System.out.println("ERRO:" + e1);
        }
        try {
            System.out.println("���������������ȴ��ͻ������ӡ���");
            you = server.accept();    //�ȴ��ͻ���Socket����

            in = new DataInputStream(you.getInputStream());//�����ͻ���Socket��������������

            out = new DataOutputStream(you.getOutputStream());//�����ͻ���Socket�������������


            while (true) {
                int i = in.readInt();  //ͨ��ʹ��in��ȡ�ͻ����������Ϣ������״̬�����Ƕ�ȡ����Ϣ
                if (i >= 0 && i < 4) {
                    out.writeUTF(chuzhao(i));//ͨ��ʹ��out������Ϣ
                } else {
                }
                Thread.sleep(500);
            }

        } catch (IOException e) {
            System.out.println("" + e);
        } catch (InterruptedException e) {
        }
    }
}
