/**The purpose of this class is to model a television
*Your name and today’s date
*/

public class Television {
	// Manufacturer/Brand Name
	private final String MANUFACTURER;
	// Size of the television screen
	private final int SCREEN_SIZE;
	
	// Current power status: on/off
	private boolean powerOn;
	// Station that television is showing
	private int channel;
	// Number value representing loudness; 0 is mute
	private int volume;
	
	// The constructor has 2 fields assigned for constants and 3 other fields.
	public Television(String MANUFACTURER, int SCREEN_SIZE) {
		this.MANUFACTURER = MANUFACTURER;
		this.SCREEN_SIZE = SCREEN_SIZE;
		
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	/**
	   * @return int This returns the volume value of the instance variable.
	   */
	public int getVolume() {
		return volume;
	}
	
	 /**
	   * @return int This returns the channel or station number of the instance
	   * variable.
	   */
	public int getChannel() {
		return channel;
	}
	
	 /**
	   * @return String This returns the manufacturer/brand name of the instance
	   * variable.
	   */
	public String getManufacturer() {
		return MANUFACTURER;
	}
	
	   /**
	   * @return int This returns the size of the screen.
	   */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}
	
	/**
	 * @param chan This is given to the channel instance variable to change it.
	 */
	public void setChannel(int chan) {
		channel = chan;
	}
	
	/**
	* This method is used to change the powerOn instance variable from its current
	* true/false value to the opposite false/true value.
	*/
	public void power() {
		powerOn = !powerOn;
	}
	
	/**
	* This method is used to add 1 to the volume instance variable.
	*/
	public void increaseVolume() {
		++volume;
	}
	
	   /**
	   * This method is used to subtract 1 from the volume instance variable.
	   */
	public void decreaseVolume() {
		--volume;
	}
}
