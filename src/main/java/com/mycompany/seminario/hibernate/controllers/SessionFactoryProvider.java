/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminario.hibernate.controllers;

import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

/**
 *
 * @author Sofi
 */
public class SessionFactoryProvider {
    	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
 
	static {
		// Creating StandardServiceRegistryBuilder 
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		
		// Hibernate settings which is equivalent to hibernate.cfg.xml's properties
		Map<String, String> dbSettings = new HashMap<>();
		dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/seminario-programacion");
		dbSettings.put(Environment.USER, "root");
		dbSettings.put(Environment.PASS, "");
		dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
 
		// Apply database settings
		registryBuilder.applySettings(dbSettings);
		// Creating registry
		standardServiceRegistry = registryBuilder.build();
		// Creating MetadataSources
		MetadataSources sources = new MetadataSources(standardServiceRegistry);
		// Creating Metadata
		Metadata metadata = sources.getMetadataBuilder().build();
		// Creating SessionFactory
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	//Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
