

public class Order {

    private int orderId;
    private String customerName;
    private String productName;
    private int quantity;
    private double total;
    private String status;
    private String date;

    public Order(int orderId, String customerName, String productName,
                 int quantity, double total, String status, String date) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
