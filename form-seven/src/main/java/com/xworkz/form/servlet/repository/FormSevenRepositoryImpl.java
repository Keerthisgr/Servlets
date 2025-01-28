package com.xworkz.form.servlet.repository;

import com.xworkz.form.servlet.entity.FormSevenEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormSevenRepositoryImpl implements FormSevenRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("keerthi");

    @Override
    public Boolean save(FormSevenEntity formSevenEntity) {
        System.out.println("Save and validate in repo");
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(formSevenEntity);
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
