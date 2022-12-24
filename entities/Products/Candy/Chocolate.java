package entities.Products.Candy;

import entities.Products.Product;

public class Chocolate extends Product{

    public Chocolate(Integer price) {
        super(price);
    }

    @Override
    public String getName() {
        return "шоколад";
    }

    @Override
    public String getTypeProduct() {
        return "сладости";
    }
    
}
