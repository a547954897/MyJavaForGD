package work.work9;

import java.io.*;

public class t3 {
    public static void main(String args[]) {
        File source = new File("D:\\study\\java\\file\\ch8\\source.txt");//声明并初始化源文件"D:/ch8/source.txt"
        File encode = new File("D:\\study\\java\\file\\ch8\\encode.txt");//声明并初始化加密文件"D:/ch8/encode.txt"
        File decode = new File("D:\\study\\java\\file\\ch8\\decode.txt");//声明并初始化解密文件"D:/ch8/decode.txt"
        char b[] = new char[100];
        try {
            //将源文件读出，加密，并写入加密文件
            FileReader in = new FileReader(source);      // 创建指向source的字符输入流in
            FileWriter out = new FileWriter(encode);        // 创建指向encode字符输出流out
            int n = 1;
            while ((n = in.read(b)) != -1) {  //  一次读取100个字符 ，文件结尾则返回-1
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');//  逐个字符加密
                }
                out.write(b, 0, n);                // out将数组b的前n单元写到文件
            }
            out.close();      // out关闭

            //从加密文件中读取数据显示
            in = new FileReader(encode);              // 创建指向encode的字符输入流
            System.out.println("加密后的文件内容:");
            while (((n = in.read(b)) != -1)) {           //  一次读取100个字符 ，文件结尾则返回-1
                String str = new String(b, 0, n);     //字符数组b存入字符串str
                System.out.println(str);
            }
            in.close(); // in关闭

            //将加密文件读出，解密，并写入解密文件
            in = new FileReader(encode);  // 创建指向encode的字符输入流
            out = new FileWriter(decode);// 创建指向decode的字符输出流
            n = 1;
            while (((n = in.read(b)) != -1)) {
                for (int i = 0; i < n; i++) {
                    b[i] = (char) (b[i] ^ 'a');
                }
                out.write(b, 0, n);
            }
            out.close();      // out关闭


            System.out.println("解密后的文件内容:");
            //从解密文件中读取数据显示
            in = new FileReader(decode);
            while (((n = in.read(b)) != -1)) {
                String str = String.copyValueOf(b);
                System.out.println(str);
            }

            in.close();         // in关闭

        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("181603010819 赵开强");
    }
}
