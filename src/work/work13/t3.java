package work.work13;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class t3 extends Frame implements Runnable {
    Button button = new Button("ok");//��ť����
    int x = 5;//���ư�ť��С
    Thread thread = new Thread(this);//�̶߳���

    public t3(){
        this.setTitle("181603010819 �Կ�ǿ");
        this.setBounds(100,200,200,200); //���ô����С
        this.setLayout(new FlowLayout());       //���ô��岼��
        this.setVisible(true);              //���ô���ɼ�
        add(button);                    //��Ӱ�ť
        button.setBounds(30,30,5,5);                //���ð�ť��С
        button.setBackground(Color.green);                  //���ð�ť��ɫ
        addWindowListener(new WindowAdapter() {//������Ӧ�¼�
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        thread.start();                 //����һ�򿪴������߳̿ɿ�ʼ���У�������run��������
    }

    @Override
    public void run() {
        while (true) {
            x= x+1;
            if (x > 100) {
                x=5;
            }
            button.setBounds(30,30,x,x);//���ð�ť�Ĵ�С
            try {
                Thread.sleep(200);//ִ���������޸İ�ť��С����Ϣ200����
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        t3 t3 = new t3();

    }
}
