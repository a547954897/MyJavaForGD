package work.work3;

;
class A{
	float a;
	static float b;
	float getA() {
		return a;
	}
	void setA(float a) {
		this.a = a;
	}
	static float getB() {
		return b;
	}
	static void setB(float b) {
		A.b = b;
	}
	void inputA(){
		System.out.println(a);
	}
	static void inputB(){
		System.out.println(b);
	}
	
	
}
public class Work3 {
	public static void main(String[] args) {
		A.b = 100;
		A.inputB();
		A cat = new A();
		A dog = new A();
		cat.setA(200);
		cat.setB(400);
		dog.setA(300);
		dog.setB(900);
		cat.inputA();
		cat.inputB();
		dog.inputA();
		dog.inputB();
		System.out.println("181603010819 ут©╙г©");
	}
}
