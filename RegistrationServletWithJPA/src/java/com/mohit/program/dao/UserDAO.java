/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.dao;

import com.mohit.program.entity.User;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface UserDAO {

    void insert(User u);

    List<User> getAll();

    User login(String username, String password);

    User getById(int id);

    User getHashkey(String hashkey);

    void update(User u, int id);

}
