
package com.mycompany.seminario.hibernatedao.eachentity;

import com.mycompany.seminario.hibernatedao.implementations.ClienteDaoImplHibernate;
import com.mycompany.seminario.hibernatedao.entityinterfaces.ClienteDaoHibernate;
import com.mycompany.seminario.hibernate.models.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sofy
 */
public class ClienteDaoEntityImplTest {
    
    public ClienteDaoEntityImplTest() {
    }
    
    
    
    @Test 
    public void testSaveOrUpdateCliente(){
        Cliente c=new Cliente();
        c.setApellido("Pereyra");
        c.setNombre("Geraldine");
        
        
    }
   

    @Test
    public void testfindAllClientes() {
        ClienteDaoHibernate c= new ClienteDaoImplHibernate();
        try {
           List<Cliente>clientes= c.findAll();
            int cant=2;
            assertEquals("cantidad clientes halladas: "+clientes.size(),2,clientes.size());
        } catch (Exception ex) {
            Logger.getLogger(ClienteDaoEntityImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
