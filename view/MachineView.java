package view;

public class MachineView {
    
    public Integer id;
    public String productType;

    @Override
    public String toString() {
        return "Автомат № " + id + " тип продукта " + productType;
    }
}
