
package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.CommonQueries;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.AseguradoraModel;
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
public class AseguradoraDaoImpl implements DaoInterface<AseguradoraModel>{

    @Override
    public List<AseguradoraModel> getAll() {
         List<AseguradoraModel>aseguradoras=new ArrayList();
        try {
           
            ResultSet rs= CommonQueries.getSelectAllQuery("aseguradora");
            while(rs.next()){
                AseguradoraModel a=new AseguradoraModel();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                aseguradoras.add(a);
            }
            
          
        } catch (SQLException ex) {
            Logger.getLogger(AseguradoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          return aseguradoras;
    }

    @Override
    public AseguradoraModel findById(AseguradoraModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(AseguradoraModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AseguradoraModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AseguradoraModel o, AseguradoraModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
