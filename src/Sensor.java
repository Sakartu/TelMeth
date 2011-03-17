import javax.swing.JLabel;

public interface Sensor {

	/**
	 * A method used to set the current value of this Sensor
	 * @param v The new value for this Sensor
	 */
	public void setValue(int v);
	
	/**
	 * A method that should be called when the internal state (read: internal value)
	 * of this Sensor has changed.
	 * Override this method to perform calculations on old versus new values
	 * @param s The sensor the value comes from
	 * @param oldValue The old (previous) value of the Sensor
	 * @param newValue The new (current) value of the Sensor
	 */
	public void stateChanged (Sensor s, int oldValue, int newValue);
	
	/**
	 * A method to retrieve the number of Sensor peaks (shifts from high to low values)
	 * of this Sensor
	 * @return An integer representing the number of Sensor peaks
	 */
	public int getPeakCount();
	
	/**
	 * A method that calculates the volume, given the current peak count
	 * @return A double representing the number of litres of lung capacity
	 */
	public double getVolume();
	
	/**
	 * A method that should be called to start measurements (start peak detection)
	 * for this sensor
	 */
	public void startMeasuring();
	
	/**
	 * A method that should be called to stop measurements (stop peak detection)
	 * for this sensor
	 */	
	public void stopMeasuring();
	
	/**
	 * A method that provides this Sensor with a JLabel where it will write the number
	 * of peaks and the volume when done.
	 * @param f A JLabel to which this Sensor can write
	 */
	public void setReadout(JLabel f);
}
