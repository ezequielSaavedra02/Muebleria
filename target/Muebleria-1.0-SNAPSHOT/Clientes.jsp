<%-- 
    Document   : Clientes
    Created on : 26 abr 2025, 19:55:33
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Clientes - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>

<body>
    <header>
        <h1>Clientes</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevoCliente.jsp'">Nuevo Cliente</button>
                <button>Modificar Cliente</button>
                <button>Eliminar Cliente</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Domicilio</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí se cargarán dinámicamente los clientes --%>
                    <% 
                        /*
                        List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                        if (clientes != null) {
                            for (Cliente c : clientes) {
                    %>
                        <tr>
                            <td><%= c.getId() %></td>
                            <td><%= c.getNombre() %></td>
                            <td><%= c.getApellido() %></td>
                            <td><%= c.getTelefono() %></td>
                            <td><%= c.getEmail() %></td>
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

