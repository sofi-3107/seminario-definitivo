package com.mycompany.seminario.hibernate.dao;

import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernate.models.TipoDocumento;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Sofi
 */
public class ClienteJpaControllerTest {

    public ClienteJpaControllerTest() {
    }

    private ClienteJpaController instance = new ClienteJpaController(EntityManagerProvider.getEntityManagerFactory());

  /*  @Test
    public void testCreate() {
        TipoDocumentoJpaController tc= new TipoDocumentoJpaController(EntityManagerProvider.getEntityManagerFactory());
        System.out.println("create");
        Cliente c = new Cliente();
        TipoDocumento t=tc.findTipoDocumento(1);
        assertNotNull("tipo documento nulo",t);
        c.setApellido("Peñaranda");
        c.setNombre("Nicolasa");
        c.setTipoDocumento(t);
        c.setNumDocumento("5876581");
        instance.create(c);
    }*/

    @Test
    public void testFindByTipoAndNumeroDocumento() {
        System.out.println("findByTipoAndNumeroDocumento");
        int id = 2;
        String num = "34066053";
        int tipoDoc = 1;
        Cliente result = instance.findByTipoAndNumeroDocumento(num, tipoDoc);
        System.out.println("telefono: "+result.getContacto().getTelefono());
        assertNotNull("cliente nulo", result);
        Integer expResult = 2;
        assertEquals("Ids diferentes",expResult, result.getId());      
       
    }

    @Test
    public void findByIdTest() {
        Integer id = 1;
        String expected = "34066052";
        Cliente res = instance.findCliente(id);
        assertEquals("no coinciden los DNI", res.getNumDocumento(), expected);

    }

}
