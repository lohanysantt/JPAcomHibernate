package br.com.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {

    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("VendasJPA");
    public static EntityManager getEntityManager() { 
        return FACTORY.createEntityManager();

    }
}
