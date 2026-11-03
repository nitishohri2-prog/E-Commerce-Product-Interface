public class Customer {

    private int customerId;
    private String customerName;
    private String phone;
    private String email;
    private String address;

    public Customer(int customerId, String customerName,
                    String phone, String email, String address) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
