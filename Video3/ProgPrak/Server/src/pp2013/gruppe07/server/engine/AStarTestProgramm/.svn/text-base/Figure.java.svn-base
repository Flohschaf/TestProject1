package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

abstract class Figure extends InteraktiveEntity implements ActionListener {

	Timer timer;
	int time = 0;
	int deathtime = Integer.MAX_VALUE;
	int attacktime = 1;
	Image AttackImage1;
	Image AttackImage2;
	Image AttackImage3;
	Image AttackImage4;
	Image AttackImage1unten;
	Image AttackImage2unten;
	Image AttackImage3unten;
	Image AttackImage4unten;
	Image AttackImage1oben;
	Image AttackImage2oben;
	Image AttackImage3oben;
	Image AttackImage4oben;
	Image AttackImage1links;
	Image AttackImage2links;
	Image AttackImage3links;
	Image AttackImage4links;
	protected int akt_mana;
	boolean attack = false;
	Image IMAGEDIE;

	int Direction = 2;

	int AttackDirection = 2;

	public Figure(int x, int y, int visibiliytRange, Type type, Team team) {
		super(x, y, visibiliytRange, Category.FIGURE, type, team);
		timer = new Timer(500, this);
		timer.start();
		AttackImage1 = Toolkit.getDefaultToolkit().getImage(
				"Images/schwert1.png");
		AttackImage2 = Toolkit.getDefaultToolkit().getImage(
				"Images/Schwert2.png");
		AttackImage3 = Toolkit.getDefaultToolkit()
				.getImage("Images/Bogen1.png");
		AttackImage4 = Toolkit.getDefaultToolkit()
				.getImage("Images/Bogen2.png");
		AttackImage1links = Toolkit.getDefaultToolkit().getImage(
				"Images/schwert1links.png");
		AttackImage2links = Toolkit.getDefaultToolkit().getImage(
				"Images/Schwert2links.png");
		AttackImage3links = Toolkit.getDefaultToolkit().getImage(
				"Images/Bogen1links.png");
		AttackImage4links = Toolkit.getDefaultToolkit().getImage(
				"Images/Bogen2links.png");
		AttackImage1oben = Toolkit.getDefaultToolkit().getImage(
				"Images/schwert1oben.png");
		AttackImage2oben = Toolkit.getDefaultToolkit().getImage(
				"Images/Schwert2oben.png");
		AttackImage3oben = Toolkit.getDefaultToolkit().getImage(
				"Images/Bogen1oben.png");
		AttackImage4oben = Toolkit.getDefaultToolkit().getImage(
				"Images/Bogen2oben.png");
		AttackImage1unten = Toolkit.getDefaultToolkit().getImage(
				"Images/schwert1unten.png");
		AttackImage2unten = Toolkit.getDefaultToolkit().getImage(
				"Images/Schwert2unten.png");
		AttackImage3unten = Toolkit.getDefaultToolkit().getImage(
				"Images/Bogen1unten.png");
		AttackImage4unten = Toolkit.getDefaultToolkit().getImage(
				"Images/Bogen2unten.png");

		IMAGEDIE = Toolkit.getDefaultToolkit().getImage("Images/KaBoom.png");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		if (attacktime == 1)
			attacktime = 2;
		else
			attacktime = 1;

	}

	public boolean getattack() {
		return attack;
	}

	public int getAttackdirection() {
		return AttackDirection;
	}

	public int getdirection() {
		return Direction;
	}

	public void move(Tile destTile) {
		super.setPosition(destTile.get_x(), destTile.get_y());
	}

	public void setattack(boolean attack) {
		this.attack = attack;
	}

	public void setAttackdirection(int direc) {
		AttackDirection = direc;
	}

	public void setdirection(int direc) {
		Direction = direc;
	}
}
