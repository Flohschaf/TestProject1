package katzen;

public class KatzenTest {
	
	public static void main(String[]args) {
		
		Siamkatze katze1=new Siamkatze(12,"Lulu");
		katze1.miau();
		
		Tiger tiger1=new Tiger(300);
		System.out.println(tiger1.gewicht);
		
	}

}
