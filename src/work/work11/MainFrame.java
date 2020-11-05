package work.work11;
import javax.swing.*; // extends JFrame    需要该包

import java.awt.*; // 设置panel颜色为黄色 需要该包
import java.awt.event.*; // 涉及到触发事件都需要包含这个包

public class MainFrame extends JFrame implements ActionListener {
	// ① 定义一个窗体类 该类实现ActionListener 接口

	JButton butok, butquit; // 这里把button等组件的定义放到类里面.方便其他函数调用.
	JPanel panel1, panel2;
	JButton bt_jiandao, bt_shitou, bt_bu, bt_clean;
	JLabel label;

	public MainFrame() {

		setTitle("181603010819 赵开强");
		setLocation(250, 250);
		setSize(500, 500);

		panel1 = new JPanel();
		panel1.setBackground(Color.yellow);

		butok = new JButton("ok");
		butquit = new JButton("quit");

		bt_bu = new JButton("布");
		bt_jiandao = new JButton("剪刀");
		bt_shitou = new JButton("石头");
		bt_clean = new JButton("清除");

		bt_jiandao.addActionListener(this);
		bt_shitou.addActionListener(this);
		bt_bu.addActionListener(this);
		bt_clean.addActionListener(this);

		butok.addActionListener(this); // ③ butok添加事件约束
		butquit.addActionListener(this); // ③ 把butquit添加事件约束

		panel1.add(bt_jiandao);
		panel1.add(bt_shitou);
		panel1.add(bt_bu);
		panel1.add(bt_clean);

		panel2 = new JPanel();
		panel2.setBackground(Color.green);
		label = new JLabel(" 文本框");
		panel2.add(label);

		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
	}

	public void play(int i) {
		int tmp = ((int) (Math.random() * 10) % 3);
	}

	public void actionPerformed(ActionEvent e) {
		// ② 在类中定义接口方法actionPerformed();
		if (e.getSource() == bt_jiandao) {
			int i = ((int) (Math.random() * 10) % 3);
			switch (i) {
				case 0:
					label.setText("你出剪刀，电脑出石头，很遗憾你输了！");
					break;
				case 1:
					label.setText("你出剪刀，电脑出剪子，平局！");
					break;
				case 2:
					label.setText("你出剪刀，电脑出布，恭喜你赢了！");
					break;
			}

		} else if (e.getSource() == bt_shitou) {
			int i = ((int) (Math.random() * 10) % 3);
			switch (i) {
				case 0:
					label.setText("你出石头，电脑出石头，平局！");
					break;
				case 1:
					label.setText("你出石头，电脑出剪子，恭喜你赢了！");
					break;
				case 2:
					label.setText("你出石头，电脑出布，很遗憾你输了！");
					break;
			}

		} else if (e.getSource() == bt_bu) {
			int i = ((int) (Math.random() * 10) % 3);
			switch (i) {
				case 0:
					label.setText("你出布，电脑出石头，恭喜你赢了！");
					break;
				case 1:
					label.setText("你出布，电脑出剪子，很遗憾你输了！");
					break;
				case 2:
					label.setText("你出布，电脑出布，平局！");
					break;
			}

		} else if (e.getSource() == bt_clean) {
			label.setText(" ");

		}

	}

	// 添加一个主函数,对窗体显示情况进行测试.
	public static void main(String agrs[]) {
		MainFrame frame = new MainFrame(); // 初始化一个窗体的对象
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭按钮
		frame.setVisible(true); // 使窗体可见.
	}

}
