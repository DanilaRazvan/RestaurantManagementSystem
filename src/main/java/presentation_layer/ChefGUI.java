package presentation_layer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.util.*;

public class ChefGUI implements Observer {

    private Scene scene;
    private Pane canvas;

    private TableView<Item> orderItems;

    private HashMap<String, Integer> items;

    public ChefGUI() {

        this.items = new HashMap<>();

        this.orderItems = new TableView();
        this.orderItems.setEditable(true);
        this.orderItems.setPrefSize(600,300);
        this.orderItems.setTranslateX(60);
        this.orderItems.setTranslateY(30);
        TableColumn<Item, ?> col1;
        col1 = new TableColumn("Item");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        col1.setPrefWidth(500);
        orderItems.getColumns().add(col1);
        col1 = new TableColumn("Qnt");
        col1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col1.setPrefWidth(99);
        orderItems.getColumns().add(col1);

        this.canvas = new Pane();
        this.canvas.getChildren().addAll(this.orderItems);
        this.scene = new Scene(canvas, 720,360);
    }

    public Scene getScene() {
        return this.scene;
    }

    @Override
    public void update(Observable o, Object arg) {
        List<Item> l = new ArrayList<>();
        HashMap<String, Integer> order = (HashMap<String, Integer>)arg;

        order.forEach((n, c) -> l.add(new Item(n, c)));

        ObservableList<Item> list = FXCollections.observableArrayList(l);

        orderItems.getItems().clear();
        orderItems.getItems().addAll(list);
    }



    public class Item {
        public String name;
        public int quantity;

        public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
