import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

//most up to date
public class VancouverBusSystem {

  public ArrayList<String> findShortestRoute(String stop1, String stop2) {
    ArrayList<String> result = new ArrayList<String>(); 
    result.add(stop1);
    result.add(stop2);
    return result;
  }

  public ArrayList<String> findStopInfo(String stop) {
    ReadFile keyValueFile = new ReadFile();
    TST tst = new TST();
    File stopInfo = new File("stops.txt");

    ArrayList<String> keyArrayList = keyValueFile.keyArrayList(stopInfo);
    ArrayList<String> valueArrayList = keyValueFile.valueArrayList(stopInfo);

    for (int j = 0; j < keyArrayList.size(); j++) {
        String currentKey;
        currentKey = keyArrayList.get(j);

        String currentValue;
        currentValue = valueArrayList.get(j);

        tst.put(currentValue, currentKey);

    }
    ArrayList<String> result = new ArrayList<String>();
    result = tst.valuesWithPrefix(stop);
    return result;

  }

  public void showMenu(TripTwo tt) {

    boolean shouldContinue = true;
    Scanner sc = new Scanner(System.in);
    do {

      String[] userOptions = { "Please choose an option", "1. Find the shortest path between two stops",
          "2. Find bus stop information by stop name", "3. Find all trips with a given departure time" };

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setSize(420, 420);

      ImageIcon icon = new ImageIcon("NewBus.jpg");

      String inputFromUser = (String) JOptionPane.showInputDialog(

          frame, "Which of Our Services Would You Like To Use? Select an Option From The Dropdown Menu",
          "Vancouver Bus Service", JOptionPane.WARNING_MESSAGE,

          icon,

          userOptions, userOptions[0]);

      switch (inputFromUser) {
        case "1. Find the shortest path between two stops":
          String stop1 = JOptionPane.showInputDialog("Please enter the first stop");
          String stop2 = JOptionPane.showInputDialog("Please enter the second stop");

          ArrayList<String> resultShortesRoute = findShortestRoute(stop1, stop2);
          String resultsshortest = "";
          if(resultShortesRoute.isEmpty()) {
            resultsshortest = "No routes found, try again";
          } else {
            for (String s : resultShortesRoute) {
              resultsshortest += s + "\n";
            }
          }
          
          
          JOptionPane.showMessageDialog(frame, resultsshortest);
          break;
        case "2. Find bus stop information by stop name":
          String stop = JOptionPane.showInputDialog("Please enter the stop name to search");
          ArrayList<String> stopInfo = findStopInfo(stop);
          String resultstopInfo = "";
          if(stopInfo.isEmpty()) {
            resultstopInfo = "Couldnt find a stop! Please try again";
          } else {
          
          for (String s : stopInfo) {
            resultstopInfo += s + "\n";
          }
        }
          JOptionPane.showMessageDialog(frame, resultstopInfo);
          break;
        case "3. Find all trips with a given departure time":
          String timeByUser = JOptionPane
              .showInputDialog("Please enter the time you wish to depart in the format 'hh:mm:ss");
          ArrayList<String> arrivalTime = tt.findTripsWithArrivalTime(timeByUser);
          String resultToShow = "";
          for (String s : arrivalTime) {
            resultToShow += s + "\n";
          }
          JOptionPane.showMessageDialog(frame, resultToShow);

        default:
          System.out.println("Invalid Input, try again!!");
      }
    } while (shouldContinue);

  }

  public static void main(String[] args) throws Exception {
    System.out.println("Welcome to Vancouver Bus System");
    TripTwo t2 = new TripTwo("stop_times.txt");

    VancouverBusSystem v = new VancouverBusSystem();
    v.showMenu(t2);

  }
}