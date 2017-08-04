package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.RoomTemperatureSetEvent;
import manager.refrigerator.FreezerTemperatureSetManager;
import manager.refrigerator.RoomTemperatureSetManager;

public class SetFreezerButton extends GUIButton {

	public SetFreezerButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FreezerTemperatureSetManager.instance()
		.processEvent(new FreezerTemperatureSetEvent(source));
	}

}
