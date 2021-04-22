import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trip {

   public int tripId;
   public String [] times;
   public String [] stopIds;
   public int [] distances;

   public final int N_OF_STOPS = 41;

   ArrayList<Trip> tripList = new ArrayList<Trip>();
   
    Trip(String filename){


        try{

            Scanner inputScanner = new Scanner(new File(filename));

            int stopCounter =0;
            //skip line with headers
            inputScanner.nextLine();

            while (inputScanner.hasNextLine()){

                stopCounter++;

                if (stopCounter == 41){
                    tripList.add(this);
                    stopCounter =0;
                }

                String line = inputScanner.nextLine();
                this.tripId = Integer.parseInt(line.split("\\,")[0]);
                

                for (int index=0; index < 41; index++){

                this.times[index] = line.split("\\,")[1];
                this.stopIds[index] = line.split("\\,")[3];
                
                if (stopCounter == 0){
                    this.stopIds[index] = line.split("\\,")[7];
                }
                else {
                    this.stopIds[index] = line.split("\\,")[8];
                }

                line = inputScanner.nextLine();

                }
            }

        } catch (FileNotFoundException e){
            System.out.println("file not found");
        



    }
    
}
