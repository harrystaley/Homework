import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PizzaControls extends JPanel {
	private String output1, output2, output3;
	private Boolean gotName, gotStyle, gotSize;
	private Boolean gotLarge, gotMedium, gotSmall;
	private Boolean gotHandTossed, gotThin, gotDeepDish;
	private Boolean gotCheese, gotPepperoni, gotSausage, gotChicken;
	private Boolean gotMush, gotPine, gotOnion, gotGrPep;
	private Boolean completeOrder, transactionType;
	private JPanel pnlName, pnlPizza, pnlComplete, pnlAllToppings;
	private JPanel pnlToppings1, pnlToppings2, pnlOrder;
	private JPanel pnlExit, pnlOrderExit;
	private JPanel pnlTrans, pnlNameAndPizza, pnlColOne, pnlColTwo;
	private JPanel pnlBothCol, pnlMoney, pnlPaid, pnlChange;
	private JLabel lblName, lblOrder1, lblOrder2, lblOrder3, lblCost;
	private JLabel lblPaid;
	private JTextField txtName, txtPaid, txtChange;
	private JComboBox cboPizzaSize, cboPizzaStyle;
	private Border border1, border2;
	private String[] pizzaSize = {"Large", "Medium", "Small"};
	private String[] pizzaStyle = {"Hand Tossed", "Thin",
									"Deep Dish"};
	private JButton btnComplete, btnChange;
	private JButton btnExit;
	private JCheckBox cbxCheese, cbxPepperoni, cbxSausage, cbxChicken;
	private JCheckBox cbxMush, cbxPine, cbxOnion, cbxGrPep;
	private JRadioButton rbtCash, rbtCheck, rbtCard;
	
	DecimalFormat fmt = new DecimalFormat("00.00");
	NumberFormat fmt2 = NumberFormat.getCurrencyInstance();
	
	   // declare constants
	
	   // cost of size of pizza
	private final double LG_COST = 10.25;
	private final double MD_COST = 9.25;
	private final double SM_COST = 8.25;
	
	   // cost of style of pizza
	private final double HT_COST = 0.50;
	private final double TN_COST = 0.75;
	private final double DD_COST = 1.00;
	
	private final double CHEESE_COST = 1.00;
	private final double PEPPERONI_COST = 1.25;
	private final double SAUSAGE_COST = 1.50;
	private final double CHICKEN_COST = 1.75;
	
	private final double MUSHROOM_COST = 1.00;
	private final double PINEAPPLE_COST = 1.15;
	private final double ONION_COST = 1.25;
	private final double GREEN_PEPPER_COST = 1.40;
	
	private double totalCost;
	
	public PizzaControls()
	{
			// initialize variables appropriately
			// for beginning of program
		output1 = "";
		output2 = "";
		output3 = "";
		gotName = false;
		gotStyle = false;
		gotSize = false;
		totalCost = 0.0;
		
		gotCheese = gotPepperoni = gotSausage = gotChicken = false;
		gotMush = gotPine = gotOnion = gotGrPep = false;
		gotLarge = gotMedium = gotSmall = false;
		gotHandTossed = gotThin = gotDeepDish = false;
		completeOrder = false;
		transactionType = false;
		
		   // give our panel a 'BorderLayout' with appropriate
		   // dimensions and color
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(1000, 400));  //1000,375
		setBackground(Color.LIGHT_GRAY);
		
		//------------create labels------------
		lblName = new JLabel ("Enter a customer's name:");
		lblName.setFont(new Font("Helvetica", Font.PLAIN, 16));
		lblName.setForeground(Color.BLACK);
		//add(lblName, BorderLayout.EAST);
		
		   // labels for entire order
		lblOrder1 = new JLabel("");
		lblOrder1.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblOrder1.setForeground(Color.WHITE);
		lblOrder2 = new JLabel("");
		lblOrder2.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblOrder2.setForeground(Color.WHITE);
		lblOrder3 = new JLabel("");
		lblOrder3.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblOrder3.setForeground(Color.WHITE);
		
		  // label for total cost
		lblCost = new JLabel();
		lblCost.setText("Total Cost: $00.00");
		lblCost.setFont(new Font("Helvetica", Font.PLAIN, 18));
		lblCost.setForeground(Color.BLACK);
		
		   // label for paid 
		lblPaid = new JLabel("          Paid:          ");
		lblPaid.setFont(new Font("Helvetica", Font.PLAIN, 18));
		lblPaid.setForeground(Color.BLACK);
		
		//------------create text fields------------
		txtName = new JTextField(12);
		txtName.setFont(new Font("Helvetica", Font.PLAIN, 16));
		txtName.setForeground(Color.BLACK);
		
		   // add the action listener 'NameListener' to establish
		   // a relationship between the text field and
		   // the listener
		txtName.addActionListener(new NameListener());
		
		txtPaid = new JTextField(6);
		txtPaid.setFont(new Font("Helvetica", Font.PLAIN, 18));
		txtPaid.setForeground(Color.BLACK);
		
		txtChange = new JTextField(6);
		txtChange.setFont(new Font("Helvetica", Font.PLAIN, 18));
		txtChange.setForeground(Color.BLACK);
		
		//------------combo boxes-----------
		   // create a combo box for pizza sizes
		cboPizzaSize = new JComboBox(pizzaSize);
		cboPizzaSize.setBackground(Color.GREEN);
		cboPizzaSize.setForeground(Color.BLACK);
		cboPizzaSize.setFont(new Font("Helvetica", Font.BOLD, 16));
		cboPizzaSize.setAlignmentX(Component.CENTER_ALIGNMENT);
		cboPizzaSize.addActionListener(new PizzaSizeListener());
		
		   // create a combo box for pizza styles
		cboPizzaStyle = new JComboBox(pizzaStyle);
		cboPizzaStyle.setBackground(Color.GREEN);
		cboPizzaStyle.setForeground(Color.BLACK);
		cboPizzaStyle.setFont(new Font("Helvetica", Font.BOLD, 16));
		cboPizzaStyle.setAlignmentX(Component.CENTER_ALIGNMENT);
		cboPizzaStyle.addActionListener(new PizzaStyleListener());
		
		
		//------------check boxes------------
		   // topping 1
		cbxCheese = new JCheckBox("Cheese");
		cbxCheese.setBackground(Color.ORANGE);
		cbxCheese.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxPepperoni = new JCheckBox("Pepperoni");
		cbxPepperoni.setBackground(Color.ORANGE);
		cbxPepperoni.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxSausage = new JCheckBox("Sausage");
		cbxSausage.setBackground(Color.ORANGE);
		cbxSausage.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxChicken = new JCheckBox("Chicken");
		cbxChicken.setBackground(Color.ORANGE);
		cbxChicken.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxCheese.addItemListener(new Toppings1Listener());
		cbxPepperoni.addItemListener(new Toppings1Listener());
		cbxSausage.addItemListener(new Toppings1Listener());
		cbxChicken.addItemListener(new Toppings1Listener());
		
		   // topping 2
		cbxMush = new JCheckBox("Mushrooms");
		cbxMush.setBackground(Color.PINK);
		cbxMush.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxPine = new JCheckBox("Pineapple");
		cbxPine.setBackground(Color.PINK);
		cbxPine.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxOnion = new JCheckBox("Onion");
		cbxOnion.setBackground(Color.PINK);
		cbxOnion.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxGrPep = new JCheckBox("Green Peppers");
		cbxGrPep.setBackground(Color.PINK);
		cbxGrPep.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		cbxMush.addItemListener(new Toppings2Listener());
		cbxPine.addItemListener(new Toppings2Listener());
		cbxOnion.addItemListener(new Toppings2Listener());
		cbxGrPep.addItemListener(new Toppings2Listener());
		
		//------------create panels------------
		   // create a panel for label name and text field name
		pnlName = new JPanel();
		pnlName.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		pnlName.add(lblName);
		pnlName.add(txtName);
		
		   // create a panel for both combo boxes size and style
		pnlPizza = new JPanel();
		pnlPizza.setLayout(new BoxLayout(pnlPizza, BoxLayout.X_AXIS));
		pnlPizza.add(cboPizzaSize);
		pnlPizza.add(Box.createRigidArea(new Dimension(5,0)));
		pnlPizza.add(cboPizzaStyle);
		pnlPizza.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		
		   // create a panel for both panels above (name and pizza)
		pnlNameAndPizza = new JPanel();
		pnlNameAndPizza.setBackground(Color.RED);
		pnlNameAndPizza.setLayout(new BoxLayout(pnlNameAndPizza,
												BoxLayout.X_AXIS));
		pnlNameAndPizza.setAlignmentY(Component.CENTER_ALIGNMENT);
		pnlNameAndPizza.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		pnlNameAndPizza.add(pnlName);
		pnlNameAndPizza.add(Box.createRigidArea(new Dimension(5,0)));
		pnlNameAndPizza.add(pnlPizza);
		
		   // create a panel for our toppings 1
		pnlToppings1 = new JPanel();
		border1 = BorderFactory.createLineBorder(Color.WHITE, 3);
		border2 = BorderFactory.createTitledBorder("Toppings 1");
		pnlToppings1.setBorder(BorderFactory.createCompoundBorder(border1, border2));
		pnlToppings1.add(cbxCheese);
		pnlToppings1.add(cbxPepperoni);
		pnlToppings1.add(cbxSausage);
		pnlToppings1.add(cbxChicken);
		
		   // create a panel for our toppings 2
		pnlToppings2 = new JPanel();
		border1 = BorderFactory.createLineBorder(Color.WHITE, 3);
		border2 = BorderFactory.createTitledBorder("Toppings 2");
		pnlToppings2.setBorder(BorderFactory.createCompoundBorder(border1, border2));
		pnlToppings2.add(cbxMush);
		pnlToppings2.add(cbxPine);
		pnlToppings2.add(cbxOnion);
		pnlToppings2.add(cbxGrPep);
		
		   // create a panel to hold ALL of the toppings
		pnlAllToppings = new JPanel();
		pnlAllToppings.setLayout(new BoxLayout(pnlAllToppings, BoxLayout.Y_AXIS));
		pnlAllToppings.setBackground(Color.RED);
		pnlAllToppings.add(pnlToppings1);
		pnlAllToppings.add(Box.createRigidArea(new Dimension(0,5)));
		pnlAllToppings.add(pnlToppings2);
		
		   // create column panel to hold 'pnlNameAndPizza' and
		   // 'pnlAllToppings' panels
		pnlColOne = new JPanel();
		pnlColOne.setBackground(Color.LIGHT_GRAY);
		pnlColOne.setLayout(new BoxLayout(pnlColOne, BoxLayout.Y_AXIS));
		pnlColOne.add(pnlNameAndPizza);
		pnlColOne.add(Box.createRigidArea(new Dimension(0,20)));
		pnlColOne.add(pnlAllToppings);
		
		   //------------create radio buttons------------
		rbtCash = new JRadioButton("Cash", true);
		rbtCash.setBackground(Color.YELLOW);
		rbtCash.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		rbtCheck = new JRadioButton("Check");
		rbtCheck.setBackground(Color.YELLOW);
		rbtCheck.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		rbtCard = new JRadioButton("Card");
		rbtCard.setBackground(Color.YELLOW);
		rbtCard.setFont(new Font("Helvetica", Font.BOLD, 16));
		
		   // add the three radio buttons to the button
		   // group called 'group'.  NOTE:  'group' is 
		   // not a container, it is used to simply
		   // organize the buttons; we will still have to
		   // add each individual button to a panel
		   // (shown below)
		ButtonGroup group = new ButtonGroup();
		group.add(rbtCash);
		group.add(rbtCheck);
		group.add(rbtCard);
		
		pnlTrans = new JPanel();
		pnlTrans.setBackground(Color.CYAN);
		pnlTrans.setLayout(new BoxLayout(pnlTrans, BoxLayout.X_AXIS));
		pnlTrans.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		
		   // add radio buttons to this subpanel
		pnlTrans.add(rbtCash);
		pnlTrans.add(Box.createRigidArea(new Dimension(5,0)));
		pnlTrans.add(rbtCheck);
		pnlTrans.add(Box.createRigidArea(new Dimension(5,0)));
		pnlTrans.add(rbtCard);
		
		   // add listeners to our radio buttons
		rbtCash.addActionListener(new TransactionListener());
		rbtCheck.addActionListener(new TransactionListener());
		rbtCard.addActionListener(new TransactionListener());
		
		   //-----------create normal buttons------------
		btnComplete = new JButton("Order Complete");
		btnComplete.setBackground(Color.RED);
		btnComplete.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnComplete.setForeground(Color.WHITE);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnExit.setForeground(Color.WHITE);
		
		
		   // add this button to its subpanel
		pnlComplete = new JPanel();
		pnlComplete.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		pnlComplete.add(btnComplete);
		
		btnComplete.addActionListener(new CompleteListener());
		
		btnChange = new JButton("Change");
		btnChange.setBackground(Color.CYAN);
		btnChange.setFont(new Font("Helvetica", Font.BOLD, 18));
		btnChange.setForeground(Color.BLACK);
		
		   // add listener to our 'btnChange' button
		btnChange.addActionListener(new ChangeListener());
		
		
			// create remaining panels
		pnlMoney = new JPanel();
		pnlMoney.setLayout(new BoxLayout(pnlMoney, BoxLayout.Y_AXIS));
		pnlMoney.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		pnlMoney.add(lblCost);
		pnlMoney.add(Box.createRigidArea(new Dimension(0,10)));
		
		pnlPaid = new JPanel();
		pnlPaid.setLayout(new BoxLayout(pnlPaid, BoxLayout.X_AXIS));
		pnlPaid.add(lblPaid);
		pnlPaid.add(Box.createRigidArea(new Dimension(5,0)));
		pnlPaid.add(txtPaid);
	
		pnlMoney.add(pnlPaid);
		pnlMoney.add(Box.createRigidArea(new Dimension(0,10)));
		
		pnlChange = new JPanel();
		pnlChange.add(btnChange);
		pnlChange.add(Box.createRigidArea(new Dimension(5,0)));
		pnlChange.add(txtChange);
	
		pnlMoney.add(pnlChange);
		
		pnlColTwo = new JPanel();
		pnlColTwo.setBackground(Color.LIGHT_GRAY);
		pnlColTwo.setLayout(new BoxLayout(pnlColTwo, BoxLayout.Y_AXIS));
		pnlColTwo.add(pnlTrans);
		pnlColTwo.add(Box.createRigidArea(new Dimension(0,20)));
		pnlColTwo.add(pnlComplete);
		pnlColTwo.add(Box.createRigidArea(new Dimension(0,20)));
		pnlColTwo.add(pnlMoney);
		
		pnlBothCol = new JPanel();
		pnlBothCol.add(pnlColOne);
		pnlBothCol.add(Box.createRigidArea(new Dimension(5,0)));
		pnlBothCol.add(pnlColTwo);
		
		pnlOrder = new JPanel();
		pnlOrder.setLayout(new BoxLayout(pnlOrder, BoxLayout.Y_AXIS));
		pnlOrder.setBackground(Color.BLUE);
		pnlOrder.add(lblOrder1);
		pnlOrder.add(lblOrder2);
		pnlOrder.add(lblOrder3);
		
		pnlExit = new JPanel();
		pnlExit.add(btnExit);
		
		btnExit.addActionListener(new ExitListener());
		
		pnlOrderExit = new JPanel();
		pnlOrderExit.setLayout(new BorderLayout());
		pnlOrderExit.add(pnlOrder, BorderLayout.NORTH);
		pnlOrderExit.add(pnlExit, BorderLayout.SOUTH);

		add(pnlBothCol, BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(pnlOrderExit, BorderLayout.SOUTH);

	}   // end constructor PizzaControls
	
	//------------listeners------------
	
	private class NameListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			String text;
			
			text = txtName.getText();
			output1 = output1 + "Order for " + text + ": ";
			gotName = true;
			
		}
	}   // end class NameListener
	
	private class PizzaSizeListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			int selection;
			String text = "";
			
			gotLarge = gotMedium = gotSmall = false;
			
			if (!gotName)
			{
				text = txtName.getText();
				if (!text.equals(""))
				{
					output1 = output1 + "Order for " + text + ": ";
					gotName = true;
				}
				else //did not enter customer name.
				{
					JOptionPane.showMessageDialog(null, 
							"ERROR! You must enter Customer Name",
							"Customer Name Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} //End outer if statement.
			
			
			if (gotName)
			{
				selection = cboPizzaSize.getSelectedIndex();
				
				switch (selection)
				{
				// Large Pizza
				case 0: output1 = output1 + pizzaSize[0] + " ";
						gotLarge = true;
					break;
				//Medium Pizza
				case 1: output1 = output1 + pizzaSize[1] + " ";
						gotMedium = true;
					break;
				//Small Pizza
				case 2: 
					output1 = output1 + pizzaSize[2] + " ";
					gotSmall = true;
					break;
				//Default to unkown size
				default:  output1 = output1 + "Unknown SigotStyleze ";
				} // end pizza size selction
				
			} //End outer if statement
			gotSize = true;
			
		}   // end method actionPerfomed
		
	}   // end class PizzaSizeListener
	
	private class PizzaStyleListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			int selection;
			String text;
			
			gotHandTossed = gotThin = gotDeepDish = false;
			
			if (!gotSize)
			{
				JOptionPane.showMessageDialog(null, 
						"ERROR! You must select the size",
						"of your pizza.",
						JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				selection = cboPizzaStyle.getSelectedIndex();
				
				switch (selection)
				{
				// Hand Tossed Pizza
				case 0: output1 = output1 + pizzaStyle[0] + " ";
						gotHandTossed = true;
					break;
				//Thin Pizza
				case 1: output1 = output1 + pizzaStyle[1] + " ";
						gotThin = true;
					break;
				//Deep Dish Pizza
				case 2: 
					output1 = output1 + pizzaStyle[2] + " ";
					gotDeepDish = true;
					break;
				//Default to unknown Style
				default:  output1 = output1 + "Unknown Style ";
				} // end pizza style selection
			} //end of else statement
			gotStyle = true;
			
		}   // end method actionPerfomed
		
	}   // end class PizzaStyleListener
	
	private class CompleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
				// if transaction type has not
				// been selected then issue error
			if (transactionType == false)
			{
				System.out.println("You must choose a " +
							"transaction type!");
					// display error message; you must have entered
					// chosen a transaction type first
				JOptionPane.showMessageDialog(null,
						"Error! You must choose a " +
								"transaction type!",
								"Transaction type error",
								JOptionPane.ERROR_MESSAGE);
			}
			else	// transaction type has been selected
			{
					// we can only complete the
					// order once
				if (completeOrder == false)
				{
					System.out.println("going to update order");
					getSizeCost();
					getStyleCost();
					gatherToppings1();
					gatherToppings2();
					lblCost.setText("Total Cost: " +
								fmt2.format(totalCost));
					lblOrder1.setText(output1);
					lblOrder2.setText(output2);
					lblOrder3.setText(output3);
					completeOrder = true;
				}	// end inner if statement
			}	// end else statement

		}   // end method actionPerformed
	}   // end class CompleteListener
	
	private class ChangeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String text;
			double paid, change;
			
			// get what the customer pays us and the parse to double.
			text = txtPaid.getText();
			paid = Double.parseDouble(text);
			
			//calculate the change that the customer will recieve
			change = paid - totalCost;
			
			//display the change
			txtChange.setText(fmt2.format(change));
			
		}   // end method actionPerformed
	}   // end class ChangeListener
	
	private class Toppings1Listener implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{	
			
			gotCheese = gotPepperoni = gotSausage = gotChicken = false;
			
			//See which toping have been selected.
			if (cbxCheese.isSelected())
			{
				gotCheese = true;
			}
			if (cbxPepperoni.isSelected())
			{
				gotPepperoni = true;
			}
			if (cbxSausage.isSelected())
			{
				gotSausage = true;
			}
			if (cbxChicken.isSelected())
			{
				gotChicken = true;
			}
			
			
			
		}   // end method itemStateChanged
	}   // end class Toppings1Listener

	private class Toppings2Listener implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{	
			gotMush = gotPine = gotOnion = gotGrPep = false;
			
			//determine what vegetable toppings will be selected.
			if (cbxMush.isSelected())
			{
				gotMush = true;
			}
			if (cbxPine.isSelected())
			{
				gotPine = true;
			}
			if (cbxOnion.isSelected())
			{
				gotOnion = true;
			}
			if (cbxGrPep.isSelected())
			{
				gotGrPep = true;
			}
			
		}   // end method itemStateChanged
	}   // end class Toppings2Listener
	
	private class TransactionListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();
			//no additional charge for cash or credit cards
			if (source == rbtCash || source == rbtCard )
			{
				totalCost +=0.0;
				transactionType = true;
			}
			//Service charge for checks
			else if (source == rbtCheck)
			{
				totalCost += 0.50;
				transactionType = true;
			}
			else
			{
				totalCost += 0.0;
				transactionType = false;
			}
			
		}   // end method actionPerformed
	}   // end class TransactionListener
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int answer;
			
				// test to see if application
				// should be terminated
			answer = JOptionPane.showConfirmDialog(null,
		        "Exit application?",
		        "Terminate",
		        JOptionPane.YES_NO_OPTION);
		
			if (answer == JOptionPane.YES_OPTION)
			{
			  JOptionPane.showMessageDialog(null,
					   "This program was written by Harry Staley" +
					   "\nEnd of program.",
					   "Good bye!",
					   JOptionPane.INFORMATION_MESSAGE);
			  
			  System.exit(0);  // shut down this program!
			}

		}  // end method actionPerformed
			

	}   // end class ExitListener



	//------------helpers----------
	
	private void gatherToppings1()
	{
		   // determine which topping 1 were chosen
		   // and add them to our output string
		   // and update the cost
		if (gotCheese)
		{
			output2 += " Cheese ";
			totalCost += CHEESE_COST;
		}
		
		if (gotPepperoni)
		{
			output2 += " Pepperoni ";
			totalCost += PEPPERONI_COST;
		}
		
		if (gotSausage)
		{
			output2 += " Sausage ";
			totalCost += SAUSAGE_COST;
		}
		
		if (gotChicken)
		{
			output2 += " Chicken ";
			totalCost += CHICKEN_COST;
		}
	}   // end method gatherToppings1
	
	private void gatherToppings2()
	{
		   // determine which topping 2 were chosen
		   // and add them to our output string
		   // and update the cost
		if (gotMush)
		{
			output3 += " Mushrooms ";
			totalCost += MUSHROOM_COST;
		}
		
		if (gotPine)
		{
			output3 += " Pineapple ";
			totalCost += PINEAPPLE_COST;
		}
		
		if (gotOnion)
		{
			output3 += " Onion ";
			totalCost += ONION_COST;
		}
		
		if (gotGrPep)
		{
			output3 += " Green Peppers ";
			totalCost += GREEN_PEPPER_COST;
		}
	}   // end method gatherToppings2

	
	private void getSizeCost()
	{
		//determine what size of pizza was selected and then add the cost
		if (gotLarge)
		{
			totalCost += LG_COST;
		}
		else if (gotMedium)
		{
			totalCost += MD_COST;
		}
		if (gotSmall)
		{
			totalCost += SM_COST;
		}
		else
		{
			totalCost += 0.0;
		}
		
	}   // end method getSizeCost
	
	private void getStyleCost()
	{
		//determine what style of pizze was selected and determine the cost
		if (gotHandTossed)
		{
			totalCost += HT_COST;
		}
		else if (gotThin)
		{
			totalCost += TN_COST;
		}
		else if (gotDeepDish)
		{
			totalCost += DD_COST;
		}
		else
		{
			totalCost += 0.0;
		}
		
		
	}   // end getStyleCost
	
}   // end PizzaControls
