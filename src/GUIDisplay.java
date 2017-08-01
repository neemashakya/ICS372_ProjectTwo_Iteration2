import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This GUI class implements the RefrigeratorDisplay interface
 */
public class GUIDisplay extends RefrigeratorDisplay implements ActionListener{

	public static SimpleDisplay frame;

	/**
	 * Do the usual layout of the frame
	 */
	private GUIDisplay() {
		frame = new SimpleDisplay();
		initialize();
	}
		
	private class SimpleDisplay extends JFrame {
		
		private GUIButton fridgeDoorOpener = new FridgeOpenButton("Open fridge door");
		private GUIButton fridgeDoorCloser = new FridgeCloseButton("Close fridge door");
		private GUIButton freezerDoorOpener = new FreezerOpenButton("Open freezer door");
		private GUIButton freezerDoorCloser = new FreezerCloseButton("Close freezer door");
		private GUIButton setRoomTemp = new SetRoomButton("Set room temp");
		private GUIButton setFridgeTemp = new SetFridgeButton("Set desired fridge temp");
		private GUIButton setFreezerTemp = new SetFreezerButton("Set desired freezer temp");
		
		private JTextField inRoomTemp = new JTextField(10);
		private JTextField inFridgeTemp = new JTextField(10);
		private JTextField inFreezerTemp = new JTextField(10);
		
		private JLabel roomTemp = new JLabel("Room temp");
		private JLabel desiredFridgeTemp = new JLabel("Desired fridge temp");
		private JLabel desiredFreezerTemp = new JLabel("Desired freezer temp");
		private JLabel status = new JLabel("Status");
		private JLabel fridgeLight = new JLabel("Fridge light <on/off>");
		private JLabel freezerLight = new JLabel("Freezer light <on/off>");
		private JLabel fridgeTemp = new JLabel("Fridge temp: ");
		private JLabel freezerTemp = new JLabel("Freezer temp: ");
		private JLabel fridgeState = new JLabel("Fridge <cooling/idle>");
		private JLabel freezerState = new JLabel("Freezer <cooling/idle>");
		
		private SimpleDisplay() {
			super("Refrigerator");
			getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			
			JPanel temps = new JPanel(new GridLayout(0,3,20,20));
			temps.add(roomTemp);
			temps.add(inRoomTemp);
			temps.add(setRoomTemp);
			temps.add(desiredFridgeTemp);
			temps.add(inFridgeTemp);
			temps.add(setFridgeTemp);
			temps.add(desiredFreezerTemp);
			temps.add(inFreezerTemp);
			temps.add(setFreezerTemp);
			
			JPanel doors = new JPanel(new GridLayout(0,2,20,20));
			doors.add(fridgeDoorOpener);
			doors.add(fridgeDoorCloser);
			doors.add(freezerDoorOpener);
			doors.add(freezerDoorCloser);
			
			JPanel states = new JPanel(new GridLayout(0,2,20,20));
			states.add(fridgeLight);
			states.add(freezerLight);
			states.add(fridgeTemp);
			states.add(freezerTemp);
			states.add(fridgeState);
			states.add(freezerState);
			
			getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
			getContentPane().add(temps);	
			getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
			getContentPane().add(doors);
			getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
			getContentPane().add(states);	
			getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
			getContentPane().add(states);
			getContentPane().add(Box.createRigidArea(new Dimension(20,20)));

			setRoomTemp.addActionListener(GUIDisplay.this);
			setFridgeTemp.addActionListener(GUIDisplay.this);
			setFreezerTemp.addActionListener(GUIDisplay.this);
			fridgeDoorOpener.addActionListener(GUIDisplay.this);
			fridgeDoorCloser.addActionListener(GUIDisplay.this);
			freezerDoorOpener.addActionListener(GUIDisplay.this);
			freezerDoorCloser.addActionListener(GUIDisplay.this);

			pack();
			setLocationRelativeTo(null);//centers GUI display
			setVisible(true);
		}
	}
		

	/**
	 * Process the buttons 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		((GUIButton) event.getSource()).inform(this);
	}

	@Override
	public void turnFridgeLightOn() {
		frame.fridgeLight.setText("Fridge light <ON>");
	}

	@Override
	public void turnFridgeLightOff() {
		frame.fridgeLight.setText("Fridge light <OFF>");
	}

	@Override
	public void turnFreezerLightOn() {
		frame.freezerLight.setText("Freezer light <ON>");	
	}

	@Override
	public void turnFreezerLightOff() {
		frame.freezerLight.setText("Freezer light <OFF>");
	}

	@Override
	public void fridgeCooling() {
		frame.fridgeState.setText("Fridge <COOLING>");
	}

	@Override
	public void fridgeIdle() {
		frame.fridgeState.setText("Fridge <IDLE>");
	}

	@Override
	public void freezerCooling() {
		frame.freezerState.setText("Freezer <COOLING>");
	}

	@Override
	public void freezerIdle() {
		frame.freezerState.setText("Freezer <IDLE>");
	}

	@Override
	public void fridgeTemp() {
		//frame.fridgeTemp.setText("Fridge temp: " + value);
	}

	@Override
	public void freezerTemp() {
		//frame.freezerTemp.setText("Freezer temp: " + value);
	}

	/**
	 * Function to select a file with JFileChooser
	 * <p>
	 * <b>Precondition:</b>
	 * File is available on drive.
	 * <b>PostCondition:</b>
	 * a file of configuration values is selected.
	 * </p>
	 *
	 * @return returns the given selected file of values
	 * that was choose by the user.
	 */
	public static String chooseFile() {

		JFileChooser chooser;
		String fileName;
		FileNameExtensionFilter filter;
		int selection;

		fileName = null;
		chooser = new JFileChooser();
		filter = new FileNameExtensionFilter("Text Files", "dat", "txt");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new File("."));//sets current directory
		selection = chooser.showOpenDialog(null);

		if (selection == JFileChooser.APPROVE_OPTION)
			fileName = chooser.getSelectedFile().getAbsolutePath();

		return (fileName);
	}


	public static void main (String args[]) {
//        int i;
//        String iFile;
//
//        iFile = chooseFile();
//        if (iFile != null) {
//            i = iFile.lastIndexOf('.');
//            if (i >= 0){
//                ReadConfigurationFromFile(configFile);
//            }
//        }

		RefrigeratorDisplay display = new GUIDisplay();
	}
}
