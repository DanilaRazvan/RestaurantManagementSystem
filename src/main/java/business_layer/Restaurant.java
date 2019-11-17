package business_layer;

import data_layer.FileWriter;
import data_layer.RestaurantSerialization;
import presentation_layer.MainUI;

import java.util.*;

public class Restaurant extends Observable implements IRestaurantProcessing {

    private RestaurantSerialization rs;

    private HashSet<MenuItem> menuItems;
    private HashMap<Order, HashMap<String, Integer>> orders;

    public Restaurant() {
        this.rs = new RestaurantSerialization();
        this.menuItems = rs.read();
        this.orders = new HashMap<>();
        this.addObserver(MainUI.getChefGUI());
    }

    @Override
    public void addMenuItem(MenuItem m) {
        assert m != null;
        assert !menuItems.contains(m);
        int size = menuItems.size();

        menuItems.add(m);

        for (MenuItem mi : this.menuItems) {
            System.out.println(mi.toString());
        }

        rs.write(menuItems);

        assert menuItems.size() == size + 1;
        assert isValid();
    }

    @Override
    public void deleteMenuItem(MenuItem m) {
        assert m != null;
        assert menuItems.contains(m);

        int size = menuItems.size();

        HashSet<MenuItem> r = new HashSet<>();

        delete(m,r);
        System.out.println(m.toString());

        this.menuItems.removeAll(r);
        this.menuItems.remove(m);
        rs.write(menuItems);

        assert menuItems.size() == size - 1;
        assert isValid();
    }

    private void delete(MenuItem m, HashSet<MenuItem> r) {
        for (MenuItem mi : this.menuItems) {
            if (mi instanceof CompositeProduct && ((CompositeProduct) mi).getParts().contains(m)) {
                r.add(mi);
                delete(mi, r);
            }
        }
    }

    @Override
    public void updateMenuItem(MenuItem oldMenuItem, MenuItem newMenuItem) {
        assert oldMenuItem != null && newMenuItem != null;
        assert menuItems.contains(oldMenuItem);
        int size = menuItems.size();

        this.menuItems.remove(oldMenuItem);
        this.menuItems.add(newMenuItem);
        rs.write(menuItems);

        assert menuItems.size() == size;
        assert isValid();
    }

    @Override
    public void createOrder(int table, HashMap<String, Integer> oi) {
        assert table > 0 && table <= 10;
        assert oi != null;
        int size = orders.keySet().size();

        Order order = new Order(table);
        this.orders.put(order, oi);

        //notify chef
        setChanged();
        notifyObservers(oi);

        assert orders.keySet().size() == size + 1;
        assert isValid();
    }

    @Override
    public void computeBill(int table, ArrayList<OrderItem> allOrderItems) {
        assert table > 0 && table <= 10;
        assert allOrderItems != null;

        FileWriter fw = new FileWriter(table, allOrderItems);
        fw.write();
    }

    public MenuItem searchProduct(String name) {
        for (MenuItem m : this.menuItems) {
            if (m.getName().equals(name)) return m;
        }
        return null;
    }

    public HashSet<MenuItem> getMenuItems() {
        return rs.read();
    }

    @Override
    public boolean isValid() {
        assert !menuItems.contains(null);

        return !menuItems.contains(null);
    }
}
