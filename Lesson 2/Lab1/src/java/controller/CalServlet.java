/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.w3c.dom.Node;

/**
 *
 * @author coder
 */
public class CalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("calculate.html");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean error = false;
        // read input from user
        double firstNumber = 0;
        try {
            firstNumber = Double.parseDouble(request.getParameter("firstNumber").toString());
        } catch (Exception e) {
            error = true;
        }
        double secondNumber = 0;
        try {
            secondNumber = Double.parseDouble(request.getParameter("secondNumber").toString());
        } catch (Exception e) {
            error = true;
        }
        String operator = request.getParameter("operator").toString();
        double result = 0;
        // do the calculation
        try {
            switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                if (secondNumber == 0) {
                    error = true;
                }
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }
        } catch (Exception e) {
            error = true;
        }
        

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CalServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"CalServlet\" method=\"post\">");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>First:</td>");
        out.println("<td><input type=\"text\" name=\"firstNumber\" value=\"" + request.getParameter("firstNumber") + "\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Second:</td>");
        out.println("<td><input type=\"text\" name=\"secondNumber\" value=\"" + request.getParameter("secondNumber") + "\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Operator</td>");
        out.println("<td>");
        out.println("<select name=\"operator\">");
        out.println("<option hidden>" + operator + "</option>");
        out.println("<option>+</option>");
        out.println("<option>-</option>");
        out.println("<option>*</option>");
        out.println("<option>/</option>");
        out.println("<option>%</option>");
        out.println("</select>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td><input type=\"submit\" value=\"Compute\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Result:</td>");
        if (error) {
            out.println("<td><input type=\"text\" value=\"" + "math error" + "\"/></td>");
        } else {
            out.println("<td><input type=\"text\" value=\"" + result + "\"/></td>");
        }
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
