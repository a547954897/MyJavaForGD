package work.work15;

import java.sql.*;
import java.util.Scanner;

public class menu {
    Connection con;
    Statement s;
    ResultSet rs;
    Scanner reader = new Scanner(System.in);
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String DB_URL = "jdbc:mysql://localhost:3306/ex?useSSL=false&serverTimezone=UTC&&allowPublicKeyRetrieval=true";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";

    public menu() throws SQLException, ClassNotFoundException {

        Class.forName(JDBC_DRIVER);
        ; //加载数据库驱动
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        ;  //连接数据库
        s = con.createStatement(); //创建查询语句实例
        showmenu();  //显示菜单
    }


    public void showmenu() throws SQLException //菜单
    {


        while (true) {
            System.out.println("请选择操作");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生");
            System.out.println("4. 查看学生");
            System.out.println("5. 退出");
            int i = reader.nextInt(); //输入选择

            switch (i) {
                case 1:
                    Insert();
                    break;//插入
                case 2:
                    delele();
                    break;//删除
                case 3:
                    update();
                    break;//修改
                case 4:
                    showtable();
                    break;//显示
                case 5:
                    System.out.println("程序结束！");
                    System.exit(1);
                    break;//退出
                default:
                    continue; //忽略其他无关输入
            }
        }

    }

    void Insert() throws SQLException {
        String sname = null;
        String ssex = null;
        int sage = 0;
        reader.nextLine();//接收回车
        System.out.println("输入姓名");
        sname = reader.nextLine();
        System.out.println("输入性别");
        ssex = reader.nextLine();
        System.out.println("输入年龄");
        sage = reader.nextInt();

        s.execute("insert into stu (sname,ssex,sage) " +
                "value ('" + sname + "','" + ssex + "'," + sage + ")");//插入学生数据
        System.out.println("添加成功");
    }

    void delele() throws SQLException {

        String sname = null;
        reader.nextLine();//接收回车
        System.out.println("输入要删除的学生姓名");
        sname = reader.nextLine();
        s.execute("delete from stu where sname='" + sname + "'");//删除对应的学生姓名的数据
        System.out.println("删除成功");
    }

    void update() throws SQLException {
        String oldsname = null;
        String sname = null;
        String ssex = null;
        int sage = 0;
        reader.nextLine();//接收回车
        System.out.println("输入要修改的学生姓名");
        oldsname = reader.nextLine();
        System.out.println("输入新姓名");
        sname = reader.nextLine();
        System.out.println("输入新性别");
        ssex = reader.nextLine();
        System.out.println("输入新年龄");
        sage = reader.nextInt();
        //更新要修改的学生姓名的数据
        s.execute("update stu " +
                "set sname = '" + sname + "',ssex = '" + ssex + "',sage =" + sage +
                " where sname='" + oldsname + "'");
        System.out.println("修改成功");
    }

    public void showtable() throws SQLException {
        System.out.println("学生表信息:");
        rs = s.executeQuery("select * from stu"); //将学生表的内容查到结果集
        while (rs.next()) {
            // 循环打印字段信息
            System.out.println("序号："+rs.getString(1) + "    姓名：" + rs.getString(2) + "    性别：" + rs.getString(3) + "    年龄：" + rs.getInt(4));

        }
    }
}
