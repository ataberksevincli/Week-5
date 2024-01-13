import java.util.ArrayList;
import java.util.Scanner;

public class Phone extends Product implements IOPeration{
    private int camera;
    private int batteryCapacity;
    private String color;
    boolean isRunning = true;

    Scanner scanner = new Scanner(System.in);

    private static final ArrayList<Phone> mobilePhoneList = new ArrayList<>();



    public Phone(String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory, int camera, int batteryCapacity, String color) {
        super(name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public Phone() {
        super();
    }

    static {

        mobilePhoneList.add(new Phone("GALAXY A51", 3199.0, 5, 5, "Samsung", "6.5", 6, "128",32,4000,"Siyah"));
        mobilePhoneList.add(new Phone("IPHONE 11 64GB", 3000.0, 5, 5, "Apple", "6.1", 6, "64",5,3046,"Turuncu"));
        mobilePhoneList.add(new Phone("Redmi Note 10 Pro 8GB", 3000.0, 5, 5, "Xiaomi", "6.5", 12, "128",35,4000,"Beyaz"));


    }

    @Override
    public void runMenu() {
        Phone mobilePhoneManager = new Phone();
        System.out.println();
        System.out.println("Telefon Yönetim Ekranı");
        System.out.println();
        System.out.println("1- Telefon Ekleme \n" +
                "2- Telefon Silme  \n" +
                "3- ID'ye göre filtreleme \n" +
                "4- Markaya göre filtreleme \n" +
                "5- Telefon Listeleme \n" +
                "0- Ana Menü");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");

        int selection = scanner.nextInt();
        switch (selection) {

            case 1:
                mobilePhoneManager.addProduct();
                break;
            case 2:
                mobilePhoneManager.deleteProduct();
                break;
            case 3:
                mobilePhoneManager.filterByProductID();
                break;
            case 4:
                mobilePhoneManager.filterByProductBrand();
                break;
            case 5:
                mobilePhoneManager.showProductList();
            case 0:
                System.out.println();
                System.out.println("Ana menüye dönüş sağlanıyor : ");
                isRunning = false;
                break;
            default:
                System.out.println("Hatalı bir değer girdiniz.");


        }

    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

        for (Phone phone : mobilePhoneList) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getBrandName(), phone.getMemory(),
                    phone.getScreenSize(), phone.getRam(), phone.getBatteryCapacity(), phone.getColor(),
                    phone.getStock(), phone.getDiscountRate());
        }
    }

    @Override
    public void addProduct() {
        System.out.println("Lütfen yeni bir ID giriniz:");
        int newPhoneID = scanner.nextInt();
        scanner.nextLine();

        if (findPhoneById(newPhoneID) == null) {
            System.out.println("Lütfen ismini giriniz:");
            String newPhoneName = scanner.nextLine();

            System.out.println("Lütfen fiyatını giriniz:");
            int newPhonePrice = scanner.nextInt();

            System.out.println("Lütfen indirim oranını giriniz:");
            double newPhoneDiscount = scanner.nextDouble();

            System.out.println("Lütfen stok bilgisi giriniz:");
            int newPhoneStock = scanner.nextInt();

            System.out.println("Lütfen markasını giriniz:");
            String newPhoneBrand = scanner.nextLine();

            System.out.println("Lütfen ekran boyutunu giriniz:");
            String newPhoneScreenSize = scanner.nextLine();

            System.out.println("Lütfen RAM giriniz(GB ile):");
            int newPhoneRam = scanner.nextInt();

            System.out.println("Lütfen Kamera piksel değeri giriniz :");
            int newPhoneCamera = scanner.nextInt();

            System.out.println("Lütfen hafızasını giriniz:");
            String newPhoneMemorySize = scanner.nextLine();

            System.out.println("Lütfen renk giriniz:");
            String newPhoneColor = scanner.nextLine();

            System.out.println("Lütfen pil gücü giriniz:");
            int newPhoneBatterySize = scanner.nextInt();

            mobilePhoneList.add(new Phone(newPhoneName,newPhonePrice,newPhoneDiscount,newPhoneStock,newPhoneBrand,newPhoneScreenSize,newPhoneRam,newPhoneMemorySize,newPhoneCamera,newPhoneBatterySize,newPhoneColor));

            System.out.println("Yeni telefon eklendi.");
            System.out.println("----------------------");

        } else {
            System.out.println("Bu ürün daha önce eklenmiş. Lütfen tekrar deneyin");
        }
    }


    @Override
    public void deleteProduct() {
        System.out.println("Silmek istediğiniz ürünün ID'sini giriniz:");
        int deleteSelection = scanner.nextInt();

        Phone phoneToDelete = findPhoneById(deleteSelection);

        if (phoneToDelete != null) {
            mobilePhoneList.remove(phoneToDelete);
            System.out.println("Ürün silindi.");

        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    @Override
    public void filterByProductID() {
        System.out.println("Filtrelemek istediğiniz ID'yi giriniz:");
        int filterID = scanner.nextInt();

        Phone filteredPhone = findPhoneById(filterID);

        if (filteredPhone != null) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s%n",
                    "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM", "Pil", "Renk", "Stok", "İndirim");

            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    filteredPhone.getId(), filteredPhone.getName(), filteredPhone.getPrice(),
                    filteredPhone.getBrandName(), filteredPhone.getMemory(), filteredPhone.getScreenSize(),
                    filteredPhone.getRam(), filteredPhone.getBatteryCapacity(), filteredPhone.getColor(),
                    filteredPhone.getStock(), filteredPhone.getDiscountRate());
        } else {
            System.out.println("ID'ye göre ürün bulunamadı.");
        }
    }

    @Override
    public void filterByProductBrand() {
        System.out.println("Filtrelemek istediğiniz markayı giriniz:");
        String filterBrand = scanner.next();

        System.out.println("Filtre sonuçları:");
        for (Phone phone : mobilePhoneList) {
            if (phone.getBrandName().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                        phone.getId(), phone.getName(), phone.getPrice(), phone.getBrandName(),
                        phone.getMemory(), phone.getScreenSize(), phone.getRam(), phone.getBrandName(),
                        phone.getColor(), phone.getStock(), phone.getDiscountRate());
            }
        }
    }

    private Phone findPhoneById(int id) {
        for (Phone phone : mobilePhoneList) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }
}
