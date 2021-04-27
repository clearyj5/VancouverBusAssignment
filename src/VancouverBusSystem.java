
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon; 


public class VancouverBusSystem {

  ArrayList<Trip> tripList = new ArrayList<Trip>();
    
    public void findShortestRoute(String stop1, String stop2){

    }

    public void findStopInfo(String stop){
      /*
      Searching for a bus stop by full name or by the first few characters in the name, using a
      ternary search tree (TST), returning the full stop information for each stop matching the
      search criteria (which can be zero, one or more stops)
      In order for this to provide meaningful search functionality please move keywords flagstop, wb, nb,
      sb, eb from start of the names to the end of the names of the stops when reading the file into a TST
      (eg “WB HASTINGS ST FS HOLDOM AVE” becomes “HASTINGS ST FS HOLDOM AVE WB”) 

      -> trie(DST) key is names of the stops, value is the description 
      */
        System.out.println("Test2");

    }

    public void showMenu() {
      boolean shouldContinue = true;
      Scanner sc = new Scanner(System.in);
      do{

        String[] userOptions = 
        {"Please choose an option", 
        "1. Find the shortest path between two stops", 
        "2. Find bus stop by full name", 
        "3. Find all the trips of a given duration"}; 

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(420,420);

        ImageIcon icon = new ImageIcon("/Users/probbins/Desktop/bluebus.jpeg"); 

        String inputFromUser = (String) JOptionPane.showInputDialog(

          frame, 
          "Which of Our Services Would You Like To Use? Select an Option From The Dropdown Menu", 
          "*Vancouver Bus Service", 
          JOptionPane.WARNING_MESSAGE, 
          icon, 
          userOptions, 
          userOptions[0]
          );

          switch(inputFromUser){
              case "1. Find the shortest path between two stops":
                String stop1 = JOptionPane.showInputDialog("Please enter the first stop"); 
                String stop2 = JOptionPane.showInputDialog("Please enter the second stop"); 
                  findShortestRoute(stop1, stop2);
                  break;
              case "2. Find bus stop by full name":
              String stop = JOptionPane.showInputDialog("Please enter the stop name to search"); 
              findStopInfo(stop);
                  break;
              case "3. Find all the trips of a given duration":
                String timeByUser = JOptionPane.showInputDialog("Please enter the durtion of your trip in a hh:mm::ss format: ");
                boolean isTimeValid = _isGivenTimeValid(timeByUser);
                if(isTimeValid) {
                  BinarySearchTimes(timeByUser);
                } else {
                  System.out.print("Invalid time entered, try again!!");
                }
                
                default:
              System.out.println("Invalid Input, try again!!");
          }
      } while(shouldContinue);

  }; 

  private boolean _isGivenTimeValid(String t) {
    boolean timeValid = true;
    try {
      String [] hhmmss = t.split(":");
    
      if(hhmmss.length < 3) {
        timeValid = false;
      }

      int h = Integer.parseInt(hhmmss[0]);
      int m = Integer.parseInt(hhmmss[1]);
      int s = Integer.parseInt(hhmmss[2]);
      if(h >23 || h < 0) {
        JOptionPane.showMessageDialog(null, "Invalid hours, it should be >=0 and <=23 ");
        timeValid = false;
      }
      if(m < 0 ||  m > 59) {
        JOptionPane.showMessageDialog(null, "Invalid mins, it should be >=0 and <=59 ");
        timeValid = false;
      } if(s < 0 || s > 59) {
        JOptionPane.showMessageDialog(null, "Invalid seconds, it should be >=0 and <=59 ");
        timeValid = false;
      }
    } catch(Exception e) {
      timeValid = false;
    }
    return timeValid;
  }
    public void findTripsWithArrivalTime(String arrivalTime){

   
       
    }

    public boolean isBefore(String time1, String time2) {

      //returns true if time1 is before time2 and false otherwise

      String tHour1= time1.split("\\:")[0];
      String tMinute1 = time1.split("\\:") [1];
      String tSecond1 = time1.split("\\:")[2];

      String tHour2= time2.split("\\:")[0];
      String tMinute2 = time2.split("\\:") [1];
      String tSecond2 = time2.split("\\:")[2];

      if (Integer.parseInt(tHour1) < Integer.parseInt(tHour2)){
        return true;
      }
      else if (Integer.parseInt(tHour1) == Integer.parseInt(tHour2)){
        if (Integer.parseInt(tMinute1) < Integer.parseInt(tMinute2)){
          return true;
        }
        else if (Integer.parseInt(tMinute1) == Integer.parseInt(tMinute2)){
          if (Integer.parseInt(tSecond1) < Integer.parseInt(tSecond2)){
            return true;
          }

        }
      }


  return false;

    }


    public void BinarySearchTimes(String time){

      //return the line number of the time






    }

    /* this method will store all the data in stop_times, into a data structure 
    *
    * Each trip, (group of 41 stops will be added to a global variable tripList)
    * Each trip will be an object in itself
    *
    *
    *
    */

    public void loadStopTimes(){

    }

  

    public boolean isValidTime(String time){


      return false;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Vancouver Bus System");
        VancouverBusSystem v = new VancouverBusSystem();
        v.showMenu();



          Trip tester= new Trip("stop_times.txt");
          

         for (int index =0; index<tester.distances.size(); index++){

          System.out.println(tester.distances.get(index) + " " + tester.stopIds.get(index));
          
         }


         
         }


    
}
