package Question4;

import java.util.Scanner;

import java.util.ArrayList;

class Order {
    private final ArrayList<Item> items;
    private int ID;

    public Order(int ID) {
        items = new ArrayList<>();
        this.ID = ID;
    }

    public double calculateAverageCost() {
        double sum;
        sum = 0;
        for (Item x : items) {
            sum += x.getPrice();
        }
        return sum / items.size();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}


class Item {
    private int ID;
    private String name;
    private double price;

    public Item(int ID, String name, double price) {
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


public class Question4 {
    public static void main(String[] args) {
        System.out.println("Test");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new number ID for order: ");
        int ID = scanner.nextInt();
        System.out.print("How many items in the order: ");
        int n = scanner.nextInt();
        Order order = new Order(ID);
        for (int i = 1; i < n + 1; i++) {
            System.out.printf("Please enter the ID for item %d: ", i);
            int IDitems = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("PLease enter the name for item %d: ", i);
            String name = scanner.nextLine();
            System.out.printf("Please enter the price for item %d: ", i);
            double price = scanner.nextDouble();
            scanner.nextLine();
            Item item = new Item(IDitems, name, price);
            order.addItem(item);
        }
        System.out.printf("You have a new order with ID: %d\n", ID);
        System.out.printf("In the order, you have %d items\n", n);
        System.out.printf("The average price in the order is: %.2f", order.calculateAverageCost());
        scanner.close();
    }
}
