package work.work9;

import java.io.*;

public class t2 {
    public static void main(String[] args) {
        FileInputStream fis = null;//�����ļ��ֽ�������
        FileOutputStream fos = null;//�����ļ��ֽ������
        BufferedInputStream bis = null;//���������ֽ�������
        BufferedOutputStream bos = null;//���������ֽ������
        int c;
        try {
            System.out.println("�����ļ�����");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//ʹ��BufferedReaderʵ�ּ�������
            String fname = in.readLine();//��ȡ����һ��
            fis = new FileInputStream("D:\\study\\java\\file\\ch8\\source.txt"); // �ļ���������ʼ����ֵΪ"D:\study\java\file\ch8\source.txt"
            bis = new BufferedInputStream(fis);        // ���ӳɴ������������
            fos = new FileOutputStream("D:\\study\\java\\file\\ch8\\" + fname);// �ļ��������ֵΪ"D:/ch8/"+fname
            bos = new BufferedOutputStream(fos);        // ���ӳɴ�����������
            while ((c = bis.read()) != -1) {  // ����ֽڶ�ȡԴ�ļ�
                bos.write(c);                      // ����ֽ�д�뿽���ļ����ļ������ڻ��Զ��������ļ�
                bos.flush();                       // ˢ������ǿ�����
            }
        } catch (IOException e1) {
            System.out.println(e1);
        } finally {
            System.out.println("181603010819 �Կ�ǿ");
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e2) {
                System.out.println(e2);
            }
        }
    }
}

