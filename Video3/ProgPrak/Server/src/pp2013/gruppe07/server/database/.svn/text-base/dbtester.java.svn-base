package pp2013.gruppe07.server.database;

import java.util.LinkedList;
import java.util.List;

import pp2013.gruppe07.shared.entity.InteraktiveEntity;
/**
	 * @author Steven
	 * klasse zum testen der datenbank
	 */
public class dbtester {
	
	public static void main(String[] args) {
		dbase db = new dbase();
		/*
		String hex1 =db.getMD5Hash("test");
		String hex2 =db.getMD5Hash("test");
		String hex3 =db.getMD5Hash("tesd");
		
		if(hex1.equals(hex2))
			System.out.println("Text muss erscheinen");
		if(hex1.equals(hex3))
			System.out.println("Text darf nicht erscheinen");
	
		
		

		db.insertNewAccount(3,"StevenGross", "correctpasswd");
		db.insertNewAccount(3,"StevenGross2", "correctpasswd2");
		db.insertNewAccount(3,"StevenGross3", "correctpasswd3");
		
		db.checkPasswd(0, "StevenGross", "correctpasswd");
		db.checkPasswd(0, "StevenGross2", "correctpasswd2");
		db.checkPasswd(0, "StevenGross3", "correctpasswd");
		//db.updateLineDB("StevenGross", "level", 60);

		*/
		
		db.playerNewHero(0, "StevenGross", "KingDaniel");
		db.playerNewHero(0, "StevenGross", "KingFlol");
	

		db.updateHeroValues("StevenGross", "KingDaniel", "totalKills", 20);	
		db.getAccountHeros("StevenGross");

		}
}