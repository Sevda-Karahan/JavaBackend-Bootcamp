public class Main {
    public static void main(String[] args) {
        // Ürünler oluşturuluyor
        Product laptop = new Electronics("Laptop", 15000, 2);
        Product tshirt = new Clothing("T-Shirt", 250, "M");
        Product book = new Book("1984", 120, "George Orwell");

        // Sipariş oluşturuluyor
        Order order = new Order("Ahmet Yılmaz", "İstanbul, Türkiye");

        // Ürünler ekleniyor
        order.addProduct(laptop);
        order.addProduct(tshirt);
        order.addProduct(book);

        // Sipariş detayı göster
        order.showOrderDetails();

        // İndirim uygulanıyor
        order.applyDiscountToAll(10);
        System.out.println("\n--- %10 indirim uygulandı ---");
        order.showOrderDetails();

        // Sipariş gönderiliyor
        order.shipOrder();
        order.showOrderDetails();

        // Kargo ilerliyor
        order.advanceShipment();
        order.showOrderDetails();
    }
}