/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.seminario;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sofi
 */
public class FichaMecanicaController implements Initializable {

    @FXML
    private Button saveFichaMecanicaBT;
    @FXML
    private CheckBox confClienteCheckBox;
    @FXML
    private TextArea disconformidadTxA;
    @FXML
    private Button agregarInsumoBT;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void saveFichaMecanica(ActionEvent event) {
          Stage stage=(Stage) this.saveFichaMecanicaBT.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void hideTextArea(ActionEvent event) {
        if (!confClienteCheckBox.isSelected()){
            disconformidadTxA.setVisible(true);
              confClienteCheckBox.setText("Cliente disconforme");
        }else{
            disconformidadTxA.setVisible(false);
            confClienteCheckBox.setText("Cliente conforme");
        }
        
    }

    @FXML
    private void openAddInsumoWindow(ActionEvent event) {
                 try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("agregarInsumo.fxml"));
            Parent root=loader.load();
            AgregarInsumoController controller=loader.getController();
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
           
                    
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
