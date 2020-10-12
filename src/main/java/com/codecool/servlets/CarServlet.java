package com.codecool.servlets;

import com.codecool.models.Car;
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

    private Gson gson = new Gson();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = new Car(1, 2004, true, "golf", "blue", 1, "VW");
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
