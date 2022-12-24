package repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entities.Products.Product;

public class ProductRepository {
    // ключ тип продукта, значение - список продукров.
    private Map<String, ArrayList<Product>> product = new HashMap<>();
    // добавить продукт
    public void addProduct(Product[] arr) {
        for (Product el : arr) {
            if (product.containsKey(el.getTypeProduct())) {
                ArrayList<Product> value = product.get(el.getTypeProduct());
                value.add(el);
            } else {
                ArrayList<Product> value = new ArrayList<>();
                value.add(el);
                product.put(el.getTypeProduct(), value);
            }
        }
    }
    // получить продукт
    public ArrayList<Product> getProduct(String typeProduct) {
        if (product.containsKey(typeProduct)) {
            ArrayList<Product> value = product.get(typeProduct);
            return value;
        } else {
            return new ArrayList<>();
        }
    }
    // найти продукт и удалить купленный
    public Product buyProduct(String productName, int price) {
        Collection<ArrayList<Product>> arrListProducts = product.values();
        for (ArrayList<Product> el : arrListProducts) {
            var product = findPoduct(el, productName, price);
            if (product != null) {
                el.remove(product);
                return product;
            }
        }
        return null;
    }
    // найти продукт в ArrayList<Product> list
    public Product findPoduct(ArrayList<Product> list, String productName, int price) {
        for (Product product : list) {
            if (product.getName() == productName && product.getPrice() == price) {
                return product;
            }
        }

        return null;
    }
}
