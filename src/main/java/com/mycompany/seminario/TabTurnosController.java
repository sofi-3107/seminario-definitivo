package com.mycompany.seminario;

import com.mycompany.seminario.controllers.EspecialidadController;
import com.mycompany.seminario.controllers.MecanicoController;
import com.mycompany.seminario.controllers.TurnoController;
import com.mycompany.seminario.models.EspecialidadModel;
import com.mycompany.seminario.models.MecanicoModel;
import com.mycompany.seminario.models.TurnoModel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author Sofi
 */
public class TabTurnosController implements Initializable {

    ObservableList<EspecialidadModel> especialidadesObs = FXCollections.observableArrayList();
    List<EspecialidadModel> especialidades = new ArrayList();
    ObservableList<TurnoModel> turnosObs = FXCollections.observableArrayList();
    List<TurnoModel> turnosD = new ArrayList();
    MecanicoModel mecanico = new MecanicoModel();
    LocalDate selectedDate = LocalDate.now();

    @FXML
    private ComboBox<EspecialidadModel> especialidadCB;
    @FXML
    private TitledPane datosClienteTP;
    @FXML
    private DatePicker agendarTurnoDP;
    @FXML
    private TextField mecanicoTF;
    @FXML
    private ComboBox<TurnoModel> turnoComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LocalDate today = LocalDate.now();
        agendarTurnoDP.setValue(today);
        especialidades = EspecialidadController.getEspecialidadesMecanicas();
        especialidadesObs.addAll(especialidades);
        especialidadCB.getItems().addAll(especialidadesObs);
    }

    @FXML
    private void onChangeEspecialidad(ActionEvent event) {
        if (!especialidadCB.getSelectionModel().isEmpty()) {
            try {
                mecanico = MecanicoController.getMecanicoPorEspecialidad(especialidadCB.getSelectionModel().getSelectedItem().getId());
                mecanicoTF.setText(mecanico.getNombre() + " " + mecanico.getApellido());
                /**/

                initTurnosDisponiblesComBoBox();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("asignarTurnoAccordion.fxml"));
                loader.load();
                AsignarTurnoAccordionController tabController = loader.getController();
                TurnoModel t = new TurnoModel();
                t.setIdMecanico(mecanico.getId());
                t.setFecha(agendarTurnoDP.getValue());
                System.out.println("turno en el origen: " + t.getIdMecanico() + " " + t.getFecha());
             
                tabController.setTurno(t);

            } catch (IOException ex) {
                Logger.getLogger(TabTurnosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void initTurnosDisponiblesComBoBox() {
        turnosD = TurnoController.getTurnosDisponiblesMecanico(selectedDate, mecanico.getId());
        turnosObs.addAll(turnosD);
        turnoComboBox.getItems().addAll(turnosObs);
    }

    @FXML
    private void onChangeSelectedDate(ActionEvent event) {
        if (!mecanicoTF.getText().isBlank()) {
            selectedDate = agendarTurnoDP.getValue();
            initTurnosDisponiblesComBoBox();
        } else {
            agendarTurnoDP.setValue(selectedDate);
            EasyAlertMaker.alertMessager(Alert.AlertType.ERROR, "Valor faltante", "Debe seleccionar una especialidad").show();
        }
    }


}
