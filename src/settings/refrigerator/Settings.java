package settings.refrigerator;
//Base class for both freezer and fridge and initializes variables being used in them.
public abstract class Settings {
	
	private int lowTemp;
	private int highTemp;
	private int roomLow;
	private int roomHigh;
	private int rateLossDoorClosed;
	private int rateLossDoorOpen;
	private int compressorStartDiff;
	private int coolRate;
	private boolean setParameters = false;
	
	protected int desiredRoomTemp;
	protected int desiredRefrigeratorTemp;
	protected int currentTemperature;
	
	public void setInstance(int lowTemp, int highTemp, int roomLow, int roomHigh, 
			int rateLossDoorClosed, int rateLossDoorOpen, int compressorStartDiff, int coolRate, int currentTemperature) {
		if (!setParameters) {
			
			this.lowTemp = lowTemp;
			this.highTemp = highTemp;
			this.roomLow = roomLow;
			this.roomHigh = roomHigh;
			this.rateLossDoorClosed = rateLossDoorClosed;
			this.rateLossDoorOpen = rateLossDoorOpen;
			this.compressorStartDiff = compressorStartDiff;
			this.coolRate = coolRate;
			this.currentTemperature = currentTemperature;
			setParameters = true;
		}
		
	}
	
	public int getDesiredRoomTemp() {
		return desiredRoomTemp;
	}
	
	public abstract void setDesiredRoomTemp(int desiredRoomTemp);
	
	public abstract void setDesiredRefrigeratorTemp(int desiredRefrigeratorTemp);
	
	public abstract void setCurrentTemp(int currentTemperature);
	
	public int getDesiredRefrigeratorTemp() {
		return desiredRefrigeratorTemp;
	}
	
	public int getLowTemp() {
		return lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public int getRoomLow() {
		return roomLow;
	}
	public int getRoomHigh() {
		return roomHigh;
	}
	public int getRateLossDoorClosed() {
		return rateLossDoorClosed;
	}
	public int getRateLossDoorOpen() {
		return rateLossDoorOpen;
	}
	public int getCompressorStartDiff() {
		return compressorStartDiff;
	}
	public int getCoolRate() {
		return coolRate;
	}
	public int getCurrentTemp() {
		return currentTemperature;
	}

}
