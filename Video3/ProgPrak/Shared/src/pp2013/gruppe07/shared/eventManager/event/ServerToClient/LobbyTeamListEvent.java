package pp2013.gruppe07.shared.eventManager.event.ServerToClient;

import java.util.LinkedList;

import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.Event;

public class LobbyTeamListEvent extends Event {

	LinkedList<Hero.Heronames> teamRed;
	LinkedList<Hero.Heronames> teamBlue;

	public LobbyTeamListEvent(int clientid, LinkedList<Hero.Heronames> teamRed,
			LinkedList<Hero.Heronames> teamBlue) {
		super(clientid, Event.Type.LOBBY_TEAM_LIST_EVENT);
		this.teamBlue = teamBlue;
		this.teamRed = teamRed;
	}

	public LinkedList<Hero.Heronames> getBlue() {
		return this.teamBlue;
	}

	public LinkedList<Hero.Heronames> getRed() {
		return this.teamRed;
	}

}
