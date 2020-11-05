package work.work12;
import java.util.LinkedList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Block   //����
{ String name; //���� ��������Χ�׸����Լ��Ƿ�Ϊ��
    int number;
    boolean boo=false;
    public void setName(String name)//���ÿ���
    { this.name=name;
    }
    public void setNumber(int n)//������Χ�׸���
    { number=n;
    }
    public int getNumber()//��ȡ��Χ�׸���
    {
        return number;
    }
    public String getName()//��ȡ����
    { return name;
    }
    boolean isMine()//�ж��Ƿ�Ϊ��
    {
        return boo;
    }
    public void setIsMine(boolean boo)//�����Ƿ�Ϊ��
    {
        this.boo=boo;
    }
}


class LayMines  //������
{   public void layMinesForBlock(Block block[][],int mineCount)//���׷���
{   int row=block.length;  //��ȡblock�����г���
    int column=block[0].length; //��ȡblock�����г���
    LinkedList list=new LinkedList(); //����������list
    for(int i=0;i<row;i++)
    { for(int j=0;j<column;j++)
    {  list.add(block[i][j]);// list��ӽڵ㣬���е�����Ϊblock[i][j]
    }
    }
    while(mineCount>0)
    {   int size=list.size();  // list���ؽڵ�ĸ���
        int randomIndex=(int)(Math.random()*size);
        Block b=(Block)list.get(randomIndex); // list��������ΪrandomIndex�Ľڵ��е�����
        b.setName("��");
        b.setIsMine(true);
        list.remove(randomIndex);      //listɾ������ֵΪrandomIndex�Ľڵ�
        mineCount--;
    }
    for(int i=0;i<row;i++)
    { for(int j=0;j<column;j++)
    { if(block[i][j].isMine()){}//�ж�block[i][j]�Ƿ��ǵ���
    else
    {  int mineNumber=0; //��������������Χ���ڵĵ��׸�����������������Ϊname��number
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


class BlockView extends Panel //��ͼ�������
{  JLabel blockName; //����һ����ǩ�����ƣ���һ����ť������
    JButton blockCover;
    CardLayout card;  //��Ƭ���֣�Ϊ����������׼��
    boolean isshow=false; //һ��ʼ������ʾΪ��
    BlockView()
    { card=new CardLayout(); //��ʼ����Ƭ����
        setLayout(card);;    //������ͼ��Ϊ��Ƭ����
        blockName=new JLabel();
        blockCover=new JButton();
        add("cover",blockCover);//��ӿ�Ƭ���水ť
        add("name",blockName);//��ӱ�ǩ����

    }
    public void setName(String name)//���ñ�ǩ������
    { blockName.setText(name);
    }
    public String getName()//��ȡ��ǩ������
    {  return blockName.getText();
    }
    public void seeBlockName()//��ʾ��ǩ����
    {  card.show(this, "name") ;//��ʾ��ǩ������
        isshow=true;//��isshow��Ϊtrue
        validate();
    }
    public void seeBlockCover()//��ʾ���水ť
    {  card.show(this, "cover");  //��ʾ��ť
        isshow=false;//��isshow��Ϊ��
        validate();
    }
    public JButton getBlockCover()//��ȡ���水ť
    {  return blockCover;
    }
}


class MineFrame extends JFrame implements ActionListener //������
{  JButton reStart;// ���水ť
    Block block[][]; //������
    BlockView blockView[][]; //��ͼ������
    LayMines lay;   //���׶���
    int row=8,colum=8,mineCount=8; //8x8��С��8����

    JPanel pCenter,pNorth;

    public MineFrame()
    {   setTitle("18160310819 �Կ�ǿ");
        reStart=new JButton("���¿�ʼ");
        pCenter=new JPanel();
        pNorth=new JPanel();
        pNorth.setBackground(Color.cyan);


        block=new Block[row][colum]; //new������ռ�
        for(int i=0;i<row;i++)
        {  for(int j=0;j<colum;j++)
        {  block[i][j]=new Block();  //��ʼ��������
        }
        }
        lay=new LayMines();  //��ʼ���鲼�׶���
        lay.layMinesForBlock(block,mineCount);   //���ò��׺���

        blockView=new BlockView[row][colum];//new��ͼ������ռ�

        pCenter.setLayout(new GridLayout(row,colum));//��������岼����Ϊ���񲼾֣�row��colum����

        for(int i=0;i<row;i++)
        { for(int j=0;j<colum;j++)
        {  blockView[i][j]=new BlockView(); //��ʼ����ͼ������
            blockView[i][j].setName(block[i][j].getName());;//��������ı�ǩ�׸�ֵ����ͼ������
            pCenter.add(blockView[i][j]);//����ͼ������������
            blockView[i][j].getBlockCover().addActionListener(this);;//Ϊÿ����ͼ��ķ��水ťע�����
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
    {  JButton source=(JButton)e.getSource();//��ȡ��ť�¼�Դ
        if(source!=reStart)   //����¼�Դ�������水ť������ҵ����ĸ����水ť��ȷ������
        { int m=-1,n=-1,r=0;
            for(int i=0;i<row;i++)
            { for(int j=0;j<colum;j++)
            { if(source==blockView[i][j].getBlockCover())//���ҷ��水ť��ȷ������
            { m=i;
                n=j;
                break;
            }
            }
            }

            if(block[m][n].isMine()) //���������жϸÿ������Ƿ�Ϊ��
            {  for(int i=0;i<row;i++)
            {  for(int j=0;j<colum;j++)
            {  blockView[i][j].getBlockCover().removeActionListener(this);//Ϊ�������з��水ť�Ƴ�����
                if(block[i][j].isMine())
                    blockView[i][j].seeBlockName(); //��ʾ����Ϊ�׵���ͼ��
            }
            }
            }
            else//��Ϊ�����������Χ���׸���
            {  if(block[m][n].getNumber()>0)//��Χ�׸�������0����ʾ
            { blockView[m][n].seeBlockName();}
            else if(block[m][n].getNumber()==0)//��Χ�׸�������0�����¼��㲢��ʾ
                for(int k=Math.max(m-1,0);k<=Math.min(m+1,row-1);k++)
                { for(int t=Math.max(n-1,0);t<=Math.min(n+1,colum-1);t++)
                {
                    blockView[k][t].seeBlockName();

                }
                }
            }

            for(int i=0;i<row;i++)
            { for(int j=0;j<colum;j++)
            {  if(blockView[i][j].isshow)r++;//ͳ���Ѿ���ʾ����ͼ��
            }
            }

            if(r==row*colum-mineCount){JOptionPane.showMessageDialog(null, "ͨ�أ�");}//��56����û�б�ը����˵��ʣ��ȫ���ף���ʾͨ�أ�

        }
        else   //����¼�Դ�����水ť�������²���
        {  for(int i=0;i<row;i++)
        { for(int j=0;j<colum;j++)
        {  block[i][j].setIsMine(false);;//�����ÿ�����ȫ��Ϊ��
        }
        }
            lay.layMinesForBlock(block,mineCount); //���²���
            for(int i=0;i<row;i++)
            { for(int j=0;j<colum;j++)
            {  blockView[i][j].setName(block[i][j].getName());//��������ı�ǩ�׸�ֵ����ͼ������
                blockView[i][j].seeBlockCover();;//��ʾ���水ť
                blockView[i][j].getBlockCover().addActionListener(this);//Ϊÿ����ͼ��ķ��水ťע�����

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
