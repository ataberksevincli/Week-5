import java.util.Scanner;

public class PatikaStore {
    Scanner scanner = new Scanner(System.in);

    boolean isRunning = true;


    public void run(){

        while (isRunning){

            System.out.println();
            System.out.println("Patika Store Yönetim Ekranı");
            System.out.println();
            System.out.println("1- Notebook işlemleri \n" +
                    "2- Cep Telefonu işlemleri \n" +
                    "3- Markaları listeleme \n" +
                    "0- Çıkış Yap");
            System.out.print("Yapmak istediğiniz işlemi seçiniz : ");

            int selection = scanner.nextInt();
            switch (selection){

                case 1:
                    Notebook notebook = new Notebook();
                    notebook.runMenu();
                    break;
                case 2:
                    Phone phone = new Phone();
                    phone.runMenu();
                    break;
                case 3:
                    Brand brand = new Brand();
                    brand.printBrand();
                    break;
                case 0:
                    System.out.println("Çıkış yapıldı.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Hatalı bir değer girdiniz.");



            }
        }
    }
}
