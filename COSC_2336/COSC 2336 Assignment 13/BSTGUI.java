import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BSTGUI extends JPanel  {
       // declare instance fields to be used in program
    private fullNode tree;
    private String output;
    private String[] traversals = {"Inorder Traversal", 
                            "Preorder Traversal",
                            "Postorder Traversal"};
    private JPanel pnlSelect, pnlTwoButtons;
    private JPanel pnlBottom, pnlBottom2, pnlMinMax;
    private JLabel lblSelect, lblStringOutput, lblAuthor;
    private JComboBox cboTraversals;
    private JRadioButton  rbtMinimum, rbtMaximum;
    private JButton btnAddChar, btnExit;
    private boolean donePopulatingBST;
    private final int TREE_EMPTY = 99999;

    
    public BSTGUI()
    {   
        tree = null;  // tree is initially null
        donePopulatingBST = false;
        setupGUI();
    }   // end constructor BSTOPerations
    
    private class fullNode
    {
            // declare instance fields to represent a node
            // in the binary search tree and its associated
            // pointers
        public BSTNode aNode;
        public fullNode left;
        public fullNode right;
        
        public fullNode(BSTNode newInfo)
        {
            aNode = newInfo;
            left = null;
            right = null;
        }   // end constructor fullNode
        
        public int getInfo()
        {
                // return information about this node
            return aNode.returnInfo();                                      
        }   // end method getInfo
        
    }   // end class fullNode
    
        //------------listeners------------
    private class PopulateBSTListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int number;
            String numberText;
            String fileText;
            Scanner fromFile = null;
            
            tree = null; // tree is initially empty
            donePopulatingBST = false;

                // prompt the user to enter the file
                // name to be used in this program
            fileText = JOptionPane.showInputDialog(null,
                "Please enter the data file name:" );
            file inputFile = new File (fileText);
    
            try
            {
                fromFile = new Scanner(inputFile);
            }   // end try clause
            catch (FileNotFoundException problem)
            {
               JOptionPane.showMessageDialog(null,
                "File: " + fileText +
                " not found !\n" +
                problem.getMessage(),
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
               return;
            } // end catch clause 

                // read in from the data file the numbers
                // to be inserted into the binary
                // search tree
            while (fromFile.hasNext())
            {
                numberText = fromFile.next();
                number = Integer.parseInt(numberText);
                insert(number);
            }   // end while loop

                // close the file
            fromFile.close();
            donePopulatingBST = true;

            JOptionPane.showMessageDialog(null,
               "Done populating the BST.",
               "Finished populating",
               JOptionPane.INFORMATION_MESSAGE);

      }   // end method actionPerformed
    }   // end class PopulateBSTListener
    
    private class TraversalSelectedListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {
            int selection;
            
            if (!donePopulatingBST)
            {
                JOptionPane.showMessageDialog(null,
                    "You must populate the BST first!",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);

                return;
            }
            
            if (getRoot() == null)
            {   
                JOptionPane.showMessageDialog(null,
                        "Cannot do any traversal!  Tree " +
                        "is empty!!!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
                return;  // leave this method now!
            }   // end if statement
            
            selection = cboTraversals.getSelectedIndex();
            
            switch (selection)
            {
                case 0: setupHeader("Inorder Traversal\n");
                        inorderTraversal(getRoot());
                        break;
                        
                case 1: setupHeader("Preorder Traversal\n");
                        preorderTraversal(getRoot());
                        break;
                
                case 2: setupHeader("Postorder Traversal\n");
                        postorderTraversal(getRoot());
                        break;
                
                default: JOptionPane.showMessageDialog(null,
                        "An error has occurred in the traversal selection!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            
                // display traversal now!
            displayTraversal();
            
        }   // end method actionPerfomed
        
    }   // end class TraversalSelectedListener
    
    private class MinMaxListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            int answer;
    
            Object source = event.getSource();
            
            if (!donePopulatingBST)
            {
                JOptionPane.showMessageDialog(null,
                        "You must populate the BST first!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }
            
                // radio button for minimum was selected   
            if (source == rbtMinimum)
            {
                answer = findMinimum();
                
                    // tree is empty
                if (answer == TREE_EMPTY)
                {
                    JOptionPane.showMessageDialog(null,
                            "Tree is empty.  Cannot " +
                            "determine minimum value.",
                            "Tree empty",
                            JOptionPane.INFORMATION_MESSAGE);
                            return;
                }
                
                JOptionPane.showMessageDialog(null,
                        "Minimum value in the BST is "+ answer,
                        "Minimum",
                        JOptionPane.INFORMATION_MESSAGE);
            }
                // radio button for maximum was selected  
            else if (source == rbtMaximum)
            {
                answer = findMaximum();
                
                    // tree is empty
                if (answer == TREE_EMPTY)
                {
                    JOptionPane.showMessageDialog(null,
                            "Tree is empty.  Cannot " +
                            "determine maximum value.",
                            "Tree empty",
                            JOptionPane.INFORMATION_MESSAGE);
                            return;
                }
                
                JOptionPane.showMessageDialog(null,
                        "Maximum value in the BST is "+ answer,
                        "Maximum",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else   // something else was selected
            {
                JOptionPane.showMessageDialog(null,
                        "An error has occurred in choosing " +
                        "the radio buttons!",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            
        }   // end method actionPerformed
    }   // end class MinMaxListener

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
    
        //------------helpers----------
    
    private void setupGUI()
    {
            // give our panel a 'BoxLayout' with appropriate
            // dimensions and color
        setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(600, 200));
        //setBackground(Color.LIGHT_GRAY);
            
            //------------create labels------------
        lblSelect = new JLabel("Select a traversal: ");
        lblSelect.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblSelect.setForeground(Color.BLACK);
        
        lblStringOutput = new JLabel();
        lblStringOutput.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblStringOutput.setForeground(Color.BLACK);
        
        lblAuthor = new JLabel("This program was written by Harry Staley. ");
        lblAuthor.setFont(new Font("Helvetica", Font.PLAIN, 16));
        lblAuthor.setForeground(Color.BLACK);
        
            //-------create combo box-------
        cboTraversals = new JComboBox(traversals);
        cboTraversals.setBackground(Color.ORANGE);
        cboTraversals.setForeground(Color.BLACK);
        cboTraversals.setFont(new Font("Helvetica", Font.BOLD, 16));
        cboTraversals.setAlignmentX(Component.CENTER_ALIGNMENT);
        
            //------------radio buttons------------
           
        rbtMinimum = new JRadioButton("Minimum", true);
        rbtMinimum.setBackground(Color.YELLOW);
        rbtMinimum.setFont(new Font("Helvetica", Font.BOLD, 16));
        
        rbtMaximum = new JRadioButton("Maximum", true);
        rbtMaximum.setBackground(Color.YELLOW);
        rbtMaximum.setFont(new Font("Helvetica", Font.BOLD, 16));
        
           // add the two radio buttons to the button
           // group called 'group'.  NOTE:  'group' is 
           // not a container, it is used to simply
           // organize the buttons; we will still have to
           // add each individual button to a panel
           // (shown below)
        ButtonGroup group = new ButtonGroup();
        group.add(rbtMinimum);
        group.add(rbtMaximum);

        
            //-----------create normal buttons------------
        btnAddChar = new JButton("Populate binary search tree");
        btnAddChar.setBackground(Color.BLUE);
        btnAddChar.setFont(new Font ("Helvetica", Font.BOLD, 20));
        btnAddChar.setForeground(Color.WHITE);
        
        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.RED);
        btnExit.setFont(new Font ("Helvetica", Font.BOLD, 20));
        btnExit.setForeground(Color.WHITE);

        
            //------------create panels------------
        pnlSelect = new JPanel();
        pnlSelect.add(lblSelect);
        pnlSelect.add(cboTraversals);
        pnlSelect.setBackground(Color.LIGHT_GRAY);
        
        pnlBottom = new JPanel();
        pnlBottom.add(lblAuthor);
        pnlBottom.setBackground(Color.LIGHT_GRAY);
        
        pnlBottom2 = new JPanel();
        pnlBottom2.add(btnExit);
        pnlBottom2.setBackground(Color.LIGHT_GRAY);
        
        pnlTwoButtons = new JPanel();
        pnlTwoButtons.add(btnAddChar);
        pnlTwoButtons.setBackground(Color.LIGHT_GRAY);
        
           // add radio buttons to this subpanel
        pnlMinMax = new JPanel();
        pnlMinMax.setBackground(Color.LIGHT_GRAY);
        pnlMinMax.add(rbtMinimum);
        pnlMinMax.add(Box.createRigidArea(new Dimension(5,0)));
        pnlMinMax.add(rbtMaximum);
    
            // create listeners for components
        btnAddChar.addActionListener(new PopulateBSTListener());
        btnExit.addActionListener(new ExitListener());
        cboTraversals.addActionListener(new TraversalSelectedListener());
        rbtMinimum.addActionListener(new MinMaxListener());
        rbtMaximum.addActionListener(new MinMaxListener());

            // add sub panels to the main panel
        add(pnlTwoButtons);
        add(pnlSelect);
        add(pnlMinMax);
        add(pnlBottom);
        add(pnlBottom2);

    }   // end method setupGUI

    private fullNode getRoot()
    {
        return tree;   // return the root of the tree
    }   // end method fullNode
    
    
    private void insert(int aNumber)
    {
        boolean found;
        fullNode current;
            
            //creat new information for
            //a new node
        BSTNode newInfo = new BSTNode(aNumber);
        current = tree; // start at the root of the tree

            // create a new node to be inserted
            // into the BST
        fullNode newNode = new fullNode(newInfo);
            
            // currently we have an empty BST
        if (current == null)
        {
                // this becomes the root of the BST
            tree = newNode;
        }   // end if statement

            // BST exists. Traverse to find out
            // the proper location for this new node
        else
        {
            found = false;

                // keep looking for proper location
            while (!found)
            {
                    // location must be on the
                    // left subtree
                if (newNode.getInfo() < current.getInfo())
                {
                    // found location
                    if (current.left == null)
                    {
                            // insert new node
                        current.left = newNode;
                        found = true;
                    }   // end inner if statement
                    else
                    {
                        // have not found proper
                        // location, keep traversing
                        // on the left subtree
                        current = current.left;
                    }   // end inner else statement
                } // end outer if statement
                else
                {
                        // location must be on the
                        // right subtree
                    if (newNode.getInfo() > current.getInfo())
                    {
                            // found location
                        if (current.right == null)
                        {
                                // insert new node
                            current.right = newNode;
                            found = true;
                        }    // end inner if statement
                        else
                        {
                            // have not found proper
                            // location, keep traversing
                            // on the right subtree
                            current = current.right;
                        }   // end inner else statement

                 }   // end outer if statement 
            } // end outer else statement

         }// end while loop

     } end else statement 
     
    }   // end method insert

    private void setupHeader(String headerString)
    {
        output = headerString;
    }   // end method setupHeader
    
    private void displayTraversal()
    {
        JOptionPane.showMessageDialog(null,
                    output,
                    "Traversal",
                    JOptionPane.INFORMATION_MESSAGE);
    }   // end method displayTraversal
    
    private void inorderTraversal(fullNode tree)
    {   
        if (tree.left ! = null)   
        {
                // recursively go down the left subtree
            inorderTraversal(tree.left);
            }
               
                // build the string of traversal
            output = output = " " + tree.getInfo();
        
if (tree.right ! = null
{
             // recursively go down the right subtree
        inorderTraversal(tree right);
     }
  }   // end method inorderTraversal
    
    
    private void preorderTraversal(fullNode tree)
    {   
        output = output + " " + tree.getInfo();

        if (tree.left ! = null)
        {
            // recursively go down the left subtree
            preorderTraversal(tree.left);
        }

        if (tree.right ! = null)
        {
                // recursively go down the right subtree
            preorderTraversal(tree.right);
        }


    }   // end method preorderTraversal
    private void postorderTraversal(fullNode tree)
    {
        if (tree.left ! = null)
        {
                // recursively go down the left subtree
            postorderTraversal(tree.left);
        }
        if (tree.right ! = null)
        {
            // recursively go down the right subtree
        postorderTraversal(tree.right);
        }

        output = output + " "+ tree.getInfo();

   

    }   // end method postorderTraversal
    
    private int findMinimum()
    {
        fullNode p;
        
        if (getRoot() == null)
        {
            System.out.println("Tree is empty!!");
            return TREE_EMPTY;
        }
        
            // start form the root of the tree
        p =  tree;

        while (?p.left ! = null)
        {
            p = p.left;            
        }   // end while loop

        //return minimum value of BST
     return p.getInfo();
        
    }   // end method findMinimum
    
    private int findMaximum()
    {
        fullNode p;
        
        if (getRoot() == null)
        {
            System.out.println("Tree is empty!!");
            return TREE_EMPTY;
        }
        
            // start from the root of the tree
        p = tree;

        while (p.right ! = null)
        {
            p = p.right;
        }   // end while loop
        
            // return maximum value of BST
        return p.getInfo();
    }   // end method findMaximum
        
}   // end class BSTGUI
