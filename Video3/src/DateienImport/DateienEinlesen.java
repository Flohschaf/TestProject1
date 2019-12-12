package DateienImport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateienEinlesen {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		File daten=new File("daten.txt");
		Scanner sc=new Scanner(daten);
		String[] d=new String [10];
		int i=0;
		while(sc.hasNextLine()) {
			d[i]=sc.nextLine();
			i++;
		}
		sc.close();
		
		for(String i1:d) {
			System.out.println(i1);
		}
	}

}
