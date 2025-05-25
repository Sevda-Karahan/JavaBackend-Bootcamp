public class Shipment {
    private String status;

    public Shipment() {
        this.status =  "Hazırlanıyor";
    }

    public void advanceStatus() {
        switch (status) {
            case "Hazırlanıyor":
                status = "Yolda";
                break;
            case "Yolda":
                status = "Teslim edildi";
                break;
        }
    }

    public String getStatus() {
        return status;
    }
}
