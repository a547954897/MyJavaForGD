package work.work11;

import javax.swing.*;  // extends JFrame    ��Ҫ�ð�
import java.awt.*;    // ����panel��ɫΪ��ɫ ��Ҫ�ð�
import java.awt.event.*;  // �漰�������¼�����Ҫ���������
public class  MainFrame2 extends JFrame implements ActionListener{
    // �� ����һ�������� ����ʵ��ActionListener �ӿ�

    JButton but_j ,but_s,but_b,but_q;     // �����button������Ķ���ŵ�������.����������������.
    JPanel  panel1, panel2;
    JLabel  label,result;
    int win=0,draw=0,lose=0,score=0;
    public MainFrame2()
    {
        setTitle("181603010819 �Կ�ǿ");
        setLocation(250, 250);
        setSize(300, 300);

        panel1 =  new JPanel();
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
        panel1.add(but_q);

        panel2 =  new JPanel();
        panel2.setBackground(Color.green);
        label = new JLabel(" �ı���");
        panel2.add(label);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.yellow);
        result=new JLabel("win:"+win+"  draw: "+draw +"  lose:"+lose+"  score:"+score);
        panel3.add(result);


        add(panel1,BorderLayout.SOUTH);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {
        //	��  �����ж���ӿڷ���actionPerformed();
        if(e.getSource()==but_j)
        {
            int i=((int)(Math.random()*10)%3);
            switch (i) {
                case 0:label.setText("������������Գ�ʯͷ�����ź������ˣ�");lose++;break;
                case 1:label.setText("������������Գ�������ƽ�֣�");draw++;break;
                case 2:label.setText("������������Գ�������ϲ��Ӯ�ˣ�");win++;break;
            }
        }
        else if(e.getSource()==but_s)
        {
            int i=((int)(Math.random()*10)%3);
            switch (i) {
                case 0:label.setText("���ʯͷ�����Գ�ʯͷ��ƽ�֣�");draw++;break;
                case 1:label.setText("���ʯͷ�����Գ���������ϲ��Ӯ�ˣ�");win++;break;
                case 2:label.setText("���ʯͷ�����Գ��������ź������ˣ�");lose++;break;
            }

        }

        else if(e.getSource()==but_b)
        {
            int i=((int)(Math.random()*10)%3);
            switch (i) {
                case 0:label.setText("����������Գ�ʯͷ����ϲ��Ӯ�ˣ�");win++;break;
                case 1:label.setText("����������Գ����������ź������ˣ�");lose++;break;
                case 2:label.setText("����������Գ�����ƽ�֣�");draw++;break;
            }
        }
        else if(e.getSource()==but_q)
        { label.setText("");
            win=0;draw=0;lose=0;score=0;}
        score=win-lose;
        result.setText("win:"+win+"  draw: "+draw +"  lose:"+lose+"  score:"+score);
    }
    //  ���һ��������,�Դ�����ʾ������в���.
    public static void main(String agrs[])
    {
        MainFrame2   frame  =  new MainFrame2();   // ��ʼ��һ������Ķ���
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���رհ�ť
        frame.setVisible(true);  // ʹ����ɼ�.
    }


}
