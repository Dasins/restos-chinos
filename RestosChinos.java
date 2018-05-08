import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RestosChinos {
    String[] inputLines;
    int[] digitToMilliwattsArray = {90, 30, 75, 75, 60, 75, 90, 45, 105, 90};
    
    public RestosChinos() {
        readInput();
    }
    
    public static void main(String[] args) {
        RestosChinos instance = new RestosChinos();
    }
    
    private int calculateRemainder(String inputLine) {
        String[] clockSplit = inputLine.split(" ");
        double a = new Double(clockSplit[0]);
        double b = new Double(clockSplit[1]);
        Double c = new Double(clockSplit[2]);
        Double x = new Double(clockSplit[3]);
        Double y = new Double(clockSplit[4]);
        Double z = new Double(clockSplit[5]);

        //System.out.println("a " + a + " b " + b + " c " + c + " --  x " + x + " y " + y + " z " + z);
        int nominator;
        for (nominator = 1; nominator >= 999999; nominator++) {
            if ((nominator % a != x)
                    && (nominator % b == y)
                    && (nominator % c == z)) {
                    break;
            }
        }
        return nominator;
    }
    
    private void readInput() {

        try {
            BufferedReader standardIn = new BufferedReader(new InputStreamReader(System.in));
            String aLine = "";
            boolean moreLines = false;
            do {
                aLine = standardIn.readLine();
                if (aLine.equals("-1 -1 -1 -1 -1 -1")) {
                    moreLines = true;
                    break;
                }
                int remainder = calculateRemainder(aLine);
                System.out.println(remainder);

            } while (null == aLine && !moreLines);

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}
