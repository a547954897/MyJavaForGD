package work.work12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Person extends JButton implements FocusListener { // ÿ��buttonΪһ���ˣ�ʵ�ֽ�������ӿ�

    int number;
    Color c;

    Person(int number, String s) {
        super(s);
        this.number = number;
        c = getBackground();// ��ȡbuttonԭ��Ĭ������ɫ
        setFont(new Font("����",Font.CENTER_BASELINE,14)); // ��������Ϊ"����",Font.CENTER_BASELINE,14)
        this.isDefaultButton(); // ��ǰ��ťע��Ϊ����ļ�����
    }

    public void focusGained(FocusEvent e) { // �����÷���
        this.setBackground(Color.cyan);;// ����button������ɫΪColor.cyan
    }

    public void focusLost(FocusEvent e) { // ����ʧȥ����
        this.setBackground(c);;// ����button������ɫΪԭ��Ĭ����ɫ
    }
}



// �̳�JFrame�࣬ʵ�ּ��̼��������������¼������ӿ�
class Hua_Rong_Road extends JFrame implements KeyListener, MouseListener,ActionListener {


    Person person[] = new Person[10];// new10��������ռ�
    JButton left, right, above, below; // ����4��button���߽�
    JButton restart = new JButton("���¿�ʼ");
    Container con;

    public Hua_Rong_Road() {
        init();
        setBounds(100, 100, 320, 360);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);// �����С���ɸ�

        person[9].requestFocus(); // person[9]��ȡ����
    }

    public void init() {// ��ʼ������
        setTitle("181603010822������");
        con = getContentPane();// ��ȡ��ǰ����
        con.setLayout(null); // ���õ�ǰ��������Ϊ�ղ���
        con.add(restart);
        restart.setBounds(100, 5, 120, 25);
        restart.addActionListener(this);
        String name[] = { "�ܲ�", "����", "��", "��", "��", "��", "��", "��", "��", "��" };
        for (int i = 0; i < name.length; i++) {
            person[i] = new Person(i, name[i]); // ��ʼ������
            person[i].addKeyListener(this); // ����ǰ����ע��Ϊperson[i]��KeyEvent�¼�������
            person[i].addMouseListener(this); // ����ǰ����ע��Ϊperson[i]��MouseEvent�¼�������
            con.add(person[i]);
        }
        person[0].setBounds(104, 54, 100, 100); // ��ʼ������λ�úʹ�С ����Ϊ 104,54,100,100
        person[1].setBounds(104, 154, 100, 50); // ��ʼ������λ�úʹ�С ����Ϊ 104,154,100,50
        person[2].setBounds(54, 154, 50, 100); // ��ʼ������λ�úʹ�С ����Ϊ54, 154,50,100
        person[3].setBounds(204, 154, 50, 100); // ��ʼ������λ�úʹ�С ����Ϊ 204,154,50,100
        person[4].setBounds(54, 54, 50, 100); // ��ʼ������λ�úʹ�С ����Ϊ54, 54, 50,100
        person[5].setBounds(204, 54, 50, 100); // ��ʼ������λ�úʹ�С ����Ϊ204, 54, 50,100
        person[6].setBounds(54, 254, 50, 50); // ��ʼ������λ�úʹ�С ����Ϊ 54,254,50,50
        person[7].setBounds(204, 254, 50, 50); // ��ʼ������λ�úʹ�С ����Ϊ 204,254,50,50
        person[8].setBounds(104, 204, 50, 50); // ��ʼ������λ�úʹ�С ����Ϊ 104,204,50,50
        person[9].setBounds(154, 204, 50, 50); // ��ʼ������λ�úʹ�С ����Ϊ154,204,50,50

        left = new JButton(); // ��ʼ����߽�
        right = new JButton();// ��ʼ���ұ߽�
        above = new JButton();// ��ʼ���ϱ߽�
        below = new JButton();// ��ʼ���±߽�
        con.add(left);
        con.add(right);
        con.add(above);
        con.add(below);
        left.setBounds(49, 49, 5, 260);// ������߽�λ�úʹ�С
        right.setBounds(254, 49, 5, 260);// �����ұ߽�λ�úʹ�С
        above.setBounds(49, 49, 210, 5);// �����ϱ߽�λ�úʹ�С
        below.setBounds(49, 304, 210, 5);// �����±߽�λ�úʹ�С
        con.validate();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        Person man = (Person) e.getSource();
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            go(man, below);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            go(man, above);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            go(man, left);
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            go(man, right);
    }


//	public void keyPressed(KeyEvent e) { // ������ѹ�¼�
//		Person man =(Person) e.getSource() ; // ��ȡ�¼�Դ
//		if (e.getKeyCode() == KeyEvent.VK_DOWN) { // �ж��Ƿ��ˡ�������
//			goDown(man);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_UP) { // �ж��Ƿ��ˡ�������
//			goUp(man);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // �ж��Ƿ��ˡ�������
//			goLeft(man);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // �ж��Ƿ��ˡ�������
//			goRight(man);
//		}
//	}

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        Person man = (Person)e.getSource(); // ��ȡ�¼�Դ
        int x = -1, y = -1;
        x = man.getBounds().width; // ��ȡx����
        y = man.getBounds().height; // ��ȡy����
        System.out.println(x+"," + y );

    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void go(Person man, JButton direction) {
        boolean move = true;
        Rectangle manRect = man.getBounds();
        int x = man.getBounds().x;
        int y = man.getBounds().y;
        if (direction == below)
            y = y + 50;
        else if (direction == above)
            y = y - 50;
        else if (direction == left)
            x = x - 50;
        else if (direction == right)
            x = x + 50;
        manRect.setLocation(x, y);
        Rectangle dirctionRect = direction.getBounds();
        for (int k = 0; k < 10; k++) {
            Rectangle personRect = person[k].getBounds();
            if ((manRect.intersects(personRect)) && (man.number != k))
                move = false;
        }
        if (manRect.intersects(dirctionRect))
            move = false;
        if (move == true)
            man.setLocation(x, y);
    }




//	public void goDown(Person man) {
//		boolean move = true; // �����ƶ�״̬Ϊ��
//		Rectangle manRect = man.getBounds();// ��ȡ���˵ľ���λ��
//		int x = man.getBounds().x;// ��ȡ���˵�λ�ú�����
//		int y = man.getBounds().y;// ��ȡ���˵�λ��������
//
//		y=y+50;// ����������50
//
//		manRect.setLocation(x, y);// ���������ƶ�
//
//		Rectangle belowRect = below.getBounds();// ��ȡ�±߽����
//
//		if (manRect.intersects(belowRect))// �����˵ľ�����±߽���󽻲��ˣ��������ˣ����ƶ�
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // �����˵ľ���������˵ľ��󽻲��ˣ�Ҳ�����ƶ�
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // �����ƶ�
//	}
//
//	public void goUp(Person man) {
//		boolean move = true; // �����ƶ�״̬Ϊ��
//		Rectangle manRect = man.getBounds();// ��ȡ���˵ľ���λ��
//		int x = man.getBounds().x;// ��ȡ���˵�λ�ú�����
//		int y = man.getBounds().y;// ��ȡ���˵�λ��������
//
//		y=y-50;// ���������50
//
//		manRect.setLocation(x, y);// ���������ƶ�
//
//		Rectangle belowRect = below.getBounds();// ��ȡ�ϱ߽����
//
//		if (manRect.intersects(belowRect))// �����˵ľ�����±߽���󽻲��ˣ��������ˣ����ƶ�
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // �����˵ľ���������˵ľ��󽻲��ˣ�Ҳ�����ƶ�
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // �����ƶ�
//
//
//	}
//
//	public void goLeft(Person man) {
//		boolean move = true; // �����ƶ�״̬Ϊ��
//		Rectangle manRect = man.getBounds();// ��ȡ���˵ľ���λ��
//		int x = man.getBounds().x;// ��ȡ���˵�λ�ú�����
//		int y = man.getBounds().y;// ��ȡ���˵�λ��������
//
//		x=x-50;// ���������50
//
//		manRect.setLocation(x, y);// ���������ƶ�
//
//		Rectangle belowRect = below.getBounds();// ��ȡ�±߽����
//
//		if (manRect.intersects(belowRect))// �����˵ľ�����±߽���󽻲��ˣ��������ˣ����ƶ�
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // �����˵ľ���������˵ľ��󽻲��ˣ�Ҳ�����ƶ�
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // �����ƶ�
//
//	}
//
//	public void goRight(Person man) {
//		boolean move = true; // �����ƶ�״̬Ϊ��
//		Rectangle manRect = man.getBounds();// ��ȡ���˵ľ���λ��
//		int x = man.getBounds().x;// ��ȡ���˵�λ�ú�����
//		int y = man.getBounds().y;// ��ȡ���˵�λ��������
//
//		x=x+50;// ����������50
//
//		manRect.setLocation(x, y);// ���������ƶ�
//
//		Rectangle belowRect = below.getBounds();// ��ȡ�±߽����
//
//		if (manRect.intersects(belowRect))// �����˵ľ�����±߽���󽻲��ˣ��������ˣ����ƶ�
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // �����˵ľ���������˵ľ��󽻲��ˣ�Ҳ�����ƶ�
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // �����ƶ�
//
//	}

    public void actionPerformed(ActionEvent e) {
        con.removeAll(); // �����Ƴ����пؼ�
        init();// ���ó�ʼ������
        validate();
        repaint();// �����ػ淽��
    }
}

public class hrd{  //����
    public static void main(String args[]) {
        new Hua_Rong_Road();
    }
}
