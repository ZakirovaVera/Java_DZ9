package entities.Machines;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import entities.Products.Product;

public abstract class VendingMachine {

    private Integer id;
    private String typeProduct;
    // ключ - код получения заказа, значение - продукт для получения.
    private Map<String, Product> reserveProduct = new HashMap<>();

    // конструктор торгового автомата
    public VendingMachine(Integer id, String typeProduct) {
        this.id = id;
        this.typeProduct = typeProduct;
    }
    // получить id
    public Integer getId() {
        return id;
    }
    // получить тип продукта
    public String getTypeProduct() {
        return typeProduct;
    }
    // резервирование продукта, присвоение кода
    public String reserveProduct(Product product) {
        String paymentCode = UUID.randomUUID().toString();
        reserveProduct.put(paymentCode, product);
        return paymentCode;
    }
    // получить зарезервированный продукт
    public Product getReservedProduct(String paymentCode) {
        if (reserveProduct.containsKey(paymentCode)) {
            Product product = reserveProduct.get(paymentCode);
            reserveProduct.remove(product);
            return product;
        }

        return null;
    }
}
