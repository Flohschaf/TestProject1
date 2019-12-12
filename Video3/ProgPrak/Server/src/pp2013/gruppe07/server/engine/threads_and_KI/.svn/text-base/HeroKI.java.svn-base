package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Nexus;
import pp2013.gruppe07.shared.entity.Shop;

/**
 * Regelt das komplette Leben eines computergesteuerten Helden.
 * 
 * @author Sven
 */
public class HeroKI implements Runnable {

	private Hero hero;
	private GameLogic administration;
	private Nexus ownTeamNexus;
	private AttackThread_Hero fighter;
	private MoveThread_Normal mover;
	private final Team OTHERTEAM;
	private boolean reachedFirstDestPosition = false;
	private boolean reachedNexus = false;

	/**
	 * @param administration
	 * @param hero
	 * @author Sven
	 */
	public HeroKI(GameLogic administration, Hero hero) {
		this.administration = administration;
		this.hero = hero;
		int nexusPosition[] = administration.getNexusPosition(hero.getTeam());

		// Speichere den eigenen Nexus zwischen
		this.ownTeamNexus = (Nexus) administration.get_map()[nexusPosition[0]][nexusPosition[1]]
				.getobject();

		if (hero.getTeam().equals(Team.RED))
			this.OTHERTEAM = Team.BLUE;
		else
			this.OTHERTEAM = Team.RED;
	}

	/**
	 * Gibt ein moegliches Angriffsziel im Sichtfeld zurueck. Dabei wird ein
	 * Gegner bevorzugt, den moeglichst wenig eigene Einheiten attackieren.
	 * 
	 * @return
	 * @author Sven
	 */
	private InteraktiveEntity attackObjektInVisibillityRange() {
		// Initialisiere die benoetigten Variablen.
		InteraktiveEntity erg = null;
		int min_AttackingEnemies = Integer.MAX_VALUE;
		int radius = hero.getVisibilityRange();

		// Sorge dafuer, dass nicht ausserhalb der Karte gesucht wird.
		int i_min = Math.max(20, (hero.getPosition()[0] - radius));
		int i_max = Math.min(119, (hero.getPosition()[0] + radius));

		// Gehe das kleinste Quadrat an Kacheln, um den Helden durch, welches
		// das Sichtfeld enthaelt
		for (int i = i_min; i <= i_max; i++) {
			int j_min = Math.max(20, (hero.getPosition()[1] - radius));
			int j_max = Math.min(119, (hero.getPosition()[1] + radius));
			for (int j = j_min; j <= j_max; j++) {
				// Wenn die Kachel im Sichtfeld ist
				if (euclid_dist(hero.getPosition()[0], hero.getPosition()[1],
						i, j) <= radius) {
					Entity object = administration.get_map()[i][j].getobject();

					// Ueberprufe, ob ein interagierendes Objekt auf der Kachel
					// ist, welches nicht der Shop ist
					if (object instanceof Figure
							|| (object instanceof Building && !(object instanceof Shop))) {
						InteraktiveEntity objectcast = (InteraktiveEntity) object;

						// Ueberpruefe, ob das Objekt zum anderen Team gehoert
						// und ob es weniger Angreifer
						// als das aktuelle Ziel hat.
						if ((objectcast.getTeam().equals(OTHERTEAM))
								&& objectcast.getAttackingEnemies() < min_AttackingEnemies) {
							erg = objectcast;
							min_AttackingEnemies = objectcast
									.getAttackingEnemies();
						}
					}
				}
			}
		}
		return erg;
	}

	/**
	 * Kontrolliert beim Bewegen laufend das Sichtfeld nach gegnerischen
	 * Einheiten und greift ggf. an. Weiterhin wird auch uberprueft, ob der
	 * eigene Nexus angegriffen wird und falls ja geht der Hero zurueck um
	 * diesen zu beschuetzen
	 * 
	 * @author Sven
	 */
	private void controlVisibilityRange() {
		boolean startfight = false;
		boolean isSavingNexus = false;
		while (!startfight && mover.isRunning() && administration.isRunning()) {
			// Ueberprueft, ob der eigene Nexus attackiert wird.
//			if (ownTeamNexus.getAttackingEnemies() > 0 && !isSavingNexus) {				
//				safeNexus();
//				isSavingNexus = true;
//			}

			// Suche nach Gegner im Sichtfeld
			InteraktiveEntity enemy = attackObjektInVisibillityRange();

			// Wenn einer gefunden wurde...
			if (enemy != null) {
				// ...dann breche die Bewegung ab und starte einen
				// Angriffsthread.
				mover.abort();
				startfight = true;
				fighter = new AttackThread_Hero(administration, hero, enemy);
				fighter.getKILock().lock();
				

				// Warte darauf, dass der Angriffsthread beendet wird und das
				// Signal kommt.
				try {
					if(!administration.getThreadPool().isShutdown())
						{administration.getThreadPool().execute(fighter);
						fighter.getKICondition().await();
						}
				} catch (InterruptedException e) {

				}
				fighter.getKILock().unlock();
			}
			if (administration.selfmadeSleeper())
				administration.sleeper(200);
			else {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {

				}
			}
		}
	}

	/**
	 * Bestimmt den euklidischen Abstand zwischen 2 Punkten
	 * 
	 * @author Sven
	 */
	private double euclid_dist(int x1, int y1, int x2, int y2) {
		return Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)), 0.5);
	}

	/**
	 * Stellt einen endlichen Deterministischen Automaten dar, der das Leben
	 * eines Helden regelt
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {

		// Bestimme die Nexusposition des Gegners
		int[] nexusPosition = administration.getNexusPosition(OTHERTEAM);
		Nexus enemiesNexus = (Nexus) administration.get_map()[nexusPosition[0]][nexusPosition[1]]
				.getobject();
		nexusPosition[0]--;
		nexusPosition[1]--;
		

		// Die auessere While-Schleife wird benoetigt, da der Hero auch
		// zurueckgehen und sterben kann
		while (administration.isRunning()) {
			// Bestimme zufaellig eine Lane und somit das erste Ziel
			int lane = (int) (Math.random() * 3) + 1;
			int[] first_dest_Position = { 25 + (lane - 1) * 45,
					25 + (lane - 1) * 45 };

			// Solange der Held nicht am ersten Ziel ist...
			while (hero.isAlive() && !reachedFirstDestPosition
					&& administration.isRunning()) {
				// ...starte Bewegungsthread dorthin
				mover = new MoveThread_Normal(administration, hero,
						first_dest_Position[0], first_dest_Position[1]);
				administration.getThreadPool().execute(mover);

				// und kontrolliere dabei parallel das Sichtfeld in der KI
				controlVisibilityRange();

				// Wenn das erste Ziel erreicht ist, dann beende diese Schleife
				if (euclid_dist(hero.getPosition()[0], hero.getPosition()[1],
						first_dest_Position[0], first_dest_Position[1]) <= 10) {
					reachedFirstDestPosition = true;
				}

				// breche die alte Bewegung ab.
				mover.abort();
			}

			// An dieser Steller befindet sich der Held in der Naeher des ersten
			// Zielpunktes.

			// Solange der gegnerische Nexus nicht erreicht wurde...
			while (reachedFirstDestPosition && !reachedNexus && hero.isAlive()
					&& administration.isRunning()) {
				// ...starte Bewegungsthread dorthin
				mover = new MoveThread_Normal(administration, hero,
						nexusPosition[0], nexusPosition[1]);
				administration.getThreadPool().execute(mover);

				// und kontrolliere dabei parallel das Sichtfeld in der KI
				controlVisibilityRange();

				// Wenn der gegnerische Nexus erreicht wurde, dann beende diese
				// Schleife.
				if (euclid_dist(hero.getPosition()[0], hero.getPosition()[1],
						nexusPosition[0], nexusPosition[1]) <= 10) {
					reachedNexus = true;
				}

				// breche die Bewegung ab.
				mover.abort();
			}
			
			//Bekaempfe den Nexus und warte bis der Angriff vorbei ist
			
			if(!administration.getThreadPool().isShutdown())
				{fighter = new AttackThread_Hero(administration, hero, enemiesNexus);
				fighter.getKILock().lock();			
				administration.getThreadPool().execute(fighter);
				try {
					fighter.getKICondition().await();
				} catch (InterruptedException e1) {				
				}
				fighter.getKILock().unlock();
				}
			
			
			// Sleeper, damit die Schleife im Fall des Tod des Heros nicht
			// durchlaeuft
			if (administration.selfmadeSleeper()) {
				administration.sleeper(500);
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

				}
			}
		}

	}

	/**
	 * Geht zurueck zum eigenen Nexus, egal wo er ist und was zwischendurch
	 * passiert, um diesen zu beschuetzen.
	 * 
	 * @author Sven
	 */
	private void safeNexus() {
		// breche alte Bewegung ab und erstelle neue zum eigenen Nexus
		mover.abort();
		mover = new MoveThread_Normal(administration, hero,
				ownTeamNexus.getPosition()[0], ownTeamNexus.getPosition()[1]);
		mover.getKILock().lock();
		administration.getThreadPool().execute(mover);
		try {
			mover.getKICondition().await();
		} catch (InterruptedException e) {

		}
		mover.getKILock().unlock();

		// Setze die Werte zurueck
		reachedFirstDestPosition = false;
		reachedNexus = false;
	}

}
