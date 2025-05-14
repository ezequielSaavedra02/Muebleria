<%-- 
    Document   : Presupuesto
    Created on : 26 abr 2025, 19:45:47
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Presupuestos - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>
<body>
    <header>
        <h1>Presupuestos</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='crearPresupuesto.jsp'">Nuevo Presupuesto</button>
                <button>Modificar Presupuesto</button>
                <button>Eliminar Presupuesto</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Producto</th>
                        <th>Fecha</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí se cargarán dinámicamente los presupuestos --%>
                    <% 
                        /*
                        List<Presupuesto> presupuestos = (List<Presupuesto>) request.getAttribute("presupuestos");
                        if (presupuestos != null) {
                            for (Presupuesto p : presupuestos) {
                    %>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getClienteNombre() %></td>
                            <td><%= p.getProductoNombre() %></td>
                            <td><%= p.getFecha() %></td>
                            <td><%= p.getTotal() %></td>
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

