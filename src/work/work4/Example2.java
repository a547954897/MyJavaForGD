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
		System.out.println("�������һ��������");
		int m = scanner.nextInt();
		System.out.println("������ڶ���������");

		int n = scanner.nextInt();
		if (m<0||n<0) {
			System.out.println("���벻��Ϊ����");
		}else {
			System.out.println("���Լ��Ϊ��"+a.f(m, n));
			System.out.println("��󹫱���Ϊ��"+b.f(m, n));
		}
		
		System.out.println("181603010819 �Կ�ǿ");

	}

}
