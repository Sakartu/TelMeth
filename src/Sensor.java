import javax.swing.JTextField;

public interface Sensor {

	public void setValue(int v);
	public void stateChanged (Sensor s, int oldValue, int newValue);
	public int getCount();
	public int getVolume();
	public void startMeasuring();
	public void stopMeasuring();
	public void setReadout(JTextField f);
}
