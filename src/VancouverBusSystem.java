
import java.util.ArrayList;



public class VancouverBusSystem {

  ArrayList<Trip> tripList = new ArrayList<Trip>();
    
    public void findShortestRoute(String stop1, String stop2){

    }

    public void findStopInfo(String stop){
        System.out.println("Test2");

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



          Trip tester= new Trip("stop_times.txt");

         for (int index =0; index<tester.distances.size(); index++){

          System.out.println(tester.distances.get(index) + " " + tester.stopIds.get(index));
          
         }


         
         }


    
}
