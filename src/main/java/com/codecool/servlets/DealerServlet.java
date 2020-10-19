package com.codecool.servlets;

import com.codecool.dao.DealerDao;
import com.codecool.models.Dealer;
import com.codecool.models.dto.DealerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DealerServlet", urlPatterns = {"/dealers", "/dealers/*"})
public class DealerServlet extends HttpServlet {

    DealerDao dealerDao = new DealerDao();
    ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getQueryString();
        Map<String, String> parsedMap = parseFormData(form);
        System.out.println(form);
        String name = parsedMap.get("name");
        String location = parsedMap.get("location");
        String phoneNumber = parsedMap.get("phone");
        Dealer dealer = new Dealer(name, location, phoneNumber);
        dealerDao.addDealer(dealer);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> splitURL = Arrays.asList(request.getRequestURI().split("/"));
        System.out.println(request.getRequestURI() + " " + splitURL.size());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(splitURL.size() == 3){
            long id = Long.parseLong(splitURL.get(2));
            Dealer dealer = dealerDao.getDealerById(id);
            DealerDTO dealerDTO = new DealerDTO(
                    dealer.getId(),
                    dealer.getName(),
                    dealer.getLocation(),
                    dealer.getPhoneNumber()
            );
            out.print(mapper.writeValueAsString(dealerDTO));
        } else{
            List<Dealer> dealers =  dealerDao.getAllDealers();
            out.print(mapper.writeValueAsString(dealers));
        }
        out.flush();

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        List<String> splitURL = Arrays.asList(request.getRequestURI().split("/"));
        long id = Long.parseLong(splitURL.get(2));
        if(splitURL.size() == 3 && id != 0L){
            dealerDao.deleteDealer(id);
        } else{
            System.out.println("No such id in database");
        }
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
