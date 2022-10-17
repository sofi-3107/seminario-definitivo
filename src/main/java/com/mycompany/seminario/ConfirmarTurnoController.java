package com.mycompany.seminario;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmarTurnoController {

    @FXML
    private Button guardarDetalleTurnoBT;
    @FXML
    private CheckBox asistenciaCheck;
    @FXML
    private Button addClienteBT;
    
    private boolean asistencia=false;

    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void isChecked(ActionEvent event) {
        if(asistenciaCheck.isSelected()){
        this.asistencia=true;}
       
    }
    
    public boolean getAsistencia(){
        return this.asistencia;
    }

    @FXML
    private void guardarDetalleTurno(ActionEvent event) {
        Stage stage=(Stage) this.guardarDetalleTurnoBT.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addCliente(ActionEvent event) {
        
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("agregarCliente.fxml"));
            Parent root=loader.load();
           AgregarClienteController controller=loader.getController();
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