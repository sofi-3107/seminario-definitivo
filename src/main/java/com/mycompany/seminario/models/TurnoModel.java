
package com.mycompany.seminario.models;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author Sofi
 */



public class TurnoModel {
    
    private LocalDate fecha;
    
    private int numeroTurno;
    
    private boolean asistencia;
    
    private LocalTime hora;
    
    private int idCliente;
    
    private String apellidoCliente;
    
    private String nombreCliente;
    
    private int idAutomotor;
   
   private String modeloAutomotor;
   
   private String marcaAutomotor;
   
   private int taller;
   
   private String especialidadMecanica;
   
   private int idHorario;
   
   private int idMecanico;

    @Override
    public String toString() {
        return hora+"";
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getIdAutomotor() {
        return idAutomotor;
    }

    public void setIdAutomotor(int idAutomotor) {
        this.idAutomotor = idAutomotor;
    }

    public String getModeloAutomotor() {
        return modeloAutomotor;
    }

    public void setModeloAutomotor(String modeloAutomotor) {
        this.modeloAutomotor = modeloAutomotor;
    }

    public String getMarcaAutomotor() {
        return marcaAutomotor;
    }

    public void setMarcaAutomotor(String marcaAutomotor) {
        this.marcaAutomotor = marcaAutomotor;
    }

    public int getTaller() {
        return taller;
    }

    public void setTaller(int taller) {
        this.taller = taller;
    }

    public String getEspecialidadMecanica() {
        return especialidadMecanica;
    }

    public void setEspecialidadMecanica(String especialidadMecanica) {
        this.especialidadMecanica = especialidadMecanica;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }
    
    
   
   
}
