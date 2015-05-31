import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LinkedListGUI2 extends JPanel {
       // declare variables that will be used in our program
    private int i;
    private String[] vowels = {"i", "y", "a","o", "e", "u"};
    
    private String[] alphabet = {"a","b","c","d","e",
                                        "f","g","h","i","j",
                                        "k","l","m","n","o",
                                        "p","q","r","s","t",
                                        "u","v","w","x","y","z"};
    private CharacterList everyCharacter;
    private String inputChar;
    private boolean gotChar;
    
    private JPanel pnlSelect, pnlTwoButtons, pnlBottom;
    private JPanel pnlBottom2;
    private JLabel lblSelect, lblStringOutput, lblAuthor;
    private JComboBox cboCharacters;
    private JTextField txtName, txtAge;
    private JButton btnAddChar, btnDeleteChar, btnDisplay, btnExit;
    
    public LinkedListGUI2()
    {
           // give our panel a 'BoxLayout' with appropriate
           // dimensions and color
        setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(600, 200));
        setBackground(Color.LIGHT_GRAY);
        gotChar = false;
        
           // instantiate the object that will represent the
           // entire linked list of characters
        everyCharacter = new CharacterList();
        
           // add each character from the array 'vowels'
           // to be inserted into the linked list
        for (i=0 ; i < vowels.length; i++)
        {
            everyCharacter.add(new character(vowels[i]));
        } //end for loop
        
            //------------create labels------------
        
        lblSelect = new JLabel("Select a character:");
        lblSelect.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblSelect.setForeground(Color.BLACK);
        
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
        
        txtAge = new JTextField(5);
        txtAge.setFont(new Font("Helvetica", Font.PLAIN, 16));
        txtAge.setForeground(Color.BLACK);
        
            //-------create combo box-------
        cboCharacters = new JComboBox(alphabet);
        cboCharacters.setBackground(Color.ORANGE);
        cboCharacters.setForeground(Color.BLACK);
        cboCharacters.setFont(new Font("Helvetica", Font.BOLD, 16));
        cboCharacters.setAlignmentX(Component.CENTER_ALIGNMENT);
        
           //-----------create normal buttons------------
        btnAddChar = new JButton("Add character");
        btnAddChar.setBackground(Color.BLUE);
        btnAddChar.setFont(new Font("Helvetica", Font.BOLD, 20));
        btnAddChar.setForeground(Color.WHITE);
        
        btnDeleteChar = new JButton("Delete character");
        btnDeleteChar.setBackground(Color.PINK);
        btnDeleteChar.setFont(new Font("Helvetica", Font.BOLD, 20));
        btnDeleteChar.setForeground(Color.BLACK);
        
        btnDisplay = new JButton("Display linked list");
        btnDisplay.setBackground(Color.YELLOW);
        btnDisplay.setFont(new Font("Helvetica", Font.BOLD, 20));
        btnDisplay.setForeground(Color.BLACK);
        
        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.RED);
        btnExit.setFont(new Font("Helvetica", Font.BOLD, 20));
        btnExit.setForeground(Color.WHITE);
        
            //------------create panels------------
        pnlSelect = new JPanel();
        pnlSelect.add(lblSelect);
        pnlSelect.add(cboCharacters);
        
        pnlBottom = new JPanel();
        pnlBottom.add(lblAuthor);
        
        pnlBottom2 = new JPanel();
        pnlBottom2.add(btnExit);
        
        pnlTwoButtons = new JPanel();
        pnlTwoButtons.add(btnAddChar);
        pnlTwoButtons.add(Box.createRigidArea(new Dimension(0,10)));
        pnlTwoButtons.add(btnDeleteChar);
        pnlTwoButtons.add(Box.createRigidArea(new Dimension(0,10)));
        pnlTwoButtons.add(btnDisplay);
        
            // create listeners for components
        btnAddChar.addActionListener(new AddCharacterListener());
        btnDeleteChar.addActionListener(new DeleteCharacterListener());
        btnDisplay.addActionListener(new DisplayListener());
        btnExit.addActionListener(new ExitListener());
        cboCharacters.addActionListener(new CharacterSelectedListener());
        
            // add sub panels to the main panel
        add(pnlSelect);
        add(pnlTwoButtons);
        add(pnlBottom);
        add(pnlBottom2);
    }   // end constructor LinkedListGUI2
    
    //------------listeners------------
    
    private class CharacterSelectedListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {
            int selection;
            
            selection = cboCharacters.getSelectedIndex();
            inputChar = alphabet[selection];
            gotChar = true;

        }   // end method actionPerfomed
        
    }   // end class CharacterSelectedListener

    
    private class AddCharacterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (!gotChar)
            {
                // display error message
                JOptionPane.showMessageDialog(null, "You must select a character!","Error",JOptionPane.ERROR_MESSAGE);
            } //end if statement
            else
            {
                everyCharacter.add(new character(inputChar));
                gotChar = false;
            } // end else
            
        }   // end method actionPerformed
    }   // end class AddCharacterListener
    
    private class DeleteCharacterListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (!gotChar)
            {
                // display error message
                JOptionPane.showMessageDialog(null, "You must select a character!","Error",JOptionPane.ERROR_MESSAGE);
            } //end if statement
            else
            {
                // delete this charcter from the linked list
                everyCharacter.delete(inputChar));
                gotChar = false;
            } // end else
            

            
        }   // end method actionPerformed
    }   // end class DeleteCharacterListener
    
    private class DisplayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {           
            // display the current list of characters.
            JOptionPane.showMessageDialog(null, everyCharacter.buildLIst(), "Linked list information", JOptionPane.INFORMATION_MESSAGE);
        }   // end method actionPerformed
    }   // end class DisplayListener
    
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

}   // end LinkedListGUI2

