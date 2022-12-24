package entities.Products.OfficeSupplies;

import entities.Products.Product;

public class Notebook extends Product {

    public Notebook(Integer price) {
        super(price);
    }

    @Override
    public String getName() {
        return "тетрадь";
    }

    @Override
    public String getTypeProduct() {
        return "канцелярия";
    }
    
}
