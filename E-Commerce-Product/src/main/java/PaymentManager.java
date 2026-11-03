import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaymentManager {

    public static ArrayList<Payment> payments = new ArrayList<>();

    public static void addPayment(Payment payment) {
        payments.add(payment);
    }

    public static ArrayList<Payment> getPayments() {

        payments.clear();

        String sql =
                "SELECT payment_id, order_id, customer_name, " +
                "amount, payment_method, payment_date " +
                "FROM payments " +
                "ORDER BY payment_id DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Payment payment = new Payment(
                        rs.getInt("payment_id"),
                        rs.getInt("order_id"),
                        rs.getString("customer_name"),
                        rs.getDouble("amount"),
                        rs.getString("payment_method"),
                        rs.getString("payment_date")
                );

                payments.add(payment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return payments;
    }
}