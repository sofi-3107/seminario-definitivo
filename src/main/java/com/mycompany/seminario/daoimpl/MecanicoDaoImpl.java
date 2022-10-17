
package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.DBConnectionProvider;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.MecanicoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class MecanicoDaoImpl implements DaoInterface<MecanicoModel>{
    
    Connection con=DBConnectionProvider.getDatabaseConnection();

    @Override
    public List<MecanicoModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MecanicoModel findById(MecanicoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void create(MecanicoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(MecanicoModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MecanicoModel o, MecanicoModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public MecanicoModel getMecanicoByTaller(int idTaller) {
        MecanicoModel m = new MecanicoModel();
        try {
            String query = "SELECT emp.nombre,emp.apellido,emp.id FROM empleado AS emp\n"
                    + "JOIN rol_empleado As rol ON emp.rol=rol.id\n"
                    + "JOIN taller As t ON emp.taller=t.id\n"
                    + "WHERE t.id=? AND rol.id=2;";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, idTaller);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
            m.setApellido(rs.getString("apellido"));
            m.setNombre(rs.getString("nombre"));
            m.setId(rs.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    
}
