/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Logica.Controladora;
import Logica.MateriaPrima;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edeze_b1s78wk
 */
@WebServlet(name = "svMPEliminar", urlPatterns = {"/svMPEliminar"})
public class svMPEliminar extends HttpServlet {
Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long idMateriaPrima = Long.parseLong(request.getParameter("id"));
            control.eliminarMateriaPrima(idMateriaPrima);
        } catch (Exception e) {
            e.printStackTrace(); // log o redirección a error.jsp si querés
        }

        List<MateriaPrima> listaMaterias = control.traerMateriasPrimas();
    request.setAttribute("materias", listaMaterias);

    request.getRequestDispatcher("MateriaPrima.jsp").forward(request, response); // o donde esté tu listado
    }
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
