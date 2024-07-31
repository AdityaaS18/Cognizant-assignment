package Week1DSA.E_Commerce;


public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class LinearSearch {
    public static Product search(Product[] products, int targetProductId) {
        for (Product product : products) {
            if (product.getProductId() == targetProductId) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product search(Product[] sortedProducts, int targetProductId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedProducts[mid].getProductId() == targetProductId) {
                return sortedProducts[mid];
            } else if (sortedProducts[mid].getProductId() < targetProductId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}