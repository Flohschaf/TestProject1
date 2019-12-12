package pp2013.gruppe07.server.engine.threads_and_KI;

import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.HitEvent;
import pp2013.gruppe07.server.engine.eventmanager_and_serverevents.SpecialHeroAttackEvent;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.special_attacks.SelbstHeilen;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.values;
import pp2013.gruppe07.shared.entity.SafetySteven;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.SpecialAttackEvent.Attacks;

/**
 * Regelt das Angriffsverhalten ausschliesslich von Helden 
 * (spezialisiert auf SafetySteven als KI)
 * 
 * @author Sven
 * 
 */
public class AttackThread_Hero extends AttackThread implements Runnable {

	private Hero hero;

	/**
	 * @param administration
	 * @param hero
	 * @param enemy
	 * @author Sven
	 */
	public AttackThread_Hero(GameLogic administration, Hero hero,
			InteraktiveEntity enemy) {
		super(administration, enemy);		
		this.hero = hero;
	}

	@Override
	public Figure get_figure() {
		return hero;
	}

	/**
	 * @return
	 * @author Sven
	 */
	public Hero getHero() {
		return hero;
	}

	@Override
	public boolean near_enough() {
		int x1 = hero.getPosition()[0];
		int y1 = hero.getPosition()[1];
		int x2 = enemy.getPosition()[0];
		int y2 = enemy.getPosition()[1];

		// Gebe zurueck, ob sich der Gegner in Reichweite befindet.
		return (Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5) <= Math
				.max(hero.getATTACKRANGE(), Math.pow(2, 0.5)));
	}

	/**
	 * Stellt die Angriffsroutine dar.
	 * 
	 * @author Sven
	 */
	@Override
	public void run() {
		isAttacking = true;		
		
		// Solange der Gegner noch lebt und der Angriff nicht abgebrochen wurde.
		while (isAttacking && enemy.isAlive() && hero.isAlive()
				&& administration.isRunning()) {
			// Pruefe ob der Angreifer neben dem Gegner steht.
			if (!near_enough()) {// Gehe zum Gegner hin.
				mover = new MoveThread_Fight(administration, this);

				// Warte bis der Weg gegangen wurde
				mover.getAttackLock().lock();
				
				try {
					if(!administration.getThreadPool().isShutdown())
						{administration.getThreadPool().execute(mover);
						mover.getAttackCondition().await();
						}
				} catch (InterruptedException e) {

				}
				mover.getAttackLock().unlock();
			}
			
			//Teste ob eine Spezialattacke ausgefuehrt werden soll, wenn
			//der Held von einer KI gesteuert wird.
			if(!hero.isHuman())
				{
				//Wenn der Held genug Mana hat und weniger als 50 Lebensenergie
				//hat, dann soll er sich selber heilen
				if(hero.get_Akt_Life()<100&&hero.getAkt_mana()>=100)
					{administration.get_eventManager().addEvent(new SpecialHeroAttackEvent(administration, hero, Attacks.HEILEN));}
				
				//Wenn der Held von mehr als 1 Gegener gleichzeitig angegriffen wird
				//und genug Mana besitzt, dann mache ihn unsichtbar
				if(hero.getAttackingEnemies()>1&&hero.getAkt_mana()>=100)
					{administration.get_eventManager().addEvent(new SpecialHeroAttackEvent(administration, hero, Attacks.UNSICHTBAR));}
				
				//Wenn der Held von einem Gegner angegriffen wird und noch
				//genug Mana hat, dann mache einen Rundumschlag
				if(hero.getAttackingEnemies()>0&&hero.getAkt_mana()>=100)
					{administration.get_eventManager().addEvent(new SpecialHeroAttackEvent(administration, hero, Attacks.RUNDUMSCHLAG));}
				}
			
			// Lege HitEvent auf EventQueue

			hitLock.lock();
			administration.get_eventManager().addEvent(
					new HitEvent(administration, this));
			// Warte bis der Schlag ausgefuehrt wurde
			try {
				hitCondition.await();
			} catch (InterruptedException e1) {

			}
			hitLock.unlock();			
			
			// Der Thread schlaeft in Abhaengigkeit der Angriffgeschwindigkeit
			// der Figur, aber nur wenn
			// ein Schlag ausgefuehrt wurde
			if (hitDone) {

				if (administration.selfmadeSleeper())
					administration.sleeper(hero.getvalue(values.ATTACKSPEED
							.ordinal()));
				else {
					try {
						Thread.sleep(hero.getvalue(values.ATTACKSPEED.ordinal()));
					} catch (InterruptedException e) {

					}
				}
			}
		}

		// Beende Kampfanimationen
		hero.setattack(false);

		// Gib der HeroKI das Signal das der Angriff vorbei ist.
		kiLock.lock();
		kiCondition.signal();
		kiLock.unlock();

		// Verringere die Anzahl der Angreifer des Gegners.
		enemy.setAttackingEnemies(enemy.getAttackingEnemies() - 1);

	}

}
