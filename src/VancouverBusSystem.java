import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Scanner;


public class VancouverBusSystem {
    
    public void findShortestRoute(String stop1, String stop2){

    }

    public void findStopInfo(String stop){

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


  
    }

}
