
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarP", urlPatterns = {"/SvEliminarP"})
public class SvEliminarP extends HttpServlet {

   Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEliminarP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEliminarP at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Obtener el ID del pedido a eliminar
        // El ID vendrá como un parámetro oculto en el formulario (e.g., <input type="hidden" name="id" ...>)
        // Es crucial que el ID sea de tipo Long, acorde a tu entidad Pedido.
        Long idEliminar = Long.parseLong(request.getParameter("id"));

        // 2. Llamar a la lógica para eliminar el pedido
        control.eliminarPedido(idEliminar); // Necesitas crear este método en tu Controladora

        // 3. Redirigir a la vista de la lista de pedidos para mostrar la actualización
        response.sendRedirect("SvPedidos");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
