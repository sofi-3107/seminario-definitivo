package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.CommonQueries;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.MarcaAutomotorModel;
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
public class MarcaAutomotorDaoImpl implements DaoInterface<MarcaAutomotorModel> {

   

    @Override
    public List<MarcaAutomotorModel> getAll() {
         List<MarcaAutomotorModel> marcas = new ArrayList();
        try {

            ResultSet rs = CommonQueries.getSelectAllQuery("marca_automotor");
            while (rs.next()) {
                MarcaAutomotorModel m=new MarcaAutomotorModel();
                m.setId(rs.getInt("id"));
                m.setMarca(rs.getString("marca"));
                marcas.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MarcaAutomotorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marcas;
    }

    @Override
    public MarcaAutomotorModel findById(MarcaAutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(MarcaAutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(MarcaAutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MarcaAutomotorModel o, MarcaAutomotorModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
