
public class Rekursion {

	public static void main(String[] args) {
		
		loop(42);
		

	}
	
	
	static void loop (int num) {
		if (num>0){
			System.out.println("Noch "+ num+" Durchlaeufe");
			loop(num-1);
		}
	}

}
