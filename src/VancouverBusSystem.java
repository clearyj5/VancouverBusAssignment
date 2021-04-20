import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Scanner;


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

    public void findTripsWithArrivalTime(Time arrivalTime){
        
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Vancouver Bus System");

        System.out.println("Testing pull request and merge to master branch"); //PC


        try {
            File myObj = new File("stops.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          System.out.println("Test"); //Pc 2




  
    }

}
