/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller;

import com.mohit.program.dao.UserDAO;
import com.mohit.program.dao.impl.UserDAOImpl;
import com.mohit.program.entity.User;
import com.mohit.program.system.Controller;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
@WebServlet(name = "", urlPatterns = {"/register"})
public class RegistrationController extends Controller {

    private UserDAO uDao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/register/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("pass1");
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            String finalPassword = (new BigInteger(1, m.digest()).toString(16));
            User u = new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setUsername(username);
            u.setEmail(email);
            u.setPassword(finalPassword);
            u.setHashkey(u.getHashkey());
            uDao.insert(u);
            response.sendRedirect(request.getContextPath() + "/login?success");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }

}
