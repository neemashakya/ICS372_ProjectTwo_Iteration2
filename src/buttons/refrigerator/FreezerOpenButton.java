package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerDoorOpenRequestEvent;
import manager.refrigerator.FreezerOpenDoorRequestManager;

//this class derives from the GUI button super class and handles Freezer open button events.
public class FreezerOpenButton extends GUIButton {

	public FreezerOpenButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FreezerOpenDoorRequestManager.instance()
		.processEvent(new FreezerDoorOpenRequestEvent(source));

	}

}
