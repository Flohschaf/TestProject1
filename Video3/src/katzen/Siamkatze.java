package katzen;

public class Siamkatze extends Hauskatze {
	
	Siamkatze(int gewicht,String name){
		super("Siam",gewicht,name);
	}
	
  void miau() {
	  System.out.println("Miauuuu");
  }
}
