import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LibraryManager {
    private static final String FILE_NAME = "kitaplar.txt";
    private static final String LOG_FILE = "log.txt";
    private List<Book> bookList = new ArrayList<>();

    public LibraryManager() {
        loadBooksFromFile();
    }

    // Kitapları dosyadan oku
    private void loadBooksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                log("kitaplar.txt oluşturuldu.");
            } catch (IOException e) {
                logError("kitaplar.txt oluşturulurken hata: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int stock = Integer.parseInt(parts[2].trim());
                    bookList.add(new Book(title, author, stock));
                }
            }
        } catch (IOException e) {
            logError("kitaplar.txt okunurken hata: " + e.getMessage());
        }
    }

    // Kitap ekle
    public void addBook(String title, String author, int stock) {
        bookList.add(new Book(title, author, stock));
        saveBooksToFile();
        log("Kitap eklendi: " + title);
    }

    // Kitap sil
    public void removeBook(String title) {
        boolean removed = bookList.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        if (removed) {
            saveBooksToFile();
            log("Kitap silindi: " + title);
        } else {
            log("Silinmek istenen kitap bulunamadı: " + title);
        }
    }

    // Stok güncelle
    public void updateStock(String title, int newStock) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                try {
                    if (newStock < 0) {
                        throw new InvalidStockException("Stok negatif olamaz: " + newStock);
                    }
                    book.setStock(newStock);
                    saveBooksToFile();
                    log("Stok güncellendi: " + title + " => " + newStock);
                    return;
                } catch (InvalidStockException e) {
                    System.out.println(e.getMessage());
                    logError(e.getMessage());
                    return;
                }
            }
        }
        log("Stok güncelleme - kitap bulunamadı: " + title);
    }

    // Kitap listesini dosyaya kaydet
    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : bookList) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            logError("Dosya yazılırken hata: " + e.getMessage());
        }
    }

    // Kitapları listele
    public void listBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Kütüphanede hiç kitap yok.");
        } else {
            System.out.println("Kitap Listesi:");
            for (Book book : bookList) {
                System.out.println("- " + book.getTitle() + " / " + book.getAuthor() + " / Stok: " + book.getStock());
            }
        }
    }

    // Log yaz
    private void log(String message) {
        writeLog("INFO", message);
    }

    // Hata logu yaz
    private void logError(String message) {
        writeLog("ERROR", message);
    }

    // Log dosyasına yaz
    private void writeLog(String type, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.write(timeStamp + " [" + type + "] " + message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Log dosyasına yazılamadı: " + e.getMessage());
        }
    }
}