package data_layer;

import business_layer.MenuItem;

import java.io.*;
import java.util.HashSet;

public class RestaurantSerialization {

    public HashSet<MenuItem> read() {
        HashSet<MenuItem> menuItems = new HashSet<MenuItem>();

        try {
            FileInputStream fis = new FileInputStream("menu_items.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            menuItems = (HashSet<MenuItem>) ois.readObject();

            ois.close();
            fis.close();
            System.out.println("Object has been deserialized");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    public void write(HashSet<MenuItem> menuItems) {
        try {
            FileOutputStream fos = new FileOutputStream("menu_items.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(menuItems);

            oos.close();
            fos.close();

            System.out.println("Object has been serialized");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
