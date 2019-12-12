package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.threads_and_KI.RespawnTimer;
import pp2013.gruppe07.server.engine.threads_and_KI.TowerKI;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.HitUpdateEvent;

/**
 * Fuehrt EINEN Schlag eines Towers aus
 * 
 * @author Sven
 * 
 */
public class HitEvent_Tower extends GameEvent {

	private TowerKI towerKI;
	private InteraktiveEntity enemy;

	/**
	 * @param administration
	 * @param tower
	 * @param enemy
	 * @author Sven
	 */
	public HitEvent_Tower(GameLogic administration, TowerKI tower,
			InteraktiveEntity enemy) {
		super(administration);
		this.towerKI = tower;
		this.enemy = enemy;
	}

	@Override
	void execute() {
		// Teste ob sich der Gegner nur ein Feld vom Angreifer entfernt befindet
		// und die Figur noch lebt
		if (towerKI.getTower().isAlive() && enemy.isAlive()
				&& towerKI.nearEnough()) {
			// Berechne Schaden und ziehen ihn dem Gegner ab
			int change = (-1)
					* towerKI.getTower().getvalue()[InteraktiveEntity.values.ATTACK
							.ordinal()]
					* (100 - enemy.getvalue()[InteraktiveEntity.values.ARMOR
							.ordinal()]) / 100;
			enemy.change_Akt_Life(change);

			// Entferne den Gegner je nachdem aus dem Spiel
			if (enemy.get_Akt_Life() == 0) {
				enemy.kill();
				int x = enemy.getPosition()[0];
				int y = enemy.getPosition()[1];
				administration.get_map()[x][y].setobject(new SpaceHolder(x, y));

				// Regele den Respawn des Helden...
				if (enemy instanceof Hero) {
					administration.getThreadPool().execute(
							new RespawnTimer(administration, (Hero) enemy));
				}

				// ...oder entferne den Gegner aus der HashMap
				else {
					administration.get_entities().remove(enemy.getID());
				}
			}

			// Schicke inkrementelles Update an die CLients

			for (int j = 0; j < Waiter.getClients().size(); j++) {
				Communication
						.newClientMessage(new HitUpdateEvent(Waiter
								.getClients().get(j).getId(), towerKI
								.getTower().getID(), enemy.getID(), change, 0,
								towerKI.getTower()));
			}

		}

		// Gibt der TowerKI des Angreifers den Befehl zum weitermachen.
		towerKI.getHitLock().lock();
		towerKI.getHitCondition().signal();
		towerKI.getHitLock().unlock();
	}

}
