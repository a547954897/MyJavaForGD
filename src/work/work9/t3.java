package work.work9;

import java.io.*;

public class t3 {
    public static void main(String args[]) {
        File source = new File("D:\\study\\java\\file\\ch8\\source.txt");//��������ʼ��Դ�ļ�"D:/ch8/source.txt"
        File encode = new File("D:\\study\\java\\file\\ch8\\encode.txt");//��������ʼ�������ļ�"D:/ch8/encode.txt"
        File decode = new File("D:\\study\\java\\file\\ch8\\decode.txt");//��������ʼ�������ļ�"D:/ch8/decode.txt"
        char b[] = new char[100];
        try {
            //��Դ�ļ����������ܣ���д������ļ�
            FileReader in = new FileReader(source);      // ����ָ��source���ַ�������in
            FileWriter out = new FileWriter(encode);        // ����ָ��encode�ַ������out
            int n = 1;
            while ((n = in.read(b)) != -1) {  //  һ�ζ�ȡ100���ַ� ���ļ���β�򷵻�-1
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');//  ����ַ�����
                }
                out.write(b, 0, n);                // out������b��ǰn��Ԫд���ļ�
            }
            out.close();      // out�ر�

            //�Ӽ����ļ��ж�ȡ������ʾ
            in = new FileReader(encode);              // ����ָ��encode���ַ�������
            System.out.println("���ܺ���ļ�����:");
            while (((n = in.read(b)) != -1)) {           //  һ�ζ�ȡ100���ַ� ���ļ���β�򷵻�-1
                String str = new String(b, 0, n);     //�ַ�����b�����ַ���str
                System.out.println(str);
            }
            in.close(); // in�ر�

            //�������ļ����������ܣ���д������ļ�
            in = new FileReader(encode);  // ����ָ��encode���ַ�������
            out = new FileWriter(decode);// ����ָ��decode���ַ������
            n = 1;
            while (((n = in.read(b)) != -1)) {
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');
                }
                out.write(b, 0, n);
            }
            out.close();      // out�ر�


            System.out.println("���ܺ���ļ�����:");
            //�ӽ����ļ��ж�ȡ������ʾ
            in = new FileReader(decode);
            while (((n = in.read(b)) != -1)) {
                String str = String.copyValueOf(b);
                System.out.println(str);
            }

            in.close();         // in�ر�

        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("181603010819 �Կ�ǿ");
    }
}
