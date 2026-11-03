import java.util.ArrayList;

public class CustomerManager {

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static CustomerDAO customerDAO = new CustomerDAO();

    public static void addCustomer(Customer customer) {
        boolean added = customerDAO.addCustomer(
                customer.getCustomerName(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getAddress()
        );

        if (added) {
            customers.add(customer);
        }
    }

    public static ArrayList<Customer> getCustomers() {
        customers = customerDAO.getAllCustomers();
        return customers;
    }
   public static boolean updateCustomer(int customerId, String name, String phone, String email, String address) {
    return customerDAO.updateCustomer(customerId, name, phone, email, address);
}

public static boolean deleteCustomer(int customerId) {
    return customerDAO.deleteCustomer(customerId);
}

}
