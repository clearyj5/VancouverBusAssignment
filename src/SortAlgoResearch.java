/*
* The following class was made to gather information on the number of tripIDs to be sorted in each arrayList
*This data was used to justify the use of insertion sort in the sortByID method for function 3.
*/

import java.util.ArrayList;
public class SortAlgoResearch {

    public static void main(String[] args) {

		TripTwo t2 = new TripTwo("stop_times.txt");


		for (int index =0; index<t2.findTripsWithArrivalTime("23:51:11").size(); index++){
			System.out.println(t2.findTripsWithArrivalTime("23:51:11").get(index));
		}


		ArrayList<String> keys = new ArrayList<String>();

		for (String key: TripTwo.tripDataSet.keySet()) {
			keys.add(key);
		}

		int max =0;
		int temp =0;
		int sum=0;

		for (int index = 0; index<keys.size(); index++){

			temp = TripTwo.tripDataSet.get(keys.get(index)).size();
			sum += temp;


			if (temp>max){
				max = temp;
			}
		}

        double average = sum/keys.size();

		System.out.println("The maximum array length is " + max + " the average array length is " + average);




	}
}
    

