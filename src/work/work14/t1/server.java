package work.work14.t1;

import java.io.*;
import java.net.*;
public class server{
   public static void main(String args[]){
       ServerSocket server=null;//��������Socket
       Socket you=null; //�ͻ���Socket
       DataOutputStream out=null;//���������
       DataInputStream  in=null;//����������
       System.out.println("181603010819 �Կ�ǿ");

       String[] students = {"�Կ�ǿ","����","����","������"};
    
       try{ 
    	   server=new ServerSocket(4331);//�������������˿�Ϊ4331
       }
       catch(IOException e1){
            System.out.println("ERRO:"+e1);
       } 
       try{ 
    	   System.out.println("���������������ȴ��ͻ������ӡ���");
    	   you=server.accept();    //�ȴ��ͻ���Socket����
    	   
            in=new DataInputStream(you.getInputStream());//�����ͻ���Socket��������������
            
            out=new DataOutputStream(you.getOutputStream());//�����ͻ���Socket�������������


           while (true) {
               int i=in.readInt();  //ͨ��ʹ��in��ȡ�ͻ����������Ϣ������״̬�����Ƕ�ȡ����Ϣ
               if (i <= students.length-1) {
                   System.out.println("�������յ�:" + i);

                   out.writeUTF("�������ѧ�Ŷ�Ӧ��ѧ����" + students[i]);//ͨ��ʹ��out������Ϣ
               } else {
                   out.writeUTF("�������ѧ�ţ�"+i+"���޴���");//ͨ��ʹ��out������Ϣ
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
