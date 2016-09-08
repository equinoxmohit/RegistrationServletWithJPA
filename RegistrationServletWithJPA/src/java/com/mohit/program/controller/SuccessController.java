/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.program.controller;

import com.mohit.program.dao.UserDAO;
import com.mohit.program.dao.impl.UserDAOImpl;
import com.mohit.program.system.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
@WebServlet(name = "success", urlPatterns = {"/success"})
public class SuccessController extends Controller {

    private UserDAO uDao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("getAll", uDao.getById(id));

        request.getRequestDispatcher("/WEB-INF/views/success/success.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
