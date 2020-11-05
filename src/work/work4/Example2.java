package work.work4;

import java.util.Scanner;

public class Example2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个正整数");
		int m = scanner.nextInt();
		System.out.println("请输入第二个正整数");

		int n = scanner.nextInt();
		if (m<0||n<0) {
			System.out.println("输入不能为负数");
		}else {
			System.out.println("最大公约数为："+a.f(m, n));
			System.out.println("最大公倍数为："+b.f(m, n));
		}
		
		System.out.println("181603010819 赵开强");

	}

}
