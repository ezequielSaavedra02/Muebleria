/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Logica.Controladora;
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
@WebServlet(name = "svProductoEditar", urlPatterns = {"/svProductoEditar"})
public class svProductoEditar extends HttpServlet {
    Controladora control = new Controladora();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if(idStr != null) {
            Long idProducto = Long.parseLong(idStr);
            Producto producto = control.obtenerProducto(idProducto); // Método que debes tener en tu controladora
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
        } else {
            response.sendRedirect("Productos.jsp");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        Long idProducto = Long.parseLong(request.getParameter("idProducto"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double precioUnitario = Double.parseDouble(request.getParameter("precioUnitario"));

        Producto producto = control.obtenerProducto(idProducto);
        if(producto != null) {
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setStock(stock);
            producto.setPrecioUnitario(precioUnitario);

            control.actualizarProducto(producto);  // Método que actualiza producto en DB
        }

        List<Producto> productos = control.traerProductos();
        request.setAttribute("listarProductos", productos);
        request.getRequestDispatcher("Productos.jsp").forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
        // Podrías enviar a un JSP de error o mostrar mensaje
        response.sendRedirect("Productos.jsp");
    }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
