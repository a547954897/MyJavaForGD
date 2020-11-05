package work.work4;

public class A {
	public int f(int m,int n) {
		if (n<m) {
			int temp;
			temp = n;
			n = m;
			m = temp;
		}
		
		int r = m%n;
		while(r!=0){
			m = n;
			n = r;
			r = m % n;
			
		}
		return n;
	}

}
