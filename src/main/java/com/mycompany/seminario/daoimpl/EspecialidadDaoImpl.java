package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.CommonQueries;
import com.mycompany.seminario.database.DBConnectionProvider;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.EspecialidadModel;
import com.mycompany.seminario.models.MecanicoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class EspecialidadDaoImpl implements DaoInterface<EspecialidadModel> {

    Connection con = DBConnectionProvider.getDatabaseConnection();

    @Override
    public List<EspecialidadModel> getAll() {
        List<EspecialidadModel> especialidades = new ArrayList();
        try {
            ResultSet rs = CommonQueries.getSelectAllQuery("taller");
            while (rs.next()) {
                EspecialidadModel e = new EspecialidadModel();
                e.setId(rs.getInt("id"));
                e.setNombreEspecialidad(rs.getString("especialidad"));
                especialidades.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especialidades;
    }

    @Override
    public EspecialidadModel findById(EspecialidadModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(EspecialidadModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(EspecialidadModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(EspecialidadModel o, EspecialidadModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
