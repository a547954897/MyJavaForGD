package work.work12;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class MyWin extends JFrame {
    JTabbedPane tabbedPane;
    JPanel flowLayoutPanel,
            gridLayoutPanel,
            borderLayoutPanel,
            nullLayoutPanel;
    Box boxLayoutPanel;
    JSplitPane splitPaneOne, splitPaneTwo;
    JLayeredPane layeredPane;

    public MyWin() {
        JButton b[] = new JButton[35];
        for (int i = 0; i < b.length; i++)
            b[i] = new JButton("B" + i);
        setTitle("181603010819 �Կ�ǿ");
        JTextArea text = new JTextArea("��Һ�,���������꣡");
        setBounds(100, 100, 500, 300);
        setVisible(true);
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        flowLayoutPanel = new JPanel();
        FlowLayout flow = new FlowLayout();      //����flow
        flow.setAlignment(FlowLayout.LEFT);           // flow��������������
        flow.setVgap(4);           // flow��������Ĵ�ֱ��϶Ϊ4�����ص�λ
        flow.setHgap(10);            // flow���������ˮƽ��϶Ϊ10�����ص�λ
        flowLayoutPanel.setLayout(flow);            // flowLayoutPanelʹ�ò���flow
        flowLayoutPanel.add(b[1]);            // flowLayoutPanel������b[1]
        flowLayoutPanel.add(b[2]);            // flowLayoutPanel������b[2]
        flowLayoutPanel.add(b[3]);            // flowLayoutPanel������b[3]
        flowLayoutPanel.add(b[4]);           // flowLayoutPanel������b[4]
        flowLayoutPanel.add(b[5]);            // flowLayoutPanel������b[5]
        tabbedPane.add("�ۿ�FlowLyout����", flowLayoutPanel);

        gridLayoutPanel = new JPanel();
        GridLayout grid = new GridLayout(2, 3);       // ��������gridΪ2��3��
        grid.setVgap(6);         // grid��������Ĵ�ֱ��϶Ϊ6�����ص�λ
        grid.setHgap(8);         // grid���������ˮƽ��϶Ϊ8�����ص�λ
        gridLayoutPanel.setLayout(grid);         // gridLayoutPanelʹ�ò���grid
        gridLayoutPanel.add(b[6]);         // gridLayoutPanel������b[6]
        gridLayoutPanel.add(b[7]);         // gridLayoutPanel ������b[7]
        gridLayoutPanel.add(b[8]);         // gridLayoutPanel������b[8]
        gridLayoutPanel.add(b[9]);         // gridLayoutPanel������b[9]
        gridLayoutPanel.add(b[19]);         // gridLayoutPanel������b[10]
        gridLayoutPanel.add(b[11]);         // gridLayoutPanel������b[11]
        tabbedPane.add("�ۿ�GriderLayout����", gridLayoutPanel);

        borderLayoutPanel = new JPanel();
        BorderLayout border = new BorderLayout();           // ��������border
        border.setVgap(5);          // border��������Ĵ�ֱ��϶Ϊ5�����ص�λ
        border.setHgap(7);          // border���������ˮƽ��϶Ϊ7�����ص�λ
        borderLayoutPanel.setLayout(border);          // borderLayoutPanelʹ�ò���border��
        borderLayoutPanel.add(b[12], BorderLayout.SOUTH);          // borderLayoutPanel���b[12]��SOUTH����
        borderLayoutPanel.add(b[13], BorderLayout.NORTH);          // borderLayoutPanel���b[13]��NORTH����
        borderLayoutPanel.add(text, BorderLayout.CENTER);          // borderLayoutPanel���text�� CENTER����
        borderLayoutPanel.add(b[14], BorderLayout.EAST);          // borderLayoutPanel���b[14]��EAST����
        borderLayoutPanel.add(b[15], BorderLayout.WEST);          // borderLayoutPanel���b[15]��WEST����
        tabbedPane.add("�ۿ�BorderLayout����", borderLayoutPanel);

        boxLayoutPanel = Box.createVerticalBox();
        boxLayoutPanel.add(b[16]);          // boxLayoutPanel���b[16]
        boxLayoutPanel.add(b[17]);          // boxLayoutPanel���b[17]
        boxLayoutPanel.add(b[18]);          // boxLayoutPanel���b[18]
        boxLayoutPanel.add(b[19]);          // boxLayoutPanel���b[19]
        boxLayoutPanel.add(b[20]);          // boxLayoutPanel���b[20]
        boxLayoutPanel.add(b[21]);          // boxLayoutPanel���b[21]
        tabbedPane.add("�ۿ�BoxLayout����", boxLayoutPanel);

        nullLayoutPanel = new JPanel();
        nullLayoutPanel.setLayout(null);          // nullLayoutPanel����������Ϊnull
        nullLayoutPanel.add(b[22]);          // nullLayoutPanel���b[22]
        nullLayoutPanel.add(b[23]);          // nullLayoutPanel���b[23]
        nullLayoutPanel.add(b[24]);          // nullLayoutPanel���b[24]
        nullLayoutPanel.add(b[25]);          // nullLayoutPanel���b[25]
        nullLayoutPanel.add(b[26]);          // nullLayoutPanel���b[26]
        b[22].setBounds(100, 200, 60, 30);          // b[22]�����������е�λ��������(100,100),�����60����30
        b[23].setBounds(130, 120, 60, 30);          // b[23]�����������е�λ��������(130,120),�����60����30
        b[24].setBounds(160, 140, 60, 30);          // b[24]�����������е�λ��������(160,140),�����60����30
        b[25].setBounds(190, 160, 60, 30);          // b[25]�����������е�λ��������(190,160),�����60����30
        b[26].setBounds(210, 180, 60, 30);          // b[26]�����������е�λ��������(210,180),�����60����30
        tabbedPane.add("�ۿ�null����", nullLayoutPanel);

        splitPaneOne = new JSplitPane(JSplitPane.VERTICAL_SPLIT,b[27],b[28]);
// ����splitPaneOneΪVERTICAL_SPLIT�ͣ��������b[27]��b[28]
        splitPaneTwo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitPaneOne,b[29]);
// ����splitPaneTwoΪHORIZONTAL_SPLIT�ͣ��������splitPaneOne��b[29]
        tabbedPane.add("�ۿ�JSplitPane", splitPaneTwo);
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.add(b[30], JLayeredPane.DEFAULT_LAYER);           // layeredPane���b[30]��DEFAULT_LAYER��
        layeredPane.add(b[31], JLayeredPane.PALETTE_LAYER);             // layeredPane���b[31]��PALETTE_LAYER��
        layeredPane.add(b[32], JLayeredPane.MODAL_LAYER);             // layeredPane���b[32]��MODAL_LAYER��
        layeredPane.add(b[33], JLayeredPane.POPUP_LAYER);             // layeredPane���b[33]��POPUP_LAYER��
        layeredPane.add(b[34], JLayeredPane.DRAG_LAYER);             // layeredPane���b[34]��DRAG_LAYER��
        b[30].setBounds(100, 100, 60, 30);
        b[31].setBounds(130, 120, 60, 30);
        b[32].setBounds(160, 140, 60, 30);
        b[33].setBounds(190, 160, 60, 30);
        b[34].setBounds(210, 180, 60, 30);
        tabbedPane.add("�ۿ�JLayeredPane", layeredPane);
        tabbedPane.validate();
        Container con = getContentPane();
        con.add(tabbedPane, BorderLayout.CENTER);
        con.validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class buju {
    public static void main(String args[]) {
        new MyWin();
    }
}
