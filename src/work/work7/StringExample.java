package work.work7;

public class StringExample {
    public static void main(String[] args) {
        System.out.println("181603010819 �Կ�ǿ");
        String s1 = new String("����һ��ѧ��");
        String s2 = new String("����˭��");
        if (s1.equals(s2)) {
            System.out.println("s1��s2������ͬ");
        } else {
            System.out.println("s1��s2���ݲ�ͬ");
        }

        String s3 = new String("22030219851022024");
        if (s3.startsWith("220302")) {
            System.out.println("����ʡ���֤");
        }
        String s4 = new String("��");
        String s5 = new String("��");
        if (s4.compareTo(s5) > 0) {
            System.out.println("���ֵ���s4����s5");
        } else {
            System.out.println("���ֵ���s4С��s5");
        }
        int position = 0;
        String path = "c:\\java\\jsp\\A.java";
        position = path.lastIndexOf("\\");
        System.out.println("c:\\java\\jsp\\A.java������\\��λ�ã�" + position);
        String filename = path.substring(position + 1);
        System.out.println("c:\\java\\jsp\\A.java�����ļ�����" + filename);
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
