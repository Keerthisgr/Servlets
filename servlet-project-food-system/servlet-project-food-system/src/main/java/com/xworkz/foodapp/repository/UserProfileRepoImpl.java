package com.xworkz.foodapp.repository;

import com.xworkz.foodapp.entity.UserProfileEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProfileRepoImpl implements UserProfileRepo {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("keerthi");

    @Override
    public Boolean save(UserProfileEntity userProfileEntity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(userProfileEntity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            return false;
        }finally {
            em.close();
        }
    }

    @Override
    public List<UserProfileEntity> getAllProfiles() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT getProfiles FROM UserProfileEntity getProfiles", UserProfileEntity.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

    }


    @Override
    public void deleteUserById(int id) {
        EntityManager em = emf.createEntityManager();
       try {
           em.getTransaction().begin();
           em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
           em.getTransaction().commit();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }finally {
           if (em.getTransaction().isActive())
               em.getTransaction().rollback();
       }
    }

    @Override
    public UserProfileEntity getProfileById(int id) {
        return ((UserProfileEntity) emf.createEntityManager().createNamedQuery("getProfileById").setParameter("id", id).getSingleResult());
    }

    @Override
    public Boolean updateProfile(UserProfileEntity entity) {
        EntityManager em = emf.createEntityManager();
        boolean isUpdated = false;
        try {
            em.getTransaction().begin();
            UserProfileEntity merge = em.merge(entity); // pass null to get error
            em.getTransaction().commit();
            if (merge != null){
                isUpdated = true;
            }
            return isUpdated;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return isUpdated;
        } finally {
            em.close();
        }
    }

}
