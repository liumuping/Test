package com.lhf.exam.servlet;

import com.lhf.exam.dao.impl.FoodDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFoodSetServlet", urlPatterns = "/DeleteFoodSetServlet")
public class DeleteFoodSetServlet extends HttpServlet {
    FoodDaoImpl foodDao = new FoodDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("delete");
        String pageNum = request.getParameter("pageNum");
        int foodsetId = Integer.parseInt(request.getParameter("foodsetId"));
        request.getSession().setAttribute("pageold", pageNum);
        foodDao.deleteFoodSet(foodsetId);
        foodDao.deleteFoodByFoodSetId(foodsetId);
        response.sendRedirect("/FoodSetServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
