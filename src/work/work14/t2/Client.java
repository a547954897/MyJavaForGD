package work.work14.t2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends JFrame implements ActionListener {
    Socket mysocket; //客户端Socket
    DataOutputStream out = null;//数据输出流
    DataInputStream in = null;//数据输入流
    String receive = null;  //接收字符串
    // ① 定义一个窗体类 该类实现ActionListener 接口
    int player = 0;
    JButton but_j, but_s, but_b, but_q;     // 这里把button等组件的定义放到类里面.方便其他函数调用.
    JPanel panel1, panel2;
    JLabel label, result;
    int win = 0, draw = 0, lose = 0, score = 0;

    public Client() {
        try {
            mysocket = new Socket("localhost", 4331); //通过IP和端口连接服务器
            in = new DataInputStream(mysocket.getInputStream());  //建立客户端Socket连接数据输入流
            out = new DataOutputStream(mysocket.getOutputStream()); //建立客户端Socket连接数据输出流
        } catch (IOException e) {
            e.printStackTrace();
        }


        setTitle("181603010819 赵开强");
        setLocation(250, 250);
        setSize(300, 300);

        panel1 = new JPanel();
        panel1.setBackground(Color.yellow);
        but_j = new JButton("剪刀");
        but_s = new JButton("石头");
        but_b = new JButton("布");
        but_q = new JButton("清除");

        but_j.addActionListener(this);    //③  butok添加事件约束
        but_s.addActionListener(this);  //③  把butquit添加事件约束
        but_b.addActionListener(this);
        but_q.addActionListener(this);
        panel1.add(but_j);
        panel1.add(but_s);
        panel1.add(but_b);
//        panel1.add(but_q);

        panel2 = new JPanel();
        panel2.setBackground(Color.green);
        label = new JLabel(" 文本框");
        panel2.add(label);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.yellow);


        add(panel1, BorderLayout.SOUTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        //	②  在类中定义接口方法actionPerformed();


        System.out.println("181603010819 赵开强");
        try {

            if (e.getSource() == but_j) {
                this.player = 1;
            } else if (e.getSource() == but_s) {
                this.player = 2;
            } else if (e.getSource() == but_b) {
                this.player = 3;
            } else if (e.getSource() == but_q) {
                this.player = 0;
                label.setText("");
            }

            out.writeInt(this.player);     //通过out向服务器写入信息
            receive = in.readUTF();//通过使用in读取服务器写入输出流的信息。堵塞状态，除非读取到信息
            label.setText(receive);

            System.out.println("客户收到:" + receive);


//        score = win - lose;
//        result.setText("win:" + win + "  draw: " + draw + "  lose:" + lose + "  score:" + score);
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client frame = new Client();   // 初始化一个窗体的对象
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭按钮
        frame.setVisible(true);  // 使窗体可见.
    }
}