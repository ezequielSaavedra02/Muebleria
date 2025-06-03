<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Logica.Cliente" %>
<%@ page import="Logica.Producto" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Pedido</title>
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
    // Obtener fecha actual formateada a yyyy-MM-dd para input type date
    LocalDate hoy = LocalDate.now();
    String fechaHoy = hoy.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
%>

<%-- LÍNEA DE DEPURACIÓN: Verifica el valor de fechaHoy --%>
<p>Valor de 'fechaHoy' en JSP: **<%= fechaHoy %>**</p>

<header>
    <h1>Nuevo Pedido</h1>
</header>

<main>
    <form action="SvPedidos" method="POST">
        <%-- FECHA DEL PEDIDO --%>
        <label for="fechaPedido">Fecha del Pedido</label>
        <input type="date" name="fechaPedido" id="fechaPedido" value="<%= fechaHoy %>" required>

        <%-- CLIENTES --%>
        <label for="cliente">Cliente</label>
        <select name="clienteId" id="cliente" required>
            <option value="">Seleccione un cliente</option>
            <%
                List<Cliente> listaClientes = (List<Cliente>) request.getAttribute("listaClientes");
                if (listaClientes != null) {
                    for (Cliente c : listaClientes) {
            %>
                <option value="<%= c.getIdCliente() %>"><%= c.getNombre() %></option>
            <%
                    }
                }
            %>
        </select>

        <%-- PRODUCTOS --%>
       <label for="producto">Producto</label>
        <select name="productoId" id="producto"> 
            <option value="">Seleccione un producto</option>
            <%
                List<Producto> listaProductos = (List<Producto>) request.getAttribute("listaProductos");
                if (listaProductos != null) {
                    for (Producto p : listaProductos) {
            %>
                <option value="<%= p.getIdProducto() %>"><%= p.getNombre() %></option>
            <%
                    }
                }
            %>
        </select>

        <%-- CANTIDAD --%>
        <label for="cantidad">Cantidad</label>
        <input type="number" name="cantidad" id="cantidad" placeholder="Cantidad" required min="1">

        <%-- TOTAL --%>
        <label for="total">Total</label>
        <input type="number" name="total" id="total" step="0.01" placeholder="Total $" required>

        <button type="submit">Guardar Pedido</button>
    </form>

    <div class="volver">
        <button onclick="location.href='Pedidos.jsp'">Volver atrás</button>
    </div>
</main>

</body>
</html>