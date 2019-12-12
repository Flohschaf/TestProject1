package pp2013.gruppe07.server.engine.eventmanager_and_serverevents;

import pp2013.gruppe07.server.comm.Communication;
import pp2013.gruppe07.server.comm.Waiter;
import pp2013.gruppe07.server.engine.general.GameLogic;
import pp2013.gruppe07.server.engine.threads_and_KI.MoveThread;
import pp2013.gruppe07.shared.Tile;
import pp2013.gruppe07.shared.entity.Figure;
import pp2013.gruppe07.shared.entity.SpaceHolder;
import pp2013.gruppe07.shared.eventManager.event.ServerToClient.MoveUpdateEvent;

/**
 * Geht EINEN Schritt
 * 
 * @author Sven
 **/
public class StepEvent extends GameEvent {

	private Tile destTile;
	private Figure figure;
	private MoveThread mover;

	/**
	 * @param administration
	 * @param destTile
	 * @param mover
	 * @author Sven
	 */
	public StepEvent(GameLogic administration, Tile destTile, MoveThread mover) {
		super(administration);
		this.destTile = destTile;
		this.mover = mover;
		this.figure = mover.get_figure();
	}

	/**
	 * Fuehre das Event aus und gib dem zugehoerigen MoveThread das Signal
	 * zurueck, dass der Step abgearbeitet wurde (auch wenn kein Schritt
	 * gegangen wurde).
	 * 
	 * @author Sven
	 */
	@Override
	void execute() {
		// Bestimme die aktuelle Kachel
		Tile currentTile = administration.get_map()[figure.getPosition()[0]][figure
				.getPosition()[1]];

		// Wenn die naechste Kachel frei ist, die Figur noch lebt und die
		// Bewegung noch aktuell ist
		if (!destTile.isCurrentlyBlocked() && mover.get_figure().isAlive()
				&& mover.isRunning()) {
			int newDirection = figure.getdirection();
			// Blickrichtung beim Gehen
			if (figure.getPosition()[0] - destTile.get_x() < 0) {
				newDirection = 2;
				figure.setdirection(newDirection);
			} else {
				if (figure.getPosition()[0] - destTile.get_x() > 0) {
					newDirection = 1;
					figure.setdirection(newDirection);
				}
			}

			// Bewege die Figur und gebe die Nachricht an den MoveThread, dass
			// der Schritt erfolgreich war.
			figure.move(destTile);
			mover.stepDone();

			// Aendere das Entity der neuen Kachel
			currentTile.setobject(new SpaceHolder(currentTile.get_x(),
					currentTile.get_y()));
			destTile.setobject(figure);

			// Schicke eine Nachricht an die Clients
			int[] newPos = { destTile.get_x(), destTile.get_y() };
			for (int j = 0; j < Waiter.getClients().size(); j++) {
				Communication.newClientMessage(new MoveUpdateEvent(Waiter
						.getClients().get(j).getId(), figure.getID(), newPos,
						newDirection));
			}
		}

		// Sende Signal an den MoverThread, dass die der Step abgearbeitet wurde
		// und somit der Thread
		// seine Arbeit wieder aufnehmen soll.
		mover.getStepLock().lock();
		mover.getStepCondition().signal();
		mover.getStepLock().unlock();
	}

}
