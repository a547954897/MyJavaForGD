package work.work10;

import java.util.*;

class Student {   //����ѧ����
    String name;
    Student(String name) {
        this.name = name;
    }   //���췽��

    public boolean equals(Object obj) { //��дequals��������ֻ֤Ҫ������ȣ�����Ϊ��ͬһ����.
        Student student = (Student) obj;
        return name.equals(student.name);
    }
}

public class t2 {


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Student[] stu = new Student[4];
        ArrayList<Student> students = new ArrayList<>();    //���� ArrayList���ͣ�ÿ��Ԫ����1��ѧ����

        System.out.println("����4��ѧ��������");
        // ��ʼ��4��ѧ��������������ӽ�ArrayList
        for (int i = 0; i < 4; i++) {
            students.add(new Student(reader.nextLine()));
        }

        System.out.println("�б��л���" + students.size() + "��ѧ����");

        for (int i = 0; i < students.size(); i++) { //�����������Ԫ����ѧ��������
            System.out.println("��" + i + "��ѧ��: " + students.get(i).name);
        }

        //��������һ��ѧ������,�жϸ�ѧ���Ƿ����б��У�����ڣ�����������б��е��±꣬Ȼ�������б����Ƴ���

        System.out.println("����Ҫ���ҵ��˵�������");
        Student s = new Student(reader.nextLine());
        if (students.contains(s)) {
            System.out.println("�ҵ�" +s.name + "���±�Ϊ" +students.indexOf(s));//����±�
            students.remove(s);    //���б����Ƴ���ѧ��

            System.out.println("ɾ��" + s.name + "��,����" +students.size() + "��ѧ����");

            for (int i = 0; i < students.size();i++) { //�����������Ԫ����ѧ��������

                System.out.println("��" + i + "��ѧ��: " +students.get(i).name);
            }
        } else System.out.println("�б����Ҳ���" + s.name);  //�粻����������Ҳ�����
        System.out.println("181603010819 �Կ�ǿ");
    }


}
