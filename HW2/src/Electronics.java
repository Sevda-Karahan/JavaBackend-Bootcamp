public class Electronics extends Product {
    private int warrantyYears;

    public Electronics(String name, double price, int warrantyYears) {
        super(name, price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    public String getDescription(){
        return name + " (Elektronik) - " + warrantyYears + " yıl garanti";
    }
}
