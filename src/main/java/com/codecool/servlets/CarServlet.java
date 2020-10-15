package com.codecool.servlets;

import com.codecool.dao.CarDao;
import com.codecool.models.Car;
import com.codecool.models.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CarServlet",  urlPatterns = {"/cars", "/cars/*"})
public class CarServlet extends HttpServlet {

    Stock stock = new Stock();
    CarDao carDao = new CarDao();
    ObjectMapper mapper = new ObjectMapper();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> splittedURL = Arrays.asList(request.getRequestURI().split("/"));
        System.out.println(request.getRequestURI() + " " + splittedURL.size());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(splittedURL.size() == 3){
            long id = Long.parseLong(splittedURL.get(2));
            Car car = carDao.getCarById(id);
            out.print(mapper.writeValueAsString(car));
        }else{
            List<Car> cars =  carDao.findAllCarsWithCriteriaQuery();
            out.print(mapper.writeValueAsString(cars));
        }
        out.flush();


    }



}
