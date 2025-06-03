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
@WebServlet(name = "svMPEditar", urlPatterns = {"/svMPEditar"})
public class svMPEditar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

    Controladora control = new Controladora();
    MateriaPrima materia = control.traerMateriaPrima(id);

    request.setAttribute("materia", materia);
    request.getRequestDispatcher("editarMateriaPrima.jsp").forward(request, response);
    }

    
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String nombre = request.getParameter("nombre");
    double costoUnitario = Double.parseDouble(request.getParameter("costoUnitario"));
    int stock = Integer.parseInt(request.getParameter("stock"));

    Controladora control = new Controladora();

    // Buscar por ID
    MateriaPrima materia = control.traerMateriaPrima(id);

    if (materia != null) {
        materia.setNombre(nombre);
        materia.setCostoUnitario(costoUnitario);
        materia.setStock(stock);

        control.modificarMateriaPrima(materia);
    }
    
    List<MateriaPrima> listaMaterias = control.traerMateriasPrimas();
    request.setAttribute("materias", listaMaterias);

    request.getRequestDispatcher("MateriaPrima.jsp").forward(request, response);
}


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
