package presentation_layer;

import business_layer.BaseProduct;
import business_layer.CompositeProduct;
import business_layer.MenuItem;
import business_layer.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AdministratorGUI {

    private Scene scene;
    private Pane canvas;

    private Button addBaseB;
    private Button addCompositeB;
    private Button addbB;
    private Button addcB;
    private Button delB;
    private Button updateB;
    private Button updateBaseB;
    private Button updateCompositeB;
    private Button addPartB;
    private Button delPartB;

    private Button doneB;

    private TextField itemName;
    private TextField price;

    private TableView<MenuItem> menuItems;
    private TableView<MenuItem> compProducts;

    MenuItem mi;

    public AdministratorGUI() {
        this.doneB = new Button("OK");
        this.doneB.setPrefSize(37,30);
        this.doneB.setTranslateX(683);
        this.doneB.setTranslateY(330);

        this.addbB = new Button("ADD BASE");
        this.addbB.setPrefSize(150, 40);
        this.addbB.setTranslateX(85);
        this.addbB.setTranslateY(40);

        this.addcB = new Button("ADD COMPOSITE");
        this.addcB.setPrefSize(150, 40);
        this.addcB.setTranslateX(85);
        this.addcB.setTranslateY(120);

        this.updateB = new Button("UPDATE");
        this.updateB.setPrefSize(150,40);
        this.updateB.setTranslateX(85);
        this.updateB.setTranslateY(200);

        this.updateBaseB = new Button("UPDATE");
        this.updateBaseB.setPrefSize(150,40);
        this.updateBaseB.setTranslateX(85);
        this.updateBaseB.setTranslateY(280);

        this.updateCompositeB = new Button("UPDATE");
        this.updateCompositeB.setPrefSize(150,40);
        this.updateCompositeB.setTranslateX(85);
        this.updateCompositeB.setTranslateY(280);

        this.delB = new Button("DELETE");
        this.delB.setPrefSize(150,40);
        this.delB.setTranslateX(85);
        this.delB.setTranslateY(280);

        this.addBaseB = new Button("ADD");
        this.addBaseB.setPrefSize(150,40);
        this.addBaseB.setTranslateX(85);
        this.addBaseB.setTranslateY(280);

        this.addCompositeB = new Button("ADD");
        this.addCompositeB.setPrefSize(150,40);
        this.addCompositeB.setTranslateX(85);
        this.addCompositeB.setTranslateY(280);

        this.itemName = new TextField();
        this.itemName.setPromptText("MENU ITEM NAME");
        this.itemName.setPrefSize(250,30);
        this.itemName.setTranslateX(35);
        this.itemName.setTranslateY(30);

        this.price = new TextField();
        this.price.setPromptText("PRICE");
        this.price.setPrefSize(250,30);
        this.price.setTranslateX(35);
        this.price.setTranslateY(90);

        this.addPartB = new Button("<-");
        this.addPartB.setPrefSize(50, 40);
        this.addPartB.setTranslateX(285);
        this.addPartB.setTranslateY(155);

        this.delPartB = new Button("DEL");
        this.delPartB.setPrefSize(50, 40);
        this.delPartB.setTranslateX(285);
        this.delPartB.setTranslateY(205);

        this.compProducts = new TableView<MenuItem>();
        this.compProducts.setPrefSize(250,100);
        this.compProducts.setTranslateX(35);
        this.compProducts.setTranslateY(150);
        TableColumn<MenuItem, ?> col = new TableColumn<>("Item");
        col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col.setPrefWidth(200);
        compProducts.getColumns().add(col);
        col = new TableColumn<>("Price");
        col.setCellValueFactory(new PropertyValueFactory<>("Price"));
        col.setPrefWidth(49);
        compProducts.getColumns().add(col);
        this.compProducts.setRowFactory(val -> {
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

        this.menuItems = new TableView<MenuItem>();
        this.menuItems.setPrefSize(350,300);
        this.menuItems.setTranslateX(335);
        this.menuItems.setTranslateY(30);
        col = new TableColumn<>("Item");
        col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        col.setPrefWidth(289);
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


        this.canvas = new Pane();
        this.scene = new Scene(canvas, 720,360);

        this.canvas.getChildren().addAll(this.doneB, this.updateB, this.addBaseB, this.addCompositeB, this.addbB, this.addcB, this.updateBaseB, this.updateCompositeB, this.delB, this.itemName, this.price, this.menuItems, this.compProducts, this.delPartB, this.addPartB);

        setHandlers();
        showMain();
    }

    private void setTexts(String name, double price) {
        this.itemName.setText(name);

        if (price == 0) {
            this.price.setText("");
        } else {
            this.price.setText(String.valueOf(price));
        }
    }

    public void showTableContent() {
        Restaurant r = new Restaurant();
        ObservableList<MenuItem> it = FXCollections.observableArrayList(r.getMenuItems());
        menuItems.setItems(it);
    }

    private void showMain() {
        this.addcB.setVisible(true);
        this.addbB.setVisible(true);
        this.updateB.setVisible(true);
        this.updateBaseB.setVisible(true);
        this.updateCompositeB.setVisible(true);
        this.delB.setVisible(true);

        this.compProducts.setVisible(false);
        this.addPartB.setVisible(false);
        this.delPartB.setVisible(false);
        this.addBaseB.setVisible(false);
        this.itemName.setVisible(false);
        this.price.setVisible(false);
    }

    private void showAddBase() {
        this.addcB.setVisible(false);
        this.addbB.setVisible(false);
        this.updateB.setVisible(false);
        this.updateBaseB.setVisible(false);
        this.updateCompositeB.setVisible(false);
        this.delB.setVisible(false);

        this.compProducts.setVisible(false);
        this.addPartB.setVisible(false);
        this.delPartB.setVisible(false);
        this.addBaseB.setVisible(true);
        this.addCompositeB.setVisible(false);
        this.itemName.setVisible(true);
        this.price.setVisible(true);
    }

    private void showAddComposite() {
        this.addcB.setVisible(false);
        this.addbB.setVisible(false);
        this.updateB.setVisible(false);
        this.updateBaseB.setVisible(false);
        this.updateCompositeB.setVisible(false);
        this.delB.setVisible(false);

        this.compProducts.setVisible(true);
        this.addPartB.setVisible(true);
        this.delPartB.setVisible(true);
        this.addBaseB.setVisible(false);
        this.addCompositeB.setVisible(true);
        this.itemName.setVisible(true);
        this.price.setVisible(true);
    }

    private void showUpdateBase() {
        this.addcB.setVisible(false);
        this.addbB.setVisible(false);
        this.updateB.setVisible(false);
        this.updateBaseB.setVisible(true);
        this.updateCompositeB.setVisible(false);
        this.delB.setVisible(false);

        this.compProducts.setVisible(false);
        this.addPartB.setVisible(false);
        this.delPartB.setVisible(false);
        this.addBaseB.setVisible(false);
        this.addCompositeB.setVisible(false);
        this.itemName.setVisible(true);
        this.price.setVisible(true);
    }

    private void showUpdateComposite() {
        this.addcB.setVisible(false);
        this.addbB.setVisible(false);
        this.updateB.setVisible(false);
        this.updateBaseB.setVisible(false);
        this.updateCompositeB.setVisible(true);
        this.delB.setVisible(false);

        this.compProducts.setVisible(true);
        this.addPartB.setVisible(true);
        this.delPartB.setVisible(true);
        this.addBaseB.setVisible(false);
        this.addCompositeB.setVisible(false);
        this.itemName.setVisible(true);
        this.price.setVisible(true);
    }

    private HashSet<MenuItem> getParts() {
        List<MenuItem> list = this.compProducts.getItems();
        return new HashSet<>(list);
    }

    private void setHandlers() {
        Restaurant r = new Restaurant();

        this.addBaseB.setOnAction(e -> {
            if(!itemName.getText().equals("") && !price.getText().equals("")) {
                String itemN = itemName.getText();
                double itemP = Double.valueOf(price.getText());
                setTexts("",0);

                BaseProduct m = new BaseProduct(itemN, itemP);
                r.addMenuItem(m);

                showTableContent();
                WaiterGUI.showMenuItemsTableContent();
                showMain();
            } else {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Please introduce correct data in all fields");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.addCompositeB.setOnAction(e -> {
            if(!itemName.getText().equals("") && !price.getText().equals("") && !(compProducts.getItems().size() == 0)) {
                String itemN = itemName.getText();
                double itemP = Double.valueOf(price.getText());
                setTexts("",0);

                CompositeProduct m = new CompositeProduct(itemN, itemP, getParts());
                r.addMenuItem(m);

                showTableContent();
                WaiterGUI.showMenuItemsTableContent();
                showMain();
            } else {
                Pane canvass = new Pane();
                Scene scene = new Scene(canvass, 250, 100);
                Label message = new Label("Please introduce correct data in all fields");
                canvass.getChildren().add(message);
                message.setPrefSize(250, 100);
                message.setAlignment(Pos.CENTER);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attention");
                stage.show();
            }
        });

        this.addbB.setOnAction(e -> {
            setTexts("", 0);
            showAddBase();
            showTableContent();
        });

        this.addcB.setOnAction(e -> {
            setTexts("", 0);
            this.compProducts.getItems().clear();
            showAddComposite();
            showTableContent();
        });

        this.addPartB.setOnAction(e -> {
            this.compProducts.getItems().add(this.menuItems.getSelectionModel().getSelectedItem());
        });

        this.delPartB.setOnAction(e -> {
            this.compProducts.getItems().remove(this.compProducts.getSelectionModel().getSelectedItem());
        });

        this.updateB.setOnAction(e -> {
            this.menuItems.getSelectionModel().getSelectedItem();
            MenuItem p = this.menuItems.getSelectionModel().getSelectedItem();
            if(p instanceof BaseProduct) {
                setTexts(p.getName(), p.getPrice());
                showUpdateBase();
            } else if(p instanceof CompositeProduct) {
                setTexts(p.getName(), p.getPrice());
                this.compProducts.getItems().setAll(((CompositeProduct) p).getParts());

                for(MenuItem m : ((CompositeProduct) p).getParts()){
                    System.out.println(m.getName());
                }

                showUpdateComposite();
            }
        });

        this.updateBaseB.setOnAction(e -> {
            mi = this.menuItems.getSelectionModel().getSelectedItem();
            String itemN = itemName.getText();
            double itemP = Double.valueOf(price.getText());
            setTexts("",0);

            BaseProduct m = new BaseProduct(itemN, itemP);
            r.updateMenuItem(mi, m);

            showMain();
            showTableContent();
            WaiterGUI.showMenuItemsTableContent();
        });

        this.updateCompositeB.setOnAction(e -> {
            mi = this.menuItems.getSelectionModel().getSelectedItem();

            String itemN = itemName.getText();
            double itemP = Double.valueOf(price.getText());
            setTexts("",0);

            CompositeProduct m = new CompositeProduct(itemN, itemP, getParts());
            r.updateMenuItem(mi, m);

            showMain();
            showTableContent();
            WaiterGUI.showMenuItemsTableContent();
        });

        this.delB.setOnAction(e -> {
            MenuItem m = this.menuItems.getSelectionModel().getSelectedItem();
            r.deleteMenuItem(m);

            showTableContent();
            WaiterGUI.showMenuItemsTableContent();
        });

        this.doneB.setOnAction(e -> showMain());
    }

    public Scene getScene() {
        return this.scene;
    }
}
