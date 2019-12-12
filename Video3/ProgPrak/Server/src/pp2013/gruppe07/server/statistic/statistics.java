package pp2013.gruppe07.server.statistic;

import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.database.dbase;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.ClientAdmin;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;

public class statistics {

	/**
	 * @autor steven
	 * speichert die werte der spieler des aktuellen spiels, auch fuer speicherung in datenbank wichtig
	 */
	public statistics(GameLogic administration){
		this.administration = administration;
	}
	
	protected GameLogic administration;
	
	
	
	protected Hero hero;
	protected ClientAdmin client;
	protected dbase database = new dbase();
	
	
	int kills = 0;
	int deaths = 1;
	int lasthits = 2;


	int playerName = 0;
	int heroName = 1;
	
//[8]: Spieler, [3]: kills, deaths, lastkills
int[][] statistic = new int[8][3];

//playername, heroname
String[][] player = new String[8][2];
/**
	 * @author Steven
	 * setzte statistic zurueck
	 */
public void resetStatistic(){

for (int i = 0; i<8; i++){
	for (int j = 0; j<3; j++){
		statistic[i][j]=0;
	
}}
for (int i = 0; i<8; i++){
	for (int j = 0; j<2; j++){
		player[i][j] ="empty";
		
	}}

}
/**
	 * @author Steven
	 * setzt statistic
	 */
public void setGameStatistic(){
	resetStatistic();

	for(int i=0; i< administration.countPlayer();i++){

			if(administration.getClientAdmin()[i]!= null){
		
			player[i][playerName]=Waiter.getClients().get(i).getAccountName();
			player[i][heroName]=administration.getClientAdmin()[i].getClientHero().getHeroName();
						
			statistic[i][kills] = administration.getClientAdmin()[i].getClientHero().getKills();
			statistic[i][deaths]=administration.getClientAdmin()[i].getClientHero().getDeaths();
			statistic[i][lasthits]=administration.getClientAdmin()[i].getClientHero().getLasthits();
	
	}
			}
}

/**
	 * @author Steven
	 * uebergibt gabestatistic
	 */
public String[][] getGameStringStatistic(){

	String[][] stat = new String[8][5];
	for (int j = 0; j<8;j++)
	for (int i=0; i<2; i++)
		stat[j][i] = player[j][i];

		
	for (int j = 0; j<8;j++)
		for (int i=2; i<5; i++)
			stat[j][i] = ""+statistic[j][i-2];

	for (int j = 0; j<8;j++){
		System.out.println("");
		for (int i=0; i<5; i++){
			System.out.print(stat[j][i] + "  ");
			}}

		
	return stat;
}
/**
	 * @author Steven
	 * uebergibt gamestatistic in db
	 */
public void gameStatinDB(Team winner){
	for(int i=0;i<8;i++){

		database.updateAccountValue(player[i][0], "level", database.getAccountValue(player[i][0], "level")+1);

if(administration.getClientAdmin()[i]!= null){
if(administration.getClientAdmin()[i].getTeam() == winner)
database.updateAccountValue(player[i][0], "spieleGewonnen", database.getAccountValue(player[i][0], "spieleGewonnen")+1);
else
database.updateAccountValue(player[i][0], "spieleVerloren", database.getAccountValue(player[i][0], "spieleVerloren")+1);

		
	database.updateHeroValues(player[i][0], player[i][1], "totalKills", database.getHeroValue(player[i][0], player[i][1], "totalKills")+statistic[i][kills]);
	database.updateHeroValues(player[i][0], player[i][1], "totalDeaths", database.getHeroValue(player[i][0], player[i][1], "totalDeaths")+statistic[i][deaths]);
	database.updateHeroValues(player[i][0], player[i][1], "totalLasthits", database.getHeroValue(player[i][0], player[i][1], "totalLasthits")+statistic[i][lasthits]);

	}
}
}
}
