
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEditarC", urlPatterns = {"/SvEditarC"})
public class SvEditarC extends HttpServlet {
 Controladora cl = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarC at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          // 1. Recibir el ID del cliente
        Long id = Long.parseLong(request.getParameter("id"));

        // 2. Llamar a la capa lógica
       
        Cliente cliente = cl.traerCliente(id);  // Este método debe existir

        // 3. Enviar cliente al JSP
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
      
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recibir los datos del formulario
        Long id = Long.parseLong(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");

        // Buscar cliente y actualizar sus datos
        Cliente cliente = cl.traerCliente(id);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);
        cliente.setDireccion(direccion);

        // Guardar cambios en la base de datos
        cl.modificarCliente(cliente);  // este método debes tenerlo en tu lógica

        // Redirigir a la lista de clientes actualizada
        response.sendRedirect("SvCliente");
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
