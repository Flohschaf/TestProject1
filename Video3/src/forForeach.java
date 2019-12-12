
public class forForeach {

	public static void main(String[] args) {
		
		
		int[]spieler=new int[5];
		
		for (int i=0; i<5;i++) {
			spieler[i]=i+1;
		}
		
		for (int eintrag:spieler) {
			System.out.println("Spieler "+eintrag+ " ist im Spiel.");
		}

	}

}
