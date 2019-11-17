package presentation_layer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainUI {

    private Scene scene;
    private Pane canvas;

    private Button admin;
    private Button waiter;
    private Button chef;

    private static ChefGUI chefGUI = new ChefGUI();
    private AdministratorGUI administratorGUI = new AdministratorGUI();
    private WaiterGUI waiterGUI = new WaiterGUI();

    public MainUI() {
        this.canvas = new Pane();
        this.scene = new Scene(canvas, 300,360);

        this.admin = new Button("Administrator");
        this.admin.setPrefSize(200,70);
        this.admin.setTranslateX(50);
        this.admin.setTranslateY(30);

        this.waiter = new Button("Waiter");
        this.waiter.setPrefSize(200,70);
        this.waiter.setTranslateX(50);
        this.waiter.setTranslateY(145);

        this.chef = new Button("Chef");
        this.chef.setPrefSize(200,70);
        this.chef.setTranslateX(50);
        this.chef.setTranslateY(260);

        this.canvas.getChildren().addAll(admin, waiter, chef);

        setHandlers();
    }

    private void setHandlers() {
        this.admin.setOnAction(e -> {
            Stage s = new Stage();
            s.setScene(administratorGUI.getScene());
            s.show();
            this.administratorGUI.showTableContent();
            s.setTitle("Administrator");
            s.setResizable(false);
        });

        this.waiter.setOnAction(e -> {
            Stage s = new Stage();
            s.setScene(waiterGUI.getScene());
            s.show();
            this.waiterGUI.showMenuItemsTableContent();
            s.setTitle("Waiter");
            s.setResizable(false);
        });

        this.chef.setOnAction(e -> {
            Stage s = new Stage();
            s.setScene(chefGUI.getScene());
            s.show();
            s.setTitle("Chef");
            s.setResizable(false);
        });
    }

    public static ChefGUI getChefGUI() {
        return chefGUI;
    }

    public Scene getScene(){
        return this.scene;
    }
}
