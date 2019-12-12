package pp2013.gruppe07.shared.entity;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.Timer;

import pp2013.gruppe07.shared.Tile;

/**Enthaelt eine abstrakte Oberklasse fuer alle Figuren
 * @author daniel,Sven
 * 
 */
public abstract class Figure extends InteraktiveEntity {

	String fightart;
	
	
	/**Ist 1, wenn die Figur ein Nahkaempfer ist und enthaelt sonst die Reichweite der Fernwaffe
	 * @author Sven
	 */
	protected final int ATTACKRANGE;
	
	Timer timer;
	Timer timer2;
	int time=0;
	int time2=0;
	int deathtime=10000;
	int attacktime=1;
	int attacktimeactivated=100;		
	
	
	
	int target[]=new int[2];
	
	
	
	/**
	 * @Daniel: Direction 1 fuer links und 2 rechts 
	 */
	int Direction=2;
	/**
	 * @Daniel: AttackDirection 1 fuer links und 2 rechts 3 oben 4 unten
	 */
	int AttackDirection=2;


	private int aktivatedtime=100;
	
	/**
	 * @param id
	 * @param x
	 * @param y
	 * @param visibiliytRange
	 * @param team
	 * @param attackRange
	 * @param giveXP
	 * @author Sven,Daniel
	 */
	public Figure(UUID id ,int x, int y, int visibiliytRange, Team team,int attackRange,int giveXP) {
		super(id, x, y, visibiliytRange, team,giveXP);
		this.ATTACKRANGE=attackRange;
		

		timer2=new Timer(500,new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			time2++;
			
		}});

	}




	/**
	 * @return
	 * @author Sven
	 */
	public int getATTACKRANGE() {
		return ATTACKRANGE;
	}

	/**
	 * @author Sven
	 */
	public enum direction{
		left,right,up,down
	}

	/**
	 * @return
	 * @author Sven
	 */
	public int getdirection(){
		return Direction;
	}
	/**
	 * @return
	 * @author Sven
	 */
	public String getfightart(){
		return fightart;
	}
	/**
	 * @param direc
	 * @author Sven
	 */
	public void setdirection(int direc){
		 Direction=direc;
	}
	/**
	 * @return
	 * @author Sven
	 */
	public int getAttackdirection(){
		return AttackDirection;
		
	}
	/**
	 * @param direc
	 * @author Daniel
	 * setzt die richtung der attacke
	 */
	public void setAttackdirection(int direc){
//		stoptimer();
		AttackDirection=direc;
//		sarttimer();
	}
	/**
	 * @param attack
	 * @author Daniel
	 * setzt die true wenn attackiert wird
	 */
	public void setattack(boolean attack){
//		if(attack==false)stoptimer();
		this.attack=attack;
//		if(attack==true)sarttimer();
	}
	
	/**
	 * @author Sven
	 * @param destTile
	 * Diese Methode repraesentiert das Gehen EINES Schrittes der Figur.
	 */
	public void move(Tile destTile) {
		super.setPosition(destTile.get_x(), destTile.get_y());
	}
	

	/**
	 * @return
	 * @author Daniel
	 * man bekommt koordinate des angegriffen ziels
	 */
	public int[] gettarget(){
		return target;
	}
	/**
	 * @author Daniel
	 * zaehlt
	 */
	public void count(){
		time++;
	}
	/**
	 * @author Daniel
	 * resetet zeit
	 */
	public void resettime(){
		time=0;
	}
	/**
	 * @param newtime
	 * @author Daniel
	 * setzt zeit
	 */
	public void settime(int newtime){
		time=newtime;
	}
	/**
	 * @param newtime
	 * @author Daniel
	 * setzt zeit zu der angriff startet
	 */
	public void settimeaktivated(int newtime){
		aktivatedtime=newtime;
	}
	/**
	 * @return
	 * @author Daniel
	 * gibt zeit wann aktiviert
	 */
	public int gettimeaktivated(){
		return aktivatedtime;
	}
	
	/**
	 * @author Daniel
	 * stoppt timer
	 */
	public void stoptimer(){
		timer.stop();
		time=0;
		setattack(false);
//		System.out.println("timerstoppt");

	}
	/**
	 * @author Daniel
	 * startet timer
	 */
	public void sarttimer(){
		if(!timer.isRunning())
		timer.start();
//		System.out.println("timerstartet");
	}
	/**
	 * @return
	 * @author Daniel
	 */
	public int gettime(){
		return time;
	}
	

	/**
	 * @param target
	 * @author Daniel
	 * setzt ziel
	 */
	public void settarget(int[] target){
		this.target=target;
		
	}
}
