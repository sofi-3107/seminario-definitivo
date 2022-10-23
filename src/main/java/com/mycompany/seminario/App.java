package com.mycompany.seminario;

import com.mycompany.seminario.hibernate.dao.ClienteJpaController;
import com.mycompany.seminario.hibernate.dao.EntityManagerProvider;
import com.mycompany.seminario.hibernate.models.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1300, 700);
        stage.setScene(scene);
        stage.setTitle("SuperCharger");

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        ClienteJpaController instance = new ClienteJpaController(EntityManagerProvider.getEntityManagerFactory());
        Cliente result = instance.findByTipoAndNumeroDocumento("34066052", 1);
        System.out.println("result" + result.getApellido());
        launch();

    }

}
