package work.work14.t1;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client{
    public static void main(String args[]){
        Socket mysocket; //�ͻ���Socket
        DataOutputStream out=null;//���������
        DataInputStream  in=null;//����������
        String receive=null;  //�����ַ���

        System.out.println("181603010819 �Կ�ǿ");
        try{  mysocket=new Socket("localhost",4331); //ͨ��IP�Ͷ˿����ӷ�����
             in=new DataInputStream(mysocket.getInputStream());  //�����ͻ���Socket��������������
             out=new DataOutputStream(mysocket.getOutputStream()); //�����ͻ���Socket�������������
             Scanner read=new Scanner(System.in);

            while (true) {
                System.out.println("������ѧ��ѧ��:");
                int i=read.nextInt();

                out.writeInt(i);     //ͨ��out�������д����Ϣ
                receive=in.readUTF();//ͨ��ʹ��in��ȡ������д�����������Ϣ������״̬�����Ƕ�ȡ����Ϣ

                System.out.println("�ͻ��յ�:"+receive);

                Thread.sleep(500);
            }
        }
        catch(IOException e){
             System.out.println("�޷�����");
        }
        catch(InterruptedException e){}
    }
}
