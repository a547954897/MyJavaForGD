//package work.work13;
//
//class Shop implements Runnable {
//    Thread zhangWorker,wangWorker,boss;
//    Shop() {
//    	 this.boss = new Thread(this);   // ����boss��Shop����ΪbossĿ�����
//    	 this.wangWorker = new Thread(this);  // ����zhangWorker��Shop����ΪbossĿ�����
//    	 this.wangWorker = new Thread(this);  // ����wangWorker��Shop����ΪbossĿ�����
//         zhangWorker.setName("�Ź�");// ����zhangWorker����Ϊ�Ź�
//         wangWorker.setName("����");// ����wangWorker����Ϊ����
//         boss.setName("���ϰ�");// ����boss����Ϊ���ϰ�
//    }
//    public void run() {
//       int i=0;
//       if(Thread.currentThread()==zhangWorker) {// ����ǰ�߳���zhangWorker
//             while(true) {
//                  try{  i++;
//                      System.out.println([����]);//���˭���˼���ƻ��
//
//                      if(i==5)
//                           [����];//�ṻ5��ƻ���깤��
//
//                        [����];       // zhangWorker����10�루10000���룩
//                  }
//                  catch(InterruptedException e) {
//                        System.out.println([����]+"��"+[����]+"��������!");
//                  }
//              }
//       }
//      else if(Thread.currentThread()==wangWorker) {// ����ǰ�߳���wangWorker
//             [����]
//      }
//      else if(Thread.currentThread()==boss) {
//              while(true) {
//            	  [����];     // ����zhangWorker
//            	  [����];      // ����wangWorker
//                   if(!([����]||[����])) {// ����λ���˶�������
//                        System.out.println([����]+"˵���°�ɣ�");   // �ϰ�˵�°�
//                        return;
//                   }
//              }
//      }
//    }
//}
//public class t4 {
//    public static void main(String args[]) {
//        Shop shop=new Shop();
//        [����];         // ��ʼ�Ź��߳�
//        [����];        // ��ʼ�����߳�
//        [����];       // ��ʼ�ϰ��߳�
//    }
//}
//
//
