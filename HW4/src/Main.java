import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("📚 Kütüphane Kitap Takip Sistemine Hoş Geldiniz 📚");

        do {
            System.out.println("\nYapmak istediğiniz işlemi seçin:");
            System.out.println("1 - Kitap Ekle");
            System.out.println("2 - Kitap Sil");
            System.out.println("3 - Stok Güncelle");
            System.out.println("4 - Kitapları Listele");
            System.out.println("5 - Çıkış");

            System.out.print("Seçiminiz: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Kitap adı: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Stok adedi: ");
                    int stock = readInteger(scanner);
                    manager.addBook(title, author, stock);
                    break;

                case "2":
                    System.out.print("Silinecek kitap adı: ");
                    String titleToDelete = scanner.nextLine();
                    manager.removeBook(titleToDelete);
                    break;

                case "3":
                    System.out.print("Stok güncellenecek kitap adı: ");
                    String titleToUpdate = scanner.nextLine();
                    System.out.print("Yeni stok adedi: ");
                    int newStock = readInteger(scanner);
                    manager.updateStock(titleToUpdate, newStock);
                    break;

                case "4":
                    manager.listBooks();
                    break;

                case "5":
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim! Lütfen 1-5 arasında bir değer girin.");
            }

        } while (!choice.equals("5"));

        scanner.close();
    }

    // Sayı kontrolü yapan yardımcı fonksiyon
    private static int readInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Geçerli bir sayı girin: ");
            }
        }
    }
}