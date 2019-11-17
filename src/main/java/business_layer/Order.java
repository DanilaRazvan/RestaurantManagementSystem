package business_layer;

import java.util.Date;

public class Order {

    static int id = 1;
    private int orderID;
    private Date date;
    private int table;

    public Order(int table) {
        this.date = new Date();
        this.table = table + 1;
        this.orderID = id;
        System.out.println(this.table + " " + this.orderID);
        id++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderID != order.orderID) return false;
        if (table != order.table) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = orderID;
        result = 31 * result + ((date != null) ? date.hashCode() : 0);
        result = 31 * result + table;
        return result;
    }
}
