import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;   // import the Random class

public class SemesterProjectGUI extends JPanel {
	   // declare instance fields that will be used in our program
	private int target;
	private boolean donePopulate, doneSort, doneSearch;
	private String result;
	
	   // set up constants for the number of array size
	   // and the range that a number can be
	final int MAX_COUNT = 1000;
	final int MAX_VALUE = 10000;
	
	   // declare constant to indicate the number of
	   // searches to do 
	final int SEARCHES = 100;

	   // declare other instance fields needed in the program
	   // (array of unsorted numbers and sorted numbers,
	   // and counters to keep track of how many searches)
	private int[] allNumbers = new int[MAX_COUNT];
	private int[] sortedNumbers = new int[MAX_COUNT];
	private int linearCount, binaryCount;

	private JPanel pnlFiveButtons, pnlBottom, pnlBottom2;
	private JLabel lblAuthor;
	private JButton btnPopulate, btnSort, btnSearch;
	private JButton btnDisplay, btnExit;
		
	public SemesterProjectGUI()
	{
			// give our panel a 'BoxLayout' with appropriate
			// dimensions and color
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(800, 130));
		setBackground(Color.LIGHT_GRAY);
		
		   // zero out counters
		linearCount = 0;
		binaryCount = 0;
		
		donePopulate = false;
		doneSort = false;
		doneSearch = false;
		
			//------------create labels------------
		lblAuthor = new JLabel("This program was written by Harry Staley ");
		lblAuthor.setFont(new Font("Helvetica", Font.PLAIN, 16));
		lblAuthor.setForeground(Color.BLACK);

			//-----------create normal buttons------------
		btnPopulate = new JButton("Populate array");
		btnPopulate.setBackground(Color.CYAN);
		btnPopulate.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnPopulate.setForeground(Color.BLACK);
		
		btnSort = new JButton("Sort array");
		btnSort.setBackground(Color.ORANGE);
		btnSort.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnSort.setForeground(Color.BLACK);
		
		btnSearch = new JButton("Search array");
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnSearch.setForeground(Color.BLACK);
		
		btnDisplay = new JButton("Display results");
		btnDisplay.setBackground(Color.YELLOW);
		btnDisplay.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnDisplay.setForeground(Color.BLACK);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Helvetica", Font.BOLD, 20));
		btnExit.setForeground(Color.WHITE);

		
			//------------create panels------------	
		pnlBottom = new JPanel();
		pnlBottom.add(lblAuthor);
		
		pnlBottom2 = new JPanel();
		pnlBottom2.add(btnExit);
		
		pnlFiveButtons = new JPanel();
		pnlFiveButtons.add(btnPopulate);
		pnlFiveButtons.add(Box.createRigidArea(new Dimension(0,10)));
		pnlFiveButtons.add(btnSort);
		pnlFiveButtons.add(Box.createRigidArea(new Dimension(0,10)));
		pnlFiveButtons.add(btnSearch);
		pnlFiveButtons.add(Box.createRigidArea(new Dimension(0,10)));
		pnlFiveButtons.add(btnDisplay);
		
			// create listeners for components
		btnPopulate.addActionListener(new PopulateListener());
		btnSort.addActionListener(new SortListener());
		btnSearch.addActionListener(new SearchListener());
		btnDisplay.addActionListener(new DisplayListener());
		btnExit.addActionListener(new ExitListener());

			// add sub panels to the main panel
		add(pnlFiveButtons);
		add(pnlBottom);
		add(pnlBottom2);
	}   // end constructor SemesterProjectGUI
	
	//------------listeners------------
	
	private class PopulateListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int i, j, oneNumber = -1;
			Random gen = new Random();
			
			for (i = 0; i < MAX_COUNT; i++ )	
			{
				oneNumber = gen.nextInt(MAX_VALUE);
				j = 0;

					//at least one element must exit
					// to check for duplication
				if (i > 0)

			{ 
				do
				{
						// duplicate number has
						// occured. Generate
						// another number
					if (allNumbers[j] == oneNumber)
					{ 
						oneNumber = gen.nextInt(MAX_VALUE);
						j = 0 ;
					}
					else  	// no duplicat number
					{		// at location j
						j++;
					}
				} while (j < i);	// look at all
									// elements from		
									// 0 to i - 1
			}	// end if statement 

				// insert random number in index
				// i of array 'allNumbers'
			allNumbers[i] = oneNumber;

		} 	// end for loop
		donePopulate = true;

		JOptionPane.showMessageDialog(null, "Created " + MAX_COUNT + "random numbers between the range of 0 and " + (MAX_VALUE - 1), "Populated Array ", JOptionPane.INFORMATION_MESSAGE);


		}   // end method actionPerformed
	}   // end class PopulateListener
	
	private class SortListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int i, j, min, temp;
			
			if (!donePopulate)
			{
				JOptionPane.showMessageDialog(null,
						"You must populate the array first!",
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
				// copy all numbers from the array
				// 'allNumbers' to array 'sortedNumbers'
				// to set up a sort
			for (i = 0; i < allNumbers.length; i++)
			{
			sortedNumbers[i] = allNumbers[i];
			}	// end for loop

				// use the selection sort to
				// sort the array 'sortedNumbers'
			for (i = 0; i < sortedNumbers.length - 1; i++)
			{
				min = i;

				for (j = i + 1; j< sortedNumbers.length; j++)
				{
						// if min element is greater,
						// then we have a new min	
					if(sortedNumbers[j] < sortedNumbers[min])
					{
						min = j; // new min
					}
				}	// end inner j for loop

					// swamp them!
				temp = sortedNumbers[min];
				sortedNumbers[min] = sortedNumbers[i];
				sortedNumbers[i] = temp;

		} // end outer i for loop

		doneSort = true;

		JOptionPane.showMessageDialog(null,
					"The array has been sorted.",
					"Sorted Array ",
					JOptionPane.INFORMATION_MESSAGE);
			
		}   // end method actionPerformed
	}   // end class SortListener
	
	private class SearchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int i;
			
			if (!doneSort)
			{
				JOptionPane.showMessageDialog(null,
						"You must sort the array first!",
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

				// conduct searches on the sorted array
				// for the binary search and searches
				// on the unsorted array for the
				//linear seach
			for (i = 0; i < SEARCHES; i++)
			{
				target = getTarget();
				linearSearch(target);
				binarySearch(target, 0, MAX_COUNT - 1);
			}  // end for loop

			doneSearch = true;

			JOptionPane.showMessageDialog(null,
			SEARCHES + "searches have been"+
			"calculated on the array.",
			"Searching",
			JOptionPane.INFORMATION_MESSAGE);
			
		}   // end method actionPerformed
	}   // end class SearchListener
	
	private class DisplayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int answer;
			
			if (!doneSearch)
			{
				JOptionPane.showMessageDialog(null,
						"You must search the array first!",
						"ERROR!",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
	result = "Average linear search count to " +
		"find " + SEARCHES + " targets: " +
		getLinearCount() / (double) SEARCHES +
		" searches. ";
		result += "\nAverage binary search count " +
		" to find " + SEARCHES +
		" targets: " + 
		getBinaryCount() / (double) SEARCHES +
		"searches. ";
	// display the average of the
	// two different kinds of searches
	// (linear search vs binary search)
JOptionPane.showMessageDialog(null, 
					result,
					"Display search results",
					JOptionPane.INFORMATION_MESSAGE);

					
				// ask user if they wish to continue
			answer = JOptionPane.showConfirmDialog(null,
					"Continue with new random numbers?",
					"Terminate",
					JOptionPane.YES_NO_OPTION);

				// user wishes to comtinue with
				// a new set of numbers, so reset
				// the appropreate variables
			if (answer == JOptionPane.YES_OPTION)
			{
			donePopulate = false;
			doneSort = false;
			doneSearch = false;
			binaryCount = 0;
			linearCount = 0;

			} // end if statement


		}   // end method actionPerformed
	}   // end class DisplayListener
	
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int answer;
			
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
	
	public void linearSearch(int target)
	{
		int i = 0;
		boolean found = false, done = false;

			// keep looping until you have found
			// the target in the array 'allNumbers'
			// or until you have searched the 
			//entire array and did not find it
		while (found == false && done == false)
		{
			linearCount++;
			if (target == allNumbers[i])
			{
				found = true;
			}	// end if statement
			else
			{
				// increment index 'i' to look 
				i++;
				// end else statement

				if (i == allNumbers.length)
{ 
					// looked at all elements of
					// the array and did not find
					// the target number	

					done = true;
				} // end if statement
}
		}	// end while loop
		
		
	}   // end method linearSearch

	public int binarySearch(int target, int min, int max)
	{
		int middle;
			// find the middle index
		middle = (min + max) / 2;


		// found target number!
		if (sortedNumbers[middle] == target)
		{
			binaryCount++;
			return middle;
		}  // end if statement

			// search the'left' side of
			// the array
		else if (sortedNumbers[middle] > target)
{
			binaryCount++;
			return binarySearch(target, min, middle - 1);
}			// end else if statement
        // seach the 'right' side of
        // the array
       else
       {
       		binaryCount++;
       		return binarySearch(target, middle + 1, max);
       }  // end else statement
	

	}   // end method binarySearch

	public int getTarget()
	{
		int target, i;
		Random gen = new Random();

			// generate a number from 0 to	
			// MAX_Count - 1
		i = gen.nextInt(MAX_COUNT);	

		// using this number, obtain the
		// target from the array 'allNumbers'
		target = allNumbers[i];		

		return target;   
	}   // end method getTarget
		
	public int getLinearCount()
	{
		return linearCount;
	}   // end method getLinearCount
		
	public int getBinaryCount()
	{
		return binaryCount;
	}

}   // end SemesterProjectGUI
