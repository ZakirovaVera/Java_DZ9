package services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.sun.tools.javac.Main;

import entities.Products.Product;
import repository.ProductRepository;

public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product[] arr) {
        repository.addProduct(arr);
    }

    public ArrayList<Product> getProduct(String typeProduct) {
        return repository.getProduct(typeProduct);
    }

    public Product buyProduct(String productName, int price) {
        return repository.buyProduct(productName, price);
    }

    public Product getTheBestProduct(String typeProduct) {
        ArrayList<Product> list = repository.getProduct(typeProduct);
        list.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.compareTo(o2);
            }
        });
        if (list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

}
