/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.dao.impl;

import com.mohit.program.dao.UserDAO;
import com.mohit.program.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Mohit
 */
public class UserDAOImpl implements UserDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RJPA");
    EntityManager em = emf.createEntityManager();
    EntityTransaction trans = em.getTransaction();

    @Override
    public void insert(User u) {
        trans.begin();
        em.persist(u);
        em.flush();
        trans.commit();
        em.close();
    }

    @Override
    public List<User> getAll() {
        Query q = em.createQuery("SELECT u FROM User u");
        List<User> userList = (List<User>) q.getResultList();
        return userList;
    }

    @Override
    public User login(String username, String password) {
        for (User u : getAll()) {
            if (((u.getUsername().equals(username)) && (u.getPassword().equals(password)))) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getById(int id) {
        User u = em.find(User.class, id);
        em.close();
        return u;
    }

    @Override
    public User getHashkey(String hashkey) {
        for (User u : getAll()) {
            if (u.getHashkey().equals(hashkey)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void update(User u, int id) {
        trans.begin();
        u = em.find(User.class, id);
        em.merge(u);
        trans.commit();
        em.close();
    }

}
