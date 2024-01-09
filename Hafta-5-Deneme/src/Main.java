import java.util.*;
import java.io.*;

class Main {

    public static String LetterCapitalize(String str) {

        String newString = String.valueOf(str.charAt(0)).toUpperCase();

        for(int i = 1;i<str.length();i++){
            if(str.charAt(i-1) == ' '){
                newString += Character.toUpperCase(str.charAt(i));
            }else{
                newString+=str.charAt(i);
            }
        }
        return str;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LetterCapitalize(s.nextLine()));
    }

}