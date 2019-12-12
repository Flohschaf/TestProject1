
public class Funktionen {

	public static void main(String[] args) {
		
		addition();
		int ergbSub=subtraktion();
		System.out.println(ergbSub);
		
		multiplikation(7,6);
		
		int ergDiv=division(42,7);
		System.out.println(ergDiv);
	}
	
	
	
	static void addition() {
		 int zahl1, zahl2;
		 zahl1=7;
		 zahl2=42;
		 System.out.println(zahl1+zahl2);
	}

	
	static int subtraktion() {
		
		int zahl1, zahl2,erg;
		zahl1=7;
		zahl2=6;
		erg=zahl1-zahl2;
		return  erg;
	}
	
	static void multiplikation(int a, int b) {
		System.out.println(a*b);
	}
	
	static int division (int a, int b) {
		return a/b;
	}
}
