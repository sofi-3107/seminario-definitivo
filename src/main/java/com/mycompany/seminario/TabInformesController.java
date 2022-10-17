
package com.mycompany.seminario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author Sofi
 */
public class TabInformesController implements Initializable {


    @FXML
    private ComboBox<?> especialidadMecanicaDropDown;
    @FXML
    private Button erFichaMecanicaBT;
    @FXML
    private ComboBox<?> mesesCB;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void loadFichaMecanicaWindow(ActionEvent event) {
    }

}
