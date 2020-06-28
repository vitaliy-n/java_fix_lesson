package com.cheba00.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String kmAsString = req.getParameter("km");
        String kgAsString = req.getParameter("kg");
        double km = Double.parseDouble(kmAsString);
        double kg = Double.parseDouble(kgAsString);
        CostCalculator costCalculator = new CostCalculator(10, 1);
        double cost = costCalculator.calcCost(kg, km);
        PrintWriter printWriter = new PrintWriter(resp.getWriter());
        printWriter.write("<h1> Влад лох<h1>");
        printWriter.write("___"+ cost);
    }

}
