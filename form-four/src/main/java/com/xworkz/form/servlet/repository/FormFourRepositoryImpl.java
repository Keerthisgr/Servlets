package com.xworkz.form.servlet.repository;

import com.xworkz.form.servlet.entity.FormFourEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormFourRepositoryImpl implements FormFourRespository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("keerthi");

    @Override
    public Boolean save(FormFourEntity formFourEntity) {
        System.out.println("Save and validate in repo");
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(formFourEntity);
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
