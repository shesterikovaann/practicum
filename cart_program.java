import java.util.ArrayList;
import java.util.Iterator;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return String.format("%s - %.2f руб.", name, price);
    }
}


class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    // Добавить товар
    public void addProduct(Product p) {
        products.add(p);
    }

    // Удалить товар по названию
    public void removeProduct(String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                return;
            }
        }
    }

    // Посчитать общую сумму
    public double getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Вывести содержимое корзины
    public void printCart() {
        System.out.println("\n=== Корзина ===");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println("Итого: " + String.format("%.2f", getTotal()) + " руб.");
    }
}


public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Создание товаров
        Product milk = new Product("Молоко", 85.50);
        Product bread = new Product("Хлеб", 45.00);
        Product eggs = new Product("Яйца", 120.75);
        Product cheese = new Product("Сыр", 250.30);

        // Добавление в корзину
        cart.addProduct(milk);
        cart.addProduct(bread);
        cart.addProduct(eggs);
        cart.addProduct(cheese);

        // Показать корзину и итоговую сумму
        cart.printCart();

        // Удаление одного товара
        cart.removeProduct("Хлеб");
        System.out.println("\nУдаляем: Хлеб.");

        // Снова показать корзину
        cart.printCart();

    }

}
