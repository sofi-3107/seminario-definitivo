
package com.mycompany.seminario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sofi
 */
public class AgregarClienteController implements Initializable {
    
    
    

    @FXML
    private ComboBox<?> tipoDocCB;
    @FXML
    private Button saveClienteBT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardarCliente(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
         alert.setHeaderText(null);
         
         alert.setTitle("Guardar Cliente");
         alert.setContentText("Cliente guardado correctamente");
         alert.showAndWait();
        Stage stage=(Stage) this.saveClienteBT.getScene().getWindow();
        stage.close();
    }
    
}
