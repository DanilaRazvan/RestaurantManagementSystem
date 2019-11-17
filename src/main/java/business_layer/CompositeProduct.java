package business_layer;

import java.util.HashSet;

public class CompositeProduct extends MenuItem {

    private HashSet<MenuItem> parts;

    public CompositeProduct(String name, double price, HashSet<MenuItem> parts) {
        super(name, price);
        this.parts = parts;
    }

    public HashSet<MenuItem> getParts() {
        return parts;
    }

    public void setParts(HashSet<MenuItem> parts) {
        this.parts = parts;
    }
}
