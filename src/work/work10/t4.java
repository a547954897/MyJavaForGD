package work.work10;

import java.util.*;

class Book {
    String ISBN, name;

    public Book(String ISBN, String name) {
        this.ISBN = ISBN;
        this.name = name;
    }
}

public class t4 {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        Book[] book = new Book[4];

        HashMap<String, Book> table = new HashMap<>(); //���� HashMap���ͣ�ÿ��Ԫ����1���顣

        System.out.println("����4�������ź�������");
        // ��ʼ��4���飬����������ӽ�HashMap
        for (int i = 0; i < 4; i++) {
            String isbn = reader.nextLine();
            String name = reader.nextLine();
            book[i] = new Book(isbn, name);
            table.put(isbn, book[i]);
        }
        //���HashMap��Ԫ�ظ���
        System.out.println("�������" + table.size() + "����: ");

        //�����������Ԫ�ص�ISBN������
        Collection<Book> collection = table.values();
        Iterator<Book> iter = collection.iterator();
        while (iter.hasNext()) {
            Book bk = iter.next();
            System.out.println("ISBN:" + bk.ISBN + " ��������" + bk.name + "��");
        }

        //��������һ��ISBN,�жϸñ����Ƿ���HashMap�У�����ڣ��������������Ȼ������HashMap���Ƴ���
        //�粻��������������ڡ�
        System.out.println("����ISBN����������");
        String key = reader.nextLine();

        if (table.containsKey(key)){
            System.out.println("��" +table.get(key).name + "���л�");//���������

            Book k = table.remove(key); //��HashMap���Ƴ��ñ���,�������Ȿ����Ϣ��k

            System.out.println("������" +k.name + "���Ȿ�����껹��" +table.size()+"����");

            //�����������Ԫ�ص�ISBN������
            collection = table.values();
            iter = collection.iterator();
            while (iter.hasNext()) {
                Book bk = iter.next();
                System.out.println("ISBN:" +bk.ISBN + " ��������" +bk.name+"��");
            }

        }
        else System.out.println("������Ҳ���ISBNΪ" +key + "���飡");
        System.out.println("181603010819 �Կ�ǿ");

    }
}
