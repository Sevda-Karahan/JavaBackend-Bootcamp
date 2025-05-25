import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private String address;
    private List<Product> products;
    private Shipment shipment;

    public Order(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
        this.products = new ArrayList<>();
        this.shipment = new Shipment();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void applyDiscountToAll(double percent) {
        for (Product p : products) {
            p.applyDiscount(percent);
        }
    }

    public void shipOrder() {
        System.out.println("\nSipariş gönderiliyor:");
        for (Product p : products) {
            p.ship(address);
        }
        shipment.advanceStatus();
    }

    public void showOrderDetails() {
        System.out.println("\nSipariş Özeti (" + customerName + "):");
        for (Product p : products) {
            System.out.println("- " + p.getDescription() + " | Fiyat: " + p.getPrice() + " TL");
        }
        System.out.println("Kargo Durumu: " + shipment.getStatus());
    }

    public void advanceShipment() {
        shipment.advanceStatus();
    }
}
