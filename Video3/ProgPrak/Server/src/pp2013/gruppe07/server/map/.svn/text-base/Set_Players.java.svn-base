package pp2013.gruppe07.server.map;

import pp2013.gruppe07.shared.*;

import pp2013.gruppe07.shared.entity.Hero;




/**
 * In dieser Klasse werden die Start/ und Spawnpunkte der Helden festgelegt
 * Die setPlayers Methode bekommt ein Array heros mit den Helden in geordneter Reihenfolge (0-3 Team Rot
 * 4-7 Team Blau.
 * Zusaetlich wird die Position an die Heldenklassen direkt uebergeben
 * 
 * @author FloHschaf
 *
 */
public class Set_Players  {
	final static int size=100;
    final static int plattformsize=(int)size/5;

	/**
	 *  Jeder Spieler bekommt in festgelegter Reihenfolge einen Start/Spawningpunkt fuer den Helden 
	 * @author Flo
	 * @param map
	 * @param heros
	 * @param playerNumber
	 * @return
	 */
	
	public Tile[][]setPlayers(Tile[][]map,Hero heros,int playerNumber){
		
		switch (playerNumber){
		case 0: {map[(int) ((size-plattformsize*0.85)-1)+20][(int) (size*0.04)+20].setobject(heros);	
				 heros.setPosition((int) ((size-plattformsize*0.85)-1+20), (int) (size*0.04)+20);break;}
		case 1:	{map[((int) (size-plattformsize*0.7)-1)+20][(int) (size*0.07-1)+20].setobject(heros);
		         heros.setPosition(((int) (size-plattformsize*0.7)-1)+20,(int) (size*0.07-1)+20);break;}
		case 2: {map[(int) ((size-plattformsize*0.4)-1)+20][(int) (size*0.15-1)+20].setobject(heros);
		         heros.setPosition((int) ((size-plattformsize*0.4)-1)+20,(int) (size*0.15-1)+20);break;}
		case 3: {map[(int) ((size-plattformsize*0.25)-1)+20][(int) (size*0.17-1)+20].setobject(heros);
		         heros.setPosition((int) ((size-plattformsize*0.25)-1)+20,(int) (size*0.17-1)+20);break;}
		case 4: {map[(int) (size*0.16+1)+20][(int) ((size-plattformsize*0.15)+1)+20].setobject(heros);				  
				 heros.setPosition((int) (size*0.16+1)+20, (int) ((size-plattformsize*0.15)+1)+20);break;}
		case 5: {map[(int) (size*0.13)+1+20][(int) ((size-plattformsize*0.4)+1+20)].setobject(heros);
		         heros.setPosition((int) (size*0.13)+1+20,(int) ((size-plattformsize*0.4)+1+20));break;}
		case 6: {map[(int) (size*0.07+1)+20][(int) ((size-plattformsize*0.77)+1)+20].setobject(heros);
		         heros.setPosition((int) (size*0.07+1)+20,(int) ((size-plattformsize*0.77)+1)+20);break;}
		case 7: {map[(int) (size*0.04+1)+20][(int) ((size-plattformsize*0.90)+1)+20].setobject(heros);
		         heros.setPosition((int) (size*0.04+1)+20,(int) ((size-plattformsize*0.90)+1)+20);break;}
		}
	 
		  return map;
	  }
	  
	  

}

