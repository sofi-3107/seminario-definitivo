package com.mycompany.seminario.hibernate.controllers;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sofi
 */
public class EntityManagerProvider {

    private static final String PERSISTENCE_UNIT_NAME = "seminario-programacion";

    private static EntityManagerFactory factory = null;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;

    }

}
