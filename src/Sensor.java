import javax.swing.JLabel;

public interface Sensor {

	public void setValue(int v);
	public void stateChanged (Sensor s, int oldValue, int newValue);
	public int getCount();
	public double getVolume();
	public void startMeasuring();
	public void stopMeasuring();
	public void setReadout(JLabel f);
}
