import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TripTwo {

	public static HashMap<String, ArrayList<String>> tripDataSet = new HashMap<String,ArrayList<String>>();  


	TripTwo(String filename){

		try{
			Scanner inputScanner = new Scanner(new File(filename));
			inputScanner.nextLine();


			while (inputScanner.hasNextLine()){

				String info = inputScanner.nextLine();
				String time = info.split("\\,") [1];
				time = time.trim();


				if (isValidTime(time)){

					if (tripDataSet.containsKey(time)){
						tripDataSet.get(time).add(info);
					}
					else{

						ArrayList<String> infoArray = new ArrayList<String>();
						infoArray.add(info);
						tripDataSet.put(time, infoArray);
					}

				}
			}
			inputScanner.close();

		} catch (FileNotFoundException e)
		{
		}

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

		String noBusError = "No buses depart at the specified time";
		String invalidInputError = "the input '" + arrivalTime + "' is not a valid time";

		if (isValidTime(arrivalTime)){

			if (tripDataSet.containsKey(arrivalTime)){
				tripsWithArrivalTime = tripDataSet.get(arrivalTime);
				sortByID(tripsWithArrivalTime);
			} else {
				tripsWithArrivalTime.add(noBusError);
			}
		}

		else {
			tripsWithArrivalTime.add(invalidInputError);
		}

		if(tripsWithArrivalTime.contains(noBusError) || tripsWithArrivalTime.contains(invalidInputError)){
			return tripsWithArrivalTime;
		}
		else{
			return formatOutput(tripsWithArrivalTime, arrivalTime);
		}
	}


	public ArrayList<String> formatOutput(ArrayList<String> tripsWithArrivalTime, String arrivalTime){



		ArrayList<String> output = new ArrayList<String>();


		for (int index =0; index<tripsWithArrivalTime.size(); index++){

			String line = tripsWithArrivalTime.get(index);

			String outputString = "Trip ID: " + line.split("\\,")[0] + ", Arrival Time: " + line.split("\\,")[1] + ", DepartureTime: " +
					line.split("\\,")[2] + ", Stop ID: " + line.split("\\,")[3] + ", Stop sequence: "  + line.split("\\,") [4] + ", Stop headsign: " + line.split("\\,") [5] 
							+ ", Pickup Type: " + line.split("\\,") [6] + ", Drop off type: "  + line.split("\\,") [7];

			if (line.split("\\,").length == 8){

				output.add(outputString);
			}

			else {
				outputString += ", Distance: " + line.split("\\,")[8];
				output.add(outputString);
			}
		}

		return output;


	}






	//using insertion sort
	public void sortByID(ArrayList<String> tripsWithArrivalTime){

		int[] IDArray = new int[tripsWithArrivalTime.size()];


		for (int index =0; index<tripsWithArrivalTime.size(); index++){

			String id = tripsWithArrivalTime.get(index).split("\\,")[0];
			id = id.trim();
			int idN = Integer.parseInt(id);

			IDArray[index] = idN;
		}

		int pHolder =0;  

		for (int counter =0; counter<IDArray.length; counter++) {

			pHolder = 0;

			do {

				if (IDArray[pHolder] > IDArray[pHolder+1]) {

					int tempValue = IDArray[pHolder+1];

					String line = tripsWithArrivalTime.get(pHolder +1);

					IDArray[pHolder+1] = IDArray[pHolder];

					tripsWithArrivalTime.set(pHolder+1, tripsWithArrivalTime.get(pHolder));

					tripsWithArrivalTime.set(pHolder, line);
				}

				pHolder++;
			} while (pHolder + 1 != IDArray.length);

		}


	}


	public static void main(String[] args) {

		TripTwo t2 = new TripTwo("stop_times.txt");


		for (int index =0; index<t2.findTripsWithArrivalTime("5:25:00").size(); index++){

			System.out.println(t2.findTripsWithArrivalTime("5:25:00").get(index));
		}







	}
}