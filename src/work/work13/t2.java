package work.work13;

class Bank implements Runnable {
    int money = 100;
    Thread zhang;
    Thread keven;

    public Bank() {
        this.zhang = new Thread(this);
        zhang.setName("���");
        this.keven = new Thread(this);
        keven.setName("����");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (Thread.currentThread() == zhang) {
                i = i + 1;
                money += 1;
                System.out.println(zhang.getName() + "��money��ֵ�޸�Ϊ��" + money);
                System.out.println(zhang.getName() + "�ľֲ�����:" + i);
                if (i >= 6) {
                    zhang.stop();

                    System.out.println(zhang.getName() + "�߳̽�������״̬");

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (Thread.currentThread() == keven) {
                i = i - 1;
                money -= 1;
                System.out.println(keven.getName() + "��money��ֵ�޸�Ϊ��" + money);
                System.out.println(keven.getName() + "�ľֲ�����:" + i);
                if (i <= -6) {
                    keven.stop();

                    System.out.println(zhang.getName() + "�߳̽�������״̬");
                }
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class t2 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.zhang.start();
        bank.keven.start();
        System.out.println("181603010819 �Կ�ǿ");
    }
}
