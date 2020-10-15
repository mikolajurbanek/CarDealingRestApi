package com.codecool.servlets;

import com.codecool.dao.CarDao;
import com.codecool.models.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@WebServlet(name = "CarServlet",  urlPatterns = {"/cars", "/cars/*"})
public class CarServlet extends HttpServlet {

    CarDao carDao = new CarDao();
    ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("carsPU");
        EntityManager em = emf.createEntityManager();
        String form = request.getQueryString();
        System.out.println(form);
        Map<String, String> parsedString = parseFormData(form);
        String color = null;
        String brand = parsedString.get("brand");
        String model = parsedString.get("model");
        int year = Integer.parseInt(parsedString.get("year"));
        boolean automat_gear = Boolean.parseBoolean(parsedString.get("automat_gear"));
        long id = Long.parseLong(parsedString.get("dealer_id"));
        for (Map.Entry<String, String> entry : parsedString.entrySet()) {
            if(entry.getKey().equals("color")){
                color = entry.getValue();
            }
            String k = entry.getKey();
            String v = entry.getValue();
            System.out.println("Key: " + k + ", Value: " + v);
        }
        System.out.println(color);
//        carDao.putCar(em, id, model, brand, color, automat_gear,year);
//        List<String> splitURL = Arrays.asList(request.getRequestURI().split("/"));
//        long dealerID = Long.parseLong(splitURL.get(2));
//        if (request.getParameter("?color") != null){
//            int id = Integer.parseInt(request.getParameter("put?id"))-1;
//            Cart.put(items.get(id));
//            String color = request.getParameter("color");
//            String name = request.getParameter("name");
//            System.out.println(color + " " + name);
//            parseFormData(request.getRequestURI());
    }

    public Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            System.out.println("Pair " + pair);
            String[] keyValue = pair.split("=");
            System.out.println(keyValue[0]);
//            String value = keyValue[1];
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> splitURL = Arrays.asList(request.getRequestURI().split("/"));
        System.out.println(request.getRequestURI() + " " + splitURL.size());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(splitURL.size() == 3){
            long id = Long.parseLong(splitURL.get(2));
            Car car = carDao.getCarById(id);
            out.print(mapper.writeValueAsString(car));
        } else{
            List<Car> cars =  carDao.findAllCarsWithCriteriaQuery();
            out.print(mapper.writeValueAsString(cars));
        }
        out.flush();

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        List<String> splitURL = Arrays.asList(request.getRequestURI().split("/"));
        long id = Long.parseLong(splitURL.get(2));
        if(splitURL.size() == 3 && id != 0L){
            carDao.deleteCar(id);
        } else{
            System.out.println("No such id in database");
        }
    }

}
