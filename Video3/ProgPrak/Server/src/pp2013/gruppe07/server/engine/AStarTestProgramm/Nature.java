package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Graphics;

import javax.swing.JComponent;

abstract class Nature extends Entity {

	public Nature(int x, int y, Type type) {
		super(x, y, type, Category.NATURE);

	}

	@Override
	public void paint(Graphics g, JComponent jComp, int position[]) {
	}

}
