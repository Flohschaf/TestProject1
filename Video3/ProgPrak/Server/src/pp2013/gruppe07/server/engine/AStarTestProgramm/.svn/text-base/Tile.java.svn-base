package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Graphics;

import javax.swing.JComponent;

class Tile {

	Entity entity;
	Ground ground;
	int X;
	int Y;

	int state;

	public Tile(Entity entity, Ground ground, int x, int y) {
		this.entity = entity;
		this.ground = ground;
		this.X = x;
		this.Y = y;

		// Legt den Status der Kachel fest
		if (entity.getCategory().equals(Entity.Category.NATURE)) {
			state = 0;
		} else
			state = 1;
		if (x == 4 && y == 5) {
			state = 4;
		}
		if (x == 20 && y == 22) {
			state = 5;
		}
		if (x >= 2 && x <= 8 && y == 14) {
			state = 7;
		}
	}

	public int get_x() {
		return X;
	}

	public int get_y() {
		return Y;
	}

	public Ground getground() {
		return ground;

	}

	public Entity getobject() {
		// TODO Auto-generated method stub
		return entity;
	}

	public int getState() {
		return state;
	}

	public boolean isBlocked() {
		boolean isblocked = false;
		if (entity.getCategory().equals(
				entity.getCategory().SPACE_HOLDER_FOR_BUILDING)
				|| entity.getCategory().equals(entity.getCategory().BUILDING)
				|| entity.getCategory().equals(entity.getCategory().NATURE))/*
																			 * oder
																			 * Boden
																			 * nicht
																			 * begehbar
																			 */
		{
			isblocked = true;
		}
		return isblocked;
	}

	public boolean isCurrentlyBlocked() {
		return entity.getCategory().equals(Entity.Category.FIGURE);
	}

	public void paintentity(Graphics g, JComponent jp, int[] position) {

		entity.paint(g, jp, position);

	}

	public void paintground(Graphics g, JComponent jp, int[] position) {
		ground.paint(g, jp, position);

	}

	public void resetState() {
		this.state = 1;
	}

	public void setground(Ground underground) {

		this.ground = underground;

	}

	public void setobject(Entity object) {
		// TODO Auto-generated method stub
		this.entity = object;

	}

	public void setState(int value) {
		if (state != 4 && state != 5 && state != 7) {
			state = value;
		}
	}
}
