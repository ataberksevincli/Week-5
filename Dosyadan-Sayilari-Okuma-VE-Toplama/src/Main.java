import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {


        try {
            FileReader input = new FileReader("src/numbers.txt");
            BufferedReader buffInput = new BufferedReader(input);
            String line;
            int totalNumber = 0;
            while ((line = buffInput.readLine()) != null) {
                totalNumber += Integer.parseInt(line);
            }
            System.out.println(totalNumber);
            buffInput.close();
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}