package com.leven.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:35 2018/8/16
 * @Modified By:
 */
public class HibernateUtil {

    private static final SessionFactory SESSIONFACTORY = buildSessionFactory();
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);

    private static SessionFactory buildSessionFactory() {

        // configures settings from hibernate.cfg.xml
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            LOGGER.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSIONFACTORY;
    }
}
