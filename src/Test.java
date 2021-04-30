import java.io.File;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        ReadFile keyValueFile = new ReadFile();
        TST tst = new TST();
        File stopInfo = new File("stops.txt");

        ArrayList<String> keyArrayList = keyValueFile.keyArrayList(stopInfo);
        ArrayList<String> valueArrayList = keyValueFile.valueArrayList(stopInfo);

        // System.out.println(keyArrayList.size());
        for (int j = 0; j < keyArrayList.size(); j++) {
            String currentKey;
            currentKey = keyArrayList.get(j);

            String currentValue;
            currentValue = valueArrayList.get(j);

            tst.put(currentValue, currentKey);

        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Stop prefix: ");
        String prefix = scan.nextLine();
        for (String element : tst.valuesWithPrefix(prefix)) {
            System.out.println(element);
        }
        scan.close();

    }
}