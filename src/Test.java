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

        //BUG: search and prefix for stops with no editing positions works, but not for 
        //stops that have had first part moved
        //UPDATE ON BUG: changed readfile.editstring() method from .toString to a string builder
        //New BUG: duplicates keywords flagstop at the end of the code
        //eg STEVENS DR AT 500 BLOCK FLAGSTOP FLAGSTOP, where one of the flagstop should be SB

        Scanner scan = new Scanner(System.in);
        System.out.println("Stop name: ");
        String search = scan.nextLine();
        System.out.println(tst.get(search));

        System.out.println("Stop prefix: ");
        String prefix = scan.nextLine();
        System.out.println(tst.valuesWithPrefix(prefix));

    }
}