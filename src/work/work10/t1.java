package work.work10;

import java.util.Random;

class Color {


    @Override
    public String toString() { //重写toStirng()
        String str;
        Random r = new Random();
        int i = r.nextInt(4) + 1; //随机生成1到4的整数
        switch (i)//选择初始化花色
        {
            case 1:
                str = "红桃";
                break;
            case 2:
                str = "方块";
                break;
            case 3:
                str = "黑桃";
                break;
            default:
                str = "黑块";
                break;
        }
        return str;
    }
}

class Point {


    @Override
    public String toString() { //重写toStirng()
        String str;
        Random r = new Random();
        int i = r.nextInt(13) + 1;//随机生成1到13的整数
        switch (i)//选择初始化点数
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

class Poker<C, P> {//定义泛型类Poker
    C c;
    P p;

    Poker(C c, P p) {
        this.c = c;  //构造方法初始化
        this.p = p;
    }

    public String gets() {
        return c.toString() + p.toString();//返回C和P的两个toString()组合
    }
}

public class t1 {
    public static void main(String[] args) {
        Color color = new Color();
        Point point = new Point();
        Poker<Color, Point> pk = new Poker<Color, Point>(color, point); //声明 Poker泛型，并使用color和point初始化

        for (int i = 1; i <= 5; i++)
            System.out.println("随机生成：" + pk.gets());//生成并打印出一张牌

        System.out.println("181603010819 赵开强");
    }

}