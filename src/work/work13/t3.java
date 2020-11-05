package work.work13;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class t3 extends Frame implements Runnable {
    Button button = new Button("ok");//按钮对象
    int x = 5;//控制按钮大小
    Thread thread = new Thread(this);//线程对象

    public t3(){
        this.setTitle("181603010819 赵开强");
        this.setBounds(100,200,200,200); //设置窗体大小
        this.setLayout(new FlowLayout());       //设置窗体布局
        this.setVisible(true);              //设置窗体可见
        add(button);                    //添加按钮
        button.setBounds(30,30,5,5);                //设置按钮大小
        button.setBackground(Color.green);                  //设置按钮颜色
        addWindowListener(new WindowAdapter() {//窗口响应事件
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        thread.start();                 //窗口一打开创建的线程可开始运行，即调用run（）方法
    }

    @Override
    public void run() {
        while (true) {
            x= x+1;
            if (x > 100) {
                x=5;
            }
            button.setBounds(30,30,x,x);//设置按钮的大小
            try {
                Thread.sleep(200);//执行完依次修改按钮大小后，休息200毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        t3 t3 = new t3();

    }
}
