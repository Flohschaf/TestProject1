package pp2013.gruppe07.server.engine.AStarTestProgramm;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

abstract class Entity {

	public static enum Category {
		FIGURE, BUILDING, NATURE, SPACE_HOLDER, SPACE_HOLDER_FOR_BUILDING;
	}

	public static enum Type {
		BOSS, CAPTAIN_OBVIOUS, CLIT_COMANDER, DANGER_DAN, FAMOUS_FLORIAN, FEDERAL_FELIX, GENERAL_HATE, HERO, INHIBITOR, MADNESS_MARC, NEXUS, OVERPOWERED_ONUR, SAFETY_STEVEN, SERIOUS_SVEN, SHOP, SPACE_HOLDER, TOWER, TREE, WALL, VASALL, SPACE_HOLDER_FOR_BUILDING;
	}

	protected int Position[];
	protected Image IMAGE;
	protected Type type;
	protected Category category;
	protected Image IMAGE2;

	protected Image IMAGE3;

	protected Image IMAGE4;

	// categorie ist die erste Unterklasse, also: "Figure" oder "Building". type
	// ist der genaue Typ, also:
	// "Vasall" oder "SafetySteven"(immer des Klassenname und beim Typ so
	// speziell wie moeglich).
	public Entity(int x, int y, Type type, Category category) {
		this.Position = new int[2];
		this.Position[0] = x;
		this.Position[1] = y;
		this.type = type;
		this.category = category;

	}

	public Category getCategory() {
		return this.category;
	}

	public int[] getPosition() {
		return this.Position;
	}

	public Type getType() {
		return this.type;
	}

	public abstract void paint(Graphics g, JComponent jComp, int position[]);

	public void paintHeroImage(Graphics g, JComponent jComp, int[] position) {

	}

	public void paintHeroImageMini(Graphics g, JComponent jComp, int[] position) {

	}

	public void setPosition(int x, int y) {
		Position[0] = x;
		Position[1] = y;
	}

}
