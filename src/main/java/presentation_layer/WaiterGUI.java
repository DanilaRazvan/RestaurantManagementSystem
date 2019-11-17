package presentation_layer;

import business_layer.MenuItem;
import business_layer.OrderItem;
import business_layer.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class WaiterGUI {

    private Scene scene;
    private Pane canvas;

    private Label tableL;
    private ComboBox tablesCB;

    private TableView<OrderItem> orderItems;
    private static TableView<MenuItem> menuItems;

    private Button addB;
    private Button incB;
    private Button decB;
    private Button delB;
    private Button orderB;
    private Button billB;

    private TextField qnt;
    private TextField search;

    ArrayList<ArrayList<OrderItem>> tables;

    HashMap<String, Integer> order;

    public WaiterGUI() {

        this.order = new HashMap<String, Integer>();

        this.tableL = new Label("Table:");
        this.tableL.setPrefSize(50, 30);
        this.tableL.setTranslateX(130);
        this.tableL.setTranslateY(30);

        ObservableList<Integer> options =
                FXCollections.observableArrayList(
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                );
        tablesCB = new ComboBox(options);
        this.tablesCB.setPrefSize(70, 30);
        this.tablesCB.setTranslateX(170);
        this.tablesCB.setTranslateY(30);
        this.tablesCB.setOnAction(e -> {
            this.order.clear();
            this.orderItems.getItems().clear();
            this.orderItems.getItems().setAll(this.tables.get(this.tablesCB.getSelectionModel().getSelectedIndex()));
            this.tablesCB.setDisable(true);
        });

        this.tables = new ArrayList<ArrayList<OrderItem>>();
        for (int i = 0; i < 10; i++) {
            this.tables.add(new ArrayList<OrderItem>());
        }

        this.qnt = new TextField();
        this.qnt.setPromptText("Qnt");
        this.qnt.setPrefSize(50, 30);
        this.qnt.setTranslateX(410);
        this.qnt.setTranslateY(30);

        this.orderItems = new TableView<OrderItem>();
        this.orderItems.setEditable(true);
        this.orderItems.setPrefSize(250, 200);
        this.orderItems.setTranslateX(60);
        this.orderItems.setTranslateY(80);
        TableColumn<OrderItem, ?> col1;
        col1 = new TableColumn("Item");
        col1.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        col1.setPrefWidth(150);
        orderItems.getColumns().add(col1);
        col1 = new TableColumn("Price");
        col1.setCellValueFactory(new PropertyValueFactory<>("Price"));
        col1.setPrefWidth(49);
        orderItems.getColumns().add(col1);
        col1 = new TableColumn<>("Qnt");
        col1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col1.setPrefWidth(49);
        orderItems.getColumns().add(col1);
        this.orderItems.setRowFactory(val -> {
            TableRow<OrderItem> row = new TableRow<OrderItem>();
            row.setOnMouseClicked(e -> {
                try {
                } catch (NullPointerException ex) {
                    Pane canvass = new Pane();
                    Scene scene = new Scene(canvass, 250, 100);
                    Label message = new Label("Please select a valid row");
                    canvass.getChildren().add(message);
                    message.setPrefSize(250, 100);
                    message.setAlignment(Pos.CENTER);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Attention");
                    stage.show();
                }
            });
            return row;
        });

        this.menuItems = new TableView<MenuItem>();
        this.menuItems.setEditable(true);
        this.menuItems.setPrefSize(250, 200);
        this.menuItems.setTranslateX(410);
        this.menuItems.setTranslateY(80);
        TableColumn<MenuItem, ?> col;
        col = new TableColumn<>("Item");
        col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col.setPrefWidth(189);
        menuItems.getColumns().add(col);
        col = new TableColumn<>("Price");
        col.setCellValueFactory(new PropertyValueFactory<>("Price"));
        col.setPrefWidth(59);
        menuItems.getColumns().add(col);
        this.menuItems.setRowFactory(val -> {
            TableRow<MenuItem> row = new TableRow<MenuItem>();
            row.setOnMouseClicked(e -> {
                try {
                } catch (NullPointerException ex) {
                    Pane canvass = new Pane();
                    Scene scene = new Scene(canvass, 250, 100);
                    Label message = new Label("Please select a valid row");
                    canvass.getChildren().add(message);
                    message.setPrefSize(250, 100);
                    message.setAlignment(Pos.CENTER);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Attention");
                    stage.show();
                }
            });
            return row;
        });

        this.addB = new Button("ADD");
        this.addB.setPrefSize(60, 30);
        this.addB.setTranslateX(330);
        this.addB.setTranslateY(90);

        this.incB = new Button("+");
        this.incB.setPrefSize(60, 30);
        this.incB.setTranslateX(330);
        this.incB.setTranslateY(140);

        this.decB = new Button("-");
        this.decB.setPrefSize(60, 30);
        this.decB.setTranslateX(330);
        this.decB.setTranslateY(190);

        this.delB = new Button("DEL");
        this.delB.setPrefSize(60, 30);
        this.delB.setTranslateX(330);
        this.delB.setTranslateY(240);

        this.orderB = new Button("ORDER");
        this.orderB.setPrefSize(100, 30);
        this.orderB.setTranslateX(135);
        this.orderB.setTranslateY(300);

        this.billB = new Button("COMPUTE BILL");
        this.billB.setPrefSize(150, 30);
        this.billB.setTranslateX(460);
        this.billB.setTranslateY(300);

        this.search = new TextField();
        this.search.setPromptText("SEARCH");
        this.search.setPrefSize(150, 30);
        this.search.setTranslateX(510);
        this.search.setTranslateY(30);

        this.canvas = new Pane();
        this.canvas.getChildren().addAll(this.tableL, this.tablesCB, this.orderItems, this.menuItems, this.addB, this.incB, this.decB, this.delB, this.orderB, this.billB, this.search, this.qnt);
        this.scene = new Scene(canvas, 720, 360);

        setHandlers();
    }

    public static void showMenuItemsTableContent() {
        Restaurant r = new Restaurant();
        ObservableList<MenuItem> it = FXCollections.observableArrayList(r.getMenuItems());
        menuItems.setItems(it);
    }

    private void setHandlers() {
        Restaurant r = new Restaurant();

        this.addB.setOnAction(e -> {
            try {
                String itemN = menuItems.getSelectionModel().getSelectedItem().getName();
                double itemP = menuItems.getSelectionModel().getSelectedItem().getPrice();
                int quantity = this.qnt.getText().equals("") ? 1 : Integer.valueOf(this.qnt.getText());

                OrderItem oi = new OrderItem(itemN, itemP, quantity);
                ArrayList<OrderItem> items = tables.get(this.tablesCB.getSelectionModel().getSelectedIndex());
                if (items.contains(oi)) {
                    OrderItem o = items.get(items.indexOf(oi));
                    o.setQuantity(o.getQuantity() + oi.getQuantity());

                    if (this.order.containsKey(oi.getItemName())) {
                        Integer q = this.order.get(oi.getItemName());
                        this.order.replace(oi.getItemName(), q, q + quantity);
                    } else {
                        this.order.put(itemN, quantity);
                    }
                } else {
                    items.add(oi);
                    this.order.put(itemN, quantity);
                }

                ObservableList<OrderItem> list = FXCollections.observableArrayList(items);
                orderItems.getItems().clear();
                orderItems.getItems().addAll(list);
            } catch (Exception ex) {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Please select a table");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.incB.setOnAction(e -> {
            try {
                OrderItem oi = orderItems.getSelectionModel().getSelectedItem();
                oi.setQuantity(oi.getQuantity() + 1);
                ArrayList<OrderItem> items = tables.get(this.tablesCB.getSelectionModel().getSelectedIndex());

                Integer q = this.order.get(oi.getItemName());
                this.order.replace(oi.getItemName(), q, q + 1);

                ObservableList<OrderItem> list = FXCollections.observableArrayList(items);
                orderItems.getItems().clear();
                orderItems.getItems().addAll(list);
            } catch (Exception ex) {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Nothing to increment");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.decB.setOnAction(e -> {
            try {
                OrderItem oi = orderItems.getSelectionModel().getSelectedItem();
                ArrayList<OrderItem> items = tables.get(this.tablesCB.getSelectionModel().getSelectedIndex());

                if (oi.getQuantity() - 1 > 0) {
                    oi.setQuantity(oi.getQuantity() - 1);

                    Integer q = this.order.get(oi.getItemName());
                    this.order.replace(oi.getItemName(), q, q - 1);
                } else {
                    items.remove(oi);
                    this.order.remove(oi.getItemName());
                }

                ObservableList<OrderItem> list = FXCollections.observableArrayList(items);
                orderItems.getItems().clear();
                orderItems.getItems().addAll(list);
            } catch (Exception ex) {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Nothing to decrement");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.delB.setOnAction(e -> {
            try {
                OrderItem oi = orderItems.getSelectionModel().getSelectedItem();
                ArrayList<OrderItem> items = tables.get(this.tablesCB.getSelectionModel().getSelectedIndex());
                items.remove(oi);
                this.order.remove(oi.getItemName());
                ObservableList<OrderItem> list = FXCollections.observableArrayList(items);
                orderItems.getItems().clear();
                orderItems.getItems().addAll(list);
            } catch (Exception ex) {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Nothing to delete");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.orderB.setOnAction(e -> {
            if(this.order.size() == 0) {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Nothing to order");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            } else {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                this.order.forEach((n, c) -> System.out.println(n + " " + c));

                r.createOrder(this.tablesCB.getSelectionModel().getSelectedIndex(), this.order);

                this.order.clear();
                this.orderItems.getItems().clear();
                this.tablesCB.setDisable(false);
            }
        });

        this.billB.setOnAction(e -> {
            ArrayList<OrderItem> items = tables.get(this.tablesCB.getSelectionModel().getSelectedIndex());
            if(items.size() == 0) {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("No products ordered yet");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            } else {    this.order.clear();
                r.computeBill(this.tablesCB.getSelectionModel().getSelectedIndex() + 1, items);
                items.clear();
                ObservableList<OrderItem> list = FXCollections.observableArrayList(items);
                orderItems.getItems().clear();
                orderItems.getItems().addAll(list);

                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Bill was generated");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.search.setOnKeyTyped(e -> {
            if (!this.search.getText().equals("")) {
                MenuItem p = r.searchProduct(this.search.getText());

                if (p != null) {
                    this.menuItems.getItems().setAll(p);
                } else {
                    showMenuItemsTableContent();
                }
            } else {
                showMenuItemsTableContent();
            }
        });
    }

    public Scene getScene() {
        return this.scene;
    }
}
