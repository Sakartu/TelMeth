import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LongMeter {
	private static int MAX_RUNS = 300;
	private static int BASE_RUNS = 100;
	private static int MAX_SENSOR_VALUE = 5;
	private Vector<Sensor> sensors;
	private int nrSensors;
	JLabel readout = new JLabel();
	Button startButton = new Button("Start");
	Button stopButton = new Button("Calc Volume");

	public LongMeter() {
		sensors = new Vector<Sensor>();
		nrSensors = 0;
	}

	public void registerSensor(final Sensor s) {
		sensors.add(s);
		nrSensors++;
		startButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				stopButton.setEnabled(false);
				System.out.println("Starting measurement");
				s.startMeasuring();
				blow();
				
			}

		});
		stopButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				stopButton.setEnabled(false);
				System.out.println("Calculating Volume...");
				s.stopMeasuring();
			}

		});		
	}

	private void setSensorValue(int s, int value) {
		try{
			Thread.sleep(1); //for some reason, java messes up if we don't stall it a bit 
		} catch(Exception e){

		}
		sensors.get(s).setValue(value);
	}

	private void initGUI() {
		JFrame frame = new JFrame("LongMeter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container panel = frame.getContentPane();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.ipadx = 300;
		gbc.ipady = 30;
		gbc.gridwidth = 2;

		readout.setOpaque(true);
		readout.setText("0");
		readout.setForeground(Color.GREEN);
		readout.setBackground(Color.BLACK);
		readout.setHorizontalAlignment(JTextField.CENTER);
		Font f = new Font("Verdana", Font.PLAIN, 32);
		readout.setFont(f);
		panel.add(readout, gbc);

		gbc.gridwidth = 1;
		gbc.ipadx = 0;
		gbc.ipady = 0;
		gbc.gridy = 1;
		panel.add(startButton, gbc);
		gbc.gridx = 1;
		stopButton.setEnabled(false);
		panel.add(stopButton, gbc);
		panel.setVisible(true);

		frame.pack();
		frame.setVisible(true);
	}

	public JLabel getReadout(){
		return readout;
	}

	public void run() {
		initGUI();
	}

	private void blow() {
		int runs = BASE_RUNS + (int) (Math.random() * (MAX_RUNS - BASE_RUNS)); //add some random breath length
		System.out.println("Doing " + runs + " runs.");
		int currentRun = 0;
		while (currentRun < runs) {
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, 0);
			setSensorValue(0, (int) (Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (1 + Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (1 + Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (1 + Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (1 + Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (Math.random() * MAX_SENSOR_VALUE));
			setSensorValue(0, (int) (Math.random() * MAX_SENSOR_VALUE));
			currentRun++;
		}
		System.out.println("Done");
		stopButton.setEnabled(true);
		startButton.setEnabled(true);
	}	
}
