//package work.work15;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class menu {
//	Connection con;
//	Statement s;
//	ResultSet rs;
//	Scanner reader=new Scanner(System.in);
//	String url = [����];
//	String user = [����];
//	String password = [����];
//
//	public menu()throws SQLException,ClassNotFoundException
//	{
//
//		        [����]; //�������ݿ�����
//		   con =[����];  //�������ݿ�
//	           s = [����]; //������ѯ���ʵ��
//		        [����];  //��ʾ�˵�
//	}
//
//
//	public void showmenu()throws SQLException //�˵�
//	{
//
//
//		while (true) {
//			System.out.println("��ѡ�����");
//			System.out.println("1. ���ѧ��");
//			System.out.println("2. ɾ��ѧ��");
//			System.out.println("3. �޸�ѧ��");
//			System.out.println("4. �鿴ѧ��");
//			System.out.println("5. �˳�");
//			int i=[����]; //����ѡ��
//
//			switch(i)
//			{
//				case 1: [����]; break;//����
//				case 2: [����]; break;//ɾ��
//				case 3: [����]; break;//�޸�
//				case 4: [����]; break;//��ʾ
//				case 5: System.out.println("���������"); [����]; break;//�˳�
//				default: continue; //���������޹�����
//			}
//		}
//
//	}
//	void Insert()throws SQLException{
//		String sname =null;
//		String ssex =null;
//		int sage =0;
//		reader.nextLine();//���ջس�
//		System.out.println("��������");
//		[����];
//		System.out.println("�����Ա�");
//		[����];
//		System.out.println("��������");
//		[����];
//
//		[����];//����ѧ������
//		System.out.println("��ӳɹ�");
//	}
//	void delele()throws SQLException{
//
//		String sname =null;
//		reader.nextLine();//���ջس�
//		System.out.println("����Ҫɾ����ѧ������");
//		[����];
//		[����];//ɾ����Ӧ��ѧ������������
//		System.out.println("ɾ���ɹ�");
//	}
//	void update()throws SQLException{
//		String oldsname =null;
//		String sname =null;
//		String ssex =null;
//		int sage =0;
//		reader.nextLine();//���ջس�
//		System.out.println("����Ҫ�޸ĵ�ѧ������");
//		[����];
//		System.out.println("����������");
//		[����];
//		System.out.println("�������Ա�");
//		[����];
//		System.out.println("����������");
//		[����];
//		//����Ҫ�޸ĵ�ѧ������������
//		[����];
//		System.out.println("�޸ĳɹ�");
//	}
//	public void showtable() throws SQLException
//	{
//		System.out.println("ѧ������Ϣ:");
//	         [����]; //��ѧ��������ݲ鵽�����
//		while(rs.next()) {
//		// ѭ����ӡ�ֶ���Ϣ
//		[����];
//		}
//	}
//}
