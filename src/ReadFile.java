import java.io.*; // Import the File/filereader class // Import this class to handle errors
import java.util.*;
import java.lang.*;

public class ReadFile {

  public static String[] keyArray = new String[8758];
  //public static String[] valueArray = new String[70057];

  public static void keyArray(String s, int i) {
    keyArray[i] = s;
  }

  // public static void valueArray(String s, int i) {
  //   valueArray[i] = s;
  // }

  /*
   * Takes all the adrress of the bus stops and places them into an array
   * 
   * @param File the stops.txt file returns the array with all the stops address
   * catches file not found error
   */
  public String[] keyArray(File file) {
    try {

      Scanner myReader = new Scanner(file);

      myReader.nextLine();
      int keyi = 1;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] key = data.split(",");
        keyArray(key[2], keyi);
        keyi++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return keyArray;
  }

  /*
   * Takes all the information of the bus stops and places them into an array
   * 
   * @param File the stops.txt file returns the array with all the stops info
   * catches file not found error
   */
  public String[] valueArray(File file) {
    String[] value = new String[8758];
    try {

      Scanner myReader = new Scanner(file);
      myReader.nextLine();
      int valuei = 1;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        value[valuei] = data;
        valuei++;

        // valueArray(value[0], valuei);
        // valuei++;
        // valueArray(value[1], valuei);
        // valuei++;
        // valueArray(value[3], valuei);
        // valuei++;
        // valueArray(value[4], valuei);
        // valuei++;
        // valueArray(value[5], valuei);
        // valuei++;
        // valueArray(value[6], valuei);
        // valuei++;
        // valueArray(value[7], valuei);
        // valuei++;
        // valueArray(value[8], valuei);
        // valuei++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    for (int i = 0; i < 8758; i++) {
      System.out.println(value[i]);
    }
    return value;
  }

  public static void main(String[] args) {

  }

}
