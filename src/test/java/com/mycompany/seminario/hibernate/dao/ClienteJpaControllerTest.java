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

    @Test
    public void testCreate() {
        TipoDocumentoJpaController tc= new TipoDocumentoJpaController(EntityManagerProvider.getEntityManagerFactory());
        System.out.println("create");
        Cliente c = new Cliente();
        TipoDocumento t=tc.findTipoDocumento(1);
        assertNotNull("tipo documento nulo",t);
        c.setApellido("Pachao");
        c.setNombre("Pedro");
        c.setTipoDocumento(t);
        c.setNumDocumento("25874123");
        instance.create(c);
    }

    @Test
    public void testFindByTipoAndNumeroDocumento() {
        System.out.println("findByTipoAndNumeroDocumento");
        int id = 2;
        String num = "34066053";
        int tipoDoc = 1;
        Cliente result = instance.findByTipoAndNumeroDocumento(num, tipoDoc);
        System.out.println("automotores: " + result.getAutomotorList().size());
        System.out.println("result" + result.getApellido());
        assertNotNull("cliente nulo", result);
        Integer expResult = 2;
        assertEquals("Ids diferentes",expResult, result.getId());      
        fail("No se puede recuperar el cliente por tipo y numero de documento ");
    }

    @Test
    public void findByIdTest() {
        Integer id = 1;
        String expected = "34066052";
        Cliente res = instance.findCliente(id);
        assertEquals("no coinciden los DNI", res.getNumDocumento(), expected);

    }

}
