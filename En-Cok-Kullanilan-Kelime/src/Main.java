import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bir Metin giriniz : ");
        String words = input.nextLine();
        String[] word = words.split(" ");

        HashMap<String,Integer> mostusedWord = new HashMap<>();

        for(String counter : word){
            if (mostusedWord.containsKey(counter)){
                mostusedWord.put(counter,mostusedWord.get(counter) + 1);
            }else{
                mostusedWord.put(counter,1);
            }
        }

int mostCount = 0;
String maxRepeatWord = "";


        for (Map.Entry<String,Integer> entry : mostusedWord.entrySet()){
            if (entry.getValue() >= mostCount){
                mostCount = entry.getValue();
                maxRepeatWord = entry.getKey();
            }
        }

        System.out.println("Metindeki en sık kullanılan kelime: " + maxRepeatWord + ", bu kelime " + mostCount + " kere kullanılmış.");
        }
    }
