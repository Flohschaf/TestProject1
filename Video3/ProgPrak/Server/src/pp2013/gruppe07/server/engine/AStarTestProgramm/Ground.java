package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

abstract class Ground {
	public static enum Groundtype {
		GRASS, JUNGLEPATH, SAND, STONE, WALLGROUND, WATER
	}

	protected int Position[];
	protected Image IMAGE;
	protected Image IMAGE2;

	protected final Groundtype TYPE;

	public Ground(int x, int y, Groundtype type2) {

		this.Position = new int[2];
		this.Position[0] = x;
		this.Position[1] = y;
		this.TYPE = type2;
	}

	public int[] getPosition() {
		return this.Position;
	}

	public Groundtype getTYPE() {
		return TYPE;
	}

	public abstract void paint(Graphics g, JComponent jComp, int position[]);

	public abstract void paintfog(Graphics g, JComponent jComp, int position[]);

}
