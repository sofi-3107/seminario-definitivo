/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


/**
 *
 * @author Sofi
 */
public final class AgregarInsumoController implements Initializable{

    @FXML
    private ComboBox<String> insumoCB;
    @FXML
    private Button addInsumoBT;
    
    private List<String>insumos=new ArrayList();

    @FXML
    private void agregarInsumo(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Collections.addAll(insumos,new String []{"manija de puerta","correa","bomba","asiento delantero","llantas"});
       insumoCB.getItems().addAll(insumos);
    }
    
}
