
public class Schleifen {
   public static void main(String[]args) {
	   
	   
	   int zahl=7;
	   int faktor=10;
	   int erg=0;
	   
	   while (faktor>0) {
		   erg+=zahl;
		   faktor--;
	   }
	   System.out.println("Das Ergebnis ist "+erg);
	   
	   int wartezeit=0;
	   
	   do {
		   System.out.println("Daten werden geladen . . . ");
		   wartezeit--;
	   }while(wartezeit>0);
	   
   }
}
