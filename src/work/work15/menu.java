package work.work15;

import java.sql.*;
import java.util.Scanner;

public class menu {
    Connection con;
    Statement s;
    ResultSet rs;
    Scanner reader = new Scanner(System.in);
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String DB_URL = "jdbc:mysql://localhost:3306/ex?useSSL=false&serverTimezone=UTC&&allowPublicKeyRetrieval=true";

    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "root";

    public menu() throws SQLException, ClassNotFoundException {

        Class.forName(JDBC_DRIVER);
        ; //�������ݿ�����
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        ;  //�������ݿ�
        s = con.createStatement(); //������ѯ���ʵ��
        showmenu();  //��ʾ�˵�
    }


    public void showmenu() throws SQLException //�˵�
    {


        while (true) {
            System.out.println("��ѡ�����");
            System.out.println("1. ���ѧ��");
            System.out.println("2. ɾ��ѧ��");
            System.out.println("3. �޸�ѧ��");
            System.out.println("4. �鿴ѧ��");
            System.out.println("5. �˳�");
            int i = reader.nextInt(); //����ѡ��

            switch (i) {
                case 1:
                    Insert();
                    break;//����
                case 2:
                    delele();
                    break;//ɾ��
                case 3:
                    update();
                    break;//�޸�
                case 4:
                    showtable();
                    break;//��ʾ
                case 5:
                    System.out.println("���������");
                    System.exit(1);
                    break;//�˳�
                default:
                    continue; //���������޹�����
            }
        }

    }

    void Insert() throws SQLException {
        String sname = null;
        String ssex = null;
        int sage = 0;
        reader.nextLine();//���ջس�
        System.out.println("��������");
        sname = reader.nextLine();
        System.out.println("�����Ա�");
        ssex = reader.nextLine();
        System.out.println("��������");
        sage = reader.nextInt();

        s.execute("insert into stu (sname,ssex,sage) " +
                "value ('" + sname + "','" + ssex + "'," + sage + ")");//����ѧ������
        System.out.println("��ӳɹ�");
    }

    void delele() throws SQLException {

        String sname = null;
        reader.nextLine();//���ջس�
        System.out.println("����Ҫɾ����ѧ������");
        sname = reader.nextLine();
        s.execute("delete from stu where sname='" + sname + "'");//ɾ����Ӧ��ѧ������������
        System.out.println("ɾ���ɹ�");
    }

    void update() throws SQLException {
        String oldsname = null;
        String sname = null;
        String ssex = null;
        int sage = 0;
        reader.nextLine();//���ջس�
        System.out.println("����Ҫ�޸ĵ�ѧ������");
        oldsname = reader.nextLine();
        System.out.println("����������");
        sname = reader.nextLine();
        System.out.println("�������Ա�");
        ssex = reader.nextLine();
        System.out.println("����������");
        sage = reader.nextInt();
        //����Ҫ�޸ĵ�ѧ������������
        s.execute("update stu " +
                "set sname = '" + sname + "',ssex = '" + ssex + "',sage =" + sage +
                " where sname='" + oldsname + "'");
        System.out.println("�޸ĳɹ�");
    }

    public void showtable() throws SQLException {
        System.out.println("ѧ������Ϣ:");
        rs = s.executeQuery("select * from stu"); //��ѧ��������ݲ鵽�����
        while (rs.next()) {
            // ѭ����ӡ�ֶ���Ϣ
            System.out.println("��ţ�"+rs.getString(1) + "    ������" + rs.getString(2) + "    �Ա�" + rs.getString(3) + "    ���䣺" + rs.getInt(4));

        }
    }
}
