import javax.swing.JTextField;


public class LightSensor implements Sensor {
	private int value = 0;
	private int count = 0;
	private boolean measuring = false;
	private JTextField readout;
	private static final int DIFF = 4;
	private static final int VOL_PER_COUNT = 3;
	
	
	public void stateChanged(Sensor s, int oldValue, int newValue) {
		if(Math.abs(newValue - oldValue) > DIFF && measuring){
			count++;
			this.readout.setText("" + count);
		}
	}
	
	public void setValue(int v) {
		int oldV;
		if (v != this.value) {
			oldV = this.value;
			this.value = v;
			stateChanged(this, oldV, this.value);
		}
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public void startMeasuring() {
		this.measuring = true;
		System.out.println("Start Pressed");
	}

	@Override
	public void stopMeasuring() {
		this.measuring = false;
		this.readout.setText("Vol: " + getVolume() + "l");
	}
	
	@Override
	public int getVolume(){
		return count * VOL_PER_COUNT;
	}

	@Override
	public void setReadout(JTextField readout) {
		this.readout = readout;
	}
}
