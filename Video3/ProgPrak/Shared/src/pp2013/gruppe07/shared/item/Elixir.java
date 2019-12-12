package pp2013.gruppe07.shared.item;

import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * @author Daniel
 *Ist ein Trank.
 */
public class Elixir extends Potion {

	private final int INCREASE_LIFE=50;
	
	public Elixir(int cost) {
		super(cost);
		// TODO Auto-generated constructor stub
	}

	public int getINCREASE_LIFE() {
		return INCREASE_LIFE;
	}

	
	
}
