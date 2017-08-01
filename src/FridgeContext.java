
public class FridgeContext {
	
	private static RefrigeratorDisplay refrigeratorDisplay;
	private FridgeState currentState;
	private static FridgeContext instance;
	
	private FridgeContext() {
		instance = this;
		refrigeratorDisplay.instance();
		currentState = FridgeClosedState.instance();
	}
	
	public static FridgeContext instance() {
		if (instance == null) {
			instance = new FridgeContext();
		}
		return instance;
	}
	
	public void initialize() {
		instance.changeCurrentState(FridgeClosedState.instance());
	}
	
	public void changeCurrentState(FridgeState nextState) {
		currentState.leave();
		currentState = nextState;
		nextState.run();
	}
	
	public RefrigeratorDisplay getDisplay() {
		return refrigeratorDisplay;
	}

}