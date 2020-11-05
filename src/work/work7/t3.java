package work.work7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的身份证号：");

        String temp = scanner.nextLine();
        // 身份证号正则表达式
        Pattern p1 = Pattern.compile("(^\\d{18}$)|(^\\d{17}[Xx]$)");
        Matcher m = p1.matcher(temp);
        if (m.matches()) {
            System.out.println("输入的身份证号合法");
        } else {
            System.out.println("输入的身份证号错误！");
        }
        System.out.println("请输入你的邮箱");
        temp = scanner.nextLine();
        //邮件正则表达式
        Pattern p2 = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
        m = p2.matcher(temp);
        if (m.matches()) {
            System.out.println("输入邮箱正确");
        } else {
            System.out.println("输入邮箱错误");
        }
        System.out.println("181603010819 赵开强");
    }
}
