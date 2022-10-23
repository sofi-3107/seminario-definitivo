package com.mycompany.seminario.hibernate.dao;

import com.mycompany.seminario.hibernate.models.Cliente;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Sofi
 */
public class ClienteJpaControllerTest {

    public ClienteJpaControllerTest() {
    }

    private ClienteJpaController instance = new ClienteJpaController(EntityManagerProvider.getEntityManagerFactory());
 

    @Test
    public void testFindByTipoAndNumeroDocumento() {
        System.out.println("findByTipoAndNumeroDocumento");
        int id = 1;
        String num = "34066052";
        int tipoDoc = 1;
        Cliente result = instance.findByTipoAndNumeroDocumento(num, tipoDoc);
        System.out.println("result" + result.getApellido());
        assertNotNull("cliente nulo",result);
        Integer expResult = 1;
        //assertEquals("Ids diferentes",expResult, result.getId());      
        //fail("No se puede recuperar el cliente por tipo y numero de documento ");
    }


    /* @Test
    public void testCreate() {
        System.out.println("create");
        Cliente c = new Cliente();      
        c.setApellido("Pachao");
        c.setNombre("Pedro");
        c.setNumDocumento("25874123");
        instance.create(c);     
    }*/
    @Test
    public void findByIdTest() {
        Integer id = 1;
        String expected = "34066052";
        Cliente res = instance.findCliente(id);
        assertEquals("no coinciden los DNI", res.getNumDocumento(), expected);

    }

}
