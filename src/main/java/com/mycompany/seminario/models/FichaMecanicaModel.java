
package com.mycompany.seminario.models;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Educacion
 */

@Getter @Setter @NoArgsConstructor
public class FichaMecanicaModel {
    
    
    private int numeroFicha;
    
    private Date fecha;
    
    private double costo;
       
    private int tiempoEmpleado;
    
    private String problema;
    
    private String trabajoRealizado;
    
    private String descargoCliente;
    
    private List<InsumoModel> insumos;
    
    private double costoTotalInsumos;
    
    private int idAutomotor;
    
    private String marcaAutomotor;
       
    private String modeloAutomotor;
    
    private String taller;
    
    private int idTaller;
    
    private ClienteModel cliente;
    
    private MecanicoModel mecanico;
    /* agregar mecanico, cliente, taller, automotor, lista de insumos*/
    
    
    
}
