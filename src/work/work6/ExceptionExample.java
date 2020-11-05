package work.work6;

class NolowerLetter extends Exception{
    public void print() {
        System.out.print("#");
    }
}
class NoDigit extends Exception{
    public void print() {
        System.out.print("*");
    }
}
class People{
    void printLetter(char c) throws NolowerLetter {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            System.out.print(c);
        } else {
            new NolowerLetter().print();
        }
    }
    void printDigit(char c) throws NoDigit {
        if (c >= '0' && c <= '9') {
            System.out.print(c);
        } else {
            new NoDigit().print();
        }
    }
}

public class ExceptionExample {
    public static void main(String[] args) throws Exception {
        People people = new People();
        for (int i = 0; i < 128; i++) {
            people.printLetter((char) i);
        }
        System.out.println();
        for (int i = 0; i < 128; i++) {
            people.printDigit((char) i);
        }
    }
}
