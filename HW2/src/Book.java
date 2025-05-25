public class Book extends Product {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return name + " (Kitap) - Yazar: " + author;
    }
}
