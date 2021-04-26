import java.io.File;

public class Test {
    public static void main(String[] args) {
        ReadFile keyValueFile = new ReadFile();
        TST tst = new TST<>();
        File stopInfo = new File("stops.txt");

        String[] keyArray = keyValueFile.keyArray(stopInfo);
        String[] valueArray = keyValueFile.valueArray(stopInfo);

        for (int i = 0; i < 8758; i++) {
            String currentKey;
            currentKey = keyArray[i];
            
            String currentValue;
            currentValue = valueArray[i];

            put( currentValue, currentKey);
        
    }
}