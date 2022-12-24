package entities.Products.Vegetables;

import entities.Products.Product;

public class Tomato extends Product{

    public Tomato(Integer price) {
        super(price);
    }

    @Override
    public String getName() {
        return "помидор";
    }

    @Override
    public String getTypeProduct() {
        return "овощи";
    }
    
}
