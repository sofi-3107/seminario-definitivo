package com.mycompany.seminario.database;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Educacion
 */
public class CommonQueries {

    private static Connection conn = DBConnectionProvider.getDatabaseConnection();

    public static ResultSet getSelectAllQuery(String table) {
        ResultSet rs = null;

        try {
            String query = "SELECT * FROM " + table;
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static ResultSet getOneByIdQuery(int id, String table) {
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM " + table + " WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /* Supone que el nombre de la fk de tabla1 es igual al nombre de tabla2
        tener en cuenta que consulta desde la entidad referenciada
     */
    public static ResultSet getTwoJoinedTables(String table1, String table2) {
        ResultSet rs = null;
        String query = "SELECT * FROM" + table1 + " JOIN " + table2 + "ON " + table1 + ".id" + "=" + table2 + "." + table1 + ";";
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(query);
            System.out.println(query);

        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    /*Trae la union de dos tablas con un JOIN en un atributo String como date o varchar y la clausula where
        tener en cuenta que 
     */
    public static ResultSet getWithJoinStringWhereAttribute(String mainTableName, String joinTable, String fkName, String whereAttribute, String whereAttributeTable, String whereValue) {
        ResultSet rs = null;
        String whereAttributeInQuery = whereAttributeTable == mainTableName ? "a." + whereAttribute : "b." + whereAttribute;
        try {

            String query = "SELECT * FROM " + mainTableName + " AS a"
                    + " JOIN " + joinTable + " AS b" + " ON a.id" + "= b." + fkName
                    + "WHERE " + whereAttributeInQuery + "=" + whereValue;
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(query);
            System.out.println(query);

        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /*joinTable es la que tiene la clave foranea*/
    public static ResultSet getWithJoinIntWhereAttribute(String mainTableName, String joinTable, String fkName, String whereAttribute, String whereAttributeTable, int whereValue) {
        ResultSet rs = null;
        String query = "";
        String whereAttributeInQuery = whereAttributeTable == mainTableName ? "a." + whereAttribute : "b." + whereAttribute;
        try {

            query = "SELECT * FROM " + mainTableName + " AS a"
                    + " JOIN " + joinTable + " AS b" + " ON a.id" + "= b." + fkName
                    + " WHERE " + whereAttributeInQuery + "=" + "?;";
            System.out.println(query);
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, whereValue);
            rs = pstm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static ResultSet simpleSingleTableWhereQuery(String tableName, String attribute, String value,String filterOperationSymbol,String valueType) {
        ResultSet rs = null;
        
        try {
            
            String query = "SELECT * FROM "+tableName+ " WHERE "+attribute+filterOperationSymbol+"?";
            PreparedStatement pstm= conn.prepareStatement(query);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date dateParam=formatter.parse(value);
            switch(valueType.toUpperCase()){
                case"STRING":
                      pstm.setString(1, value);
                      break;
                case "DOUBLE":
                        pstm.setDouble(1, parseDouble(value));
                        break;
                case "INT":
                     pstm.setInt(1,parseInt(value));
                     break;
                case "DATE":
                   pstm.setDate(1, (java.sql.Date) dateParam);
                    break;
                           
            }
            rs=pstm.executeQuery();
            

     
        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static ResultSet simpleAndOrQueryStringParams(String tableName, String type, Map<String, String> params) {
        ResultSet rs = null;
        try {

            int chopTimes = 0;
            StringBuilder query = new StringBuilder("SELECT * FROM ").append(tableName).append(" WHERE ");

            params.forEach((k, v) -> {
                query.append(k).append("=").append(v).append(" ").append(type).append(" ");
            });
            chopTimes = type.toUpperCase().equals("AND") ? 4 : 3;

            for (int i = 0; i <= chopTimes; i++) {
                query.deleteCharAt(query.length() - 1);
            }
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(query.toString());

        } catch (SQLException ex) {
            Logger.getLogger(CommonQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
