package com.mycompany.seminario;

import com.mycompany.seminario.commandpattern.JasperReportImpl;
import com.mycompany.seminario.commandpattern.PrintReportInvoker;
import com.mycompany.seminario.controllers.AseguradoraController;
import com.mycompany.seminario.controllers.AutomotorController;
import com.mycompany.seminario.controllers.ClienteController;
import com.mycompany.seminario.controllers.MarcaAutoController;
import com.mycompany.seminario.controllers.ModeloAutoController;
import com.mycompany.seminario.controllers.TipoDocumentoController;
import com.mycompany.seminario.models.AseguradoraModel;
import com.mycompany.seminario.models.AutomotorModel;
import com.mycompany.seminario.models.ClienteModel;
import com.mycompany.seminario.models.MarcaAutomotorModel;
import com.mycompany.seminario.models.ModeloAutomotorModel;
import com.mycompany.seminario.models.TipoDocumentoModel;
import com.mycompany.seminario.models.TurnoModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sofi
 */
public class AsignarTurnoAccordionController implements Initializable {

    TurnoModel newTurno = new TurnoModel();

    ObservableList<TipoDocumentoModel> tiposDoc = FXCollections.observableArrayList();
    ObservableList<AseguradoraModel> aseguradoras = FXCollections.observableArrayList();
    ObservableList<MarcaAutomotorModel> marcasAutos = FXCollections.observableArrayList();
    ObservableList<ModeloAutomotorModel> modelosAutos = FXCollections.observableArrayList();
    ObservableList<AutomotorModel> autosObsCliente = FXCollections.observableArrayList();

    List<TipoDocumentoModel> listaTiposDoc = new ArrayList();
    List<AseguradoraModel> aseguradorasList = new ArrayList();
    List<MarcaAutomotorModel> marcasList = new ArrayList();
    List<ModeloAutomotorModel> modelosList = new ArrayList();

    ClienteModel cliente = new ClienteModel();
    List<AutomotorModel> autosCliente = new ArrayList();

    @FXML
    private ComboBox<ModeloAutomotorModel> modeloCB;
    @FXML
    private ComboBox<AseguradoraModel> aseguradoraCB;
    @FXML
    private ComboBox<MarcaAutomotorModel> marcaCB;
    @FXML
    private ComboBox<TipoDocumentoModel> tipoDocCB;
    @FXML
    private Button comprobanteBT;
    @FXML
    private Button agendarTurnoBT;
    @FXML
    private Button buscarPorDNIBT;
    @FXML
    private TextField documentoTF;
    @FXML
    private TextField apellidoTF;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField telefonoTF;
    @FXML
    private TextField polizaTF;
    @FXML
    private TextField numTurnoTF;
    @FXML
    private ComboBox<AutomotorModel> automotoresClienteCB;
    @FXML
    private TextField numPolizaAutomotorClienteTF;
    @FXML
    private Label labelAutomotoresCliente;
    @FXML
    private Label labelNumPolizaCliente;

   // String rutaInforme = "D:\\Netbeans Projects\\Seminario Programacion github\\seminario\\src\\main\\java\\com\\mycompany\\seminario\\Constancia_Turno.jrxml";
    String rutaInforme="Constancia_Turno.jrxml";
    JasperReportImpl jasper = new JasperReportImpl(rutaInforme, null);
    PrintReportInvoker print = new PrintReportInvoker();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initializeComboBoxes();
    }

    public void initializeComboBoxes() {

        switchClienteAutomotorVisibility(false);

        /*Fetching data FROM controller wich connects to database CRUD provider, dao implementations, JDBC behind it*/
        listaTiposDoc = TipoDocumentoController.getTiposDeDocumento();
        aseguradorasList = AseguradoraController.getAllAseguradoras();
        marcasList = MarcaAutoController.getMarcasAutos();
        modelosList = ModeloAutoController.getModelosAutos();

        /*Filling ObservableLists*/
        tiposDoc.addAll(listaTiposDoc);
        aseguradoras.addAll(aseguradorasList);
        marcasAutos.addAll(marcasList);
        modelosAutos.addAll(modelosList);

        /*Filling ComboBoxes with fetched data*/
        tipoDocCB.getItems().addAll(tiposDoc);
        aseguradoraCB.getItems().addAll(aseguradoras);
        marcaCB.getItems().addAll(marcasAutos);
        modeloCB.getItems().addAll(modelosAutos);

    }

    @FXML
    private void agendarTurno(ActionEvent event) {
        crearTurno();
        switchClienteAutomotorVisibility(false);
        FastClearControls.clearTextFields(apellidoTF, nombreTF, telefonoTF, documentoTF);

        /*
        verificar si el cliente existe 
        guardar el cliente si se carga el apellido, nombre y telefono. 
        O asignar el id al turno si existe
        limpiar los campos   
         */
    }

    @FXML
    private void buscarPorDocumento(ActionEvent event) {

        if (tipoDocCB.getSelectionModel().getSelectedItem() == null || documentoTF.getText().isEmpty()) {
            EasyAlertMaker.alertMessager(Alert.AlertType.ERROR, "campos requeridos", "Debe elegir un tipo y tipear un numero de documento").show();
        }
        cliente = ClienteController.buscarPorTipoyNumeroDocumento(tipoDocCB.getSelectionModel().getSelectedItem().getId(), documentoTF.getText());

        if (cliente.getApellido() == null) {
            documentoTF.clear();
            tipoDocCB.getSelectionModel().clearSelection();
            EasyAlertMaker.alertMessager(Alert.AlertType.INFORMATION, "Cliente no encontrado", "El cliente no existe en base de datos").show();
        } else {
            apellidoTF.setText(cliente.getApellido());
            nombreTF.setText(cliente.getNombre());
            telefonoTF.setText(cliente.getTelefono());
            autosCliente = AutomotorController.buscarPorDueño(cliente.getId());
            switchClienteAutomotorVisibility(true);
            autosObsCliente.addAll(autosCliente);
            automotoresClienteCB.getItems().addAll(autosObsCliente);

        }

    }

    @FXML
    private void onSelectAutomotorCliente(ActionEvent event) {

        String poliza = automotoresClienteCB.getSelectionModel().getSelectedItem().getPoliza();
        numPolizaAutomotorClienteTF.setText(poliza);

    }

    public void switchClienteAutomotorVisibility(boolean mustBeVisible) {
        automotoresClienteCB.setVisible(mustBeVisible);
        numPolizaAutomotorClienteTF.setVisible(mustBeVisible);
        labelAutomotoresCliente.setVisible(mustBeVisible);
        labelNumPolizaCliente.setVisible(mustBeVisible);
        /*DISABLE*/
        marcaCB.setDisable(mustBeVisible);
        modeloCB.setDisable(mustBeVisible);
        polizaTF.setDisable(mustBeVisible);
        aseguradoraCB.setDisable(mustBeVisible);
    }

    private void crearTurno() {
        System.out.println("Dato recibido: " + newTurno.getFecha());

    }

    public void setTurno(TurnoModel turno) {
        this.newTurno = turno;
    }

    @FXML
    private void imprimirComprobante(ActionEvent event) {

        print.setReporter(jasper);
        print.print();
    }
}
