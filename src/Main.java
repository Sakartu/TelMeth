
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongMeter lm = new LongMeter();
		LightSensor ls = new LightSensor();
		ls.setReadout(lm.getReadout());
		lm.registerSensor(ls);
		lm.run();
	}

}
