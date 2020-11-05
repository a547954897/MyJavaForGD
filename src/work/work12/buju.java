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
        setTitle("181603010819 赵开强");
        JTextArea text = new JTextArea("大家好,我是王尼玛！");
        setBounds(100, 100, 500, 300);
        setVisible(true);
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        flowLayoutPanel = new JPanel();
        FlowLayout flow = new FlowLayout();      //创建flow
        flow.setAlignment(FlowLayout.LEFT);           // flow设置组件靠左对齐
        flow.setVgap(4);           // flow设置组件的垂直间隙为4个像素单位
        flow.setHgap(10);            // flow设置组件的水平间隙为10个像素单位
        flowLayoutPanel.setLayout(flow);            // flowLayoutPanel使用布局flow
        flowLayoutPanel.add(b[1]);            // flowLayoutPanel添加组件b[1]
        flowLayoutPanel.add(b[2]);            // flowLayoutPanel添加组件b[2]
        flowLayoutPanel.add(b[3]);            // flowLayoutPanel添加组件b[3]
        flowLayoutPanel.add(b[4]);           // flowLayoutPanel添加组件b[4]
        flowLayoutPanel.add(b[5]);            // flowLayoutPanel添加组件b[5]
        tabbedPane.add("观看FlowLyout布局", flowLayoutPanel);

        gridLayoutPanel = new JPanel();
        GridLayout grid = new GridLayout(2, 3);       // 创建布局grid为2行3列
        grid.setVgap(6);         // grid设置组件的垂直间隙为6个像素单位
        grid.setHgap(8);         // grid设置组件的水平间隙为8个像素单位
        gridLayoutPanel.setLayout(grid);         // gridLayoutPanel使用布局grid
        gridLayoutPanel.add(b[6]);         // gridLayoutPanel添加组件b[6]
        gridLayoutPanel.add(b[7]);         // gridLayoutPanel 添加组件b[7]
        gridLayoutPanel.add(b[8]);         // gridLayoutPanel添加组件b[8]
        gridLayoutPanel.add(b[9]);         // gridLayoutPanel添加组件b[9]
        gridLayoutPanel.add(b[19]);         // gridLayoutPanel添加组件b[10]
        gridLayoutPanel.add(b[11]);         // gridLayoutPanel添加组件b[11]
        tabbedPane.add("观看GriderLayout布局", gridLayoutPanel);

        borderLayoutPanel = new JPanel();
        BorderLayout border = new BorderLayout();           // 创建布局border
        border.setVgap(5);          // border设置组件的垂直间隙为5个像素单位
        border.setHgap(7);          // border设置组件的水平间隙为7个像素单位
        borderLayoutPanel.setLayout(border);          // borderLayoutPanel使用布局border。
        borderLayoutPanel.add(b[12], BorderLayout.SOUTH);          // borderLayoutPanel添加b[12]在SOUTH区域
        borderLayoutPanel.add(b[13], BorderLayout.NORTH);          // borderLayoutPanel添加b[13]在NORTH区域
        borderLayoutPanel.add(text, BorderLayout.CENTER);          // borderLayoutPanel添加text在 CENTER区域
        borderLayoutPanel.add(b[14], BorderLayout.EAST);          // borderLayoutPanel添加b[14]在EAST区域
        borderLayoutPanel.add(b[15], BorderLayout.WEST);          // borderLayoutPanel添加b[15]在WEST区域
        tabbedPane.add("观看BorderLayout布局", borderLayoutPanel);

        boxLayoutPanel = Box.createVerticalBox();
        boxLayoutPanel.add(b[16]);          // boxLayoutPanel添加b[16]
        boxLayoutPanel.add(b[17]);          // boxLayoutPanel添加b[17]
        boxLayoutPanel.add(b[18]);          // boxLayoutPanel添加b[18]
        boxLayoutPanel.add(b[19]);          // boxLayoutPanel添加b[19]
        boxLayoutPanel.add(b[20]);          // boxLayoutPanel添加b[20]
        boxLayoutPanel.add(b[21]);          // boxLayoutPanel添加b[21]
        tabbedPane.add("观看BoxLayout布局", boxLayoutPanel);

        nullLayoutPanel = new JPanel();
        nullLayoutPanel.setLayout(null);          // nullLayoutPanel将布局设置为null
        nullLayoutPanel.add(b[22]);          // nullLayoutPanel添加b[22]
        nullLayoutPanel.add(b[23]);          // nullLayoutPanel添加b[23]
        nullLayoutPanel.add(b[24]);          // nullLayoutPanel添加b[24]
        nullLayoutPanel.add(b[25]);          // nullLayoutPanel添加b[25]
        nullLayoutPanel.add(b[26]);          // nullLayoutPanel添加b[26]
        b[22].setBounds(100, 200, 60, 30);          // b[22]设置在容器中的位置坐标是(100,100),本身宽60，高30
        b[23].setBounds(130, 120, 60, 30);          // b[23]设置在容器中的位置坐标是(130,120),本身宽60，高30
        b[24].setBounds(160, 140, 60, 30);          // b[24]设置在容器中的位置坐标是(160,140),本身宽60，高30
        b[25].setBounds(190, 160, 60, 30);          // b[25]设置在容器中的位置坐标是(190,160),本身宽60，高30
        b[26].setBounds(210, 180, 60, 30);          // b[26]设置在容器中的位置坐标是(210,180),本身宽60，高30
        tabbedPane.add("观看null布局", nullLayoutPanel);

        splitPaneOne = new JSplitPane(JSplitPane.VERTICAL_SPLIT,b[27],b[28]);
// 创建splitPaneOne为VERTICAL_SPLIT型，放置组件b[27]和b[28]
        splitPaneTwo = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitPaneOne,b[29]);
// 创建splitPaneTwo为HORIZONTAL_SPLIT型，放置组件splitPaneOne和b[29]
        tabbedPane.add("观看JSplitPane", splitPaneTwo);
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.add(b[30], JLayeredPane.DEFAULT_LAYER);           // layeredPane添加b[30]在DEFAULT_LAYER层
        layeredPane.add(b[31], JLayeredPane.PALETTE_LAYER);             // layeredPane添加b[31]在PALETTE_LAYER层
        layeredPane.add(b[32], JLayeredPane.MODAL_LAYER);             // layeredPane添加b[32]在MODAL_LAYER层
        layeredPane.add(b[33], JLayeredPane.POPUP_LAYER);             // layeredPane添加b[33]在POPUP_LAYER层
        layeredPane.add(b[34], JLayeredPane.DRAG_LAYER);             // layeredPane添加b[34]在DRAG_LAYER层
        b[30].setBounds(100, 100, 60, 30);
        b[31].setBounds(130, 120, 60, 30);
        b[32].setBounds(160, 140, 60, 30);
        b[33].setBounds(190, 160, 60, 30);
        b[34].setBounds(210, 180, 60, 30);
        tabbedPane.add("观看JLayeredPane", layeredPane);
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
