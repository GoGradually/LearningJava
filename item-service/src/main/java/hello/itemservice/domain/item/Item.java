package hello.itemservice.domain.item;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private int quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
