/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author axel
 */
@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class SvCliente extends HttpServlet {

    Controladora ct= new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      List<Cliente> clientes = ct.traerCliente();  // No hace falta crear new ArrayList si ya te devuelve una lista

    request.setAttribute("clientes", clientes);

    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String nombre=request.getParameter("nombre");
         String apellido=request.getParameter("apellido");
         String direccion=request.getParameter("direccion");
         String telefono=request.getParameter("telefono");
         String email=request.getParameter("email");
   
       
        
        Cliente clien =new Cliente();
        clien.setNombre(nombre);
        clien.setApellido(apellido);
        clien.setDireccion(direccion);
        clien.setTelefono(telefono);
         clien.setEmail(email);
         //invocamos para crear a la controladora
        ct.crearCliente(clien); 
        
        List<Cliente> clientes = ct.traerCliente();
    request.setAttribute("clientes", clientes);

    // Mostrar la lista actualizada
    request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
