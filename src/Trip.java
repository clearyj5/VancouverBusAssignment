import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trip {

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

                if (hour <=24){
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
                        System.out.println(line1);
                    }

                }
          


          inputScanner.close();
            
        } catch (FileNotFoundException e)
        {
    }
    
}
}

