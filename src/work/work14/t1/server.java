package work.work14.t1;

import java.io.*;
import java.net.*;
public class server{
   public static void main(String args[]){
       ServerSocket server=null;//服务器端Socket
       Socket you=null; //客户端Socket
       DataOutputStream out=null;//数据输出流
       DataInputStream  in=null;//数据输入流
       System.out.println("181603010819 赵开强");

       String[] students = {"赵开强","马云","马化腾","王健林"};
    
       try{ 
    	   server=new ServerSocket(4331);//建立服务器，端口为4331
       }
       catch(IOException e1){
            System.out.println("ERRO:"+e1);
       } 
       try{ 
    	   System.out.println("服务器已启动，等待客户端连接……");
    	   you=server.accept();    //等待客户端Socket连接
    	   
            in=new DataInputStream(you.getInputStream());//建立客户端Socket连接数据输入流
            
            out=new DataOutputStream(you.getOutputStream());//建立客户端Socket连接数据输出流


           while (true) {
               int i=in.readInt();  //通过使用in读取客户输出流的信息。堵塞状态，除非读取到信息
               if (i <= students.length-1) {
                   System.out.println("服务器收到:" + i);

                   out.writeUTF("你输入的学号对应的学生是" + students[i]);//通过使用out发送信息
               } else {
                   out.writeUTF("你输入的学号："+i+"查无此人");//通过使用out发送信息
               }
               Thread.sleep(500);
           }
           
       }
       catch(IOException e){
            System.out.println(""+e);
       }
       catch(InterruptedException e){}
    }
}
