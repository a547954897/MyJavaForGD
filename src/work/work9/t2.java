package work.work9;

import java.io.*;

public class t2 {
    public static void main(String[] args) {
        FileInputStream fis = null;//声明文件字节输入流
        FileOutputStream fos = null;//声明文件字节输出流
        BufferedInputStream bis = null;//声明缓冲字节输入流
        BufferedOutputStream bos = null;//声明缓冲字节输出流
        int c;
        try {
            System.out.println("输入文件名：");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//使用BufferedReader实现键盘输入
            String fname = in.readLine();//读取键盘一行
            fis = new FileInputStream("D:\\study\\java\\file\\ch8\\source.txt"); // 文件输入流初始化，值为"D:\study\java\file\ch8\source.txt"
            bis = new BufferedInputStream(fis);        // 串接成带缓冲的输入流
            fos = new FileOutputStream("D:\\study\\java\\file\\ch8\\" + fname);// 文件输出流，值为"D:/ch8/"+fname
            bos = new BufferedOutputStream(fos);        // 串接成带缓冲的输出流
            while ((c = bis.read()) != -1) {  // 逐个字节读取源文件
                bos.write(c);                      // 逐个字节写入拷贝文件，文件不存在会自动创建该文件
                bos.flush();                       // 刷新流，强制输出
            }
        } catch (IOException e1) {
            System.out.println(e1);
        } finally {
            System.out.println("181603010819 赵开强");
            try {
                if (fis != null)
                    fis.close();
                if (fos != null)
                    fos.close();
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e2) {
                System.out.println(e2);
            }
        }
    }
}

