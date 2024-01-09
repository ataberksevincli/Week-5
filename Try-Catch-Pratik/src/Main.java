import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
        String[] arr = {"Ata", "Eru", "Ares", "Gandalf", "Sauron", "Melkor", "Yavanna", "Manwe", "Aragorn", "Eowyn"};
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Bir Eleman Numarası Giriniz : ");
        int i = scanner.nextInt();
        scanner.close();
        try {
            System.out.println("Belirtilen indeksteki eleman: " + arr[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Hata: Geçersiz indeks. Dizi boyutunu aşamazsınız.");
        }
    }
}

