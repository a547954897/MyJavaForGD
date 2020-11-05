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
//		System.out.println("等待客户端连接……");
//		while(true){
//			try{
//				server=new ServerSocket(4331);
//			}
//			catch(IOException e1){System.out.println("等待客户端连接……");}
//			try{
//
//				player=server.accept();
//				System.out.println("玩家的地址："+player.getInetAddress());//获取玩家IP地址
//			}
//			catch(IOException e){System.out.println("正在等待玩家");}
//			if(player!=null)
//				new ServerThread(player).start();//为每个玩家分派一条线程
//			else
//				continue;
//		}
//	}
//}
//class ServerThread extends Thread{ //玩家线程类
//
//	Socket socket;
//	DataInputStream in=null;
//	DataOutputStream out=null;
//	ServerThread(Socket t){ //玩家线程类初始化
//
//                [代码]
//	}
//	public void run(){
//		while(true){   //实现判分
//
//                           [代码]
//			}
//			catch(IOException e){System.out.println("玩家离开");
//			break;}
//		}
//	}
//}