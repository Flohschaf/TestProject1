package katzen;

import java.util.ArrayList;

 public class ArrayListGenerisch {

	public static void main(String[] args) {
		
       ArrayList<Siamkatze> liste=new ArrayList <Siamkatze>();
		
       
       liste.add(new Siamkatze(4,"Peter"));
       liste.add(new Siamkatze(5,"Hans"));
       
       
       for(Siamkatze i:liste) {
    	   i.miau();
       }
		
	}

}
