package work.work13;

class Bank implements Runnable {
    int money = 100;
    Thread zhang;
    Thread keven;

    public Bank() {
        this.zhang = new Thread(this);
        zhang.setName("会计");
        this.keven = new Thread(this);
        keven.setName("出纳");
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (Thread.currentThread() == zhang) {
                i = i + 1;
                money += 1;
                System.out.println(zhang.getName() + "将money的值修改为：" + money);
                System.out.println(zhang.getName() + "的局部变量:" + i);
                if (i >= 6) {
                    zhang.stop();

                    System.out.println(zhang.getName() + "线程进入死亡状态");

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (Thread.currentThread() == keven) {
                i = i - 1;
                money -= 1;
                System.out.println(keven.getName() + "将money的值修改为：" + money);
                System.out.println(keven.getName() + "的局部变量:" + i);
                if (i <= -6) {
                    keven.stop();

                    System.out.println(zhang.getName() + "线程进入死亡状态");
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
        System.out.println("181603010819 赵开强");
    }
}
