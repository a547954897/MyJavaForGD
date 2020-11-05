package work.work12;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Person extends JButton implements FocusListener { // 每个button为一个人，实现焦点监听接口

    int number;
    Color c;

    Person(int number, String s) {
        super(s);
        this.number = number;
        c = getBackground();// 获取button原来默背景颜色
        setFont(new Font("宋体",Font.CENTER_BASELINE,14)); // 将字体设为"宋体",Font.CENTER_BASELINE,14)
        this.isDefaultButton(); // 当前按钮注册为本身的监视器
    }

    public void focusGained(FocusEvent e) { // 焦点获得方法
        this.setBackground(Color.cyan);;// 设置button背景颜色为Color.cyan
    }

    public void focusLost(FocusEvent e) { // 焦点失去方法
        this.setBackground(c);;// 设置button背景颜色为原来默认颜色
    }
}



// 继承JFrame类，实现键盘监听、鼠标监听和事件监听接口
class Hua_Rong_Road extends JFrame implements KeyListener, MouseListener,ActionListener {


    Person person[] = new Person[10];// new10个人数组空间
    JButton left, right, above, below; // 定义4个button做边界
    JButton restart = new JButton("重新开始");
    Container con;

    public Hua_Rong_Road() {
        init();
        setBounds(100, 100, 320, 360);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);// 窗体大小不可改

        person[9].requestFocus(); // person[9]获取焦点
    }

    public void init() {// 初始化方法
        setTitle("181603010822张启松");
        con = getContentPane();// 获取当前容器
        con.setLayout(null); // 设置当前容器布局为空布局
        con.add(restart);
        restart.setBounds(100, 5, 120, 25);
        restart.addActionListener(this);
        String name[] = { "曹操", "关羽", "张", "刘", "马", "许", "兵", "兵", "兵", "兵" };
        for (int i = 0; i < name.length; i++) {
            person[i] = new Person(i, name[i]); // 初始化人物
            person[i].addKeyListener(this); // 将当前窗口注册为person[i]的KeyEvent事件监视器
            person[i].addMouseListener(this); // 将当前窗口注册为person[i]的MouseEvent事件监视器
            con.add(person[i]);
        }
        person[0].setBounds(104, 54, 100, 100); // 初始化人物位置和大小 参数为 104,54,100,100
        person[1].setBounds(104, 154, 100, 50); // 初始化人物位置和大小 参数为 104,154,100,50
        person[2].setBounds(54, 154, 50, 100); // 初始化人物位置和大小 参数为54, 154,50,100
        person[3].setBounds(204, 154, 50, 100); // 初始化人物位置和大小 参数为 204,154,50,100
        person[4].setBounds(54, 54, 50, 100); // 初始化人物位置和大小 参数为54, 54, 50,100
        person[5].setBounds(204, 54, 50, 100); // 初始化人物位置和大小 参数为204, 54, 50,100
        person[6].setBounds(54, 254, 50, 50); // 初始化人物位置和大小 参数为 54,254,50,50
        person[7].setBounds(204, 254, 50, 50); // 初始化人物位置和大小 参数为 204,254,50,50
        person[8].setBounds(104, 204, 50, 50); // 初始化人物位置和大小 参数为 104,204,50,50
        person[9].setBounds(154, 204, 50, 50); // 初始化人物位置和大小 参数为154,204,50,50

        left = new JButton(); // 初始化左边界
        right = new JButton();// 初始化右边界
        above = new JButton();// 初始化上边界
        below = new JButton();// 初始化下边界
        con.add(left);
        con.add(right);
        con.add(above);
        con.add(below);
        left.setBounds(49, 49, 5, 260);// 设置左边界位置和大小
        right.setBounds(254, 49, 5, 260);// 设置右边界位置和大小
        above.setBounds(49, 49, 210, 5);// 设置上边界位置和大小
        below.setBounds(49, 304, 210, 5);// 设置下边界位置和大小
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


//	public void keyPressed(KeyEvent e) { // 键盘下压事件
//		Person man =(Person) e.getSource() ; // 获取事件源
//		if (e.getKeyCode() == KeyEvent.VK_DOWN) { // 判断是否按了“↓”键
//			goDown(man);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_UP) { // 判断是否按了“↑”键
//			goUp(man);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // 判断是否按了“←”键
//			goLeft(man);
//		}
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 判断是否按了“→”键
//			goRight(man);
//		}
//	}

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        Person man = (Person)e.getSource(); // 获取事件源
        int x = -1, y = -1;
        x = man.getBounds().width; // 获取x坐标
        y = man.getBounds().height; // 获取y坐标
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
//		boolean move = true; // 设置移动状态为真
//		Rectangle manRect = man.getBounds();// 获取该人的矩阵位置
//		int x = man.getBounds().x;// 获取该人的位置横坐标
//		int y = man.getBounds().y;// 获取该人的位置纵坐标
//
//		y=y+50;// 纵坐标增加50
//
//		manRect.setLocation(x, y);// 整个矩阵移动
//
//		Rectangle belowRect = below.getBounds();// 获取下边界矩阵
//
//		if (manRect.intersects(belowRect))// 若该人的矩阵和下边界矩阵交叉了，即出界了，则不移动
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // 若该人的矩阵和其他人的矩阵交叉了，也不能移动
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // 该人移动
//	}
//
//	public void goUp(Person man) {
//		boolean move = true; // 设置移动状态为真
//		Rectangle manRect = man.getBounds();// 获取该人的矩阵位置
//		int x = man.getBounds().x;// 获取该人的位置横坐标
//		int y = man.getBounds().y;// 获取该人的位置纵坐标
//
//		y=y-50;// 纵坐标减少50
//
//		manRect.setLocation(x, y);// 整个矩阵移动
//
//		Rectangle belowRect = below.getBounds();// 获取上边界矩阵
//
//		if (manRect.intersects(belowRect))// 若该人的矩阵和下边界矩阵交叉了，即出界了，则不移动
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // 若该人的矩阵和其他人的矩阵交叉了，也不能移动
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // 该人移动
//
//
//	}
//
//	public void goLeft(Person man) {
//		boolean move = true; // 设置移动状态为真
//		Rectangle manRect = man.getBounds();// 获取该人的矩阵位置
//		int x = man.getBounds().x;// 获取该人的位置横坐标
//		int y = man.getBounds().y;// 获取该人的位置纵坐标
//
//		x=x-50;// 纵坐标减少50
//
//		manRect.setLocation(x, y);// 整个矩阵移动
//
//		Rectangle belowRect = below.getBounds();// 获取下边界矩阵
//
//		if (manRect.intersects(belowRect))// 若该人的矩阵和下边界矩阵交叉了，即出界了，则不移动
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // 若该人的矩阵和其他人的矩阵交叉了，也不能移动
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // 该人移动
//
//	}
//
//	public void goRight(Person man) {
//		boolean move = true; // 设置移动状态为真
//		Rectangle manRect = man.getBounds();// 获取该人的矩阵位置
//		int x = man.getBounds().x;// 获取该人的位置横坐标
//		int y = man.getBounds().y;// 获取该人的位置纵坐标
//
//		x=x+50;// 纵坐标增加50
//
//		manRect.setLocation(x, y);// 整个矩阵移动
//
//		Rectangle belowRect = below.getBounds();// 获取下边界矩阵
//
//		if (manRect.intersects(belowRect))// 若该人的矩阵和下边界矩阵交叉了，即出界了，则不移动
//			move = false;
//
//		for (int i = 0; i < 10; i++) { // 若该人的矩阵和其他人的矩阵交叉了，也不能移动
//			Rectangle personRect = person[i].getBounds();
//			if ((manRect.intersects(personRect)) && (man.number != i))
//				move = false;
//		}
//
//		if (move == true)
//			man.setLocation(x, y);; // 该人移动
//
//	}

    public void actionPerformed(ActionEvent e) {
        con.removeAll(); // 容器移除所有控件
        init();// 调用初始化方法
        validate();
        repaint();// 调用重绘方法
    }
}

public class hrd{  //主类
    public static void main(String args[]) {
        new Hua_Rong_Road();
    }
}
