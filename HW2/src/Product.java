public abstract class Product implements Shippable {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getDescription();

    public void applyDiscount(double percent) {
        double discount = price * percent / 100;
        price -= discount;
    }

    public void ship(String address) {
        System.out.println(name + " ürünü şu adrese gönderiliyor: " + address);
    }

    public double getPrice() {
        return price;
    }
}
