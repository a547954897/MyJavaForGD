package work.work7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������������֤�ţ�");

        String temp = scanner.nextLine();
        // ���֤��������ʽ
        Pattern p1 = Pattern.compile("(^\\d{18}$)|(^\\d{17}[Xx]$)");
        Matcher m = p1.matcher(temp);
        if (m.matches()) {
            System.out.println("��������֤�źϷ�");
        } else {
            System.out.println("��������֤�Ŵ���");
        }
        System.out.println("�������������");
        temp = scanner.nextLine();
        //�ʼ�������ʽ
        Pattern p2 = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        m = p2.matcher(temp);
        if (m.matches()) {
            System.out.println("����������ȷ");
        } else {
            System.out.println("�����������");
        }
        System.out.println("181603010819 �Կ�ǿ");
    }
}
