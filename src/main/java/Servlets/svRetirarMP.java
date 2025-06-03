/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Logica.Controladora;
import Logica.DetalleProducto;
import Logica.MateriaPrima;
import Logica.Producto;
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
@WebServlet(name = "svRetirarMP", urlPatterns = {"/svRetirarMP"})
public class svRetirarMP extends HttpServlet {

    
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
        request.getRequestDispatcher("registrarRetiro.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreProducto = request.getParameter("productoNombre");
        int idMateriaPrima = Integer.parseInt(request.getParameter("materiaPrimaId"));
        int cantidadUsada = Integer.parseInt(request.getParameter("cantidad"));

        Controladora control = new Controladora();

        // Traer la materia prima
        MateriaPrima materia = control.traerMateriaPrima(idMateriaPrima);

        if (materia != null && materia.getStock() >= cantidadUsada) {
            // 1. Restar stock
            materia.setStock(materia.getStock() - cantidadUsada);
            control.editarMateriaPrima(materia);

            // 2. Buscar o crear producto
            Producto producto = control.buscarProductoPorNombre(nombreProducto);
            if (producto == null) {
                producto = new Producto();
                producto.setNombre(nombreProducto);
                control.crearProducto(producto);
            }

            // 3. Crear detalle
            DetalleProducto detalle = new DetalleProducto();
            detalle.setCantidadUtilizada(cantidadUsada);
            detalle.setMateriaPrima(materia);
            detalle.setProducto(producto);
            control.crearDetalleProducto(detalle);

            List<DetalleProducto> listaRetiros = control.traerDetalleProductos();

        request.setAttribute("detalleProductos", listaRetiros);
        request.getRequestDispatcher("retirosMateriaPrima.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Stock insuficiente o materia prima no encontrada.");
            List<DetalleProducto> listaRetiros = control.traerDetalleProductos();

        request.setAttribute("detalleProductos", listaRetiros);
        request.getRequestDispatcher("retirosMateriaPrima.jsp").forward(request, response);
        }
    }
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
