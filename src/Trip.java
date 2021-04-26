/* The following class creates a trip object (poorly named sorry)
* As you can see from the instance variables, the object consists of arrayLists holding the relevant data from the stop_times.txt file

Therefore data can be accessed in other classes as follows

eg. 

Trip test = new Trip("stop_times.txt");
test.distances.get(** index of distance which you want to get**);

*The constructor ensures stop times after 23:59:59 are not added to the list
*
 The input size is so large but there is no way of avoiding loading it in,
 So where possible use this object to get the information you need for your function as opposed to creating your own object
 This is just to stop the compiler unneccesarily reading very large files more than once.
*
*
*
*
*
*
*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trip  {

   public ArrayList<Integer> tripId = new ArrayList<Integer>();
   public  ArrayList<String> times = new ArrayList<String>();
   public ArrayList<Integer> stopIds = new ArrayList<Integer>();
   public ArrayList<Double> distances = new ArrayList<Double>();
   public final int N_OF_STOPS = 41;


     Trip(String filename){

        try{
            Scanner inputScanner = new Scanner(new File(filename));
            //skip first line
            inputScanner.nextLine();
          

           while (inputScanner.hasNextLine()){

                String line1 = inputScanner.nextLine();
                String line = line1;
    
                String time = line1.split("\\,")[1];
                String hourWord= time.split("\\:")[0];
                hourWord = hourWord.trim();
                int hour = Integer.parseInt(hourWord);

                if (isValidTime(time)){
                    this.tripId.add(Integer.parseInt((line.split("\\,") [0])));
                    this.times.add(time);
                    this.stopIds.add(Integer.parseInt((line.split("\\,") [3])));

                    if (Integer.parseInt(line.split("\\,")[4]) == 1) {
                        this.distances.add(Double.parseDouble((line.split("\\,") [7])));
                    }
                    else {
                        this.distances.add(Double.parseDouble((line.split("\\,") [8])));
                    }
                }

                else if (inputScanner.hasNextLine()){
                }

                else {
                      
                    }

                }
          inputScanner.close();
            
        } catch (FileNotFoundException e)
        {
    }
    
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


  public boolean isValidTime(String time){

    try{

      String hour = time.split("\\:") [0];
      String minute =time.split("\\:")[1];
      String second = time.split("\\:")[2];

      hour = hour.trim();
      minute = minute.trim();
      second = second.trim();

      if (Integer.parseInt(hour) < 24 && Integer.parseInt(hour)>=0){
        if (Integer.parseInt(minute)<60 && Integer.parseInt(minute)>=0){
          if (Integer.parseInt(second) <60 && Integer.parseInt(second)>=0){
            return true;
          }

        }
      }

    } catch (Exception e){
      return false;
    }

    return false;
  }




public ArrayList<String> findTripsWithArrivalTime(String arrivalTime){

    ArrayList<String> tripsWithArrivalTime = new ArrayList<String>();

    if (isValidTime(arrivalTime)){
    for (int index =0; index < times.size(); index++){

        if (times.get(index).trim().equals(arrivalTime.trim())){
            tripsWithArrivalTime.add("Trip ID: " + tripId.get(index) +"," +  " Leaves at: " + times.get(index) + ", " + "Stop ID: " + stopIds.get(index) + "," + " Distance: " + distances.get(index));

        }
    }

    }
    else {
        tripsWithArrivalTime.add("The time you entered " + "'" + arrivalTime + "'" + " " + "is invalid");
    }

    if (tripsWithArrivalTime.isEmpty()){
        tripsWithArrivalTime.add("No buses depart at the you entered '" + arrivalTime + "'");
    }

    return tripsWithArrivalTime;
}




  


  public static void main(String[] args) {

    Trip test = new Trip("stop_times.txt");


    ArrayList<String> t = new ArrayList<String>();
     t = test.findTripsWithArrivalTime("21:00:00");

    for (int index =0; index<t.size(); index++){
        System.out.println(t.get(index));
    }


  }

}