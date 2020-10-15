package com.codecool.servlets;

import com.codecool.models.Car;
import com.codecool.Services.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CarServlet",  urlPatterns = {"/cars"})
public class CarServlet extends HttpServlet {

    Stock stock = new Stock();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Car car : stock.getCars()) {
            System.out.println(car.getModel() + " from " + car.getYear());
        }
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (request.getParameter("get?id") != null) {
            out.print(request.getParameter("get?id"));
            int id = Integer.parseInt(request.getParameter("get?id"))-1;
            Car car2 = stock.getCars().get(id);
            out.print(mapper.writeValueAsString(car2));
            out.flush();
        }
        else {
            out.print(mapper.writeValueAsString(stock.getCars()));
            out.flush();
        }
    }

}