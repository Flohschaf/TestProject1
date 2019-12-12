package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;

class SafetySteven extends Hero {

	// fernkampf

	public SafetySteven(int x, int y, Team team) {
		super(x, y, Entity.Type.SAFETY_STEVEN, team);
		HERONAME = "SafetySteven";
		IMAGE = Toolkit.getDefaultToolkit().getImage("Images/Stevenklein.png");
		IMAGE2 = Toolkit.getDefaultToolkit().getImage("Images/Stevengross.png");
		IMAGE3 = Toolkit.getDefaultToolkit().getImage(
				"Images/Stevenkleinlinks.png");

		default_values[0] = 10;
		default_values[1] = 10;
		default_values[2] = 20;
		default_values[3] = 30;
		default_values[4] = 1000;
		default_values[5] = 10;
		default_values[6] = 800;
		default_values[7] = 150;
		akt_life = default_values[6];
		akt_mana = default_values[7];

	}

	@Override
	public boolean getattack() {
		return attack;
	}

	@Override
	public String getHeroName() {

		return HERONAME;
	}

	@Override
	public int getlife()// Methode zum verndern der Values also sowas wie kraft
	{
		return akt_life;
	}

	public int getmana()// Methode zum verndern der Values also sowas wie kraft
	{
		return akt_mana;
	}

	@Override
	public int[] getvalue()// Methode zum verndern der Values also sowas wie
							// kraft
	{
		return default_values;
	}

	@Override
	public void paint(Graphics g, JComponent jComp, int[] position) {
		g.setColor(Color.black);
		g.fillRect(position[0], position[1], 53, 6);
		g.setColor(Color.green);
		if (getlife() >= 0)
			g.fillRect(position[0] + 1, position[1] + 1,
					(getlife() * 51 / default_values[6]), 4);

		if (getdirection() == 2)
			g.drawImage(IMAGE, position[0], position[1], jComp);
		if (getdirection() == 1)
			g.drawImage(IMAGE3, position[0], position[1], jComp);
		if (getlife() <= 0) {
			if (deathtime > time)
				deathtime = time;
			if (time < deathtime + 2)
				g.drawImage(IMAGEDIE, position[0], position[1], jComp);
		}
		if (getattack()) {
			if (getAttackdirection() == 2) {
				if (attacktime == 1)
					g.drawImage(AttackImage3, position[0] + 20,
							position[1] - 15, jComp);
				if (attacktime == 2)
					g.drawImage(AttackImage4, position[0] + 25,
							position[1] - 20, jComp);
			}
			if (getAttackdirection() == 1) {
				if (attacktime == 1)
					g.drawImage(AttackImage3links, position[0] - 30,
							position[1] - 15, jComp);
				if (attacktime == 2)
					g.drawImage(AttackImage4links, position[0] - 35,
							position[1] - 20, jComp);
			}

			if (getAttackdirection() == 3) {
				if (attacktime == 1)
					g.drawImage(AttackImage3oben, position[0] - 10,
							position[1] - 40, jComp);
				if (attacktime == 2)
					g.drawImage(AttackImage4oben, position[0] - 5,
							position[1] - 35, jComp);
			}
			if (getAttackdirection() == 4) {
				if (attacktime == 1)
					g.drawImage(AttackImage3unten, position[0] - 10,
							position[1] + 15, jComp);
				if (attacktime == 2)
					g.drawImage(AttackImage4unten, position[0] - 5,
							position[1] + 20, jComp);
			}

		}
	}

	@Override
	public void paintHeroImage(Graphics g, JComponent jComp, int[] position) {
		g.drawImage(IMAGE2, position[0], position[1], jComp);

	}

	@Override
	public void paintHeroImageMini(Graphics g, JComponent jComp, int[] position) {
		if (TEAM.equals(Team.BLUE))
			g.setColor(Color.blue);
		if (TEAM.equals(Team.RED))
			g.setColor(Color.red);
		g.fillOval(position[0], position[1], 4, 4);

	}

	@Override
	public void setlife(int increase)// Methode zum verndern der Values also
										// sowas wie kraft
	{
		akt_life = akt_life + increase;
	}

	public void setmana(int increase)// Methode zum verndern der Values also
										// sowas wie kraft
	{
		akt_mana = akt_mana + increase;
	}

	@Override
	public void setPosition(int x, int y) {
		Position[0] = x;
		Position[1] = y;
	}

	@Override
	public void setvalue(int pos, int increase)// Methode zum verndern der
												// Values also sowas wie kraft
	{
		default_values[pos] = default_values[pos] + increase;
	}

}
