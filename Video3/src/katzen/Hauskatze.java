package katzen;

public class Hauskatze extends Katze{

	String name;
	Hauskatze(String rasse,int gewicht,String derName){
		super(rasse,gewicht);
		this.name=derName;
	}
	
	void miau() {
		System.out.println("Miau");
	}
	
}
