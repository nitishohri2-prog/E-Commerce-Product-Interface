import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderManager {

    public static ArrayList<Order> orders = new ArrayList<>();

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static ArrayList<Order> getOrders() {

        orders.clear();

        String sql =
                "SELECT o.order_id, c.name AS customer_name, " +
                "p.name AS product_name, oi.quantity, " +
                "o.total_amount, o.status, o.order_date " +
                "FROM orders o " +
                "JOIN customers c ON o.customer_id = c.customer_id " +
                "JOIN order_items oi ON o.order_id = oi.order_id " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "ORDER BY o.order_id DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Order order = new Order(
                        rs.getInt("order_id"),
                        rs.getString("customer_name"),
                        rs.getString("product_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("total_amount"),
                        rs.getString("status"),
                        rs.getString("order_date")
                );

                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static ArrayList<Order> getPendingOrders() {

        ArrayList<Order> pendingOrders = new ArrayList<>();

        for (Order order : getOrders()) {

            if (order.getStatus().equalsIgnoreCase("Pending")) {
                pendingOrders.add(order);
            }
        }

        return pendingOrders;
    }
}