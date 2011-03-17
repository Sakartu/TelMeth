import java.text.DecimalFormat;

import javax.swing.JLabel;


public class LightSensor implements Sensor {
	private int value = 0;
	private int count = 0;
	private boolean measuring = false;
	private JLabel readout;
	private static final int DIFF = 4;
	private static final double VOL_PER_COUNT = 0.2;


	public void stateChanged(Sensor s, int oldValue, int newValue) {
		if(Math.abs(newValue - oldValue) > DIFF && measuring){
			count++;
			showText("Turns: " + count);
		}
	}

	public void setValue(int v) {
		int oldV = this.value;
		this.value = v;
		stateChanged(this, oldV, this.value);
	}

	@Override
	public int getPeakCount() {
		return count;
	}

	@Override
	public void startMeasuring() {
		this.count = 0;
		showText("Turns: 0");
		this.measuring = true;
	}

	@Override
	public void stopMeasuring() {
		this.measuring = false;
		showText("Vol: " + roundTwoDec(getVolume()) + "l");
		this.count = 0;
	}

	@Override
	public double getVolume(){
		return count * VOL_PER_COUNT;
	}

	@Override
	public void setReadout(JLabel readout) {
		this.readout = readout;
	}

	private void showText(String line){
		this.readout.setText(line);
		this.readout.paintImmediately(this.readout.getVisibleRect());		
	}

	private double roundTwoDec(double in){
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(in));

	}

}
