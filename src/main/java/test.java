import controller.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class test extends Application {

    public static void main(String[] args) {
        System.out.println("Hello World");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Charger la scène principale
        FXMLLoader loader = new FXMLLoader(
                Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/hello-world.fxml"))
        );
        VBox root = loader.load();

        // Récupérer le contrôleur et lui passer le Stage
        HelloController helloController = loader.getController();
        helloController.setPrimaryStage(stage);

        // Charger le fichier CSS
        URL cssFile = getClass().getClassLoader().getResource("stylesheets/HelloWorld.css");
        Scene scene = new Scene(root, 300, 300);
        if (cssFile != null) {
            scene.getStylesheets().add(cssFile.toString());
        }

        // Configuration de la fenêtre
        stage.setTitle("Pizza Party");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Fermeture de l'application !");
    }
}
