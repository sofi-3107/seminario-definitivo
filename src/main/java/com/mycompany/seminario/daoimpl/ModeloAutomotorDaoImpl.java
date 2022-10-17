
package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.CommonQueries;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.ModeloAutomotorModel;
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
public class ModeloAutomotorDaoImpl implements DaoInterface<ModeloAutomotorModel>{

    @Override
    public List<ModeloAutomotorModel> getAll() {
        List<ModeloAutomotorModel> modelos = new ArrayList();
        try {

            ResultSet rs = CommonQueries.getSelectAllQuery("modelo_automotor");
            while (rs.next()) {
                ModeloAutomotorModel m=new ModeloAutomotorModel();
                m.setId(rs.getInt("id"));
                m.setMarca(rs.getString("marca"));
                m.setAnio(rs.getInt("anio"));
                m.setModelo(rs.getString("modelo"));
                modelos.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MarcaAutomotorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelos;
    }

    @Override
    public ModeloAutomotorModel findById(ModeloAutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(ModeloAutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ModeloAutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ModeloAutomotorModel o, ModeloAutomotorModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
