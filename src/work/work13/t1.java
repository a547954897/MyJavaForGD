package work.work13;

class Tortoise extends Thread {
    int sleepTime = 0;
    int liveLength = 0;

    public Tortoise(int sleepTime, String name, int liveLength) {
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
        setName(name);
    }

    @Override
    public void run() {
        while (true) {
            liveLength--;
            System.out.print("@");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (liveLength < 0) {
                System.out.print("乌龟死了");
                return;
            }
        }
    }
}

class Rabbit extends Thread {
    int sleepTime = 0;
    int liveLength;

    public Rabbit(int sleepTime,String name, int liveLength) {
        this.sleepTime = sleepTime;
        this.liveLength = liveLength;
        setName(name);
    }

    @Override
    public void run() {

        while (true) {
            liveLength--;
            System.out.print("*");
            try {
                sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (liveLength < 0) {
                System.out.print("兔子死了");
                return;
            }
        }
    }
}

public class t1 {
    public static void main(String[] args) {
        System.out.println("181603010819 赵开强");

        Rabbit rabbit = new Rabbit(500,"兔子",50);
        Tortoise tortoise = new Tortoise(100, "乌龟", 50);
        rabbit.start();
        tortoise.start();

    }
}
