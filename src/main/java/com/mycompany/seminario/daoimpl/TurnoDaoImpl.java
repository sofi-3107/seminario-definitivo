package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.DBConnectionProvider;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.TurnoModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class TurnoDaoImpl implements DaoInterface<TurnoModel> {

    Connection con = DBConnectionProvider.getDatabaseConnection();

    @Override
    public List<TurnoModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TurnoModel findById(TurnoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(TurnoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TurnoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TurnoModel o, TurnoModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<TurnoModel> getAvailableAppointments(LocalDate fecha,int idMecanico) {
        List<TurnoModel> turnos = new ArrayList();
        try {
            String query = "SELECT h.id,h.hora FROM horario AS h WHERE h.id NOT IN(SELECT t.horario FROM turno AS t WHERE t.fecha=? AND t.mecanico=?);";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setDate(1, Date.valueOf(fecha));
            pstm.setInt(2, idMecanico);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
            TurnoModel t=new TurnoModel();
            t.setFecha(fecha);
            t.setHora(rs.getTime("hora").toLocalTime());
            t.setIdHorario(rs.getInt("id"));
            turnos.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turnos;
    }

}
