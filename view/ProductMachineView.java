package view;

public class ProductMachineView {

    public String typeProduct;
    public String nameProduct;
    public Integer priceProduct;

    @Override
    public String toString() {
        return typeProduct + " Название " + nameProduct + " Стоимость " + priceProduct;
    }
}
