package work.work15;

import java.awt.*;
import java.sql.*;
import java.util.Scanner;

public class mis {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        Scanner reader = new Scanner(System.in);
        System.out.println("181603010819 �Կ�ǿ");
        System.out.println("��ӭ��¼����ѧ����Ϣ����ϵͳ��");
        System.out.println("�������û���");
        String aname = new String(reader.nextLine());
        System.out.println("����������");
        String apass = new String(reader.nextLine());
        //���������ݿ����Ӵ�
        String url = "jdbc:mysql://localhost:3306/ex?useSSL=false&serverTimezone=UTC&&allowPublicKeyRetrieval=true";
        //���ݿ���û���
        String user = "root";
        //���ݿ���û�����
        String password = "root";

        //����jdbc��������
        Class.forName("com.mysql.jdbc.Driver");

        // ��urlָ��������Դ��������
        Connection con = DriverManager.getConnection(url, user, password);
        //����Statement���в�ѯ
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from admin where aname = '" + aname + "' and apass='" + apass + "'"); // ��ѯ�Ƿ�����û��������붼�Ե���
        if (rs.next()) {
            // ����ڴ�ӡ�ֶ���Ϣ
            System.out.println("��½�ɹ���");
            new menu(); // ��ʼ���˵���

        } else {
            System.out.println("�û�����������󣬳��������");
        }
        //�ر�
        rs.close();
        con.close();
    }


}
