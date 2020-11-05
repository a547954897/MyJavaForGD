package work.work7;

public class StringExample {
    public static void main(String[] args) {
        System.out.println("181603010819 赵开强");
        String s1 = new String("你是一个学生");
        String s2 = new String("你是谁？");
        if (s1.equals(s2)) {
            System.out.println("s1与s2内容相同");
        } else {
            System.out.println("s1与s2内容不同");
        }

        String s3 = new String("22030219851022024");
        if (s3.startsWith("220302")) {
            System.out.println("吉林省身份证");
        }
        String s4 = new String("你");
        String s5 = new String("我");
        if (s4.compareTo(s5) > 0) {
            System.out.println("按字典序，s4大于s5");
        } else {
            System.out.println("按字典序，s4小于s5");
        }
        int position = 0;
        String path = "c:\\java\\jsp\\A.java";
        position = path.lastIndexOf("\\");
        System.out.println("c:\\java\\jsp\\A.java最后出现\\的位置：" + position);
        String filename = path.substring(position + 1);
        System.out.println("c:\\java\\jsp\\A.java含有文件名：" + filename);
        String s6 = new String("100");
        String s7 = new String("123.678");
        int n1 = Integer.parseInt(s6);
        double n2 = Double.parseDouble(s7);
        double n = n1 + n2;
        System.out.println(n);
        String s8 = new String("ABCDEF");
        char a[] = s8.toCharArray();
        for (int i = a.length - 1; 0 < i + 1; i--) {
            System.out.print(a[i]);
        }

    }
}
