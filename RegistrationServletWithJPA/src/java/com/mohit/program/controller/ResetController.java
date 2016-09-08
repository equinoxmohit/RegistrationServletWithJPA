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
@WebServlet(name = "reset", urlPatterns = {"/reset"})
public class ResetController extends Controller {

    UserDAO uDao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/reset/reset.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("pass1");
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            String finalPassword = (new BigInteger(1, m.digest()).toString(16));
            User u = new User();
            u.setPassword(finalPassword);
            uDao.update(u, id);
            response.sendRedirect(request.getContextPath()+"/login?success");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }
}
