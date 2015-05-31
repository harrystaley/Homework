//----------------------------------------------------
// Programmer:   Harry Staley
// Course:       COSC 2336
// Semester:     Spring 2015
// Assignment #: 14
// Due Date:     5-10-2015
//----------------------------------------------------

import javax.swing.*;

public class DSPTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
           // declare variables to be used in program
        String output = "";
        int i, numberNodes;
        
           // instantiate an object from the class 'DSP'
        DSP theGraph = new DSP();
        
           // determine the shortest paths from node 0
           // (San Antonio) to all other nodes (cities)
           // in the graph
        theGraph.findShortestPath();
        
           // how many cities are there?
        numberNodes = theGraph.getNumberNodes();
        
           // display the shortest paths from node 0
           // (San Antonio) to all other cities in the graph
        for (i = 1;i < numberNodes ; i++ )
        {
          output += "\n\nPath from "+ theGraph.getCityName(0) + " to " +  theGraph.getCityName(i)+": ";

          //obtain the string of cities that is the shortest path to node i
          output += theGraph.printShortestPaths(i);
          // obtain the cost of the shortest path to node i.
          output += "\nShortest path cost is: ";
          output += theGraph.printShortestDistance(i);
        } // end for loop
        
           // display the shortest paths and cost from
           // node 0 (San Antonio) to all other nodes (cities)
        JOptionPane.showMessageDialog(null, output, "Final Shortest Paths", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null,
                "This program was written by Harry Staley." +
                "\nEnd of program.");
    }   // end method main
}   // end class DSPTester
