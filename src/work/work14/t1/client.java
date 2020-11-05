package work.work14.t1;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client{
    public static void main(String args[]){
        Socket mysocket; //客户端Socket
        DataOutputStream out=null;//数据输出流
        DataInputStream  in=null;//数据输入流
        String receive=null;  //接收字符串

        System.out.println("181603010819 赵开强");
        try{  mysocket=new Socket("localhost",4331); //通过IP和端口连接服务器
             in=new DataInputStream(mysocket.getInputStream());  //建立客户端Socket连接数据输入流
             out=new DataOutputStream(mysocket.getOutputStream()); //建立客户端Socket连接数据输出流
             Scanner read=new Scanner(System.in);

            while (true) {
                System.out.println("请输入学生学号:");
                int i=read.nextInt();

                out.writeInt(i);     //通过out向服务器写入信息
                receive=in.readUTF();//通过使用in读取服务器写入输出流的信息。堵塞状态，除非读取到信息

                System.out.println("客户收到:"+receive);

                Thread.sleep(500);
            }
        }
        catch(IOException e){
             System.out.println("无法连接");
        }
        catch(InterruptedException e){}
    }
}
