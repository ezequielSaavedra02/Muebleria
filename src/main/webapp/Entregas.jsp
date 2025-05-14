<%-- 
    Document   : Entregas
    Created on : 26 abr 2025, 19:54:17
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Entregas - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>

<body>
    <header>
        <h1>Entregas</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevaEntrega.jsp'">Nueva Entrega</button>
                <button>Modificar Entrega</button>
                <button>Eliminar Entrega</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Producto</th>
                        <th>Fecha Entrega</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí se cargarán dinámicamente las entregas --%>
                    <% 
                        /*
                        List<Entrega> entregas = (List<Entrega>) request.getAttribute("entregas");
                        if (entregas != null) {
                            for (Entrega e : entregas) {
                    %>
                        <tr>
                            <td><%= e.getId() %></td>
                            <td><%= e.getClienteNombre() %></td>
                            <td><%= e.getProductoNombre() %></td>
                            <td><%= e.getFechaEntrega() %></td>
                            <td><%= e.getEstado() %></td>
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

