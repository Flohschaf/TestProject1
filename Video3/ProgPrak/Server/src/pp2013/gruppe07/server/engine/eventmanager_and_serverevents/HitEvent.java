package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.threads_and_KI.AttackThread;
import pp2013.gruppe07.server.engine.threads_and_KI.RespawnTimer;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.Inhibitor;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Nexus;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.HitUpdateEvent;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.IncreaseXPEvent;

/**
 * Fuehrt EINEN Schlag/Angriff einer Figur aus.
 * 
 * @author Sven
 */
public class HitEvent extends GameEvent {

	private AttackThread fight;

	/**
	 * @param administration
	 * @param fight
	 * @author Sven
	 */
	public HitEvent(GameLogic administration, AttackThread fight) {
		super(administration);
		this.fight = fight;
	}

	@Override
	void execute() {

		// Speichere die Kaempfer zwischen.
		Figure figure = fight.get_figure();
		InteraktiveEntity enemy = fight.get_enemy();

		// Teste ob sich der Gegner nur ein Feld vom Angreifer entfernt befindet
		// und die Figur noch lebt
		// und der Angriff noch ausgefuehrt werden soll
		if (figure.isAlive() && enemy.isAlive() && fight.near_enough()
				&& fight.isAttacking()) {
			// Regele die Kampfanimation
			int attackDirection = figure.getAttackdirection();

			figure.setattack(true);
			int target[] = { enemy.getPosition()[0], enemy.getPosition()[1] };
			figure.settarget(target);

			if ((figure.getPosition()[1] - enemy.getPosition()[1]) < 0) {
				attackDirection = 4;
			}
			if ((figure.getPosition()[1] - enemy.getPosition()[1]) > 0) {
				attackDirection = 3;
			}
			if ((figure.getPosition()[0] - enemy.getPosition()[0]) < 0) {
				attackDirection = 2;
			}
			if ((figure.getPosition()[0] - enemy.getPosition()[0]) > 0) {
				attackDirection = 1;
			}

			figure.setAttackdirection(attackDirection);

			// Berechne Schaden und ziehe diesen beim Gegner ab
			int change = (-1)
					* figure.getvalue()[InteraktiveEntity.values.ATTACK
							.ordinal()]
					* (100 - enemy.getvalue()[InteraktiveEntity.values.ARMOR
							.ordinal()]) / 100;
			enemy.change_Akt_Life(change);

			// Schicke eine Nachricht an die Clients
			for (int j = 0; j < Waiter.getClients().size(); j++) {
				Communication.newClientMessage(new HitUpdateEvent(Waiter
						.getClients().get(j).getId(), figure.getID(), enemy
						.getID(), change, attackDirection, figure));
			}

			// Entferne den Gegner je nachdem aus dem Spiel
			if (enemy.get_Akt_Life() == 0) {
				enemy.kill();
				int x = enemy.getPosition()[0];
				int y = enemy.getPosition()[1];
				administration.get_map()[x][y].setobject(new SpaceHolder(x, y));

				if (figure instanceof Hero) {
					// Erhoehe die Erfahrungspunkte des Helden
					Hero hero = ((Hero) figure);
					boolean levelUp = hero.increase_Akt_XP(enemy.getGIVE_XP());

					// Wenn ein Levelup erfolgt ist...
					if (levelUp) {
						// ...dann erhoehe die Werte und setze Leben und
						// Mana auf maximale Punkte
						// Schicke anschliessen die entsprechenden Events an
						// die Clients
						int[] newValues = { 10, 5, 5, 0, 0, 5, 150, 150 };
						for (int i = 0; i < 8; i++) {
							hero.increaseValue(i, newValues[i]);
						}
						hero.change_Akt_Life(hero.getvalue(6));
						hero.change_Akt_mana(hero.getvalue(7));
						}
					}				

				// Regele den Respawn des Helden
				if (enemy instanceof Hero) {
					administration.getThreadPool().execute(
							new RespawnTimer(administration, (Hero) enemy));
				}

				// Oder entferne den Gegner aus der Liste
				else {
					administration.get_entities().remove(enemy.getID());

					// Wenn ein Nexus zerstoert wurde, dann beende das Spiel
					if (enemy instanceof Nexus) {
						Nexus nexus = (Nexus) enemy;
						if (nexus.getTeam().equals(Team.RED)) {
							administration.setWonGame(Team.BLUE);
						} else {
							administration.setWonGame(Team.RED);
						}
						administration.quitGame();
					}

					// Wenn ein Inhibitor zerstoert wurde, dann setze die
					// entsprechende Variable.
					else {
						if (enemy instanceof Inhibitor) {
							Team team = ((Inhibitor) enemy).getTeam();
							if (team.equals(Team.RED)) {
								administration.setInhibitorAliveRed(false);
							} else {
								administration.setInhibitorAliveBlue(false);
							}
						}
					}
				}
			}

			// Sage dem Angriffsthread, dass der Schlag erfolgreich ausgefuehrt
			// wurde.
			fight.hitDone();
		}
		// Gibt dem Angriffsthread des Angreifers den Befehl zum weitermachen.
		fight.getHitLock().lock();
		fight.getHitCondition().signal();
		fight.getHitLock().unlock();
	}

}
