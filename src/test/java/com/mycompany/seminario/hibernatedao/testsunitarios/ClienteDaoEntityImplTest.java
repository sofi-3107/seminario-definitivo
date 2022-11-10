package com.mycompany.seminario.hibernatedao.testsunitarios;

import com.mycompany.seminario.factory.DaoFactory;
import com.mycompany.seminario.hibernate.models.Automotor;
import com.mycompany.seminario.hibernatedao.entityinterfaces.ClienteDaoHibernate;
import com.mycompany.seminario.hibernate.models.Cliente;
import com.mycompany.seminario.hibernate.models.Taller;
import com.mycompany.seminario.hibernate.models.TipoDocumento;
import com.mycompany.seminario.hibernatedao.entityinterfaces.AutomotorDaoHibernate;
import com.mycompany.seminario.hibernatedao.entityinterfaces.TallerDaoHibernate;
import com.mycompany.seminario.hibernatedao.entityinterfaces.TipoDocumentoDaoHibernate;
import java.util.ArrayList;
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
    ClienteDaoHibernate clienteDaoH = (ClienteDaoHibernate) DaoFactory.getHibernateDao("cliente");
    TipoDocumentoDaoHibernate tipoDocDaoH = (TipoDocumentoDaoHibernate) DaoFactory.getHibernateDao("tipodocumento");
    AutomotorDaoHibernate autoDaoH = (AutomotorDaoHibernate) DaoFactory.getHibernateDao("automotor");
    TallerDaoHibernate tallerDaoH = (TallerDaoHibernate) DaoFactory.getHibernateDao("taller");

    @Test
    public void testSaveOrUpdateCliente() {
        try {
            /* Creamos 2 clientes*/
            TipoDocumento dni = tipoDocDaoH.getId(1);
            TipoDocumento cedula = tipoDocDaoH.getId(2);

            Cliente c1 = new Cliente();
            c1.setApellido("Pereyra");
            c1.setNombre("Geraldine");
            c1.setTipoDocumento(dni);
            c1.setNumDocumento("34966052");

            Cliente c2 = new Cliente();
            c2.setApellido("Loper");
            c2.setNombre("Maria");
            c2.setTipoDocumento(cedula);
            c2.setNumDocumento("25632145");

            /*persistimos*/
            clienteDaoH.saveOrUpdate(c1);
            clienteDaoH.saveOrUpdate(c2);

            /*Los consultamos por tipo y numero de documento*/
            Cliente fetched1 = clienteDaoH.findByTipoAndNumDocumento(1, "34066052");
            Cliente fetched2 = clienteDaoH.findByTipoAndNumDocumento(2, "25632145");

            /*verificamos que Hibernate les haya dado un id al persistirlos*/
            assertNotNull(fetched1.getId());
            assertNotNull(fetched2.getId());

        } catch (Exception ex) {
            Logger.getLogger(ClienteDaoEntityImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void testfindAllClientes() {

        try {
            List<Cliente> clientes = clienteDaoH.findAll();
            /* la base de datos tiene 2 clientes, al ejecutar el test anterior tendra 4*/
            int cant = 4;
            assertEquals("cantidad clientes halladas: " + clientes.size(), 2, clientes.size());
        } catch (Exception ex) {
            Logger.getLogger(ClienteDaoEntityImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void deleteClientes() {
        try {
            Cliente fetched1 = clienteDaoH.findByTipoAndNumDocumento(1, "34066052");
            Cliente fetched2 = clienteDaoH.findByTipoAndNumDocumento(2, "25632145");
            clienteDaoH.delete(fetched1.getId());
            clienteDaoH.delete(fetched2.getId());
            Cliente afterDelete1 = clienteDaoH.findByTipoAndNumDocumento(2, "25632145");
            assertNull("recuperar cliente borrado: ",afterDelete1);
        } catch (Exception ex) {
           System.out.println("delete: "+ex.getMessage());
        }
    }

    @Test
    public void getAutomotoresDeUnCliente() {
        /*requiere los datos de BD*/
        List<Automotor> autos = autoDaoH.findByOwner(2);
        assertEquals("cantidad de autos del cliente 2: ", 2, autos.size());
    }

    @Test
    public void getTalleresMecanicos() {
        /*requiere los datos de BD*/
        List<Taller> talleres = new ArrayList();
        try {
            talleres = tallerDaoH.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ClienteDaoEntityImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals("cantidad de talleres en BD: ", 4, talleres.size());
    }

}
