package hello.core.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int price;
    private int discount;

    private Order(Long memberId, String itemName, int price, int discount){
        this.memberId = memberId;
        this.itemName = itemName;
        this.price = price;
        this.discount = discount;
    }

    public int CalculatePrice(){
        return price - discount;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    // 4. return 주문 결과 반환
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
