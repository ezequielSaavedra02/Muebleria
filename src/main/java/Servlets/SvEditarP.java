
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.DetallePedido;
import Logica.Pedido;
import Logica.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
@WebServlet(name = "SvEditarP", urlPatterns = {"/SvEditarP"})
public class SvEditarP extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditarP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditarP at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // 1. Obtener el ID del pedido a editar
        // ¡CAMBIO AQUÍ! Ahora parseamos a Long.
        Long idEditar = Long.parseLong(request.getParameter("id"));

        // 2. Buscar el pedido en la lógica de negocio
        // El método traerPedido en Controladora ahora debe aceptar Long.
        Pedido pedidoEditar = control.traerPedido(idEditar); 

        // 3. Obtener listas de Clientes y Productos para los desplegables del formulario
        List<Cliente> listaClientes = control.traerClientes();
        List<Logica.Producto> listaProductos = control.traerProductos(); // Asegúrate que esta lista es de Logica.Producto

        // 4. Guardar el pedido y las listas en la sesión para que el JSP las acceda
        HttpSession miSession = request.getSession();
        miSession.setAttribute("pedidoAEditar", pedidoEditar);
        miSession.setAttribute("listaClientes", listaClientes);
        miSession.setAttribute("listaProductos", listaProductos);

        // 5. Redirigir al JSP del formulario de edición
        response.sendRedirect("editarPedido.jsp"); // Redirige al JSP del formulario de edición
   
    }

   
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        // 1. Obtener el ID del pedido
        Long idPedido = Long.parseLong(request.getParameter("idPedido"));

        // 2. Obtener nuevos valores del formulario
        Long idCliente = Long.parseLong(request.getParameter("clienteId")); 
        LocalDate fecha = LocalDate.parse(request.getParameter("fechaPedido"));
        double total = Double.parseDouble(request.getParameter("total"));
        Long idProducto = Long.parseLong(request.getParameter("productoId"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // 3. Buscar entidades
        Cliente cliente = control.traerCliente(idCliente);
        Producto producto = control.traerProducto(idProducto);
        Pedido pedido = control.traerPedido(idPedido);

        if (cliente == null || producto == null || pedido == null) {
            request.setAttribute("error", "Cliente, Producto o Pedido no encontrado.");
            request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
            return;
        }

        // 4. Actualizar campos del pedido
        pedido.setCliente(cliente);
        pedido.setFechaPedido(fecha);
        pedido.setTotal(total);
        pedido.setProducto(producto);  // Asumiendo que el pedido tiene un solo producto
        pedido.setCantidad(cantidad);  // Asumiendo también que guarda una cantidad

        // 5. Guardar los cambios
        control.modificarPedido(pedido);

        // 6. Redirigir a la lista de pedidos
        response.sendRedirect("SvPedidos");

    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("error", "Error al editar el pedido: " + e.getMessage());
        request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
    }
}


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
