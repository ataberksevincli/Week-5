import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product implements IOPeration {

    Scanner scanner = new Scanner(System.in);

    boolean isRunning = true;

    private static final int id = 1;
    private static final ArrayList<Notebook> notebookList = new ArrayList<>();

    public Notebook(String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory) {
        super(name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }

    public Notebook() {
        super();
    }


    static {

        notebookList.add(new Notebook("Matebook 14", 7000.0, 5, 5, "Huawei", "14", 16, "512.0"));
        notebookList.add(new Notebook("v14 IGL", 3699.0, 5, 5, "Lenovo", "14", 8, "1024.0"));
        notebookList.add(new Notebook("TUF GAMING", 8199.0, 5, 5, "ASUS", "15.6", 32, "512.0"));


    }

    @Override
    public void runMenu() {
        Notebook noteBookManager = new Notebook();
        System.out.println();
        System.out.println("Notebook Yönetim Ekranı");
        System.out.println();
        System.out.println("1- Notebook Ekleme \n" +
                "2- Notebook Silme  \n" +
                "3- ID'ye göre filtreleme \n" +
                "4- Markaya göre filtreleme \n" +
                "5- Notebook Listeleme \n" +
                "0- Ana Menü");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");

        int selection = scanner.nextInt();
        switch (selection) {

            case 1:
                noteBookManager.addProduct();
                break;
            case 2:
                noteBookManager.deleteProduct();
                break;
            case 3:
                noteBookManager.filterByProductID();
                break;
            case 4:
                noteBookManager.filterByProductBrand();
                break;
            case 5:
                noteBookManager.showProductList();
            case 0:
                System.out.println();
                System.out.println("Ana menüye dönüş sağlanıyor : ");
                isRunning = false;
                break;
            default:
                System.out.println("Hatalı bir değer girdiniz.");


        }

    }

    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Stok", "İndirim");
        for (Notebook notebook : notebookList) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrandName(),
                    notebook.getMemory(), notebook.getScreenSize(), notebook.getRam(), notebook.getStock(),
                    notebook.getDiscountRate());
        }


    }

    @Override
    public void addProduct() {
        System.out.println("Lütfen yeni bir ID giriniz:");
        int newNotebookID = scanner.nextInt();
        scanner.nextLine();

        if (findNotebookById(newNotebookID) == null) {
            System.out.println("Lütfen ismini giriniz:");
            String newNotebookName = scanner.nextLine();

            System.out.println("Lütfen fiyatını giriniz:");
            int newNotebookPrice = scanner.nextInt();

            System.out.println("Lütfen indirim oranını giriniz:");
            double newNotebookDiscount = scanner.nextDouble();

            System.out.println("Lütfen stok bilgisi giriniz:");
            int newNotebookStock = scanner.nextInt();

            System.out.println("Lütfen markasını giriniz:");
            String newNotebookBrand = scanner.nextLine();

            System.out.println("Lütfen ekran boyutunu giriniz:");
            String newNotebookScreenSize = scanner.nextLine();

            System.out.println("Lütfen RAM giriniz(GB ile):");
            int newNotebookRam = scanner.nextInt();

            System.out.println("Lütfen hafızasını giriniz:");
            String newNotebookMemorySize = scanner.nextLine();

            notebookList.add(new Notebook(newNotebookName, newNotebookPrice, newNotebookDiscount, newNotebookStock, newNotebookBrand, newNotebookScreenSize, newNotebookRam, newNotebookMemorySize));

            System.out.println("Yeni notebook eklendi.");
            System.out.println("----------------------");

        } else {
            System.out.println("Bu ürün daha önce eklenmiş. Lütfen tekrar deneyin");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.println("Silmek istediğiniz ürünün ID'sini giriniz:");
        int deleteSelection = scanner.nextInt();

        Notebook notebookToDelete = findNotebookById(deleteSelection);

        if (notebookToDelete != null) {
            notebookList.remove(notebookToDelete);
            System.out.println("Ürün silindi.");
        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    private Notebook findNotebookById(int id) {
        for (Notebook notebook : notebookList) {
            if (notebook.getId() == id) {
                return notebook;
            }
        }
        return null;
    }


    @Override
    public void filterByProductID() {
        System.out.println("Filtrelemek istediğiniz ID'yi giriniz:");
        int filterID = scanner.nextInt();

        System.out.println("Filtre sonuçları");
        for (Notebook notebook : notebookList) {
            if (notebook.getId() == filterID) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s%n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrandName(),
                        notebook.getMemory(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }

    @Override
    public void filterByProductBrand() {
        System.out.println("Filtrelemek istediğiniz markayı giriniz:");
        String filterBrand = scanner.next();

        System.out.println("Filtre sonuçları");
        for (Notebook notebook : notebookList) {
            if (notebook.getBrandName().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s%n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrandName(),
                        notebook.getMemory(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }
}