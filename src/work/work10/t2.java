package work.work10;

import java.util.*;

class Student {   //定义学生类
    String name;
    Student(String name) {
        this.name = name;
    }   //构造方法

    public boolean equals(Object obj) { //重写equals方法，保证只要名字相等，则认为是同一个人.
        Student student = (Student) obj;
        return name.equals(student.name);
    }
}

public class t2 {


    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Student[] stu = new Student[4];
        ArrayList<Student> students = new ArrayList<>();    //定义 ArrayList泛型，每个元素是1个学生。

        System.out.println("输入4个学生姓名：");
        // 初始化4个学生，并将他们添加进ArrayList
        for (int i = 0; i < 4; i++) {
            students.add(new Student(reader.nextLine()));
        }

        System.out.println("列表中还有" + students.size() + "个学生：");

        for (int i = 0; i < students.size(); i++) { //遍历输出所有元素中学生的姓名
            System.out.println("第" + i + "个学生: " + students.get(i).name);
        }

        //键盘输入一个学生姓名,判断该学生是否在列表中，如存在，则输出其在列表中的下标，然后将它从列表中移除。

        System.out.println("输入要查找的人的姓名：");
        Student s = new Student(reader.nextLine());
        if (students.contains(s)) {
            System.out.println("找到" +s.name + "，下标为" +students.indexOf(s));//输出下标
            students.remove(s);    //从列表中移除该学生

            System.out.println("删除" + s.name + "后,还有" +students.size() + "个学生：");

            for (int i = 0; i < students.size();i++) { //遍历输出所有元素中学生的姓名

                System.out.println("第" + i + "个学生: " +students.get(i).name);
            }
        } else System.out.println("列表中找不到" + s.name);  //如不存在则输出找不到。
        System.out.println("181603010819 赵开强");
    }


}
