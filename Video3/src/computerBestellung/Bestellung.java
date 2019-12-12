package computerBestellung;

public class Bestellung {

	public static void main(String[] args) {

		Computer gamingPC= new Computer ("42Hz", "over9000",1337,1.50f);
		Computer notebook= new Computer ("2MHz", "7er Serie",1,13.37f);
		
		String gk=gamingPC.grafikkarte;
		System.out.println(gk);
		
		gk=notebook.grafikkarte;
		System.out.println(gk);
		
		gamingPC.datenblatt();
		notebook.datenblatt();
		

	}

}
