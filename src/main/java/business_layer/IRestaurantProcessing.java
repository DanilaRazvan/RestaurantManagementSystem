package business_layer;

import java.util.ArrayList;
import java.util.HashMap;

public interface IRestaurantProcessing {

    /**
     * @param m product to add in restaurants menu
     * @pre m != null
     * @pre menuItems.contains(m) == false;
     * @post size() == size()@pre + 1
     */
    void addMenuItem(MenuItem m);

    /**
     * @param m - product to delete from restaurants menu
     * @pre m != null
     * @pre menuItems.contains(m) == true;
     * @post size() == size()@pre - 1
     */
    void deleteMenuItem(MenuItem m);

    /**
     * @param oldMenuItem - product to be updated
     * @param newMenuItem - new products
     * @pre oldMenuItem != null && newMenuItem != null
     * @pre menuItems.contains(oldMenuItem) == true
     * @post size() == size()@pre
     */
    void updateMenuItem(MenuItem oldMenuItem, MenuItem newMenuItem);

    /**
     * @param table - table from which the order was placed
     * @param oi - orders items names and with quantities
     * @pre table > 0 && table <= 10
     * @pre oi != null
     * @post size() == size()@pre + 1
     */
    void createOrder(int table, HashMap<String, Integer> oi);

    /**
     * @param table - table for which the bill will be computed
     * @param orderItems - all the products ordered on that table
     * @pre table > 0 && table <= 10
     * @pre orderItems != null
     */
    void computeBill(int table, ArrayList<OrderItem> orderItems);

    /**
     * @pre menuItems.contains(null) == false
     */
    boolean isValid();
}
