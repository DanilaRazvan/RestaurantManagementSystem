package business_layer;

public class OrderItem {

    private String itemName;
    private double price;
    private int quantity;

    public OrderItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return itemName != null ? itemName.equals(orderItem.itemName) : orderItem.itemName == null;

    }

    @Override
    public int hashCode() {
        return itemName != null ? itemName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return itemName + " - " + price + " x " + quantity;
    }
}