
package com.mycompany.seminario.controllers;

import com.mycompany.seminario.daoimpl.TurnoDaoImpl;
import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.models.TurnoModel;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Sofi
 */
public class TurnoController {
    
    
    public static List<TurnoModel>getTurnosDisponiblesMecanico(LocalDate fecha, int idMecanico){       
        TurnoDaoImpl t= (TurnoDaoImpl)DaoFactory.getDaoObject("turno");
        return t.getAvailableAppointments(fecha, idMecanico);
    }
    
}
