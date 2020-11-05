package work.work10;

import java.util.*;

class Block {
    String name;
    boolean boo = false;

    public void setName(String name) {
        this.name = name;  // ������name��ֵ����Ա����
    }

    public String getName() {
        return name;  // ���س�Ա����name
    }

    boolean isMine() {
        return boo;  // ���س�Ա����boo
    }

    public void setBoolean(boolean boo) {
        this.boo = boo;  // ������boo��ֵ����Ա����boo
    }
}

public class t3 {
    public static void main(String args[]) {
        int mine = 25;
        Block block[][] = new Block[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                block[i][j] = new Block();     //��ʼ��block[i][j]
            }
        }
        LinkedList<Block> list = new LinkedList<>();  // ����LinkList���Ͷ���list
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                list.add(block[i][j]);   //��block[i][j]��ӵ�list
            }
        }
        while (mine >= 0) {
            int size = list.size();// ����list�нڵ����
            int randomIndex = (int) (Math.random() * size);
            Block b = list.get(randomIndex);// ����list������ֵΪrandomIndex�Ľڵ��еĶ���
            b.setName("@");
            b.setBoolean(true);
            list.remove(randomIndex);          // listɾ������ֵΪrandomIndex�Ľڵ�
            mine--;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (block[i][j].isMine())//�ж�block[i][j]�Ƿ��ǵ���
                {

                } else {
                    int mineNumber = 0;               //��������������Χ���ڵĵ��׸�����������������Ϊname
                    for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, 7); k++) {
                        for (int t = Math.max(j - 1, 0); t <= Math.min(j + 1, 7); t++) {
                            if (block[k][t].isMine()) //�ж�block[k][t]�Ƿ��ǵ���
                                mineNumber++;
                        }
                    }
                    block[i][j].setName("" + mineNumber);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%2s", block[i][j].getName());
            }
            System.out.printf("%n");
        }
        System.out.println("181603010819 �Կ�ǿ");
    }

}

