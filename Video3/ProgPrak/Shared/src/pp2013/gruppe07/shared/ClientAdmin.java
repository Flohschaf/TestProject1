package pp2013.gruppe07.shared;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.item.Item;

/**Stellt eine Administrationsklasse fuer die Serverengine dar.
 * @author Sven,Steven,Felix
 *
 */
public class ClientAdmin  implements Serializable,Cloneable{

	
	private final int clientNr;
	private Hero clientHero;
	private final InteraktiveEntity.Team TEAM;


	
	/**
	 * @param hero
	 * @param team
	 * @param id
	 * @author Sven,Steven
	 */
	public ClientAdmin(Hero hero,InteraktiveEntity.Team team, int id)
		{this.TEAM=team;
		this.clientNr=id;
		this.clientHero=hero;}
	
	
	
	/**
	 * @return
	 * @author Sven,Steven
	 */
	public int getClientNr() {
		return clientNr;
	}

	/**
	 * @return
	 * @author Sven,Steven
	 */
	public Hero getClientHero() {
		return clientHero;
	}

	/**
	 * @return
	 * @author Sven,Steven
	 */
	public InteraktiveEntity.Team getTeam() {
		return TEAM;
	}

	
	
}
