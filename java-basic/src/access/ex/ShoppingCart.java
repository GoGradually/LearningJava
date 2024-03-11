package access.ex;

public class ShoppingCart {
    private final Item[] items = new Item[10];
    private int itemCount;

    public void addItem(Item item) {
        if (itemCount == 10) {
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        items[itemCount++] = item;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        int sum = 0;
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            int val = item.sumOfItemPrice();
            System.out.println("상품명: " + item.getItemName() + ", 합계:" + val);
            sum += val;
        }
        System.out.println("전체 가격 합:" + sum);
    }
}