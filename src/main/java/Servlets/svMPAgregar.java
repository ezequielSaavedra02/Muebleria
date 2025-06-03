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
@WebServlet(name = "svMPAgregar", urlPatterns = {"/svMPAgregar"})
public class svMPAgregar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controladora control = new Controladora();

        List<MateriaPrima> listaMaterias = control.traerMateriasPrimas();

        request.setAttribute("materias", listaMaterias);
        request.getRequestDispatcher("MateriaPrima.jsp").forward(request, response);
    }

    
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    double costoUnitario = Double.parseDouble(request.getParameter("costoUnitario"));
    int stock = Integer.parseInt(request.getParameter("stock"));

    Controladora control = new Controladora();

    // Buscar si ya existe una materia prima con ese nombre
    MateriaPrima materiaExistente = control.buscarMateriaPorNombre(nombre);

    if (materiaExistente != null) {
        // Si existe, actualizamos el stock sumando
        int nuevoStock = materiaExistente.getStock() + stock;
        materiaExistente.setStock(nuevoStock);
        control.modificarMateriaPrima(materiaExistente);
    } else {
        // Si no existe, creamos una nueva
        MateriaPrima nuevaMateria = new MateriaPrima();
        nuevaMateria.setNombre(nombre);
        nuevaMateria.setCostoUnitario(costoUnitario);
        nuevaMateria.setStock(stock);
        control.crearMateriaPrima(nuevaMateria);
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
