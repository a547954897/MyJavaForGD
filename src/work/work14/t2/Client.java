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
    Socket mysocket; //�ͻ���Socket
    DataOutputStream out = null;//���������
    DataInputStream in = null;//����������
    String receive = null;  //�����ַ���
    // �� ����һ�������� ����ʵ��ActionListener �ӿ�
    int player = 0;
    JButton but_j, but_s, but_b, but_q;     // �����button������Ķ���ŵ�������.����������������.
    JPanel panel1, panel2;
    JLabel label, result;
    int win = 0, draw = 0, lose = 0, score = 0;

    public Client() {
        try {
            mysocket = new Socket("localhost", 4331); //ͨ��IP�Ͷ˿����ӷ�����
            in = new DataInputStream(mysocket.getInputStream());  //�����ͻ���Socket��������������
            out = new DataOutputStream(mysocket.getOutputStream()); //�����ͻ���Socket�������������
        } catch (IOException e) {
            e.printStackTrace();
        }


        setTitle("181603010819 �Կ�ǿ");
        setLocation(250, 250);
        setSize(300, 300);

        panel1 = new JPanel();
        panel1.setBackground(Color.yellow);
        but_j = new JButton("����");
        but_s = new JButton("ʯͷ");
        but_b = new JButton("��");
        but_q = new JButton("���");

        but_j.addActionListener(this);    //��  butok����¼�Լ��
        but_s.addActionListener(this);  //��  ��butquit����¼�Լ��
        but_b.addActionListener(this);
        but_q.addActionListener(this);
        panel1.add(but_j);
        panel1.add(but_s);
        panel1.add(but_b);
//        panel1.add(but_q);

        panel2 = new JPanel();
        panel2.setBackground(Color.green);
        label = new JLabel(" �ı���");
        panel2.add(label);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.yellow);


        add(panel1, BorderLayout.SOUTH);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        //	��  �����ж���ӿڷ���actionPerformed();


        System.out.println("181603010819 �Կ�ǿ");
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

            out.writeInt(this.player);     //ͨ��out�������д����Ϣ
            receive = in.readUTF();//ͨ��ʹ��in��ȡ������д�����������Ϣ������״̬�����Ƕ�ȡ����Ϣ
            label.setText(receive);

            System.out.println("�ͻ��յ�:" + receive);


//        score = win - lose;
//        result.setText("win:" + win + "  draw: " + draw + "  lose:" + lose + "  score:" + score);
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client frame = new Client();   // ��ʼ��һ������Ķ���
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���رհ�ť
        frame.setVisible(true);  // ʹ����ɼ�.
    }
}