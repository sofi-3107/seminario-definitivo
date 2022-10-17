
package com.mycompany.seminario.models;

import java.util.List;


/**
 *
 * @author Sofi
 */


public class ClienteModel extends PersonaModel{
    
    
    
    
    private String telefono;
    
    
    private int idContacto;
    
    private int idTipoDocumento;
    
    private String tipoDocumento;
    
    private String numeroDocumento;
    
    public ClienteModel(){
        super();
    }
    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }


    
    
    
    
    
}
