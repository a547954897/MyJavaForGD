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
//	String url = [代码];
//	String user = [代码];
//	String password = [代码];
//
//	public menu()throws SQLException,ClassNotFoundException
//	{
//
//		        [代码]; //加载数据库驱动
//		   con =[代码];  //连接数据库
//	           s = [代码]; //创建查询语句实例
//		        [代码];  //显示菜单
//	}
//
//
//	public void showmenu()throws SQLException //菜单
//	{
//
//
//		while (true) {
//			System.out.println("请选择操作");
//			System.out.println("1. 添加学生");
//			System.out.println("2. 删除学生");
//			System.out.println("3. 修改学生");
//			System.out.println("4. 查看学生");
//			System.out.println("5. 退出");
//			int i=[代码]; //输入选择
//
//			switch(i)
//			{
//				case 1: [代码]; break;//插入
//				case 2: [代码]; break;//删除
//				case 3: [代码]; break;//修改
//				case 4: [代码]; break;//显示
//				case 5: System.out.println("程序结束！"); [代码]; break;//退出
//				default: continue; //忽略其他无关输入
//			}
//		}
//
//	}
//	void Insert()throws SQLException{
//		String sname =null;
//		String ssex =null;
//		int sage =0;
//		reader.nextLine();//接收回车
//		System.out.println("输入姓名");
//		[代码];
//		System.out.println("输入性别");
//		[代码];
//		System.out.println("输入年龄");
//		[代码];
//
//		[代码];//插入学生数据
//		System.out.println("添加成功");
//	}
//	void delele()throws SQLException{
//
//		String sname =null;
//		reader.nextLine();//接收回车
//		System.out.println("输入要删除的学生姓名");
//		[代码];
//		[代码];//删除对应的学生姓名的数据
//		System.out.println("删除成功");
//	}
//	void update()throws SQLException{
//		String oldsname =null;
//		String sname =null;
//		String ssex =null;
//		int sage =0;
//		reader.nextLine();//接收回车
//		System.out.println("输入要修改的学生姓名");
//		[代码];
//		System.out.println("输入新姓名");
//		[代码];
//		System.out.println("输入新性别");
//		[代码];
//		System.out.println("输入新年龄");
//		[代码];
//		//更新要修改的学生姓名的数据
//		[代码];
//		System.out.println("修改成功");
//	}
//	public void showtable() throws SQLException
//	{
//		System.out.println("学生表信息:");
//	         [代码]; //将学生表的内容查到结果集
//		while(rs.next()) {
//		// 循环打印字段信息
//		[代码];
//		}
//	}
//}
