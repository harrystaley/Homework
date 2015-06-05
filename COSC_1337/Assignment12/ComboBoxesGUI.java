import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ComboBoxesGUI extends JPanel {
	private JLabel lblName, lblDegree;
	private JTextField txtName;
	private JComboBox cboInfo;
	private String[] personalInfo = {"Doctorate", 
									"Master", "Bachelor"};
	private JLabel lblOutput;

	public ComboBoxesGUI()
	{
			// create a label that will
			// be used for display
		lblOutput = new JLabel("----------");
		
			// create labels and text
			// fields for name
		lblName = new JLabel("What is your name?");
		txtName = new JTextField(21);
		
		lblDegree = new JLabel("What kind of degree do yoiu want?");
		

			// create a combo box for degrees
		cboInfo = new JComboBox(personalInfo);
		cboInfo.addActionListener(new cboListener());
			// add all controls to panel
		add(lblName);
		add(txtName);
		add(lblDegree);
		add(cboInfo);
		add(lblOutput);
			// set up size and control of panel
	    setPreferredSize (new Dimension(325 , 125));
	    setBackground (Color.YELLOW);

	}	// end constructor ComboBoxesGUI
	
	private class cboListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			int selection;
			String output = "";
			
				// determine which combo box
				// was selected and act appropriately
			selection = cboInfo.getSelectedIndex();
			output = txtName.getText()+ ", ";
			switch(selection)
			{
			//Doctorate
			case 0: output += " going for the top "+
					"degree I see: " +
					personalInfo[selection];
			break;
			//Master
			case 1: output += " good decision that "+
					"you are doing this: " +
					personalInfo[selection];
			break;
			//Bachelor
			case 2: output += " go and get that  "+
					"degree now: " +
					personalInfo[selection];
			break;
			default: output += "ERROR Unkown Degree";
			
			}
    	  	// display this label!
    	  lblOutput.setText(output);
		}   // end method actionPerfomed
		
	}   // end class cboListener


}	// end class ComboBoxesGUI
