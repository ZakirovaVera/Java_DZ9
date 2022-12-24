package entities.Products.Candy;

import entities.Products.Product;

public class Cookies extends Product{

    public Cookies(Integer price) {
        super(price);
    }

    @Override
    public String getName() {
        return "печенье";
    }

    @Override
    public String getTypeProduct() {
        return "сладости";
    }
    
}
