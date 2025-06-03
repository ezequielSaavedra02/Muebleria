<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Logica.Cliente" %>
<%@ page import="Logica.Producto" %>
<%@ page import="Logica.Pedido" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Pedido</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 0; }
        header { background: #2e7d32; color: white; padding: 20px; text-align: center; }
        main { padding: 30px; }
        form { background: white; padding: 20px; border-radius: 8px; max-width: 500px; margin: auto; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        input, select {
            width: 100%; padding: 10px; margin: 10px 0; border-radius: 5px; border: 1px solid #ccc;
        }
        button {
            background: #2e7d32; color: white; border: none; padding: 12px; width: 100%;
            margin-top: 10px; border-radius: 5px; font-size: 16px; cursor: pointer;
        }
        button:hover { background: #1b5e20; }
        .volver { margin-top: 20px; text-align: center; }
        .volver button { background: #4caf50; }
    </style>
</head>
<body>

<%
    HttpSession miSession = request.getSession();
    Pedido pedidoEditar = (Pedido) miSession.getAttribute("pedidoAEditar");

    if (pedidoEditar == null) {
        response.sendRedirect("SvPedidos");
        return;
    }

    List<Cliente> listaClientes = (List<Cliente>) miSession.getAttribute("listaClientes");
    List<Producto> listaProductos = (List<Producto>) miSession.getAttribute("listaProductos");

    String fechaPedidoStr = (pedidoEditar.getFechaPedido() != null) ?
                            pedidoEditar.getFechaPedido().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";
%>

<header>
    <h1>Editar Pedido</h1>
</header>

<main>
    <form action="SvEditarP" method="post">
        <input type="hidden" name="idPedido" value="<%= pedidoEditar.getIdPedido() %>">

        <label for="fechaPedido">Fecha del Pedido</label>
        <input type="date" name="fechaPedido" id="fechaPedido" value="<%= fechaPedidoStr %>" required>

        <label for="cliente">Cliente</label>
        <select name="clienteId" id="cliente" required>
            <option value="">Seleccione un cliente</option>
            <%
                if (listaClientes != null) {
                    for (Cliente c : listaClientes) {
                        String selected = (pedidoEditar.getCliente() != null &&
                                           pedidoEditar.getCliente().getIdCliente() == c.getIdCliente()) ? "selected" : "";
            %>
                <option value="<%= c.getIdCliente() %>" <%= selected %>><%= c.getNombre() %></option>
            <%
                    }
                }
            %>
        </select>

        <label for="producto">Producto</label>
        <select name="productoId" id="producto">
            <option value="">Seleccione un producto</option>
            <%
                if (listaProductos != null) {
                    for (Producto p : listaProductos) {
                        String selected = (pedidoEditar.getProducto() != null &&
                                           pedidoEditar.getProducto().getIdProducto() == p.getIdProducto()) ? "selected" : "";
            %>
                <option value="<%= p.getIdProducto() %>" <%= selected %>><%= p.getNombre() %></option>
            <%
                    }
                }
            %>
        </select>

        <label for="cantidad">Cantidad</label>
        <input type="number" name="cantidad" id="cantidad" placeholder="Cantidad"
               value="<%= pedidoEditar.getCantidad() %>" min="1">

        <label for="total">Total</label>
        <input type="number" name="total" id="total" step="0.01" placeholder="Total $"
               value="<%= String.format("%.2f", pedidoEditar.getTotal()) %>" required>

        <button type="submit">Guardar Cambios</button>
    </form>

    <div class="volver">
        <button onclick="location.href='SvPedidos'">Volver a Pedidos</button>
    </div>
</main>

</body>
</html>
