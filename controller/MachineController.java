package controller;

import java.util.ArrayList;

import entities.Machines.VegetableVendingMachine;
import entities.Machines.VendingMachine;
import entities.Products.Product;
import services.ProductService;
import view.MachineView;
import view.ProductMachineView;

public class MachineController {

    private ProductService service;
    private ArrayList<VendingMachine> listMachine = new ArrayList<>();

    // конструктор, добавили один автомат - овощной
    public MachineController(ProductService service) {
        this.service = service;
        listMachine.add(new VegetableVendingMachine(1, "овощи"));
    }
    // получить массив автоматов
    public MachineView[] getMachines() {
        ArrayList<MachineView> listView = new ArrayList<>();
        for (VendingMachine vendingMachine : listMachine) {
            MachineView view = new MachineView();
            view.id = vendingMachine.getId();
            view.productType = vendingMachine.getTypeProduct();
            listView.add(view);
        }

        MachineView[] dsf = new MachineView[listView.size()];
        return listView.toArray(dsf);
    }
    // получить массив продуктов данного автомата
    public ProductMachineView[] getProductMachine(Integer id) {
        var machine = getMachineById(id);
        var typeProduct = machine.getTypeProduct();
        var products = service.getProduct(typeProduct);

        ArrayList<ProductMachineView> listView = new ArrayList<>();
        for (Product product : products) {
            ProductMachineView view = convertProductToView(product);
            listView.add(view);
        }

        ProductMachineView[] dsf = new ProductMachineView[listView.size()];
        return listView.toArray(dsf);
    }

    private ProductMachineView convertProductToView(Product product){
        ProductMachineView view = new ProductMachineView();
        view.typeProduct = product.getTypeProduct();
        view.nameProduct = product.getName();
        view.priceProduct = product.getPrice();

        return view;
    }
    // получить автомат по id
    private VendingMachine getMachineById(Integer id) {
        for (VendingMachine el : listMachine) {
            if (el.getId() == id) {
                return el;
            }
        }
        return null;
    }

    public String buyProduct(Integer idMachine, String productName, int price) {
        Product product = service.buyProduct(productName, price);
        if (product == null) {
            return "";
        }

        var machine = getMachineById(idMachine);
        String paymentCode = machine.reserveProduct(product);
        return paymentCode;
    }
    // получить зарезервированный товар в интересующем автомате по коду
    public ProductMachineView getReservedProduct(Integer idMachine, String paymentCode) {
        var machine = getMachineById(idMachine);
        Product product = machine.getReservedProduct(paymentCode);
        var view = convertProductToView(product);
        return view;
    }
    // получить лучший продукт у автомата
    public ProductMachineView getTheBestProduct(Integer idMachine){
        var machine = getMachineById(idMachine);
        var typeProduct = machine.getTypeProduct();
        Product product = service.getTheBestProduct(typeProduct);
        if (product == null) {
            return null;
        }
        var view = convertProductToView(product);
        return view;
    }
}
