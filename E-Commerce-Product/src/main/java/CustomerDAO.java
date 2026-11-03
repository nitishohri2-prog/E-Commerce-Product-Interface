import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    public boolean addCustomer(String name, String phone, String email, String address) {

        String sql = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, address);

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
   public java.util.ArrayList<Customer> getAllCustomers() {

    java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();

    String sql = "SELECT customer_id, name, phone, email, address FROM customers";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         java.sql.ResultSet rs = statement.executeQuery()) {

        while (rs.next()) {

            Customer customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address")
            );

            customers.add(customer);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return customers;
}
   public boolean updateCustomer(int customerId, String name, String phone, String email, String address) {
    String sql = "UPDATE customers SET name = ?, phone = ?, email = ?, address = ? WHERE customer_id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, name);
        statement.setString(2, phone);
        statement.setString(3, email);
        statement.setString(4, address);
        statement.setInt(5, customerId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean deleteCustomer(int customerId) {
    String sql = "DELETE FROM customers WHERE customer_id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, customerId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
}