package edu.hibernate;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.configure("hibernate.cfg.xml");
        final var serviceRegistry = serviceRegistryBuilder.build();

        MetadataSources metadata = new MetadataSources(serviceRegistry);
        metadata.addAnnotatedClass(Aircraft.class);
        final var buildMetadata = metadata.buildMetadata();

        final var sessionFactory = buildMetadata.getSessionFactoryBuilder().build();

        final var session = sessionFactory.openSession();
        final var transaction = session.beginTransaction();

        final var aircraft = session.get(Aircraft.class, "733");

        log.info("Aircraft: {}", aircraft);

        final var list = (List<Aircraft>) session.createQuery("from Aircraft").list();
        for (Aircraft o : list) {
            log.info("A: {}", o);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
