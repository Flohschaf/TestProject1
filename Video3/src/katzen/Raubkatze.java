package katzen;

public class Raubkatze extends Katze {
	String beute;
	
	Raubkatze(String rasse, int gewicht,String diebeute){
		super(rasse,gewicht);
		this.beute=diebeute;
	}
	

}
