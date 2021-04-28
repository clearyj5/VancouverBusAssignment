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

		if (isValidTime(arrivalTime)){

			if (tripDataSet.containsKey(arrivalTime)){
				tripsWithArrivalTime = tripDataSet.get(arrivalTime);
				 sortByID(tripsWithArrivalTime);
			} else {
				tripsWithArrivalTime.add("No buses depart at the specified time");
			}
		}

		else {
			tripsWithArrivalTime.add("the input '" + arrivalTime + "' is not a valid time" );
		}
		return tripsWithArrivalTime;
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


		for (int index =0; index<t2.findTripsWithArrivalTime("23:51:11").size(); index++){
			System.out.println(t2.findTripsWithArrivalTime("23:51:11").get(index));
		}

		/*
		VancouverBusSystem v = new VancouverBusSystem();
        v.showMenu(t2);

		*/ 

		ArrayList<String> keys = new ArrayList<String>();

		for (String key: tripDataSet.keySet()) {
			keys.add(key);
		}

		int max =0;
		int temp =0;
		int sum=0;

		for (int index = 0; index<keys.size(); index++){

			temp = tripDataSet.get(keys.get(index)).size();
			sum += temp;


			if (temp>max){
				max = temp;
			}
		}

		System.out.println(max + " " + sum/keys.size());

}