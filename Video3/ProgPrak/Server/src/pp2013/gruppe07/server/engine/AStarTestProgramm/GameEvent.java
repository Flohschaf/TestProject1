package pp2013.gruppe07.server.engine.AStarTestProgramm;

abstract class GameEvent {

	protected static enum EventType {
		StepEvent, HitEvent, ShopEvent, CreateVasallEvent
	}

	protected EventType type;

	protected GameLogic administration;

	public GameEvent(EventType type, GameLogic administration) {
		this.type = type;
		this.administration = administration;
	}

	void execute() {
	}

	EventType getEventType() {
		return type;
	}

}
