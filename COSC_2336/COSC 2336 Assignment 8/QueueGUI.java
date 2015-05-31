import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QueueGUI extends JPanel {
       // instantiate an object for shoppers from
       // the HEBQueue class
    HEBQueue<QueueInfo> shoppers = new HEBQueue<QueueInfo>();
    
       // declare variables that will be used 
       // in the program
    String aName, aPriceText, answer, output;
    QueueInfo dequeueName;
    double aPrice;
    
       // declare GUI components to be used
    private JPanel pnlName, pnlBill, pnlNameAndBill;
    private JPanel pnlSelection, pnlBottom, pnlBottom2;
    private JLabel lblName, lblBill, lblStringOutput, lblAuthor;
    private JTextField txtName, txtBill;
    private JButton btnExit;
    private JRadioButton rbtEnqueue, rbtDequeue, rbtDisplay;

    public QueueGUI()
    {
           // give our panel a 'BoxLayout' with appropriate
           // dimensions and color
        setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(500, 275));
        //setBackground(Color.LIGHT_GRAY);
        
            //------------create labels------------
        
        lblName = new JLabel("Enter shopper's name:");
        lblName.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblName.setForeground(Color.BLACK);
        
        lblBill = new JLabel("Enter shopper's bill:");
        lblBill.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblBill.setForeground(Color.BLACK);
        
        lblStringOutput = new JLabel ();
        lblStringOutput.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblStringOutput.setForeground(Color.BLACK);
        
        lblAuthor = new JLabel("This program was written by Harry Staley.");
        lblAuthor.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblAuthor.setForeground(Color.BLACK);
        
            //------------create text fields------------
        txtName = new JTextField(15);
        txtName.setFont(new Font("Helvetica", Font.PLAIN, 16));
        txtName.setForeground(Color.BLACK);
        
        txtBill = new JTextField(6);
        txtBill.setFont(new Font("Helvetica", Font.PLAIN, 16));
        txtBill.setForeground(Color.BLACK);
        
            //-------create normal buttons
        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.RED);
        btnExit.setFont(new Font("Helvetica", Font.BOLD, 20));
        btnExit.setForeground(Color.WHITE);
        
           //------------create radio buttons------------
        rbtEnqueue = new JRadioButton("Enqueue shopper", true);
        rbtEnqueue.setBackground(Color.YELLOW);
        rbtEnqueue.setFont(new Font("Helvetica", Font.BOLD, 16));
        
        rbtDequeue = new JRadioButton("Dequeue shopper");
        rbtDequeue.setBackground(Color.YELLOW);
        rbtDequeue.setFont(new Font("Helvetica", Font.BOLD, 16));
        
        rbtDisplay = new JRadioButton("Display queue");
        rbtDisplay.setBackground(Color.YELLOW);
        rbtDisplay.setFont(new Font("Helvetica", Font.BOLD, 16));
        
           // add the three radio buttons to the button
           // group called 'group'.  NOTE:  'group' is 
           // not a container, it is used to simply
           // organize the buttons; we will still have to
           // add each individual button to a panel
           // (shown below)
        ButtonGroup group = new ButtonGroup();
        group.add(rbtEnqueue);
        group.add(rbtDequeue);
        group.add(rbtDisplay);

            //------------create panels------------
        pnlName = new JPanel();
        pnlName.add(lblName);
        pnlName.add(txtName);
        
        pnlBill = new JPanel();
        pnlBill.add(lblBill);
        pnlBill.add(txtBill);
        
        pnlNameAndBill = new JPanel();
        pnlNameAndBill.add(pnlName);
        pnlNameAndBill.add(pnlBill);
        
        pnlSelection = new JPanel();
        pnlSelection.setBackground(Color.CYAN);
        pnlSelection.setLayout(new BoxLayout(pnlSelection, BoxLayout.X_AXIS));
        pnlSelection.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        
           // add radio buttons to this subpanel
        pnlSelection.add(rbtEnqueue);
        pnlSelection.add(Box.createRigidArea(new Dimension(5,0)));
        pnlSelection.add(rbtDequeue);
        pnlSelection.add(Box.createRigidArea(new Dimension(5,0)));
        pnlSelection.add(rbtDisplay);
        
        pnlBottom = new JPanel();
        pnlBottom.add(lblAuthor);
        
        pnlBottom2 = new JPanel();
        pnlBottom2.add(btnExit);
        
        btnExit.addActionListener(new ExitListener());
        rbtEnqueue.addActionListener(new QueueListener());
        rbtDequeue.addActionListener(new QueueListener());
        rbtDisplay.addActionListener(new QueueListener());

        
            // add sub panels to the main panel
        add(pnlNameAndBill);
        add(pnlSelection);
        add(pnlBottom);
        add(pnlBottom2);
    }   // end constructor QueueGUI
    
        //------------listeners------------
    private class QueueListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            object source = event.getSource();

            // Select what to do with the queue
            if (source == rbtEnqueue) // enqueue
            {
                enqueueShopper();
            } 
            else if (source == rbtDequeue) // dequeue
            {
                dequeueShopper();
            }
            else if (source == rbtDisplay) // display
            { 
                displayQueue();
            }
            else // something else was selected
            {
                System.out.println("Error!");
            }
        }   // end method actionPerformed
    }   // end class QueueListener
    
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
                System.exit(0);  // shut down this program!
            }

        }   // end method actionPerformed
    }   // end class ExitListener
    
        //------------helpers------------
    private void enqueueShopper()
    {
        aName = txtName.getText();
        if (aName.equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter a shopper's name!", "Error!",JOptionPane.ERROR_MESSAGE);
            return;       
        }

        aPriceText = txtBill.getText();

        if (aPriceText.equals("")) {
            JOptionPane.showMessageDialog(null, "You must enter a shopper's bill!", "Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }

        aPrice = Double.parseDouble(aPriceText);

        // attempt to enqueue this shoppers name and bill
        if (shoppers.fullShoppers() == false) {
            shoppers.enqueue(new QueueInfo(aName, aPrice));
            JOptionPane.showMessageDialog(null, aName + " has been enqueued.", "Shopper", JOptionPane.INFORMATION_MESSAGE);
            txtName.setText(""):
            txtBill.setText("");
        } // end if statement
        else
        {
            JOptionPane.showMessageDialog(null, "Could not add new shopper '" + aName + "' to the queue since it is full. \nYou must dequeue a shopper!", "Error!", JOptionPane.ERROR_MESSAGE);
        } // end else statement

    }   // end method enqueueShopper
    
    private void dequeueShopper()
    {
        if (shopper.emptyShoppers() == false) {
            // dequeue one shopper
            dequeueName = shoppers.Dequeue();
            JOptionPane.showMessageDialog(null, dequeueName + " has been dequeued.\nThey are done shopping!", "Shopper", JOptionPane.INFORMATION_MESSAGE);
        } // end if statement
        else
        {
            JOptionPane.showMessageDialog(Null, "Could not dequeue a shopper from the queue since it is empty!", "Empty!", JOptionPane.ERROR_MESSAGE);
        }   // end else statement
    }   // end method dequeueShopper
    
    private void displayQueue()
    {
        QueueInfo holdShoppers[] = new QueueInfo[10];
        int i = 0, j;
        
        output = "Here is your current shopper's queue\n";
        
           // dequeue all of the shopper's name and their
           // shopping bill from the queues and then use
           // them to build up a string
        while (shoppers.emptyShoppers() == false)
        {
               // dequeue a shopper
            dequeueName = shoppers.dequeue();
            
            holdShoppers[i] = dequeueName;
            i++;
            
               // build the string of names and bills
            output = output + "\n" + dequeueName;
        }   // end while loop
        
           // now display all of the shoppers that were dequeued
        JOptionPane.showMessageDialog(null,
output,
"Current shoppers",
JOptionPane.INFORMATION_MESSAGE);
        
            // enqueue these shoppers again!
        for (j = 0; j < i; j++)
        {
            if (shoppers.fullShoppers() == false)
            {
                shoppers.enqueue(holdShoppers[j]); 
            }
        }   // end for loop
    }   // end method displayQueue

}   // end class QueueGUI
