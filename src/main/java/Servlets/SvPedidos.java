
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


@WebServlet(name = "SvPedidos", urlPatterns = {"/SvPedidos"})
public class SvPedidos extends HttpServlet {
Controladora control = new Controladora();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvPedidos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvPedidos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action"); // Obtiene el parámetro 'action'

        if ("nuevo".equals(action)) {
            // Lógica para mostrar el formulario de "Nuevo Pedido"
            
            // 1. Obtener la lista de clientes
            List<Cliente> listaClientes = control.traerClientes(); // Necesitas este método en tu Controladora
            
            // 2. Obtener la lista de productos
            List<Producto> listaProductos = control.traerProductos(); // Necesitas este método en tu Controladora
            
            // 3. Enviar las listas al JSP
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("listaProductos", listaProductos);
            
            // 4. Redirigir al JSP del formulario de nuevo pedido
            request.getRequestDispatcher("nuevoPedido.jsp").forward(request, response);

        } else {
            // Lógica por defecto: mostrar la lista de todos los pedidos
            List<Pedido> listaPedidos = control.traerPedidos();
            request.setAttribute("pedidos", listaPedidos);
            request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
        }
    }

   
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        Long idCliente = Long.parseLong(request.getParameter("clienteId"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fechaPedido"));
        double total = Double.parseDouble(request.getParameter("total"));
        Long idProducto = Long.parseLong(request.getParameter("productoId"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Buscar cliente y producto
        Cliente cliente = control.traerCliente(idCliente);
        Producto producto = control.traerProducto(idProducto);

        if (cliente == null || producto == null) {
            request.setAttribute("error", "Cliente o Producto no encontrado.");
            request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
            return;
        }

        // Crear el pedido sin detalles
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFechaPedido(fecha);
        pedido.setTotal(total);
        pedido.setProducto(producto); // Asumiendo que la clase Pedido ahora tiene un atributo Producto
        pedido.setCantidad(cantidad); // Asumiendo que también tiene un campo cantidad

        // Guardar el pedido
        control.crearPedido(pedido);

        // Actualizar listas para el JSP
        List<Cliente> listaClientes = control.traerClientes();
        List<Producto> listaProductos = control.traerProductos();

        request.setAttribute("listaClientes", listaClientes);
        request.setAttribute("listaProductos", listaProductos);
        request.getRequestDispatcher("Pedidos.jsp").forward(request, response);

    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("error", "Error al procesar el pedido: " + e.getMessage());
        request.getRequestDispatcher("Pedidos.jsp").forward(request, response);
    }
}



   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
