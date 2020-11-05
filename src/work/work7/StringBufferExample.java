package work.work7;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("ABCDEFG");
        stringBuffer.append("123456789");
        System.out.println(stringBuffer);

        stringBuffer.replace(1, 2, "b");
        System.out.println(stringBuffer);

        stringBuffer.insert(7, "Game");
        System.out.println(stringBuffer);

        int index = stringBuffer.indexOf("1");
        System.out.println(index);
        stringBuffer.delete(index, index + 4);

        int n = stringBuffer.length();
        stringBuffer.replace(n - 3, n, "Æß°Ë¾Å");
        System.out.println(stringBuffer);
        System.out.println("181603010819 ÕÔ¿ªÇ¿");

    }
}
