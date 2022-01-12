package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SesionFactory {
    private static final SesionFactory sesionFactory = new SesionFactory();
    private Transaction transaction = null;
    private Session currentSession = null;
    private SessionFactory sessionFactory;

    private SesionFactory() {
        try {

            Configuration config = new Configuration();
            // Se configura Hibernate a partir del archivo .cfg.xml
            config.configure();
            sessionFactory = config.buildSessionFactory();
            // Se construye la SessionFactory
        } catch (Exception ex) {
            System.err.println("No se pudo crear la SessionFactory:" +
                    ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SesionFactory getSesionFactory() {
        return sesionFactory;
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public Transaction openCurrentSessionwithTransaction() {
        if (currentSession == null || !currentSession.isOpen())
            currentSession = openCurrentSession();
        transaction = currentSession.beginTransaction();
        return transaction;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        transaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return transaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.transaction = currentTransaction;
    }
}
