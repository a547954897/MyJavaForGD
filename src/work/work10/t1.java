package work.work10;

import java.util.Random;

class Color {


    @Override
    public String toString() { //��дtoStirng()
        String str;
        Random r = new Random();
        int i = r.nextInt(4) + 1; //�������1��4������
        switch (i)//ѡ���ʼ����ɫ
        {
            case 1:
                str = "����";
                break;
            case 2:
                str = "����";
                break;
            case 3:
                str = "����";
                break;
            default:
                str = "�ڿ�";
                break;
        }
        return str;
    }
}

class Point {


    @Override
    public String toString() { //��дtoStirng()
        String str;
        Random r = new Random();
        int i = r.nextInt(13) + 1;//�������1��13������
        switch (i)//ѡ���ʼ������
        {
            case 1:
                str = "A";
                break;
            case 11:
                str = "J";
                break;
            case 12:
                str = "Q";
                break;
            case 13:
                str = "K";
                break;
            default:
                str = i + "";
                break;

        }

        return str;

    }

}

class Poker<C, P> {//���巺����Poker
    C c;
    P p;

    Poker(C c, P p) {
        this.c = c;  //���췽����ʼ��
        this.p = p;
    }

    public String gets() {
        return c.toString() + p.toString();//����C��P������toString()���
    }
}

public class t1 {
    public static void main(String[] args) {
        Color color = new Color();
        Point point = new Point();
        Poker<Color, Point> pk = new Poker<Color, Point>(color, point); //���� Poker���ͣ���ʹ��color��point��ʼ��

        for (int i = 1; i <= 5; i++)
            System.out.println("������ɣ�" + pk.gets());//���ɲ���ӡ��һ����

        System.out.println("181603010819 �Կ�ǿ");
    }

}