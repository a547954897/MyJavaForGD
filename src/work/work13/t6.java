package work.work13;

class JoinThread  implements Runnable {
    Thread �˻�˾��,װ�˹�,�ֿ����Ա;
    String step[ ]={"�򿪳���","���շ�����","�ҵ�","������","����"};
    JoinThread() {
       �˻�˾��=new Thread(this);   // ��ʼ���˻�˾��
       װ�˹�=new Thread(this);    // ��ʼ��װ�˹�
       �ֿ����Ա=new Thread(this);// �ֿ����Ա
       �˻�˾��.setName("�˻�˾��");
       װ�˹�.setName("װ�˹�");
       �ֿ����Ա.setName("�ֿ����Ա");
    }
    public void run(){
       if(Thread.currentThread()==�˻�˾��) {// ��Ϊ�˻�˾��
             System.out.println(�˻�˾��.getName()+"Ҫ��"+װ�˹�.getName()+"���");
             try{   װ�˹�.join();    // ռ��CPU��Դ�ڼ������̣߳�װ�˹�
             } 
             catch(InterruptedException e) { }
             for(int i=0;i<step.length;i++) {
                   System.out.println(�˻�˾��.getName()+step[i]);
                   try{  Thread.sleep(500);// ��Ϣ0.5��
                   }
                   catch(InterruptedException ee) { }
             }
       }
       else if(Thread.currentThread()==װ�˹�) {// ��Ϊװ�˹�
    	   
    	   System.out.println(װ�˹�.getName()+"Ҫ��"+�ֿ����Ա.getName()+"����");
    	   
             try{   �ֿ����Ա.join();   // ռ��CPU��Դ�ڼ������̣߳��ֿ����Ա
             } 
             catch(InterruptedException e) { }
             
             
             for(int i=1;i<=10;i++) {
                   System.out.println(װ�˹�.getName()+"���˵�"+i+"����ﵽ����");
                   try{ 
                	   Thread.sleep(500);// ��Ϣ0.5��
                   }
                   catch(InterruptedException ee) { }
             }
       }
       else if(Thread.currentThread()==�ֿ����Ա) { // ��Ϊ�ֿ����Ա
    	 
            for(int i=1;i<=5;i++) {	
                 System.out.println(�ֿ����Ա.getName( )+"�򿪵�"+i+"����") ;
                 try{  Thread.sleep(500);    // ��Ϣ0.5��
                 }
                 catch(InterruptedException e) { }
            } 
       }
    }
}
public class t6{
    public static void main(String args[ ]) {
        JoinThread  a=new JoinThread ( ); // ��ʼ�������߳���
        a.�˻�˾��.start( );  // ����˾����ʼ����
        a.װ�˹�.start( );   // װ�˹���ʼ���
        a.�ֿ����Ա.start( );// �ֿ����Ա��ʼ����
    }
}
