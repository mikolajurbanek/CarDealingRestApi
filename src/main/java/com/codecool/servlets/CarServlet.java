package com.codecool.servlets;

import com.codecool.models.Car;
import com.codecool.models.Stock;
import com.google.gson.Gson;

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

    private Gson gson = new Gson();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (Car car : stock.getCars()) {
            System.out.println(car.getModel() + " is in " + car.getYear());
        }
        Car car = stock.getCars().get(1);
        String employeeJsonString = this.gson.toJson(car);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();

//        out.println(
//                "<html>\n" +
//                        "<head><title>Web shop</title></head>\n" +
//                        "<body>\n" +
//                        "<h1>WEB MIKE'S BIKES STORE</h1>" +
//                        (itemId == null ?
//                                "<h3>No items added to cart yet</h3>" :
//                                "<h3> " + stock.getItemByID(Integer.parseInt(itemId)).getName() + " just added to cart!</h3>") +
//                        "<br/>" +
//                        "<div>" + buffer.toString() + "</div>" +
//                        "</body></html>"
//        );
    }


}
