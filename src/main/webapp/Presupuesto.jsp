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
    <h1>Presupuestos</h1>
</header>

<main>
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
        <div style="margin-top: 30px; text-align: center;">
        <button onclick="location.href='index.jsp'" style="background: #4caf50; padding: 12px 24px; border-radius: 6px; border: none; color: white; font-size: 16px; cursor: pointer;">
            Volver al Inicio
        </button>
    </div>
</main>

</body>
</html>

