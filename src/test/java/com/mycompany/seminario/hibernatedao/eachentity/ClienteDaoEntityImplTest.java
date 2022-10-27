
package com.mycompany.seminario.hibernatedao.eachentity;

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
    public void testSomeMethod() {
        ClienteDaoEntity c= new ClienteDaoEntityImpl();
        try {
            c.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ClienteDaoEntityImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        fail("The test case is a prototype.");
    }
    
}
