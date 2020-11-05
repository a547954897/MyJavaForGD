package work.work9;

import java.io.*;

class FileAccept implements FilenameFilter { //ʵ���ļ����������ӿ�
    String str = null;
    FileAccept(String s) {
        this.str = s;       //��.�������ļ���׺��str
    }
    public boolean accept(File dir, String name) {//��д�ӿ�accept����
        return name.endsWith(str);  //�����ļ�����׺�Ƿ���str��β
    }
}

public class t1 {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:\\study\\java\\file");  //��������ʼ���ļ�Ŀ¼dirΪ��d:\\ch8��
        if (!dir.exists()) {//�ж��ļ�Ŀ¼�Ƿ����
            dir.mkdirs();//�������򴴽���Ŀ¼
            File[] f = new File[8];//�����ļ�����f[8]
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 1)
                    f[i] = new File(dir, i + ".txt");//iΪ��������dir�³�ʼ��f[i]Ϊi.txt�ļ�
                else
                    f[i] = new File(dir, i + ".dat");//iΪż������dir�³�ʼ��f[i]Ϊi.dat�ļ�

                if (!f[i].exists()) f[i].createNewFile();//ԭ�ļ��������򴴽���Щ�ļ�
            }
            System.out.println("�ɹ�����8���ļ���");

        } else {
            File[] list = dir.listFiles();//��dirĿ¼�µ��ļ��б�����ļ�����list
            System.out.println(dir.getPath() + "Ŀ¼�µ��ļ���"); //���dir��ֵ
            for (int i = 0; i < dir.listFiles().length; i++) {
                System.out.println("��" + i + "��---name:" + list[i].getName() + "��С��" + list[i].length()); // ��ӡ��ǰĿ¼�°������ļ������� �ʹ�С
            }

            FileAccept accept = new FileAccept("txt");//��ʼ���ļ���������ֵΪ�ı��ĵ���
            list = dir.listFiles(accept);  //��dirĿ¼�µ�txt�ļ��б�����ļ�����list
            System.out.println("------------------------------------------------------------------");
            for (int i = 0; i < list.length; i++) {
                System.out.println("Ŀ¼�µ�txt�ļ���");
                System.out.println("��" + i + "��---name:" + list[i].getName() + "��С��" + list[i].length()); // ��ӡ��ǰĿ¼�°������ļ������� �ʹ�С

            }
            System.out.println("181603010819 �Կ�ǿ");
        }


    }

}
