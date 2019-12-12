package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.special_attacks.Aussaugen;
import pp2013.gruppe07.server.engine.special_attacks.Clitisieren;
import pp2013.gruppe07.server.engine.special_attacks.Eispfeil;
import pp2013.gruppe07.server.engine.special_attacks.Erdbeben;
import pp2013.gruppe07.server.engine.special_attacks.FrostPfeil;
import pp2013.gruppe07.server.engine.special_attacks.Haddleruf;
import pp2013.gruppe07.server.engine.special_attacks.HinterhaltsSchlag;
import pp2013.gruppe07.server.engine.special_attacks.HoherTon;
import pp2013.gruppe07.server.engine.special_attacks.Kugelhagel;
import pp2013.gruppe07.server.engine.special_attacks.MegaBombe;
import pp2013.gruppe07.server.engine.special_attacks.Rundumschlag;
import pp2013.gruppe07.server.engine.special_attacks.SchoenesLied;
import pp2013.gruppe07.server.engine.special_attacks.Schutzschild;
import pp2013.gruppe07.server.engine.special_attacks.SelbstHeilen;
import pp2013.gruppe07.server.engine.special_attacks.SpecialAttack;
import pp2013.gruppe07.server.engine.special_attacks.StarkerSchlag;
import pp2013.gruppe07.server.engine.special_attacks.Supersayajin;
import pp2013.gruppe07.server.engine.special_attacks.Unsichtbar;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.eventManager.event.ClientToServer.SpecialAttackEvent.Attacks;

/**Regelt das Ausfuehren einer Spezialattacke eines Helden
 * @author Sven
 * @author Steven
 *
 */
public class SpecialHeroAttackEvent extends GameEvent {

	private Hero hero;
	private SpecialAttack attack;
	
	/**
	 * @param administration
	 * @param hero
	 * @param spc
	 * @author Sven
	 */
	public SpecialHeroAttackEvent(GameLogic administration,Hero hero,Attacks spc) {
		super(administration);
		this.hero=hero;
		attack=createAttack(spc);
	}

	/**Erzeugt das passende Objekt zum Typ.
	 * @param spc
	 * @return
	 * @author Sven,Steven
	 */
	private SpecialAttack createAttack(Attacks spc)
		{
		switch(spc)
			{case SCHUTZSCHILD:
				{return new Schutzschild(administration, hero);						
				}
			case SUPERSAYAJIN:
			{return new Supersayajin(administration, hero);						
			}
			
			case STARKERSCHLAG:
			{return new StarkerSchlag(administration, hero);						
			}

			case AUSSAUGEN:
			{return new Aussaugen(administration, hero);						
			}
			case ERDBEBEN:
			{return new Erdbeben(administration, hero);						
			}
			case AUSZAHLUNG:
			{return new Haddleruf(administration, hero);						
			}
			case CLITISIEREN:{	
				return new Clitisieren(administration, hero);		
			}
			case EISPFEIL:{
				return new Eispfeil(administration, hero);
			}
			case FROSTFEIL:{
				return new FrostPfeil(administration, hero);	
			}
			case HADDLERUF:{
				return new Haddleruf(administration, hero);
			}
			case HEILEN:{
				return new SelbstHeilen(administration, hero);
			}
			case HINTERHALT:{
				return new HinterhaltsSchlag(administration, hero);
				
			}
			case HOHERTON:{
				return new HoherTon(administration, hero);
			}
			case KUGELHAGEL:{
				return new Kugelhagel(administration, hero);
			}
			case MEGABOMBE:{
				return new MegaBombe(administration, hero);
			}
			case RUNDUMSCHLAG:{
				return new Rundumschlag(administration, hero);
			}
			case SCHILDPANZER:{}
			case SCHOENESLIED:{
				return new SchoenesLied(administration, hero);
			}
			case UNSICHTBAR:{
				return new Unsichtbar(administration, hero);
			}
		
			default:
				return null;
			}
		}
	
	void execute()
		{attack.execute();
		if(attack.isRunnbale())
			{administration.getThreadPool().execute(attack);}
		
		}
}
