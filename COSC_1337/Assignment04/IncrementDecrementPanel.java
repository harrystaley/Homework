import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class IncrementDecrementPanel extends JPanel
{
		//	declare constant to be used in program
	private int INITIAL_NUMBER = 50;

   		// declare variables/controls to
   		// be used in program
 private JLabel numberLabel;
 private JButton IncButton, decButton;
 private int number;

   public IncrementDecrementPanel()
   {
      number = INITIAL_NUMBER;

		// create a label showing the number
      numberLabel = new JLabel (String.valueOf(number));

      	// create two buttons and associate
      	// their respective listeners
      IncButton = new JButton("Increment");
      IncButton.addActionListener(new IncListener());

      decButton = new JButton("Decrement");
      decButton.addActionListener(new DecListener());
      
      	// add controls to panel
      add(decButton);
      add(numberLabel);
      add(IncButton);

      	// set up size and color of panel
      setPreferredSize(new Dimension(250, 50));
      setBackground(Color.YELLOW);
   }	// end constructor IncrementDecrementPanel


   private class IncListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
    	  	// increment number and display it
         numberLabel.setText(Integer.toString(++number));
      }
   }	// end class IncListener

   
   private class DecListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
    	  	// decrement number and display it
    	  numberLabel.setText(Integer.toString(--number));
      }
   }	// end class DecListener
}   // end class IncrementDecrementPanel
