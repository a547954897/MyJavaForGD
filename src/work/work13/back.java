//package work.work13;
//
//class Shop implements Runnable {
//    Thread zhangWorker,wangWorker,boss;
//    Shop() {
//    	 this.boss = new Thread(this);   // 创建boss，Shop对象为boss目标对象
//    	 this.wangWorker = new Thread(this);  // 创建zhangWorker，Shop对象为boss目标对象
//    	 this.wangWorker = new Thread(this);  // 创建wangWorker，Shop对象为boss目标对象
//         zhangWorker.setName("张工");// 设置zhangWorker姓名为张工
//         wangWorker.setName("王工");// 设置wangWorker姓名为王工
//         boss.setName("李老板");// 设置boss姓名为李老板
//    }
//    public void run() {
//       int i=0;
//       if(Thread.currentThread()==zhangWorker) {// 若当前线程是zhangWorker
//             while(true) {
//                  try{  i++;
//                      System.out.println([代码]);//输出谁搬了几箱苹果
//
//                      if(i==5)
//                           [代码];//搬够5箱苹果完工。
//
//                        [代码];       // zhangWorker休眠10秒（10000毫秒）
//                  }
//                  catch(InterruptedException e) {
//                        System.out.println([代码]+"让"+[代码]+"继续工作!");
//                  }
//              }
//       }
//      else if(Thread.currentThread()==wangWorker) {// 若当前线程是wangWorker
//             [代码]
//      }
//      else if(Thread.currentThread()==boss) {
//              while(true) {
//            	  [代码];     // 吵醒zhangWorker
//            	  [代码];      // 吵醒wangWorker
//                   if(!([代码]||[代码])) {// 若两位工人都搬完了
//                        System.out.println([代码]+"说：下班吧！");   // 老板说下班
//                        return;
//                   }
//              }
//      }
//    }
//}
//public class t4 {
//    public static void main(String args[]) {
//        Shop shop=new Shop();
//        [代码];         // 开始张工线程
//        [代码];        // 开始王工线程
//        [代码];       // 开始老板线程
//    }
//}
//
//
