package computerBestellung;

public class Computer {

	
	String prozessor;
	String grafikkarte;
	int arbeitsspeicher;
	float preis;
	
	Computer(String derProzessor,String dieGrafikkarte, int derArbeitsspeicher,float derPreis){
		
		prozessor= derProzessor;
		grafikkarte=dieGrafikkarte;
		arbeitsspeicher=derArbeitsspeicher;
		preis=derPreis;
	}
	
	void datenblatt() {
		System.out.println("Prozessor:"+ prozessor);
		System.out.println("Grafikkarte:"+ grafikkarte);
		System.out.println("Arbeitsspeicher"+ arbeitsspeicher);
		System.out.println("Preis"+ preis);
		
	}
	
}
