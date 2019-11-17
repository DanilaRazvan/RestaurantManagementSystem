package start;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation_layer.MainUI;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello");
        stage.setScene(new MainUI().getScene());
        stage.show();
        stage.setResizable(false);
    }
}
