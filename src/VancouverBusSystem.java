import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.*;


public class VancouverBusSystem {
    
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

    public void findTripsWithArrivalTime(String arrivalTime){

      String tHour= arrivalTime.split("\\,")[0];
      String tMinute = arrivalTime.split("\\,") [1];
      String tSecond = arrivalTime.split("\\,")[2];

     
/*

trip object has array of  41 stops, 41 stop times, trip id, distance 
place all trips in an array List, sort by trip id n/40 log n 


*/





       
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

    public boolean isValidTime(String time){

      String hour = arrivalTime.split("\\:")[0];
      String minutes = arrivalTime.split("\\:") [1];
      String seconds = arrivalTime.split("\\:")[2];




    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Vancouver Bus System");


          VancouverBusSystem vbs = new VancouverBusSystem();

         System.out.println(vbs.isBefore("14:20:13", "14:20:15"));






  
    }

}
