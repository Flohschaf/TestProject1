package pp2013.gruppe07.client.gui.daniel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import javax.swing.JPanel;

import pp2013.gruppe07.client.gui.Frame;
import pp2013.gruppe07.client.gui.Images;
import pp2013.gruppe07.client.gui.World;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Building;
import pp2013.gruppe07.shared.entity.Entity;
import pp2013.gruppe07.shared.entity.Hero;
import pp2013.gruppe07.shared.entity.InteraktiveEntity.Team;
import pp2013.gruppe07.shared.entity.Monster;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.entity.Vasall;
import pp2013.gruppe07.shared.ground.Ground;
import pp2013.gruppe07.shared.ground.Sand;

/**
 * 
 * @author Daniel Diese Klasse erstellt die MiniMap
 */

public class LoLminimap extends JPanel {

	private Tile[][] MAP = new Tile[140][140];

	private boolean FollowHero;

	private World world;
	Frame frame;
	private boolean Fog = true;

	public LoLminimap(Tile[][] map, boolean followHero, Frame frame, World world) {
		super.setSize(40, 40);
		this.frame = frame;
		this.setVisible(true);
		FollowHero = followHero;
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		this.world = world;

		for (int i = 0; i < 140; i++) {
			for (int j = 0; j < 140; j++) {
				MAP[i][j] = new Tile(new SpaceHolder(1, 1), new Sand(1, 1), i,
						j);
			}
		}

		MAP = map;
		// paint();

	}

	/**
	 * 
	 * @author Daniel Diese Methode dient der Bestimmung ob die Ansicht dem
	 *         Helden folgt oder nicht.
	 * */
	public void setfollowhero(boolean follow) {
		FollowHero = follow;

	}

	public void paint(Graphics g) {

		MAP = world.getMap();

		// Graphics g = this.getGraphics();
		for (int i = 20; i < MAP.length - 20; i++) {
			for (int j = 20; j < MAP[0].length - 20; j++) {
				Ground ground = MAP[i][j].getground();

				int[] position = { i - 20, j - 20 };
				if (Fog) {// hier wird der Grund gemalt, entweder vernebelt oder
							// klassisch
					if (frame.getGlobalBackground().getLoLFrame().getfog()[i][j] != 2)
						g.drawImage(Images.grounds.get(ground.getTYPE())[1],
								position[0], position[1], this);

					else
						g.drawImage(Images.grounds.get(ground.getTYPE())[0],
								position[0], position[1], this);
				} else
					g.drawImage(Images.grounds.get(ground.getTYPE())[0],
							position[0], position[1], this);

			}
		}
		for (int i = 20; i < MAP.length - 20; i++) {
			for (int j = 20; j < MAP[0].length - 20; j++) {

				Entity entity = MAP[i][j].getobject();
				int[] position = { i - 20, j - 20 };
				if (Fog) {// hier werden die Objekte, bzw Hinweiser fuer die
							// Objekte gemalt, bzw nicht gemalt, je nach Nebel
							// Einstellungen
					if ((MAP[i][j].getobject() instanceof Building)
							|| (frame.getGlobalBackground().getLoLFrame()
									.getfog()[i][j] == 2)) {
						if (entity instanceof Hero) {
							if (((Hero) entity).getTeam().equals(Team.BLUE))
								g.setColor(Color.blue);
							if (((Hero) entity).getTeam().equals(Team.RED))
								g.setColor(Color.red);
							g.fillOval(position[0], position[1], 4, 4);

						}
						if (entity instanceof Vasall) {
							if (((Vasall) entity).getTeam().equals(Team.BLUE))
								g.setColor(Color.blue);
							if (((Vasall) entity).getTeam().equals(Team.RED))
								g.setColor(Color.red);
							g.fillOval(position[0], position[1], 2, 2);

						}
						if (entity instanceof Building) {
							if (((Building) entity).getTeam().equals(Team.BLUE))
								g.setColor(Color.blue);
							if (((Building) entity).getTeam().equals(Team.RED))
								g.setColor(Color.red);
							g.fillOval(position[0] - 1, position[1] - 1, 3, 3);

						}
						if (entity instanceof Monster) {
							g.setColor(Color.BLACK);
							g.fillOval(position[0], position[1], 2, 2);

						}

					}

				} else {
					if (entity instanceof Hero) {
						if (((Hero) entity).getTeam().equals(Team.BLUE))
							g.setColor(Color.blue);
						if (((Hero) entity).getTeam().equals(Team.RED))
							g.setColor(Color.red);
						g.fillOval(position[0], position[1], 4, 4);

					}
					if (entity instanceof Vasall) {
						if (((Vasall) entity).getTeam().equals(Team.BLUE))
							g.setColor(Color.blue);
						if (((Vasall) entity).getTeam().equals(Team.RED))
							g.setColor(Color.red);
						g.fillOval(position[0], position[1], 2, 2);

					}
					if (entity instanceof Building) {
						if (((Building) entity).getTeam().equals(Team.BLUE))
							g.setColor(Color.blue);
						if (((Building) entity).getTeam().equals(Team.RED))
							g.setColor(Color.red);
						g.fillOval(position[0] - 1, position[1] - 1, 3, 3);

					}
					if (entity instanceof Monster) {
						g.setColor(Color.BLACK);
						g.fillOval(position[0], position[1], 2, 2);

					}

				}
			}

		}

		// hier wird der weisse Rahmen gezeichnet der anzeigt wo sich die
		// Ansicht befindet.
		if (FollowHero) {
			int xparameter = 8, yparameter = 8;
			for (int j = 0; j < 8; j++) {

				if (((Hero) world.getEntities().get(
						world.getClientAdmin().getClientHero().getID()))
						.getPosition()[0] - j > 0)
					xparameter = j;
			}
			for (int j = 0; j < 6; j++) {
				if (((Hero) world.getEntities().get(
						world.getClientAdmin().getClientHero().getID()))
						.getPosition()[1] - j > 0)
					yparameter = j;

			}
			for (int i = ((Hero) world.getEntities().get(
					world.getClientAdmin().getClientHero().getID()))
					.getPosition()[0] - xparameter; i < ((Hero) world
					.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
					.getPosition()[0]
					+ 24 - xparameter; i++) {

				g.setColor(Color.white);

				g.fillRect(
						i - 20,
						((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getPosition()[1] - yparameter - 20, 1, 1);
				g.fillRect(
						i - 20,
						((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getPosition()[1] + 14 - yparameter - 20, 1, 1);
			}
			for (int j = ((Hero) world.getEntities().get(
					world.getClientAdmin().getClientHero().getID()))
					.getPosition()[1] - yparameter; j < ((Hero) world
					.getEntities().get(
							world.getClientAdmin().getClientHero().getID()))
					.getPosition()[1]
					+ 15 - yparameter; j++) {
				g.setColor(Color.white);

				g.fillRect(
						((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getPosition()[0] - xparameter - 20, j - 20, 1,
						1);
				g.fillRect(
						((Hero) world.getEntities().get(
								world.getClientAdmin().getClientHero().getID()))
								.getPosition()[0] + 23 - xparameter - 20,
						j - 20, 1, 1);
			}
		} else {
			int x = frame.getGlobalBackground().getLoLFrame().moveviewxvalue();
			int y = frame.getGlobalBackground().getLoLFrame().moveviewyvalue();
			for (int i = x; i < x + 24; i++) {

				g.setColor(Color.white);

				g.fillRect(i - 20, y - 20, 1, 1);
				g.fillRect(i - 20, y + 14 - 20, 1, 1);
			}
			for (int j = y; j < y + 15; j++) {
				g.setColor(Color.white);

				g.fillRect(x - 20, j - 20, 1, 1);
				g.fillRect(x + 23 - 20, j - 20, 1, 1);
			}

		}

	}

	public void setfog(boolean fog) {
		this.Fog = fog;
	}
}
