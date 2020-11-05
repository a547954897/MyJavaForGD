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
                    return "你出剪刀，电脑出石头，很遗憾你输了！";
                case 1:
                    draw++;
                    return "你出剪刀，电脑出剪刀，平局！";
                case 3:
                    win++;
                    return "你出剪刀，电脑出布，恭喜你赢了！";
            }
        } else if (player == 2) {
            int i = ((int) (Math.random() * 10) % 3) + 1;
            switch (i) {
                case 2:
                    draw++;
                    return "你出石头，电脑出石头，平局！";
                case 1:
                    win++;
                    return "你出石头，电脑出剪刀，恭喜你赢了！";
                case 3:
                    lose++;
                    return "你出石头，电脑出布，很遗憾你输了！";
            }

        } else if (player == 3) {
            int i = ((int) (Math.random() * 10) % 3) + 1;
            switch (i) {
                case 2:
                    win++;
                    return "你出布，电脑出石头，恭喜你赢了！";
                case 1:
                    lose++;
                    return "你出布，电脑出剪刀，很遗憾你输了！";
                case 3:
                    draw++;
                    return "你出布，电脑出布，平局！";
            }
        } else if (player == 0) {
            win = 0;
            draw = 0;
            lose = 0;
            score = 0;
        } else {
            return "你的输入不正确";
        }

        score = win - lose;
        return "";

    }

    public static void main(String args[]) {
        ServerSocket server = null;//服务器端Socket
        Socket you = null; //客户端Socket
        DataOutputStream out = null;//数据输出流
        DataInputStream in = null;//数据输入流
        System.out.println("181603010819 赵开强");

        try {
            server = new ServerSocket(4331);//建立服务器，端口为4331
        } catch (IOException e1) {
            System.out.println("ERRO:" + e1);
        }
        try {
            System.out.println("服务器已启动，等待客户端连接……");
            you = server.accept();    //等待客户端Socket连接

            in = new DataInputStream(you.getInputStream());//建立客户端Socket连接数据输入流

            out = new DataOutputStream(you.getOutputStream());//建立客户端Socket连接数据输出流


            while (true) {
                int i = in.readInt();  //通过使用in读取客户输出流的信息。堵塞状态，除非读取到信息
                if (i >= 0 && i < 4) {
                    out.writeUTF(chuzhao(i));//通过使用out发送信息
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
