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
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: #f4f6f8; margin: 0; padding: 0; }
        header { background: #2e7d32; color: white; padding: 20px; text-align: center; }
        main { padding: 30px; }
        .actions { margin-bottom: 20px; }
        button { background: #2e7d32; color: white; border: none; padding: 10px 20px; margin-right: 10px; border-radius: 5px; cursor: pointer; }
        button:hover { background: #1b5e20; }
        table { width: 100%; background: white; border-collapse: collapse; }
        th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }
        th { background: #66bb6a; color: white; }
    </style>
</head>
<body>

<header>
    <h1>Entregas</h1>
</header>

<main>
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
        <div style="margin-top: 30px; text-align: center;">
        <button onclick="location.href='index.jsp'" style="background: #4caf50; padding: 12px 24px; border-radius: 6px; border: none; color: white; font-size: 16px; cursor: pointer;">
            Volver al Inicio
        </button>
    </div>
</main>

</body>
</html>

