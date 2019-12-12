package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Graphics;

import javax.swing.JComponent;

class SpaceHolder extends Entity {

	public SpaceHolder(int x, int y) {

		super(x, y, Entity.Type.SPACE_HOLDER, Entity.Category.SPACE_HOLDER);

	}

	@Override
	public void paint(Graphics g, JComponent jComp, int[] position) {

	}

}
