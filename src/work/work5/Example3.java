package work.work5;


interface ComputeSales {
    double Sales();     // Ĭ��Ϊpublic abstract ���εķ���
}

class Television implements ComputeSales {

    @Override
    public double Sales() {

        return 2300;
    }
}

class Computer implements ComputeSales {

    @Override
    public double Sales() {
        return 4500;
    }
}

class Mobile implements ComputeSales {

    @Override
    public double Sales() {
        return 1200;
    }
}

class Shop {
    ComputeSales[] goods;
    double totalSales = 0;

    Shop(ComputeSales[] goods) {
        this.goods = goods;
    }

    public double giveTotalSales(int n) {
        totalSales = 0;
        for (int i = 0; i < n; i++) {
            totalSales += goods[i].Sales();
        }
        return totalSales;
    }
}

public class Example3 {
    public static void main(String[] args) {
        ComputeSales[] goods = new ComputeSales[20];
        int temp;
        int total;
        total = (int) (Math.random() * 21);
        for (int i = 0; i < total; i++) {
            temp = (int) (Math.random() * 3);
            if (temp == 0) {
                goods[i] = new Television();
                System.out.println("�̵����۳�һ̨���ӻ�,����Ϊ:" + goods[i].Sales());
            } else if (temp == 1) {
                goods[i] = new Computer();
                System.out.println("�̵����۳�һ̨����,����Ϊ:" + goods[i].Sales());
            } else if (temp == 2) {
                goods[i] = new Mobile();
                System.out.println("�̵����۳�һ̨�ֻ�,����Ϊ:" + goods[i].Sales());
            }
        }
        Shop shop = new Shop(goods);
        System.out.println("�����̵����۵�������Ϊ��" + total);
        System.out.println("�����̵����۶" + shop.giveTotalSales(total));
        System.out.println("181603010819 �Կ�ǿ");
    }

}
