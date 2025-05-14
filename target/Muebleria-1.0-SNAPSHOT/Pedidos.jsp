<%-- 
    Document   : Pedidos
    Created on : 26 abr 2025, 19:52:55
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pedidos - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>

<body>
    <header>
        <h1>Pedidos</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevoPedido.jsp'">Nuevo Pedido</button>
                <button>Modificar Pedido</button>
                <button>Eliminar Pedido</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Fecha Pedido</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí se cargarán dinámicamente los pedidos --%>
                    <% 
                        /*
                        List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
                        if (pedidos != null) {
                            for (Pedido p : pedidos) {
                    %>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getClienteNombre() %></td>
                            <td><%= p.getProductoNombre() %></td>
                            <td><%= p.getCantidad() %></td>
                            <td><%= p.getFechaPedido() %></td>
                            <td><%= p.getEstado() %></td>
                        </tr>
                    <% 
                            }
                        }
                        */
                    %>
                </tbody>
            </table>
        </div>
        <button class="volver-btn" onclick="location.href='index.jsp'">Volver al Inicio</button>
    </main>
</body>
</html>
