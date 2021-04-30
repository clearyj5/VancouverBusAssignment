import java.io.*; // Import the File/filereader class // Import this class to handle errors
import java.util.*;

public class ReadFile {

  public static ArrayList<String> keyArrayList = new ArrayList<String>();
  public static ArrayList<String> valueArrayList = new ArrayList<String>();
  public static String[] keyWordsStrings = { "FLAGSTOP", "SB", "WB", "NB", "EB" };

  public void keyArrayList(String s) {
    keyArrayList.add(s);
  }

  /*
   * Takes all the adrress of the bus stops and places them into an array
   * 
   * @param File the stops.txt file returns the array with all the stops address
   * catches file not found error
   */
  public ArrayList<String> keyArrayList(File file) {
    try {

      Scanner myReader = new Scanner(file);

      myReader.nextLine();

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine().trim();
        String[] key = data.split(",");
        key[2].trim();
        if (key[2].contains("WB ")) {
          key[2] = (editString(key[2]));
        }
        if (key[2].contains("FLAGSTOP ")) {
          key[2] = editString(key[2]);
        }
        if (key[2].contains("NB ")) {
          key[2] = (editString(key[2]));
        }
        if (key[2].contains("SB ")) {
          key[2] = (editString(key[2]));
        }
        if (key[2].contains("EB ")) {
          key[2] = (editString(key[2]));
        }
        keyArrayList(key[2]);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return keyArrayList;
  }

  public static boolean checksKeyWords(String wordChecked) {
    for (int i = 0; i < keyWordsStrings.length; i++) {
      if (keyWordsStrings[i].equals(wordChecked)) {
        return true;
      }
    }
    return false;
  }

  /*
   * Edits the position of the words in the keys by turning the strings into an
   * element in an array and moving it
   */
  public String editString(String string) {
    String[] aux = string.split(" ");
    if (checksKeyWords(aux[0])) {
      String temp = aux[0];
      for (int j = 1; j < aux.length; j++) {
        aux[j - 1] = aux[j];
      }
      int length = aux.length - 1;
      aux[length] = temp;
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < aux.length; i++) {
        stringBuilder.append(aux[i]);
        stringBuilder.append(" ");
      }
      String appended = stringBuilder.toString();
      return appended;
    } else {
      return string;
    }
  }

  /*
   * Takes all the information of the bus stops and places them into an array
   * 
   * @param File the stops.txt file returns the array with all the stops info
   * catches file not found error
   */
  public ArrayList<String> valueArrayList(File file) {
    try {

      Scanner myReader = new Scanner(file);
      myReader.nextLine();
      // int valuei = 1;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        valueArrayList.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return valueArrayList;
  }
}
