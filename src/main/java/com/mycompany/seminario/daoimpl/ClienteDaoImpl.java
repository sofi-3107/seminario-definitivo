package com.mycompany.seminario.daoimpl;

import com.mycompany.seminario.database.DBConnectionProvider;
import com.mycompany.seminario.database.DaoInterface;
import com.mycompany.seminario.models.ClienteModel;
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
public class ClienteDaoImpl implements DaoInterface<ClienteModel> {

    Connection conn = DBConnectionProvider.getDatabaseConnection();

    @Override
    public ClienteModel findById(ClienteModel o) {
        ClienteModel c = new ClienteModel();
        String query = "SELECT c.apellido, c.nombre c.tipo_documento";
        return c;
    }

    @Override
    public void create(ClienteModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ClienteModel o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ClienteModel o, ClienteModel p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ClienteModel findByTipoAndNumDocumento(int tipo, String numero) {
        ClienteModel c = new ClienteModel();
        try {

            String query = "SELECT c.apellido,c.id, c.nombre,con.telefono FROM cliente AS c\n"
                    + "JOIN tipo_documento AS t ON c.tipo_documento=t.id\n"
                    + "JOIN contacto AS con ON con.id=c.id WHERE c.tipo_documento=? AND c.num_documento=?;";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, tipo);
            pstm.setString(2, numero);
            ResultSet rs = pstm.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    c.setApellido(rs.getString("apellido"));
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("telefono"));

                }

            } else {
                throw new RuntimeException("El cliente no existe en la base de datos");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
}
