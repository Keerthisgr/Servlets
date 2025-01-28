package com.xworkz.form.repository;

import com.xworkz.form.entity.FormEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormRepositoryImpl implements FormRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("keerthi");

    @Override
    public Boolean save(FormEntity formEntity) {
        System.out.println("Save and validate in repo");
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(formEntity);
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
