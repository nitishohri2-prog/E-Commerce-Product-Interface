import java.util.ArrayList;

public class ProductManager {

    private static ArrayList<Product> products = new ArrayList<>();
    private static ProductDAO productDAO = new ProductDAO();

    public static boolean addProduct(Product product) {
        boolean added = productDAO.addProduct(
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getQuantity()
        );

        if (added) {
            products.add(product);
        }

        return added;
    }

    public static ArrayList<Product> getProducts() {
        products = productDAO.getAllProducts();
        return products;
    }

    public static boolean updateProduct(int productId, String name, String category, double price, int quantity) {
        return productDAO.updateProduct(
                productId,
                name,
                category,
                price,
                quantity
        );
    }

    public static boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }
}
