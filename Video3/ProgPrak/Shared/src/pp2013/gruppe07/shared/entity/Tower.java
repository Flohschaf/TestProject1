package pp2013.gruppe07.shared.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JComponent;
import javax.swing.Timer;


/**
 * 
 * @author daniel
 *  Hier ist noch der erste Towerhit entwurf zu finden.
 *
 */
public class Tower   extends Building implements ActionListener {
	Timer timer;
	int time=0;


	boolean attack=false;
	int target[]={10,0};

	
	public Tower(UUID id,int x , int y,Team team){
		super(id,x,y,5,team,Type.TOWER,75);
		timer=new Timer(1,(ActionListener) this);
		
		
//		IMAGE = Toolkit.getDefaultToolkit().getImage( "Images/Turmblue.png" );
//		IMAGE2= Toolkit.getDefaultToolkit().getImage( "Images/Turmred.png" );
//		IMAGE3= Toolkit.getDefaultToolkit().getImage( "Images/Towerhit.png" );
		
		
		default_values[0]=150;
		default_values[1]=15;
		default_values[3]=1000;
		default_values[6]=3500;
		default_values[7]=150;
		akt_life=default_values[6];
		
		position_values[0]=0;
		position_values[1]=0;
		position_values[2]=0;
		position_values[3]=0;
		position_values[4]=0;
		position_values[5]=0;
		position_values[6]=0;
		position_values[7]=0;
		position_values[8]=0;
		position_values[9]=0;
		position_values[10]=0;
		position_values[11]=0;
		position_values[12]=0;
		position_values[13]=0;
		position_values[14]=0;
		position_values[15]=0;
		position_values[16]=0;
		position_values[17]=0;
		position_values[18]=0;
		position_values[19]=0;
		position_values[20]=0;
		position_values[21]=0;
		position_values[22]=0;
		position_values[23]=0;
	}

	
//	@Override
//	public void paint(Graphics g, JComponent jComp, int[] position) {
////		if(TEAM.equals("blue"))
//		g.setColor(Color.black);
//		g.fillRect(position[0], position[1], 103, 6);
//		g.setColor(Color.green);		
//		g.fillRect(position[0]+1, position[1]+1,(akt_life*101/default_values[6]), 4);
//		if(TEAM.equals(Team.BLUE))
//			g.drawImage(IMAGE,position[0],position[1],jComp);
//			if(TEAM.equals(Team.RED))
//				g.drawImage(IMAGE2,position[0],position[1],jComp);
//			
//		if(getattack()){
//			
//			timer.start();
//			double increase;
//
//			if((gettarget()[0]-getPosition()[0])!=0){increase=(gettarget()[1]-getPosition()[1])/(gettarget()[0]-getPosition()[0]);
//
//			System.out.println("hiiiiier"+increase);
//					if((gettarget()[0]-position[0])<0){
//							g.drawImage(IMAGE3,(int)(position[0]-time*(15-increase)),(int)(position[1]-time*(15-increase)*increase),jComp);
//					}					
//					else
//						g.drawImage(IMAGE3,(int)(position[0]+time*(15-increase)),(int)(position[1]+time*(15-increase)*increase),jComp);
//			}
//			else
//				if(gettarget()[1]-getPosition()[1]<=0)	
//					g.drawImage(IMAGE3,getPosition()[0],position[1]-time*15,jComp);
//				else	
//				g.drawImage(IMAGE3,getPosition()[0],position[1]+time*15,jComp);
//			
//				
//				System.out.println(target[0]+"sksksksks"+target[1]);
//			if(time>=15)time=0;//hier muss eig abgefragt werden ob das ziel getroffen wurde
//		}
//	}

	public void paintHeroImageMini(Graphics g, JComponent jComp, int[] position) {
		if(TEAM.equals(Team.BLUE))
			g.setColor(Color.blue);
			if(TEAM.equals(Team.RED))
			g.setColor(Color.red);
		g.fillOval(position[0], position[1],3, 3);
		
	}
	public boolean getattack(){
		return attack;
	}
	public int time(){
		return time;
	}

	public void setattack(boolean attack){
		this.attack=attack;
	}

	public int[] gettarget(){
		return target;
	}

	public void settarget(int[] target){
		
		this.target=target;
		
		time=0;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
	
	}
}
