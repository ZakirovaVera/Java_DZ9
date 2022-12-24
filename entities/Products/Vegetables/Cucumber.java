package entities.Products.Vegetables;
import entities.Products.Product;


public class Cucumber extends Product{

    public Cucumber(Integer price) {
        super(price);
    }

    @Override
    public String getName() {
        return "огурец";
    }

    @Override
    public String getTypeProduct() {
        return "овощи";
    }
    

}
