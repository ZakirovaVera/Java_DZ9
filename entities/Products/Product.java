package entities.Products;

public abstract class Product implements ComparableProduct {

    Integer price;

    public Product(Integer price) {
        this.price = price;
    }

    public abstract String getName();

    public abstract String getTypeProduct();

    // получить цену
    public Integer getPrice() {
        return price;
    }

    @Override
    public Double getAttractiveness() {
        return Double.valueOf(getPrice());
    }

    @Override
    public int compareTo(ComparableProduct o) {
        if (this.getAttractiveness() > o.getAttractiveness()) {
        return -1;
        }
        return this.getAttractiveness().compareTo(o.getAttractiveness());
    }

    @Override
    public String toString() {
        return getTypeProduct() + " Название " + getName() + " Стоимость " + getPrice();
    }
}