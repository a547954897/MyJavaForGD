package work.work14.t3;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A extends JFrame implements Runnable, ActionListener {
    JTextField outMessage = new JTextField(12);
    JTextArea inMessage = new JTextArea(12, 20);
    JButton b = new JButton("发送数据");

    A() {
        super("181603010819 赵开强");
        setSize(320, 200);
        setVisible(true);
        JPanel p = new JPanel();
        b.addActionListener(this);
        p.add(outMessage);
        p.add(b);
        Container con = getContentPane();
        con.add(new JScrollPane(inMessage), BorderLayout.CENTER);
        con.add(p, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();

        Thread thread = new Thread(this);
        thread.start();                                //线程负责接收数据
    }

    public void actionPerformed(ActionEvent event) {     //单击按钮发送数据
        byte b[] = outMessage.getText().getBytes();//将文本框的字符串转为字节数组
        try {
            InetAddress address = InetAddress.getByName("localhost");//定义目标主机IP
            DatagramPacket data = new DatagramPacket(b, b.length, address, 1234);//初始化数据报包，构造方法里传入 b,b.length,address,1234
            DatagramSocket mail = new DatagramSocket();//初始化数据报socket
            mail.send(data); //发送数据
            outMessage.setText("");
        } catch (Exception e) {
        }
    }

    public void run() {                                //接收数据
        DatagramPacket pack = null;
        DatagramSocket mail = null;
        byte b[] = new byte[8192]; //定义长度8192的字节数组
        try {
            pack = new DatagramPacket(b, b.length);//初始化数据报包，构造方法里传入 b,b.length
            mail = new DatagramSocket(5678);//初始化数据报socket，构造方法里传入端口5678
        } catch (Exception e) {
        }
        while (true) {
            try {
                mail.receive(pack);  //接收数据报
                String message = new String(pack.getData(), 0, pack.getLength()); //将接收的数据转为字符串，构造方法里传入 pack.getData(),0,pack.getLength()
                inMessage.append("收到数据来自：" + pack.getAddress());//获取数据来自的主机IP，将其加到inMessage
                inMessage.append("\n收到数据是：" + message + "\n");//将message加到inMessage
                inMessage.setCaretPosition(inMessage.getText().length()); //把新输入的内容接到已输入内容的尾部。
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) {
        new A();
    }
}
