package com.xworkz.form.repository;

import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;
import com.xworkz.form.entity.UserProfileEntity;

import javax.persistence.*;

public class UserProfileRepositoryImpl implements UserProfileRepository {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("keerthi");
    @Override
    public Boolean save(UserProfileEntity userProfileEntity) {
        System.out.println("Save and validate in repo");
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userProfileEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return false;

            } else {
                return false;
            }
        } finally {
            entityManager.close();
        }

    }
}


