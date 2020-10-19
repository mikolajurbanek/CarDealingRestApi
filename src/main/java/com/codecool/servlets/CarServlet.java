package com.codecool.servlets;

import com.codecool.dao.CarDao;
import com.codecool.exceptions.ObjectNotFoundException;
import com.codecool.models.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.codecool.Services.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@WebServlet(name = "CarServlet",  urlPatterns = {"/cars", "/cars/*"})
public class CarServlet extends HttpServlet {

    CarDao carDao = new CarDao();
    ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getQueryString();
        Map<String, String> parsedMap = parseFormData(form);
        String color = parsedMap.get("color");
        String brand = parsedMap.get("brand");
        String model = parsedMap.get("model");
        int year = Integer.parseInt(parsedMap.get("year"));
        boolean automatGear = Boolean.parseBoolean(parsedMap.get("automat_gear"));
        long id = Long.parseLong(parsedMap.get("dealer_id"));

        carDao.addCar(id, model, brand, color, automatGear, year);
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
            List<Car> cars =  carDao.getAllCars();
            out.print(mapper.writeValueAsString(cars));
        }
        out.flush();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> splitURL = Arrays.asList(request.getRequestURI().split("/"));
        long id = Long.parseLong(splitURL.get(2));
        if(splitURL.size() != 3 && id == 0L){
            throw new IOException("No such id in database");
        }

        carDao.deleteCar(id);
    }

    public Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }

}