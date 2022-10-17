package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.CommonQueries;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.TipoDocumentoModel;
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
public class TipoDocumentoDaoImpl implements DaoInterface<TipoDocumentoModel> {

    List<TipoDocumentoModel> tiposDoc = new ArrayList();

    @Override
    public List<TipoDocumentoModel> getAll() {
        try {
            ResultSet rs = CommonQueries.getSelectAllQuery("tipo_documento");
            while (rs.next()) {
             TipoDocumentoModel t= new TipoDocumentoModel();
             t.setId(rs.getInt("id"));
             t.setTipo(rs.getString("tipo"));
             tiposDoc.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiposDoc;
    }

    @Override
    public TipoDocumentoModel findById(TipoDocumentoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(TipoDocumentoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TipoDocumentoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TipoDocumentoModel o, TipoDocumentoModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
