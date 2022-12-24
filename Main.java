import controller.MachineController;
import entities.Products.Product;
import entities.Products.Vegetables.Cucumber;
import entities.Products.Vegetables.Tomato;
import repository.ProductRepository;
import services.ProductService;
import view.ProductMachineView;

public class Main {

    public static void main(String[] arr) {
        // создаем сервис на основе репозитория и добавляем продукты в массив Product
        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);
        service.addProduct(new Product[] { new Tomato(50), new Tomato(60), new Cucumber(66) });
        
        // создание автомата и вывод выбранного
        MachineController controller = new MachineController(service);
        printStr("Список автоматов: ");
        printArray(controller.getMachines());

        // список продуктов в созданном автомате
        Integer idMachine = 1;
        printStr("Доступные продукты автомата 1: ");
        printArray(controller.getProductMachine(idMachine));

        // лучший продукт
        System.out.println();
        printStr("Лучший продукт автомата 1: ");
        System.out.println(controller.getTheBestProduct(idMachine));

        // покупка токара по имени и цене
        System.out.println();
        var paymentCode = controller.buyProduct(idMachine, "помидор", 50);
        printStr("Покупка помидора, код: " + paymentCode);
        printStr("Доступные продукты автомата 1: ");
        printArray(controller.getProductMachine(idMachine));

        // получение зарезервированного товара
        System.out.println();
        ProductMachineView productFromReserve = controller.getReservedProduct(idMachine, paymentCode);
        printStr("Получили товар: ");
        printArray(new Object[] { productFromReserve });
    }

    public static void printArray(Object[] array) {
        for (Object object : array) {
            System.out.println(object);
        }
    }

    public static void printStr(String text) {
        System.out.println(text);
    }
}