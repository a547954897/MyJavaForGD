package work.work11;

import javax.swing.*;  // extends JFrame    需要该包
import java.awt.*;    // 设置panel颜色为黄色 需要该包
import java.awt.event.*;  // 涉及到触发事件都需要包含这个包
public class  MainFrame2 extends JFrame implements ActionListener{
    // ① 定义一个窗体类 该类实现ActionListener 接口

    JButton but_j ,but_s,but_b,but_q;     // 这里把button等组件的定义放到类里面.方便其他函数调用.
    JPanel  panel1, panel2;
    JLabel  label,result;
    int win=0,draw=0,lose=0,score=0;
    public MainFrame2()
    {
        setTitle("181603010819 赵开强");
        setLocation(250, 250);
        setSize(300, 300);

        panel1 =  new JPanel();
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
        panel1.add(but_q);

        panel2 =  new JPanel();
        panel2.setBackground(Color.green);
        label = new JLabel(" 文本框");
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
        //	②  在类中定义接口方法actionPerformed();
        if(e.getSource()==but_j)
        {
            int i=((int)(Math.random()*10)%3);
            switch (i) {
                case 0:label.setText("你出剪刀，电脑出石头，很遗憾你输了！");lose++;break;
                case 1:label.setText("你出剪刀，电脑出剪刀，平局！");draw++;break;
                case 2:label.setText("你出剪刀，电脑出布，恭喜你赢了！");win++;break;
            }
        }
        else if(e.getSource()==but_s)
        {
            int i=((int)(Math.random()*10)%3);
            switch (i) {
                case 0:label.setText("你出石头，电脑出石头，平局！");draw++;break;
                case 1:label.setText("你出石头，电脑出剪刀，恭喜你赢了！");win++;break;
                case 2:label.setText("你出石头，电脑出布，很遗憾你输了！");lose++;break;
            }

        }

        else if(e.getSource()==but_b)
        {
            int i=((int)(Math.random()*10)%3);
            switch (i) {
                case 0:label.setText("你出布，电脑出石头，恭喜你赢了！");win++;break;
                case 1:label.setText("你出布，电脑出剪刀，很遗憾你输了！");lose++;break;
                case 2:label.setText("你出布，电脑出布，平局！");draw++;break;
            }
        }
        else if(e.getSource()==but_q)
        { label.setText("");
            win=0;draw=0;lose=0;score=0;}
        score=win-lose;
        result.setText("win:"+win+"  draw: "+draw +"  lose:"+lose+"  score:"+score);
    }
    //  添加一个主函数,对窗体显示情况进行测试.
    public static void main(String agrs[])
    {
        MainFrame2   frame  =  new MainFrame2();   // 初始化一个窗体的对象
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭按钮
        frame.setVisible(true);  // 使窗体可见.
    }


}
