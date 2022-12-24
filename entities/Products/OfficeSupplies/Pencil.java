package entities.Products.OfficeSupplies;

import entities.Products.Product;

public class Pencil extends Product {

    public Pencil(Integer price) {
        super(price);
    }

    @Override
    public String getName() {
        return "карандаш";
    }

    @Override
    public String getTypeProduct() {
        return "канцелярия";
    };
}
