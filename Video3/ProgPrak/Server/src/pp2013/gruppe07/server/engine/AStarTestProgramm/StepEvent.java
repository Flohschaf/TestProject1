package pp2013.gruppe07.server.engine.AStarTestProgramm;

class StepEvent extends GameEvent {

	private Tile destTile;
	private Figure figure;
	private MoveThread mover;

	public StepEvent(GameLogic administration, Tile destTile, MoveThread mover) {
		super(EventType.StepEvent, administration);
		this.destTile = destTile;
		this.mover = mover;
		this.figure = mover.get_figure();
	}

	@Override
	void execute() {
		Tile currentTile = administration.get_map()[figure.getPosition()[0]][figure
				.getPosition()[1]];

		// Wenn die naechste Kachel frei ist.
		if (!destTile.isCurrentlyBlocked() && mover.get_figure().isAlive()) {
			// Blickrichtung beim Gehen
			if (figure.getPosition()[0] - destTile.get_x() < 0) {
				figure.setdirection(2);
			} else {
				if (figure.getPosition()[0] - destTile.get_x() > 0) {
					figure.setdirection(1);
				}
			}
			figure.move(destTile);
			mover.stepDone();

			// Aendere die Entity der neuen Kachel
			currentTile.setobject(new SpaceHolder(currentTile.get_x(),
					currentTile.get_y()));
			destTile.setobject(figure);
		}

		// Sende Signal an den MoverThread, dass die der Step abgearbeitet wurde
		// und somit der Thread
		// seine Arbeit wieder aufnehmen soll.
		mover.getStepLock().lock();
		mover.getStepCondition().signal();
		mover.getStepLock().unlock();
	}

}
