import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class NumericKeypadPanel extends JPanel
{
		// declare variables/controls to
		// be used in program
   private JPanel keyPanel, clearPanel;
   private JLabel displayLabel;

   public NumericKeypadPanel()
   {
	   	// set type of border to
	   	// be used (BoderLayout)
	   setLayout(new BorderLayout());
	   
	   displayLabel = new JLabel(" ");
	   displayLabel.setBackground(Color.WHITE);
	   displayLabel.setBorder(new BevelBorder (BevelBorder.LOWERED));
	   add (displayLabel, BorderLayout.NORTH);
	   
	   	// create the panel to hold the keys
	   	// use a GridLayout of 4, 3
	   keyPanel = new JPanel();
	   keyPanel.setLayout(new GridLayout(4,3));
	   keyPanel.setBorder(new LineBorder(Color.BLACK, 4));
	   
      	// create the buttons and add to the keyPanel
      	// and associate their respective listeners
      	// buttons will be 0 thru 9, '*', '#',
      	// and a clear button

      JButton button1, button2, button3;
      JButton button4, button5, button6;
      JButton button7, button8, button9;
      JButton button0, buttonAst, buttonPnd;
      JButton buttonC;
      KeyListener displayKey = new KeyListener();

      button1 = new JButton("1");
      button1.setMnemonic('1');
      button1.addActionListener(displayKey);
      keyPanel.add(button1);

      button2 = new JButton("2");
      button2.setMnemonic('2');
      button2.addActionListener(displayKey);
      keyPanel.add(button2);
      
      button3 = new JButton("3");
      button3.setMnemonic('3');
      button3.addActionListener(displayKey);
      keyPanel.add(button3);
      
      button4 = new JButton("4");
      button4.setMnemonic('4');
      button4.addActionListener(displayKey);
      keyPanel.add(button4);
      
      button5 = new JButton("5");
      button5.setMnemonic('5');
      button5.addActionListener(displayKey);
      keyPanel.add(button5);
      
      button6 = new JButton("6");
      button6.setMnemonic('6');
      button6.addActionListener(displayKey);
      keyPanel.add(button6);
      
      button7 = new JButton("7");
      button7.setMnemonic('7');
      button7.addActionListener(displayKey);
      keyPanel.add(button7);
      
      button8 = new JButton("8");
      button8.setMnemonic('8');
      button8.addActionListener(displayKey);
      keyPanel.add(button8);
      
      button9 = new JButton("9");
      button9.setMnemonic('9');
      button9.addActionListener(displayKey);
      keyPanel.add(button9);
      
      buttonAst = new JButton("*");
      buttonAst.setMnemonic('*');
      buttonAst.addActionListener(displayKey);
      keyPanel.add(buttonAst);
      
      button0 = new JButton("0");
      button0.setMnemonic('0');
      button0.addActionListener(displayKey);
      keyPanel.add(button0);
      
      buttonPnd = new JButton("#");
      buttonPnd.setMnemonic('#');
      buttonPnd.addActionListener(displayKey);
      keyPanel.add(buttonPnd);
     
      	// add panel in the Center
      add(keyPanel, BorderLayout.CENTER);
      
      buttonC = new JButton();
      buttonC.setText("Clear");
      buttonC.setMnemonic('C');
      buttonC.setToolTipText("Clear");
      buttonC.addActionListener(new ClearListener());
      keyPanel.add(buttonC);
      
      add (buttonC, BorderLayout.SOUTH);
      
		// set up size of panel
      setPreferredSize(new Dimension(250, 250));
      
   }	// end constructor NumericKeypadPanel

   private class KeyListener implements ActionListener
   {
      
      public void actionPerformed(ActionEvent event)
      {
    	  	// display number
         JButton source = (JButton)event.getSource();
         displayLabel.setText(displayLabel.getText() + 
        		 source.getText());
      }
   }	// end class KeyListener

   private class ClearListener implements ActionListener
   {
 
      public void actionPerformed(ActionEvent event)
      {
    	  	// clear display
    	  displayLabel.setText(" ");
    	  
      }
   }	// end class ClearListener
}	// end class NumericKeypadPanel
