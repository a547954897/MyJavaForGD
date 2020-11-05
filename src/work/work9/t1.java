package work.work9;

import java.io.*;

class FileAccept implements FilenameFilter { //实现文件名过滤器接口
    String str = null;
    FileAccept(String s) {
        this.str = s;       //“.”加上文件后缀名str
    }
    public boolean accept(File dir, String name) {//重写接口accept方法
        return name.endsWith(str);  //返回文件名后缀是否以str结尾
    }
}

public class t1 {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:\\study\\java\\file");  //声明并初始化文件目录dir为“d:\\ch8”
        if (!dir.exists()) {//判断文件目录是否存在
            dir.mkdirs();//不存在则创建该目录
            File[] f = new File[8];//声明文件数组f[8]
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 1)
                    f[i] = new File(dir, i + ".txt");//i为奇数则在dir下初始化f[i]为i.txt文件
                else
                    f[i] = new File(dir, i + ".dat");//i为偶数则在dir下初始化f[i]为i.dat文件

                if (!f[i].exists()) f[i].createNewFile();//原文件不存在则创建这些文件
            }
            System.out.println("成功创建8个文件！");

        } else {
            File[] list = dir.listFiles();//将dir目录下的文件列表存至文件数组list
            System.out.println(dir.getPath() + "目录下的文件有"); //输出dir的值
            for (int i = 0; i < dir.listFiles().length; i++) {
                System.out.println("第" + i + "个---name:" + list[i].getName() + "大小：" + list[i].length()); // 打印当前目录下包含的文件的名字 和大小
            }

            FileAccept accept = new FileAccept("txt");//初始化文件过滤器，值为文本文档。
            list = dir.listFiles(accept);  //将dir目录下的txt文件列表存至文件数组list
            System.out.println("------------------------------------------------------------------");
            for (int i = 0; i < list.length; i++) {
                System.out.println("目录下的txt文件有");
                System.out.println("第" + i + "个---name:" + list[i].getName() + "大小：" + list[i].length()); // 打印当前目录下包含的文件的名字 和大小

            }
            System.out.println("181603010819 赵开强");
        }


    }

}
