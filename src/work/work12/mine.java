package work.work12;
import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Block   //块类
{ String name; //声明 块名和周围雷个数以及是否为雷
    int number;
    boolean boo=false;
    public void setName(String name)//设置块名
    { this.name=name;
    }
    public void setNumber(int n)//设置周围雷个数
    { number=n;
    }
    public int getNumber()//获取周围雷个数
    {
        return number;
    }
    public String getName()//获取块名
    { return name;
    }
    boolean isMine()//判断是否为雷
    {
        return boo;
    }
    public void setIsMine(boolean boo)//设置是否为雷
    {
        this.boo=boo;
    }
}


class LayMines  //布雷类
{   public void layMinesForBlock(Block block[][],int mineCount)//布雷方法
{   int row=block.length;  //获取block数组行长度
    int column=block[0].length; //获取block数组列长度
    LinkedList list=new LinkedList(); //创建空链表list
    for(int i=0;i<row;i++)
    { for(int j=0;j<column;j++)
    {  list.add(block[i][j]);// list添加节点，其中的数据为block[i][j]
    }
    }
    while(mineCount>0)
    {   int size=list.size();  // list返回节点的个数
        int randomIndex=(int)(Math.random()*size);
        Block b=(Block)list.get(randomIndex); // list返回索引为randomIndex的节点中的数据
        b.setName("雷");
        b.setIsMine(true);
        list.remove(randomIndex);      //list删除索引值为randomIndex的节点
        mineCount--;
    }
    for(int i=0;i<row;i++)
    { for(int j=0;j<column;j++)
    { if(block[i][j].isMine()){}//判断block[i][j]是否是地雷
    else
    {  int mineNumber=0; //计算非雷坐标的周围存在的地雷个数，并将个数设置为name和number
        for(int k=Math.max(i-1,0);k<=Math.min(i+1,row-1);k++)
        { for(int t=Math.max(j-1,0);t<=Math.min(j+1,column-1);t++)
        {   if(block[k][t].isMine())
            mineNumber++;
        }
        }
        block[i][j].setName(""+mineNumber);
        block[i][j].setNumber(mineNumber);
    }
    }
    }
}
}


class BlockView extends Panel //视图块面板类
{  JLabel blockName; //声明一个标签做底牌，和一个按钮做封面
    JButton blockCover;
    CardLayout card;  //卡片布局，为上下两层做准备
    boolean isshow=false; //一开始底牌显示为假
    BlockView()
    { card=new CardLayout(); //初始化卡片布局
        setLayout(card);;    //设置视图块为卡片布局
        blockName=new JLabel();
        blockCover=new JButton();
        add("cover",blockCover);//添加卡片封面按钮
        add("name",blockName);//添加标签底牌

    }
    public void setName(String name)//设置标签底牌名
    { blockName.setText(name);
    }
    public String getName()//获取标签底牌名
    {  return blockName.getText();
    }
    public void seeBlockName()//显示标签底牌
    {  card.show(this, "name") ;//显示标签底牌名
        isshow=true;//将isshow置为true
        validate();
    }
    public void seeBlockCover()//显示封面按钮
    {  card.show(this, "cover");  //显示按钮
        isshow=false;//将isshow置为假
        validate();
    }
    public JButton getBlockCover()//获取封面按钮
    {  return blockCover;
    }
}


class MineFrame extends JFrame implements ActionListener //主窗体
{  JButton reStart;// 重玩按钮
    Block block[][]; //块数组
    BlockView blockView[][]; //视图块数组
    LayMines lay;   //布雷对象
    int row=8,colum=8,mineCount=8; //8x8大小，8个雷

    JPanel pCenter,pNorth;

    public MineFrame()
    {   setTitle("18160310819 赵开强");
        reStart=new JButton("重新开始");
        pCenter=new JPanel();
        pNorth=new JPanel();
        pNorth.setBackground(Color.cyan);


        block=new Block[row][colum]; //new块数组空间
        for(int i=0;i<row;i++)
        {  for(int j=0;j<colum;j++)
        {  block[i][j]=new Block();  //初始化块数组
        }
        }
        lay=new LayMines();  //初始化块布雷对象
        lay.layMinesForBlock(block,mineCount);   //调用布雷函数

        blockView=new BlockView[row][colum];//new视图块数组空间

        pCenter.setLayout(new GridLayout(row,colum));//将中心面板布局设为网格布局，row乘colum方阵

        for(int i=0;i<row;i++)
        { for(int j=0;j<colum;j++)
        {  blockView[i][j]=new BlockView(); //初始化视图块数组
            blockView[i][j].setName(block[i][j].getName());;//将块数组的标签底赋值给视图块数组
            pCenter.add(blockView[i][j]);//将视图块加入中心面板
            blockView[i][j].getBlockCover().addActionListener(this);;//为每个视图块的封面按钮注册监听
        }
        }

        reStart.addActionListener(this);
        pNorth.add(reStart);
        add(pNorth,BorderLayout.NORTH);
        add(pCenter,BorderLayout.CENTER);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }
    public void actionPerformed(ActionEvent e)
    {  JButton source=(JButton)e.getSource();//获取按钮事件源
        if(source!=reStart)   //如果事件源不是重玩按钮，则查找到是哪个封面按钮，确定坐标
        { int m=-1,n=-1,r=0;
            for(int i=0;i<row;i++)
            { for(int j=0;j<colum;j++)
            { if(source==blockView[i][j].getBlockCover())//查找封面按钮，确定坐标
            { m=i;
                n=j;
                break;
            }
            }
            }

            if(block[m][n].isMine()) //按照坐标判断该块数组是否为雷
            {  for(int i=0;i<row;i++)
            {  for(int j=0;j<colum;j++)
            {  blockView[i][j].getBlockCover().removeActionListener(this);//为雷则所有封面按钮移除监听
                if(block[i][j].isMine())
                    blockView[i][j].seeBlockName(); //显示所有为雷的视图块
            }
            }
            }
            else//不为雷则计算其周围的雷个数
            {  if(block[m][n].getNumber()>0)//周围雷个数大于0则显示
            { blockView[m][n].seeBlockName();}
            else if(block[m][n].getNumber()==0)//周围雷个数等于0则重新计算并显示
                for(int k=Math.max(m-1,0);k<=Math.min(m+1,row-1);k++)
                { for(int t=Math.max(n-1,0);t<=Math.min(n+1,colum-1);t++)
                {
                    blockView[k][t].seeBlockName();

                }
                }
            }

            for(int i=0;i<row;i++)
            { for(int j=0;j<colum;j++)
            {  if(blockView[i][j].isshow)r++;//统计已经显示的视图块
            }
            }

            if(r==row*colum-mineCount){JOptionPane.showMessageDialog(null, "通关！");}//满56个而没有被炸，则说明剩下全是雷，提示通关！

        }
        else   //如果事件源是重玩按钮，则重新布雷
        {  for(int i=0;i<row;i++)
        { for(int j=0;j<colum;j++)
        {  block[i][j].setIsMine(false);;//重新置块数组全不为雷
        }
        }
            lay.layMinesForBlock(block,mineCount); //重新布雷
            for(int i=0;i<row;i++)
            { for(int j=0;j<colum;j++)
            {  blockView[i][j].setName(block[i][j].getName());//将块数组的标签底赋值给视图块数组
                blockView[i][j].seeBlockCover();;//显示封面按钮
                blockView[i][j].getBlockCover().addActionListener(this);//为每个视图块的封面按钮注册监听

            }
            }
        }
    }
}

public class mine
{  public static void main(String args[])
{  new MineFrame();
}
}
