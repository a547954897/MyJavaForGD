package work.work5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("现在时间是："+now);
        Toolkit.getDefaultToolkit().beep();
    }
}
public class Example4 {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(1000,listener);
        timer.start();
        JOptionPane.showMessageDialog(null,"exit？");
        System.exit(0);
    }
}
