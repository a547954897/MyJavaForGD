//package work.work14.t4;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//public class mserver {
//	public static void main(String args[]){
//		ServerSocket server=null;
//		ServerThread thread;
//		Socket player=null;
//		System.out.println("�ȴ��ͻ������ӡ���");
//		while(true){
//			try{
//				server=new ServerSocket(4331);
//			}
//			catch(IOException e1){System.out.println("�ȴ��ͻ������ӡ���");}
//			try{
//
//				player=server.accept();
//				System.out.println("��ҵĵ�ַ��"+player.getInetAddress());//��ȡ���IP��ַ
//			}
//			catch(IOException e){System.out.println("���ڵȴ����");}
//			if(player!=null)
//				new ServerThread(player).start();//Ϊÿ����ҷ���һ���߳�
//			else
//				continue;
//		}
//	}
//}
//class ServerThread extends Thread{ //����߳���
//
//	Socket socket;
//	DataInputStream in=null;
//	DataOutputStream out=null;
//	ServerThread(Socket t){ //����߳����ʼ��
//
//                [����]
//	}
//	public void run(){
//		while(true){   //ʵ���з�
//
//                           [����]
//			}
//			catch(IOException e){System.out.println("����뿪");
//			break;}
//		}
//	}
//}