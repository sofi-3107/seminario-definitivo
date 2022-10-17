
package com.mycompany.seminario.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofi
 */
public class DBConnectionProvider {
    
    
    private static Connection conn=null;
    
    public static Connection getDatabaseConnection(){
        try {
            Properties props= new Properties();
            props.load(new InputStreamReader(new FileInputStream("database.properties")));
            String user=props.getProperty("USER");
            String pass=props.getProperty("PASSWORD");
            String url=props.getProperty("URL");
            System.out.println(user+" "+pass+" "+url);
           /* String url="jdbc:mysql://localhost/seminario-programacion";
            String user="root";
            String pass="";*/
            if(conn==null){
                conn=DriverManager.getConnection(url, user, pass);
                System.out.println("conexión exitosa a base de datos: "+url);
            }
            
       } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(DBConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    
    }
    
    
}
