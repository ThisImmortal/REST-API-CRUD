package org.restful.project.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("bookRESTcrud");

    public static EntityManagerFactory getEntityManagerFactory(){

        return emf;
    }
}
