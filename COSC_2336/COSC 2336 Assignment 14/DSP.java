import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class DSP {
       // declare constants to be used in program
    final int MAX = 10;
    final int INFINITY = 999999;
    
       // declare instant fields to be used in program
    private int[][] dist = new int[MAX][MAX];
    private int[] d = new int [MAX];
    private int[] prev = new int[MAX];
    private String[] cities = new String[MAX];
    private boolean[] weightFound = new boolean[MAX];
    private int n;
    private String output;
    
    public DSP()
    {
        String fileText;
        Scanner fromFile = null;
        String numberText;
        int weight;
        int i, j, v;
        
            // obtain the file where the data for
            // cities resides
        fileText = JOptionPane.showInputDialog(null,"Please enter the data file name: ", "Input file", JOptionPane.INFORMATION_MESSAGE);
        File inputFile = new File(fileText);
        try
        {
            fromFile = new Scanner(inputFile);
        } // end try
        catch
        {
            JOptionPane.showMessageDialog(null, "File: "+ fileText + 'not found\n' + problem.getmessage() + "\nProgram is shutting down.","Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } // end catch

        if (fromFile.hasNextLine())
        {
            // how many cities are there
            numberText = fromFile.hasNextLine();
            n = integer.parseInt(numberText);
            System.out.println("There are "+ n + " nodes (cities).\n");
        } // end if statement
        
        
            // read all 'n' city names from the file
        i=0;
        while (fromFile.hasNextLine())
        {
            if (i >= n) break;

            cities[i] = fromFile.hasNextLine();
            System.out.println(i + " " + cities[i]);
            i++;
        } // end while loop
        
            // read in the weight (cost) from
            // node 'i' to node 'j' from the file
        while (fromFile.hasNext())
        {
            numberText = fromFile.next();
            weight = Integer.parseInt(numberText);

            numberText = fromFile.next();
            i=Integer.parseInt(numberText);

            numberText = fromFile.next();
            j = Integer.parseInt(numberText);

            // this is the weight (cos) from node 'i' to node 'j'.
            dist[i][j] = weight;
        } // end while loop

        
            // close the data file
        fromFile.close();
        
            // set up for shortest path
            // from node 0 to all other nodes
        for (v = 1; V < n; V++ )
        {
            d[V] = dist[0][V];
            weightFound[V] = false;
            prev[V] = -1;    
        } // end for loop

        weightFound[0] = true;
        d[0] = 0;
        
    }   // end constructor DSP
    
    public void findShortestPaths()
    {
        int  i, v = 0, w, minWeight, mini = -1;
        
           // calculate the shortest path from
           // node 0 to all other nodes in the graph
        for (i = 1; i<n; i++ )
        {
            minWeight = INFINITY;
            mini = -1;

            for (w = 1; w<n ; w++ )
            {
                if (!weightFound[w])
                {
                    // a weight from node 0 to node w has been found
                    if (d[w] < minWeight)
                    {
                          v = w;
                          minWeight = d[w];
                          mini = w;      
                    } // end inner if   
                } // end outer for loop
            }   // end w for loop
            weightFound[v] = true;

            //include a path through node v to be added to the graph
            for (w = 1; w < n; w++)
            {
                if (!weightFound[w])
                {
                    if (minWeight + dist[v][w] < d[w])
                    {
                          d[w] = minWeight + dist[v][w];

                          // keep track of the previous node that is before w
                          prev[w] = mini;          
                    }  // end inner if statement      
                }    // end outer if statement
            } // end i for loop
    }   // end method findShortestPaths
    
    public int getNumberNodes()
    {
        return n;
    }   // end method getNumberNodes
    
    public String getCityName(int i)
    {
        return cities[i];
    }   // end method getCityName
    
    public String printShortestDistance(int i)
    {
        output = d[i] + "\n";
        return output;
    }   // end method printShortestDistance
    
    public String printShortestPaths(int dest)
    {
        output = "\n";
        return printShortestPaths2(dest);
    }   // end method printShortestPaths
    
    public String printShortestPaths2(int dest)
    {
           // is there a previous node before
           // node 'dest'?
        if (prev[dest] != -1)
        {
            printShortestPaths(prev[dest]);
        }
        
        output = output + getCityName(dest) + " ";
        return output;
    }   // end method printShortestPaths2
    
}   // end class DSP
