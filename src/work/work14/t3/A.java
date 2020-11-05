package work.work14.t3;

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A extends JFrame implements Runnable, ActionListener {
    JTextField outMessage = new JTextField(12);
    JTextArea inMessage = new JTextArea(12, 20);
    JButton b = new JButton("��������");

    A() {
        super("181603010819 �Կ�ǿ");
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
        thread.start();                                //�̸߳����������
    }

    public void actionPerformed(ActionEvent event) {     //������ť��������
        byte b[] = outMessage.getText().getBytes();//���ı�����ַ���תΪ�ֽ�����
        try {
            InetAddress address = InetAddress.getByName("localhost");//����Ŀ������IP
            DatagramPacket data = new DatagramPacket(b, b.length, address, 1234);//��ʼ�����ݱ��������췽���ﴫ�� b,b.length,address,1234
            DatagramSocket mail = new DatagramSocket();//��ʼ�����ݱ�socket
            mail.send(data); //��������
            outMessage.setText("");
        } catch (Exception e) {
        }
    }

    public void run() {                                //��������
        DatagramPacket pack = null;
        DatagramSocket mail = null;
        byte b[] = new byte[8192]; //���峤��8192���ֽ�����
        try {
            pack = new DatagramPacket(b, b.length);//��ʼ�����ݱ��������췽���ﴫ�� b,b.length
            mail = new DatagramSocket(5678);//��ʼ�����ݱ�socket�����췽���ﴫ��˿�5678
        } catch (Exception e) {
        }
        while (true) {
            try {
                mail.receive(pack);  //�������ݱ�
                String message = new String(pack.getData(), 0, pack.getLength()); //�����յ�����תΪ�ַ��������췽���ﴫ�� pack.getData(),0,pack.getLength()
                inMessage.append("�յ��������ԣ�" + pack.getAddress());//��ȡ�������Ե�����IP������ӵ�inMessage
                inMessage.append("\n�յ������ǣ�" + message + "\n");//��message�ӵ�inMessage
                inMessage.setCaretPosition(inMessage.getText().length()); //������������ݽӵ����������ݵ�β����
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) {
        new A();
    }
}
