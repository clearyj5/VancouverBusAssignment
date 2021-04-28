import java.io.*; // Import the File/filereader class // Import this class to handle errors
import java.util.*;
import java.lang.*;

public class ReadFile {

  public static String[] keyArray = new String[8758];

  //would you consider using an array list here instead, since if anymore bus stops are added the program will not work
  //With an arrayList you dont have to specify size in advance
  

  public static void keyArray(String s, int i) {
    keyArray[i] = s;
  }

  
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
  *Edits the position of the words in the keys
  *by turning the strings into an element in an array and moving it
  */
  public String editString(String string) {
    int index = string.indexOf("WB");
    String[] aux = string.split(" ");
    String temp = aux[index];
    String temp2;
    for (int i = 1; i < aux.length; i++) {
      aux[i] = aux[i - 1];
    }
    int length = aux.length - 1;
    aux[length] = temp;
    String appended = Arrays.toString(aux);

    return appended;
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
        if (data.contains("WB ")) {
          editString(data);
        }
        if (data.contains("FLAGSTOP ")) {
          editString(data);
        }
        if (data.contains("NB ")) {
          editString(data);
        }
        if (data.contains("SB ")) {
          editString(data);
        }
        if (data.contains("EB ")) {
          editString(data);
        }
        value[valuei] = data;
        valuei++;

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
