public class Payment {

    private int paymentId;
    private int orderId;
    private String customerName;
    private double amount;
    private String paymentMethod;
    private String date;

    public Payment(int paymentId, int orderId, String customerName,
                   double amount, String paymentMethod, String date) {

        this.paymentId = paymentId;
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getDate() {
        return date;
    }
}
