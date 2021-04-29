import java.io.*; // Import the File/filereader class // Import this class to handle errors
import java.util.*;

public class ReadFile {

  public static ArrayList<String> keyArrayList = new ArrayList<String>();
  public static ArrayList<String> valueArrayList = new ArrayList<String>();

  public static void keyArrayList(String s) {
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
      // int keyi = 1;

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] key = data.split(",");

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

  /*
   * Edits the position of the words in the keys by turning the strings into an
   * element in an array and moving it
   */
  public static String editString(String string) {
    if (string.contains("WB ")) {
      // converts string to array
      String[] aux = string.split(" ");
      int index = -1;
      // finds the index of WB
      for (int i = 0; i < aux.length; i++) {
        if (aux[i].equals("WB")) {
          index = i;
          break;
        }
      }
      String temp = aux[index];
      for (int j = 1; j < aux.length; j++) {
        aux[j - 1] = aux[j];
      }
      int length = aux.length - 1;
      aux[length] = temp;
      String appended = Arrays.toString(aux);
      return appended;
    }

    else if (string.contains("FLAGSTOP ")) {
      String[] aux = string.split(" ");
      int index = -1;
      for (int i = 0; i < aux.length; i++) {
        if (aux[i].equals("FLAGSTOP")) {
          index = i;
          break;
        }
      }
      String temp = aux[index];
      for (int j = 1; j < aux.length; j++) {
        aux[j - 1] = aux[j];
      }
      int length = aux.length - 1;
      aux[length] = temp;
      String appended = Arrays.toString(aux);
      return appended;
    }

    else if (string.contains("NB ")) {
      String[] aux = string.split(" ");
      int index = -1;
      for (int i = 0; i < aux.length; i++) {
        if (aux[i].equals("NB")) {
          index = i;
          break;
        }
      }
      String temp = aux[index];
      for (int j = 1; j < aux.length; j++) {
        aux[j - 1] = aux[j];
      }
      int length = aux.length - 1;
      aux[length] = temp;
      String appended = Arrays.toString(aux);
      return appended;
    }

    else if (string.contains("SB ")) {
      String[] aux = string.split(" ");
      int index = -1;
      for (int i = 0; i < aux.length; i++) {
        if (aux[i].equals("SB")) {
          index = i;
          break;
        }
      }
      String temp = aux[index];
      for (int j = 1; j < aux.length; j++) {
        aux[j - 1] = aux[j];
      }
      int length = aux.length - 1;
      aux[length] = temp;
      String appended = Arrays.toString(aux);
      return appended;
    }

    else if (string.contains("EB ")) {
      String[] aux = string.split(" ");
      int index = -1;
      for (int i = 0; i < aux.length; i++) {
        if (aux[i].equals("EB")) {
          index = i;
          break;
        }
      }
      String temp = aux[index];
      for (int j = 1; j < aux.length; j++) {
        aux[j - 1] = aux[j];
      }
      int length = aux.length - 1;
      aux[length] = temp;
      String appended = Arrays.toString(aux);
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
    // for (int i = 0; i < valueArrayList.size(); i++) {
    //   System.out.println(valueArrayList.get(i));
    // }
    return valueArrayList;
  }

  public static void main(String[] args) {

  }

}
