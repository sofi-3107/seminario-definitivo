package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.DBConnectionProvider;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.AutomotorModel;
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
public class AutomotorDaoImpl implements DaoInterface<AutomotorModel> {

    Connection con = DBConnectionProvider.getDatabaseConnection();

    @Override
    public List<AutomotorModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AutomotorModel findById(AutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(AutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AutomotorModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AutomotorModel o, AutomotorModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<AutomotorModel> findByOwnerId(int id) {
        String query = "SELECT a.id AS idAuto,ma.marca,mo.modelo,mo.anio,ase.nombre AS aseguradora,ase.id AS idAseguradora,a.numero_poliza AS poliza FROM automotor AS a \n"
                + "JOIN cliente AS c ON c.id=a.dueño \n"
                + "JOIN marca_automotor AS ma ON a.marca=ma.id\n"
                + "JOIN modelo_automotor AS mo ON mo.id=a.modelo\n"
                + "JOIN aseguradora AS ase ON a.aseguradora=ase.id\n"
                + "WHERE c.id=?;";
        List<AutomotorModel> autos = new ArrayList();
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                AutomotorModel a = new AutomotorModel();
                a.setId(rs.getInt("idAuto"));
                a.setAnio(rs.getInt("anio"));
                a.setMarca(rs.getNString("marca"));
                a.setModelo(rs.getString("modelo"));
                a.setAseguradora(rs.getString("aseguradora"));
                a.setIdAseguradora(rs.getInt("idAseguradora"));
                a.setPoliza(rs.getString("poliza"));
                autos.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AutomotorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autos;

    }
}
