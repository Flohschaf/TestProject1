package pp2013.gruppe07.shared;
//import java.awt.Graphics;
//
//import javax.swing.JComponent;
//
//import Entity.Entity;
//
//import Ground.Ground;
///**
// * 
// * @author Felix
// *
// */
//public class Tile {
//	
//	Entity entity;
//	Ground ground;
//	
//	private int x;
//	private int y;
//	boolean blocked;
//
//	
//	public Tile(Entity entity,Ground ground,int x, int y,boolean blocked){
//		this.entity = entity;
//		this.ground = ground;
//		this.x=x;
//		this.y=y;
//		this.blocked=blocked;
//	}
//	
//	public void paint(Graphics g , JComponent jp , int[]position){
//		ground.paint(g, jp, position);
//		entity.paint(g, jp, position);
//		
//	}
//	
//	public int get_x()
//		{return x;}
//	
//	public int get_y()
//		{return y;}
//	
//	public boolean isBlocked()
//		{//Soll ueberpruefen, ob ein festes, unbewegliches und unbegehbares Objekt auf der Kachel ist.
//		return blocked;}
//	
//	public boolean isCurrentlyBlocked()
//		{//Soll ueberpruefen, ob sich ein bewegliches Objekt auf der Kachel befindet.
//		return false;}
//	
//	
//	
//}

import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JComponent;

import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Nature;
import pp2013.gruppe07.shared.entity.SpaceHolderforBuilding;
import pp2013.gruppe07.shared.ground.Ground;


/**
 * Eine Kachel aus der die Map gebaut wird.
 * @author Felix,Sven,Daniel
 *
 */
public class Tile  implements Serializable{
	
	Entity entity;
	Ground ground;
	int X;
	int Y;

	
	public Tile(Entity entity,Ground ground, int x, int y){
		this.entity = entity;
		this.ground = ground;
		this.X=x;
		this.Y=y;		
	}	
	
	
	public int get_x()
		{return X;}
	
	public int get_y()
		{return Y;}
	
	
	/**Gibt an, ob ein UNBEWEGLICHES Objekt den Weg versperrt. Beispielsweise ein Gebaeude, ein Baum
	 * oder ein unbegehbarer Bodentyp. Bewegliche Ziele werden bewusst nicht beachtet.
	 * @author Sven
	 * @return
	 */
	public boolean isBlocked()
		{boolean isblocked=false;
		if(entity instanceof SpaceHolderforBuilding||entity instanceof Building||entity instanceof Nature)
			{isblocked=true;}
		return isblocked;
		}
	
	
	/**Gibt an ob ein BEWEGLICHES Objekt, also eine Figur den Weg versperrt. Unbewegliche Ziele
	 * werden bewusst nicht beachtet
	 * @author Sven
	 * @return
	 */
	public boolean isCurrentlyBlocked()
		{return entity instanceof Figure;}
	
	public Ground getground(){
		return ground;
		
	}

	public Entity getobject() {
		// TODO Auto-generated method stub
		return entity;
	}
public void setground(Ground underground){
		
		this.ground=underground;
		
	}

	public void setobject(Entity object) {
		// TODO Auto-generated method stub
		this.entity = object;
		
	}
}
