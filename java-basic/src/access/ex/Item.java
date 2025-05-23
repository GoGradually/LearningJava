package access.ex;

public class Item {
    private final String name;
    private final int price;
    private final int quantity;

    Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return name;
    }

    public int sumOfItemPrice() {
        return price * quantity;
    }
}