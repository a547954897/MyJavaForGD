package work.work11;
import javax.swing.*; // extends JFrame    ��Ҫ�ð�

import java.awt.*; // ����panel��ɫΪ��ɫ ��Ҫ�ð�
import java.awt.event.*; // �漰�������¼�����Ҫ���������

public class MainFrame extends JFrame implements ActionListener {
	// �� ����һ�������� ����ʵ��ActionListener �ӿ�

	JButton butok, butquit; // �����button������Ķ���ŵ�������.����������������.
	JPanel panel1, panel2;
	JButton bt_jiandao, bt_shitou, bt_bu, bt_clean;
	JLabel label;

	public MainFrame() {

		setTitle("181603010819 �Կ�ǿ");
		setLocation(250, 250);
		setSize(500, 500);

		panel1 = new JPanel();
		panel1.setBackground(Color.yellow);

		butok = new JButton("ok");
		butquit = new JButton("quit");

		bt_bu = new JButton("��");
		bt_jiandao = new JButton("����");
		bt_shitou = new JButton("ʯͷ");
		bt_clean = new JButton("���");

		bt_jiandao.addActionListener(this);
		bt_shitou.addActionListener(this);
		bt_bu.addActionListener(this);
		bt_clean.addActionListener(this);

		butok.addActionListener(this); // �� butok����¼�Լ��
		butquit.addActionListener(this); // �� ��butquit����¼�Լ��

		panel1.add(bt_jiandao);
		panel1.add(bt_shitou);
		panel1.add(bt_bu);
		panel1.add(bt_clean);

		panel2 = new JPanel();
		panel2.setBackground(Color.green);
		label = new JLabel(" �ı���");
		panel2.add(label);

		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
	}

	public void play(int i) {
		int tmp = ((int) (Math.random() * 10) % 3);
	}

	public void actionPerformed(ActionEvent e) {
		// �� �����ж���ӿڷ���actionPerformed();
		if (e.getSource() == bt_jiandao) {
			int i = ((int) (Math.random() * 10) % 3);
			switch (i) {
				case 0:
					label.setText("������������Գ�ʯͷ�����ź������ˣ�");
					break;
				case 1:
					label.setText("������������Գ����ӣ�ƽ�֣�");
					break;
				case 2:
					label.setText("������������Գ�������ϲ��Ӯ�ˣ�");
					break;
			}

		} else if (e.getSource() == bt_shitou) {
			int i = ((int) (Math.random() * 10) % 3);
			switch (i) {
				case 0:
					label.setText("���ʯͷ�����Գ�ʯͷ��ƽ�֣�");
					break;
				case 1:
					label.setText("���ʯͷ�����Գ����ӣ���ϲ��Ӯ�ˣ�");
					break;
				case 2:
					label.setText("���ʯͷ�����Գ��������ź������ˣ�");
					break;
			}

		} else if (e.getSource() == bt_bu) {
			int i = ((int) (Math.random() * 10) % 3);
			switch (i) {
				case 0:
					label.setText("����������Գ�ʯͷ����ϲ��Ӯ�ˣ�");
					break;
				case 1:
					label.setText("����������Գ����ӣ����ź������ˣ�");
					break;
				case 2:
					label.setText("����������Գ�����ƽ�֣�");
					break;
			}

		} else if (e.getSource() == bt_clean) {
			label.setText(" ");

		}

	}

	// ���һ��������,�Դ�����ʾ������в���.
	public static void main(String agrs[]) {
		MainFrame frame = new MainFrame(); // ��ʼ��һ������Ķ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���ô���رհ�ť
		frame.setVisible(true); // ʹ����ɼ�.
	}

}
