package pp2013.gruppe07.server.map;






import pp2013.gruppe07.server.engine.general.ID_Generator;
import pp2013.gruppe07.shared.*;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Sebamster;
import pp2013.gruppe07.shared.entity.Joschifant;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Inhibitor;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Nature;
import pp2013.gruppe07.shared.entity.Nexus;
import pp2013.gruppe07.shared.entity.Shop;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.entity.SpaceHolderforBuilding;
import pp2013.gruppe07.shared.entity.Superboss;
import pp2013.gruppe07.shared.entity.Tower;
import pp2013.gruppe07.shared.entity.Tree;
import pp2013.gruppe07.shared.entity.Tree2;
import pp2013.gruppe07.shared.entity.Wall;
import pp2013.gruppe07.shared.ground.Grass;
import pp2013.gruppe07.shared.ground.Ground.Groundtype;
import pp2013.gruppe07.shared.ground.Sand;
import pp2013.gruppe07.shared.ground.Stone;
import pp2013.gruppe07.shared.ground.Wallground;
import pp2013.gruppe07.shared.ground.Water;
import pp2013.gruppe07.shared.ground.Junglepath;

import java.util.*;

/**
 * Die Map_Gen Klasse generiert das komplette Spielfeld
 * @author FloHschaf
 *
 */
/**
 * @author FloHschaf
 *
 */
public class Map_Gen extends Set_Players {
	Tile [][]map;
	final static int SIZE=100;                    //groesse des sichtbaren Spielfelds
	final static int BASISSIZE=(int)SIZE/5;   // saemtliche Groessen in Relation zur Spielfeldgroesse
	final static int LANESIZE=(int)SIZE/20;
	final static int RIVERSIZE=(int)SIZE/20;
	final static int NEXUSSIZE=(int)SIZE/40;
	final static int SHOPSIZE=(int)SIZE/25;
	final static int INHIBITORSIZE=(int)SIZE/70;
	final Hero[] heros;
    /**
     * Hier wird die Map erzeugt
     * @param heros
     */
	public Map_Gen(Hero[] heros)
		{this.heros=heros;}             //hier wird ein Array mit den Helden uebergeben(geordnet)
	
	  private void createmap(){		   
		    
			map=new Tile[SIZE+40][SIZE+40];
			for (int i=0;i<SIZE+40;i++){
				for (int j=0;j<SIZE+40;j++){

					//ganze Karte wird mit Gras gefuellt

					map[i][j]= new Tile(new SpaceHolder(i,j),new Grass(i,j),i,j);
					
				}}
			/* ab hier wird die Map gefuellt, Erklaerungen stehen an den einzelnen Methoden
			 * jede Erweiterung die ab hier folgt und vor der mirror Methode steht wird gespiegelt
			 */
			map=ground(map);
			map=mixforest(map);
     		map=conectlane(map);
     		map=wallbasis(map);
		    map=river(map);
		    map=laneleft(map,LANESIZE);
 			map=bottomlane(map,LANESIZE);
     	    map=middleLane(map);
		    map=startplatoon(map);
			map=borders(map);
			map=jungleup(map,(int)(SIZE*0.95)+20,(int)(SIZE*0.55)+20,(int)(SIZE*0.7)+20,(int)(SIZE*0.7)+20,4);
			map=jungleup(map,(int)(SIZE*0.92)+20, (int)(SIZE*0.25)+20,(int)(SIZE*0.55)+20,(int)(SIZE*0.55)+20,4);
			map=jungleup(map,(int)(SIZE*0.45)+20, LANESIZE+20,(int)(SIZE*0.2)+20,(int)(SIZE*0.2)+20,4);
			map=jungleup(map,(int)(SIZE*0.70)+20, LANESIZE+20,(int)(SIZE*0.35)+20,(int)(SIZE*0.35)+20,4);
			map=jungledown(map,(int)(SIZE*0.7)+20,(int)(SIZE*0.3)+20,(int)(SIZE*0.95)+20,(int)(SIZE*0.5)+20,4);
			map=jungledown(map,(int)(SIZE*0.6)+20, (int)(SIZE*0.4)+20,(int)(SIZE*0.95)+20,(int)(SIZE*0.7)+20,4);
			map=jungledown(map, (int)(SIZE*0.3)+20, LANESIZE+20,(int)(SIZE*0.55)+20,(int)(SIZE*0.45)+20,4);
			map=jungledown(map, (int)(SIZE*0.5)+20, LANESIZE+20,(int)(SIZE*0.7)+20,(int)(SIZE*0.3)+20,4);
			map=treecover(map);
			map=morewall(map);
			 // hier wird gespiegelt
			map=mirror(map);   
			 /* Gebaeude,Monster und Spieler die Teamabhaengig sind werden nicht gespiegelt
			  * Symmetrie wird trotzdem innerhalb der Methoden beruecksichtigt
			  */
			map=monsters1(map);
			map=riverwalls(map);
			map=nexus(map);
			map=shop(map);
			map=inhibitor(map);
			map=towersleftlane(map);
			map=towersbottomlane(map);
			map=towersmiddlelane(map);
			map=setsuperRiverMonster(map);
			// hier werden die Spieler gesetzt
			
			
			for(int i=0;i<heros.length;i++){				
				if (!(heros[i]==null)){					
					map=setPlayers(map,heros[i],i);
				}
			}	

	  }
	  /**
	   * Diese Methode setzt das Super Monster (Drache) im Fluss
	   * @author Flo
	   * @param map23
	   * @return
	   */
	  private Tile[][]setsuperRiverMonster(Tile[][]map23){
		  map23[50][50].setobject(new Superboss(ID_Generator.getID(),50,50));
		  map23[85][85].setobject(new Superboss(ID_Generator.getID(),85,85));
		  return map23;
	  }
	  /**
	   * Diese Methode setzt zufaellig Felsen in den Fluss
	   * @author Flo
	   * @param map22
	   * @return
	   */
	  private Tile[][]riverwalls(Tile[][]map22){
		    Random generator= new Random();
		    
		     for (int i=0;i<SIZE+40;i++){
		    	 for(int j=0;j<SIZE+40;j++){
		    		 if(map22[i][j].getground().getTYPE().equals(Groundtype.WATER)){
		    			 int number=generator.nextInt(12);
		    			 if(number==2){
		 
		    					map22[i][j].setobject(new Wall(i,j));
		    			 }
		    		 }
		    	 }
		     }
		  return map22;
	  }
	  /**
	   * Diese Methode ergaenzt die Mauer um die Basis der jeweiligen Teams
	   * @author Flo
	   * @param map21
	   * @return
	   */
	  private Tile[][] morewall(Tile[][]map21){
		  map21[94+20][19+20].setground(new Wallground(94+20,19+20));
			map21[94+20][19+20].setobject(new Wall(94+20,19+20));
		   map21[93+20][19+20].setground(new Wallground(93+20,19+20));
			map21[93+20][19+20].setobject(new Wall(93+20,19+20));
		   map21[92+20][19+20].setground(new Wallground(92+20,19+20));
		    map21[92+20][19+20].setobject(new Wall(92+20,19+20));
		   map21[92+20][19+20].setground(new Wallground(92+20,19+20));
			map21[92+20][19+20].setobject(new Wall(92+20,19+20));
		   map21[91+20][18+20].setground(new Wallground(91+20,18+20));
			map21[91+20][18+20].setobject(new Wall(91+20,18+20));
		   map21[92+20][18+20].setground(new Wallground(92+20,18+20));
			map21[92+20][18+20].setobject(new Wall(92+20,18+20));
	       map21[90+20][17+20].setground(new Wallground(90+20,17+20));
			map21[90+20][17+20].setobject(new Wall(90+20,17+20));
		   map21[83+20][12+20].setground(new Wallground(83+20,12+20));
			map21[83+20][12+20].setobject(new Wall(83+20,12+20));
		   map21[83+20][11+20].setground(new Wallground(83+20,11+20));
			map21[83+20][11+20].setobject(new Wall(83+20,11+20));
		   map21[81+20][6+20].setground(new Wallground(81+20,6+20));
			map21[81+20][6+20].setobject(new Wall(81+20,6+20));
		   map21[81+20][7+20].setground(new Wallground(81+20,7+20));
			map21[81+20][7+20].setobject(new Wall(81+20,7+20));
		   map21[81+20][8+20].setground(new Wallground(81+20,8+20));
			map21[81+20][8+20].setobject(new Wall(81+20,8+20));
		   map21[82+20][8+20].setground(new Wallground(82+20,8+20));
			map21[82+20][8+20].setobject(new Wall(82+20,8+20));
		   map21[83+20][10+20].setground(new Wallground(83+20,10+20));
			map21[83+20][10+20].setobject(new Wall(83+20,10+20));
		
		  return map21;
	  }
	  /**
	   * Diese Methode setzt die normalen Monster im Dschungel
	   * @author Flo
	   * @param map20
	   * @return
	   */
	  private Tile [][]monsters1(Tile[][]map20){
		  int xm1=35;
		  int ym1=35;
		  int xm2=85;        // Startpositionen fuer die Suche werden festgelegt
		  int ym2=38;        // von der aus nach links, rechts, oben und unten nach Wegen
		  int xm3=105;       // im Jungle gesucht wird
	      int ym3=25;
	      int xm4=95;
	      int ym4=95;
	      
	      /* Es wird innerhalb der While Schleifen solange nach rechts,links,oben und unten
	       * gegangen bis Groundtype Grass erreicht wird, wenn moeglich wird dann das Monster noch etwas
	       * weiter in den Weg reingesetzt(siehe if-Anweisung)
	       */
		  while (!map20[xm1][ym1].getground().getTYPE().equals(Groundtype.GRASS)){
			  xm1++;
			  }
		  if(map20[xm1+2][ym1].getground().getTYPE().equals(Groundtype.GRASS)){xm1=xm1+2;}
		  
		  while (!map20[xm2][ym2].getground().getTYPE().equals(Groundtype.GRASS)){
			  xm2--;
			  }
		  if(map20[xm2+2][ym2].getground().getTYPE().equals(Groundtype.GRASS)){xm2=xm2+2;}
		  
		  while (!map20[xm3][ym3].getground().getTYPE().equals(Groundtype.GRASS)){
			  ym3++;
			  }
		  if(map20[xm3][ym3+2].getground().getTYPE().equals(Groundtype.GRASS)){ym3=ym3+2;}
		  
		  while (!map20[xm4][ym4].getground().getTYPE().equals(Groundtype.GRASS)){
			  ym4--;
			  }
		  if(map20[xm4][ym4+2].getground().getTYPE().equals(Groundtype.GRASS)){ym4=ym4+2;}
		  
		  map20[xm1][ym1].setobject(new Sebamster(ID_Generator.getID(),xm1,ym1));   //Die Monstertypen werden dann auf die  
		  map20[xm2][ym2].setobject(new Joschifant(ID_Generator.getID(),xm2,ym2));  // gefundenen Positionen gesetzt
		  map20[xm3][ym3].setobject(new Sebamster(ID_Generator.getID(),xm3,ym3));
		  map20[xm4][ym4].setobject(new Joschifant(ID_Generator.getID(),xm4,ym4));
		 
		  map20[SIZE-1-xm1+40][SIZE-1-ym1+40].setobject(new Sebamster(ID_Generator.getID(),SIZE-1-xm1+40,SIZE-1-ym1+40)); //Spiegelung der Monster
		  map20[SIZE-1-xm2+40][SIZE-1-ym2+40].setobject(new Joschifant(ID_Generator.getID(),SIZE-1-xm2+40,SIZE-1-ym2+40));  // 
		  map20[SIZE-1-xm3+40][SIZE-1-ym3+40].setobject(new Sebamster(ID_Generator.getID(),SIZE-1-xm3+40,SIZE-1-ym3+40));
		  map20[SIZE-1-xm4+40][SIZE-1-ym4+40].setobject(new Joschifant(ID_Generator.getID(),SIZE-1-xm4+40,SIZE-1-ym4+40));
		  return map20;
	  }
	  
	  /**
	   * Diese Methode setzt die Tuerme auf der MiddleLane
	   * @author Flo
	   * @param map19
	   * @return
	   */
	  private Tile [][]towersmiddlelane(Tile[][]map19){
		  int xchange;
		  int ychange;
		  int sortx;
		  int sorty;
		  int scalex;
		  int scaley;
		  for(int i=0;i<3;i++){
			  
		  Random generator= new Random();
		     xchange=generator.nextInt(3);  //generiert die Auslenkung in x-Richtung
		     ychange=generator.nextInt(3);  //generiert die Auslenkung in y-Richtung
		     sortx=generator.nextInt(2);    //generiert das Vorzeichen in x Richtung (nach links oder nach rechts)
		     sorty=generator.nextInt(2);    //generiert das Vorzeichen in y-Richtung (nach oben oder nach unten
		     
		     if (sortx==0)scalex=-1;else scalex=1; //Vorzeichen werden ausgewertet
		     if(sorty==0)scaley=-1;else scaley=1;
		     
		     /*Die Tuerme haben einen Optimalen taktischen Standpunkt (zentriert auf den Wegen)
		      * von dieser Position wird nun in dem generierten Radius jeder Turm gesetzt(Jeder Turm hat eigene
		      * Zufallszahlen)
		      * Zudem wird die festgelegte Position eines Turms fuer beide Teams symmetrisch gesetzt
		      */
		     
		     map19[(int)(SIZE*0.8)-i*(int)(0.13*SIZE)+ychange*scaley+20][(int)(SIZE*0.16)+i*(int)(0.13*SIZE)+xchange*scalex+20].setobject(new Tower(ID_Generator.getID(),(int)(SIZE*0.8)-i*(int)(0.13*SIZE)+ychange*scaley+20,(int)(SIZE*0.16)+i*(int)(0.13*SIZE)+xchange*scalex+20,Team.RED));
		     map19[SIZE-1-((int)(SIZE*0.82)-i*(int)(0.13*SIZE)+ychange*scaley)+20][SIZE-1-((int)(SIZE*0.2)+i*(int)(0.13*SIZE)+xchange*scalex)+20].setobject(new Tower(ID_Generator.getID(),SIZE-1-((int)(SIZE*0.82)-i*(int)(0.13*SIZE)+ychange*scaley)+20,SIZE-1-((int)(SIZE*0.2)+i*(int)(0.13*SIZE)+xchange*scalex)+20,Team.BLUE));
		     }
		     /*
		      * Hier werden noch jeweils zwei Tuerme pro Team (fest) vor die Nexi gesetzt
		      */
		     map19[SIZE-1-93+20][SIZE-1-11+20].setobject(new Tower(ID_Generator.getID(),SIZE-1-93+20,SIZE-1-11+20,Team.BLUE)); 
		     map19[SIZE-1-88+20][SIZE-1-5+20].setobject(new Tower(ID_Generator.getID(),SIZE-1-88+20,SIZE-1-5+20,Team.BLUE));
		     
		     map19[93+20][11+20].setobject(new Tower(ID_Generator.getID(),93+20,11+20,Team.RED));
		     map19[88+20][5+20].setobject(new Tower(ID_Generator.getID(),88+20,5+20,Team.RED));
			
		  
		  return map19;
	  }
	  /**
	   * Diese Methode setzt die Tuerme auf den horizontalen Lane's
	   * @author Flo
	   * @param map18
	   * @return
	   */
	  private Tile [][]towersbottomlane(Tile[][]map18){
		  int xchange;
		  int ychange;
		  int sortx;
		  int sorty;
		  int scalex;
		  int scaley;
		  for(int i=0;i<3;i++){
		  Random generator= new Random();
		     xchange=generator.nextInt(3);
		     ychange=generator.nextInt(3);
		     sortx=generator.nextInt(2);
		     sorty=generator.nextInt(2);
		     
		     if (sortx==0)scalex=-1;else scalex=1;
		     if(sorty==0)scaley=-1;else scaley=1;
		     map18[(SIZE-1-((int)(LANESIZE/2)+3))+ychange*scaley+20][((int)(SIZE*0.25+i*(int)(0.3*SIZE)))+xchange*scalex+20].setobject(new Tower(ID_Generator.getID(),(SIZE-1-((int)(LANESIZE/2)+3))+ychange*scaley+20,((int)(SIZE*0.25+i*(int)(0.3*SIZE)))+xchange*scalex+20,Team.RED));//Tower Red setzen
		     map18[(((int)(LANESIZE/2)+3))+ychange*scaley+20][SIZE-1-(((int)(SIZE*0.25+i*(int)(0.3*SIZE)))+xchange*scalex)+20].setobject(new Tower(ID_Generator.getID(),(((int)(LANESIZE/2)+3))+ychange*scaley+20,SIZE-1-(((int)(SIZE*0.25+i*(int)(0.3*SIZE)))+xchange*scalex)+20,Team.BLUE));//Tower Blue setzen
		  }
		  return map18;
	  }
	  /**
	   * Diese Methode setzt die Tuerme auf den vertikalen Lane's
	   * @author Flo
	   * @param map17
	   * @return
	   */
	  private Tile [][]towersleftlane(Tile[][]map17){
		  int xchange;
		  int ychange;
		  int sortx;
		  int sorty;
		  int scalex;
		  int scaley;
		  for(int i=0;i<3;i++){
		  Random generator= new Random();
		     xchange=generator.nextInt(3);
		     ychange=generator.nextInt(3);
		     sortx=generator.nextInt(2);
		     sorty=generator.nextInt(2);
		     
		     if (sortx==0)scalex=-1;else scalex=1;
		     if(sorty==0)scaley=-1;else scaley=1;
		    
		     map17[((int)(SIZE*0.75)-i*(int)(0.3*SIZE))+ychange*scaley+20][(int)(LANESIZE/2+2)+xchange*scalex+20].setobject(new Tower(ID_Generator.getID(),((int)(SIZE*0.75)-i*(int)(0.3*SIZE))+ychange*scaley+20,(int)(LANESIZE/2+2)+xchange*scalex+20,Team.RED)); //Tower Red setzen
		     map17[(SIZE-1-((int)(SIZE*0.75)-i*(int)(0.3*SIZE)))+ychange*scaley+20][SIZE-1-((int)(LANESIZE/2+2)+xchange*scalex)+20].setobject(new Tower(ID_Generator.getID(),(SIZE-1-((int)(SIZE*0.75)-i*(int)(0.3*SIZE)))+ychange*scaley+20,SIZE-1-((int)(LANESIZE/2+2)+xchange*scalex)+20,Team.BLUE));//Tower Blue setzen
		     
		  }
		  return map17;
	  }
	  /**
	   * Diese Methode generiert einen zufaelligen Mischwald
	   * @author Flo
	   * @param map16
	   * @return
	   */
	  private Tile[][]mixforest(Tile[][]map16){
		  int zahl=0;
		  for (int i=0;i<SIZE+40;i++){
			   for(int j=0;j<SIZE+40;j++){
				   if(map16[i][j].getobject() instanceof Tree){
					   Random generator= new Random();
					     zahl=generator.nextInt(2); //Generator erzeugt 0 und 1 
					    
					     if(zahl==0) map16[i][j].setobject(new Tree2(i,j)); //Setze Baumtyp1
					     if(zahl==1) map16[i][j].setobject(new Tree(i,j)); //Setze Baumtyp2
				   }
			      }
			     
			   }
		  return map16;
	  }
	  /**
	   * Diese Methode umrahmt das Spielfeld mit einer Mauer
	   * @author Flo
	   * @param map15
	   * @return
	   */
	  private Tile [][]borders (Tile[][]map15){
		  for (int i=20;i<SIZE+40;i++){
			  for (int j=0;j<6;j++){
			  map15[i][20-j].setground(new Wallground(i,20-j));
			  map15[i][20-j].setobject(new Wall(i,20-j));
			  }
			 }
		  
		  for (int i=20;i<SIZE+40;i++){
			  for (int j=0;j<6;j++){
			  map15[20+SIZE-1+j][i].setground(new Wallground(20+SIZE-1+j,i));
			  map15[20+SIZE-1+j][i].setobject(new Wall(20+SIZE-1+j,i));
			  }
		  }
			  
		  return map15;
	  }
	  /**
	   * Diese Methode aendert den Bodentyp der Baeume, damit sie auf der Minimap sichtbar sind
	   * @author Flo
	   * @param map14
	   * @return
	   */
	  private Tile[][]treecover(Tile[][]map14){
		   for (int i=20;i<SIZE+20;i++){
			   for(int j=20;j<SIZE+20;j++){
				   if (map14[i][j].getobject() instanceof Nature&&!(map14[i][j].getobject() instanceof Wall)){
					   map14[i][j].setground(new Junglepath(i,j)); // Jungleboden setzen
					  
				   }
			   }
		   }
		   return map14;
	   }
	  
	  /**
	   * Diese Methode setzt die Mauer um die Basis (kreisfoermig)
	   * @author Flo
	   * @param map13
	   * @return
	   */
	  private Tile[][] wallbasis(Tile[][] map13){
			for (int i=SIZE-BASISSIZE+20;i<SIZE+20;i++){
				for (int j=20;j<=BASISSIZE+20;j++){
					if (circle2(SIZE+20,20,BASISSIZE,i,j)) {
						map13[i][j].setground(new Wallground(i,j)); //Mauer Boden wird gesetzt
						map13[i][j].setobject(new Wall(i,j)); // Objekttyp Mauer setzen
					}
				}
			}
			return map13;
		}
	  
	  /**
	   * Diese Methode generiert die Dschungelwege die nach oben verlaufen
	   * @author Flo
	   * @param map12
	   * @param startX
	   * @param startY
	   * @param finishX
	   * @param finishY
	   * @param junglelanesize
	   * @return
	   */
	  private Tile[][]jungleup(Tile[][]map12,int startX,int startY,int finishX,int finishY,int junglelanesize){ 
			int zahl;
			int i=startX;  
			int j=startY;
		   //Solange der Endpunkt nicht erreicht ist
			while(!found(i,j,finishX,finishY)){
		      Random generator= new Random();
		     zahl=generator.nextInt(2); //genriert 0 und 1 
		   
		     // Wenn 0 dann gehe nach rechts
			 if (zahl==0){
				 //hier wird ueberpruft ob die X Richtung nicht ueberschritten ist
				 if(i>finishX){
					 // hier wird der Weg fuer jede neue Position verbreitert
	                 for (int x=j;x<j+junglelanesize;x++){
				         map12[i][x].setobject(new SpaceHolder(i,x)); //Objekttyp leer
				         map12[x][j].setobject(new SpaceHolder(x,j));} //an diesen Positionen werden die Baeume geloescht
					 i--;
					
				  }
				 }
			 // Wenn 1 dann gehe nach oben
			 if(zahl==1){
				  //hier wird ueberpruft ob die Y Richtung nicht ueberschritten ist
				   if(j<finishY){
					   //hier wird der Weg fuer jede neue Position vebreitert
					 for (int x=i;x<i+junglelanesize;x++){
				         map12[x][j].setobject(new SpaceHolder(x,j));//Objekttyp leer
				         map12[i][x].setobject(new SpaceHolder(i,x));}
					 j++;
				
				 }
			   }
			}
			  return map12;
			  
			  
		  }
	  
	  /**
	   * Diese Methode generiert die Dschungel Wege die nach unten verlaufen
	   * @author Flo
	   * @param map11
	   * @param startX
	   * @param startY
	   * @param finishX
	   * @param finishY
	   * @param junglelanesize
	   * @return
	   */
	  private Tile[][]jungledown(Tile[][]map11,int startX,int startY,int finishX,int finishY,int junglelanesize){ 
		int zahl;
		int i=startX;
		int j=startY;
		
		while(!found(i,j,finishX,finishY)){
	      Random generator= new Random();
	     zahl=generator.nextInt(2);
	   
		 if (zahl==0){
		   
			 if(i<finishX){
                 for (int x=j;x<j+junglelanesize;x++){
			         map11[i][x].setobject(new SpaceHolder(i,x));//Objekttyp leer
			         map11[x][j].setobject(new SpaceHolder(x,j));}
				 i++;
			  }
			 }
		 
		 if(zahl==1){
			
			   if(j<finishY){
				 for (int x=i;x<i+junglelanesize;x++){
			         map11[x][j].setobject(new SpaceHolder(x,j)); //Objekttyp leer
			         map11[i][x].setobject(new SpaceHolder(i,x));}
				 j++;   
			 }
		   }
		}
		  return map11;
		  
		  
	  }
	  /**
	   * Diese Methode ueberprueft ob der jeweilige Endpunkt gefunden ist
	   * @author Flo
	   * @param x1
	   * @param y1
	   * @param x2
	   * @param y2
	   * @return
	   */
	  private boolean found(int x1,int y1,int x2,int y2){
		   if(x1==x2&&y1==y2)return true;
		   else return false;
	   }
	  
	  /**
	   * Diese Methode setzt die Inhibitoren der jeweiligen Teams
	   * @author Flo
	   * @param map10
	   * @return
	   */
	  private Tile[][] inhibitor(Tile[][] map10){
		  /*hier werden die eigentlichen Standpunkte der Inihibitoren gesetzt,die
			 * z.B. fuer Angriff wichtig sind(sie werden im Shared Ordner geteilt)
			 */
			 map10[(int)(SIZE*0.88)+20][(int) (SIZE*0.11)+20].setground(new Stone((int)(SIZE*0.88)+20,(int) (SIZE*0.11)+20));
			 map10[(int)(SIZE*0.88)+20][(int) (SIZE*0.11)+20].setobject(new Inhibitor(ID_Generator.getID(),(int)(SIZE*0.88)+20,(int) (SIZE*0.11)+20,Team.RED));//Nexus Rot
			 map10[(int) (SIZE*0.11)+20][(int)(SIZE*0.88)+20].setground(new Stone((int) (SIZE*0.11)+20,(int)(SIZE*0.88)+20));
			 map10[(int) (SIZE*0.11)+20][(int)(SIZE*0.88)+20].setobject(new Inhibitor(ID_Generator.getID(),(int) (SIZE*0.11)+20,(int)(SIZE*0.88)+20,Team.BLUE)); //Nexus Blau
				for(int i=0;i<2;i++){
					for(int j=0;j<2;j++){
						/* hier werden die Faelder blockiert die von dem Bild besetzt sind 
						 * damit man nicht in das Bild laufen kann
						 */
//						 map10[(int)(SIZE*0.87+i)+20][(int) (SIZE*0.12-j)+20].setground(new Stone((int)(SIZE*0.87+i)+20,(int) (SIZE*0.12-j)+20));//Stein setzen
						 
					
						 if(i!=0&&j!=0)
							 if(!(map10[(int)(SIZE*0.87+i)+20][(int) (SIZE*0.12-j)+20].getobject() instanceof Inhibitor))
						 	{map10[(int)(SIZE*0.87+i)+20][(int) (SIZE*0.12-j)+20].setobject(new SpaceHolderforBuilding((int)(SIZE*0.87+i)+20,(int)(SIZE*0.12-j)+20,(Building)(map10[(int)(SIZE*0.88)+20][(int) (SIZE*0.11)+20].getobject())));// Objekttyp leer
						 	}
						 }
					}		
					
					

				
			return map10;
		}
	  
	  /**
	   * Diese Methode verbindet die drei Hauptlanes (kreisfoermig)
	   * @author Flo
	   * @param map7
	   * @return
	   */
	  private Tile[][] conectlane(Tile[][] map7){
			for (int i=(int)(SIZE-BASISSIZE*1.4)+20;i<SIZE+20;i++){
				for (int j=20;j<=BASISSIZE*1.4+20;j++){
					//hier findet die Kreisabfrage statt
					if (circle1(SIZE+20,20,1.25*BASISSIZE,i,j)) {
						map7[i][j].setground(new Sand(i,j)); //Sand wird gesetzt
						map7[i][j].setobject(new SpaceHolder(i,j));//Objekttyp leer
					}
				}
			}
			return map7;
		}
	
	 /**
	  * Diese Methode ueberrueft die Zeichenvorschrift der MiddleLane
	  * @author Flo
	  * @param x1
	  * @param y1
	  * @return
	  */
	  private boolean middlelanecontrol(int x1,int y1){
		  if(x1+y1>=SIZE+40-(int)LANESIZE&&x1+y1<=SIZE+40+(int)LANESIZE)return true;
		  return false;
	  }
	  /**
	   * Diese Methode zeichnet die MiddleLane
	   * @author Flo
	   * @param map6
	   * @return
	   */
	  private Tile[][]middleLane(Tile[][] map6){
		
		  for (int i=SIZE-1+20;i>20;i--){
			  for (int j=1+20;j<SIZE-1+20;j++){
				  //Wenn middlelanecontrol==true und groundtype nicht Stein ist wird der Weg gesetzt
				  if (middlelanecontrol(i,j)&&!(map6[i][j].getground().getTYPE().equals(Groundtype.STONE))){
					  map6[i][j-1].setground(new Sand(i,j-1)); //Sand wird gesetzt
					  map6[i][j-1].setobject(new SpaceHolder(i,j-1));//Objekt leer 
					  
				  }
			  }
		  }
		  return map6;
	  }
	  
	/**
	 * Diese Methode zeichnet die vertikalen Wege
	 * @author Flo
	 * @param map4
	 * @param wegbreite
	 * @return
	 */
	  private Tile[][]laneleft(Tile [][]map4,int wegbreite){
		  for (int i=20;i<SIZE+20;i++){
			  for (int j=20;j<wegbreite+4+20;j++){
					
					  map4[i][j].setground(new Sand(i,j)); //Sand wird gesetzt
					 map4[i][j].setobject(new SpaceHolder(i,j));//Objekttyp leer
					
					 }
				  }
		  return map4;
		  }
	 /**
	  * Diese Methode zeichnet die horizontalen Wege
	  * @author Flo
	  * @param map5
	  * @param wegbreite
	  * @return
	  */
	  private Tile[][]bottomlane(Tile[][] map5,int wegbreite){
		  for (int i=20+SIZE-wegbreite-4;i<SIZE+20;i++){
			  for (int j=20;j<SIZE+20;j++){
					 
				      map5[i][j].setground(new Sand(i,j)); //Sand wird gesetzt
					  map5[i][j].setobject(new SpaceHolder(i,j));//Objekttyp leer
					
					 }
				  }
			  
		  return map5;
		  }
		
	/**
	 * Diese Methode ueberprueft die Zeichenvorschrift des Flusses
	 * @author Flo
	 * @param x1
	 * @param y1
	 * @param breite
	 * @return
	 */
	  private boolean rivercontrol(int x1,int y1,int breite){
		  // die Abrage geschieht ueber den absolut Betrag der Differenz der x und y Koordinaten der Kachel
		  if(Math.abs(x1-y1)<=breite){
			  return true;}
		  
			  return false;
	  }
	  /**
	   * Diese Methode setzt den Fluss
	   * @author Flo
	   * @param map3
	   * @return
	   */
	  private Tile[][]river(Tile[][] map3){
		  for (int i=20;i<SIZE+20;i++){
			  for (int j=20;j<SIZE+20;j++){
				  if(rivercontrol(i,j,RIVERSIZE)){
					  map3[i][j].setground(new Water(i,j)); //Wasser wird gesetzt
					  map3[i][j].setobject(new SpaceHolder(i,j));// Objekttyp leer 
					 
				  }
			  }
		  }
		  return map3;
	  }
	 /**
	  * Diese Methode setzt auf der ganzen Map Baeume
	  * @author Flo
	  * @param map1
	  * @return
	  */
	  private Tile [][] ground(Tile[][] map1){
			for (int i=0;i<SIZE+40;i++){
				for(int j=0;j<SIZE+40;j++){
					map1[i][j].setground(new Grass(i,j));// Grass wird gesetzt
					map1[i][j].setobject(new Tree(i,j));//Objekttyp Baum 
				}
			}
			return map1;
		}
	 /**
	  * Diese Methode ueberprueft ob Kacheln innerhalb eines Kreises liegen 
	  * @author Flo
	  * @param x1
	  * @param y1
	  * @param radius
	  * @param x2
	  * @param y2
	  * @return
	  */
	  private boolean circle1 (double x1, double y1,double radius,double x2,double y2){
			
			if (Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2))<=radius){
				return true;
			}
			return false;
		}
	  
	  /**
	   * Diese Methode ueberprueft ob Kacheln auf einer Kreislinie liegen
	   * @author Flo
	   * @param x1
	   * @param y1
	   * @param radius
	   * @param x2
	   * @param y2
	   * @return
	   */
	  private boolean circle2 (double x1, double y1,double radius,double x2,double y2){
		
		if ((int)(Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2)))==radius){
			return true;
		}
		return false;
	}
		/**
		 * Diese Methode setzt die Basisareale (viertel Kreisfoermig)
		 * @author Flo
		 * @param map1
		 * @return
		 */
	  private Tile[][] startplatoon(Tile[][] map1){
			for (int i=0;i<SIZE+40;i++){
				for (int j=0;j<SIZE+40;j++){
					//hier findet die Kreisabfrage statt
					if (circle1(SIZE+20,20,BASISSIZE,i,j)) {
						map1[i][j].setground(new Stone(i,j));
						map1[i][j].setobject(new SpaceHolder(i,j));
					}
				}
			}
			return map1;
		}
		
	  /**
	   * Diese Methode spiegelt die Map an dem Mittelpunkt der Map
	   * @author Flo
	   * @param map2
	   * @return
	   */
	  private Tile[][]mirror (Tile[][] map2){
			for (int i=0;i<SIZE+20;i++){
				for (int j=0;j<i;j++){
					
					Tile newTile = new Tile(map2[i+20][j+20].getobject(),map2[i+20][j+20].getground(),20+SIZE-1-i,20+SIZE-1-j);		
					map2[20+SIZE-1-i][20+SIZE-1-j]=newTile;
					
				}
			}
			return map2;
		}
			

	
		
		/**
		 * Diese Methode setzt den Shop der jeweiligen Teams
		 * @author Flo
		 * @param map9
		 * @return
		 */
	  private Tile[][]shop(Tile[][] map9){
		  
		  map9[96+20][2+20].setobject(new Shop(ID_Generator.getID(),96+20,2+20,Team.RED));
		  map9[2+20][97+20].setobject(new Shop(ID_Generator.getID(),2+20,97+20,Team.BLUE));
		  return map9;
	  }
	  /**
	   * Diese Methode setz die Nexi der jeweiligen Teams
	   * @author Flo
	   * @param map8
	   * @return
	   */
	  private Tile[][] nexus(Tile[][] map8){
		//hier werden die eigentlichen Standpunkte der Nexi gesetzt die wieder im Shared Ordner geteilt werden
		  map8[(int)(SIZE*0.92)+20][(int) (SIZE*0.06)+20].setobject(new Nexus(ID_Generator.getID(),(int)(SIZE*0.92)+20,(int) (SIZE*0.06)+20, Team.RED));
	       map8[(int) (SIZE*0.06)+20][(int)(SIZE*0.92)+20].setobject(new Nexus(ID_Generator.getID(),(int) (SIZE*0.06)+20, (int)(SIZE*0.92)+20, Team.BLUE));
		  for (int i=0;i<4;i++){
				for (int j=0;j<3;j++){
					
						// hier werden die Kacheln blockiert, die vom Bild eingenommen sind
						map8[(int)(SIZE*0.92)+i+20][(int) (SIZE*0.08)-j+20].setground(new Stone((int)(SIZE*0.92)+i+20,(int) (SIZE*0.08)-j+20));
						
						
						map8[(int) (SIZE*0.09)-i+20][(int)(SIZE*0.92)+j+20].setground(new Stone((int) (SIZE*0.09)-i+20,(int)(SIZE*0.92)+j+20));
						
						
						if(i!=0&&j!=0)
							{map8[(int)(SIZE*0.92)+i+20][(int) (SIZE*0.08)-j+20].setobject(new SpaceHolderforBuilding((int)(SIZE*0.92)+i+20,(int) (SIZE*0.08)-j+20, (Building)map8[(int)(SIZE*0.92)+20][(int) (SIZE*0.06)+20].getobject()));
							map8[(int) (SIZE*0.09)-i+20][(int)(SIZE*0.92)+j+20].setobject(new SpaceHolderforBuilding((int) (SIZE*0.09)-i+20,(int)(SIZE*0.92)+j+20, (Building)map8[(int) (SIZE*0.06)+20][(int)(SIZE*0.92)+20].getobject()));}
					}
				}
			  
		       
			 
			return map8;
			}
	  
	  /**
	   * Hier werden die Inhibitor Positionen zurueck gegeben
	   * @author Flo
	   * @param team
	   * @return
	   */
	public int[]getInhibitorPosition(InteraktiveEntity.Team team){
		int[]position=new int[2];
		if (team.equals(InteraktiveEntity.Team.RED)){
			position[0]=(int)(SIZE*0.88)+20;  // x-Koordinate
		    position[1]=(int) (SIZE*0.11)+20;  //y-Koordinate
			return position;
		}
		else{
			position[0]=(int) (SIZE*0.11)+20;  // x-Koordinate
		    position[1]=(int)(SIZE*0.88)+20;  //y-Koordinate
			return position;
		}
	 }
				
	/**
	 * Hier werden die Nexi Positionen zurueck gegeben
	 * @author Flo
	 * @param team
	 * @return
	 */
	public int[] getNexusPosition(InteraktiveEntity.Team team) {
			int[]position=new int[2];
			if(team.equals(InteraktiveEntity.Team.RED)){
				position[0]= (int)(size*0.92+20);
				position[1]=(int) (size*0.06+20);
				return position;
				
			}
			else{
				
					position[0]= (int) (size*0.06+20);
					position[1]=(int)(size*0.92+20);
					return position;
			}
			
		}  
	  

	
	/**
	 * Uebergabe der Map
	 * @author Flo
	 * @return
	 */
	public Tile[][] get_map() {
		// TODO Auto-generated method stub
		this.createmap();
		return map;
	}

	

	

	
	

	}


