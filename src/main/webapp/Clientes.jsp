<%@page import="Logica.Cliente"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Clientes - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
    <style>
        .btn-accion {
            margin: 0 5px;
            padding: 5px 10px;
            font-size: 0.9em;
            cursor: pointer;
        }
        .editar-btn {
            background-color: #4CAF50;
            color: white;
            border: none;
        }
        .eliminar-btn {
            background-color: #f44336;
            color: white;
            border: none;
        }
    </style>
</head>

<body>
    <header>
        <h1>Clientes</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevoCliente.jsp'">Agregar Cliente</button>
                <button onclick="location.href='SvCliente'">Actualizar Lista</button>
                <button onclick="history.back()">Volver Atrás</button>
                <button onclick="location.href='index.jsp'">Volver al Inicio</button>
            </div>

            <%
                List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
            %>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Domicilio</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (clientes == null) {
                    %>
                        <tr>
                            <td colspan="7" style="text-align:center;">No se encontraron clientes en el request.</td>
                        </tr>
                    <%
                        } else if (clientes.isEmpty()) {
                    %>
                        <tr>
                            <td colspan="7" style="text-align:center;">No hay clientes disponibles.</td>
                        </tr>
                    <%
                        } else {
                            for (Cliente c : clientes) {
                    %>
                        <tr>
                            <td><%= c.getIdCliente() %></td>
                            <td><%= c.getNombre() %></td>
                            <td><%= c.getApellido() %></td>
                            <td><%= c.getTelefono() %></td>
                            <td><%= c.getEmail() %></td>
                            <td><%= c.getDireccion() %></td>
                            <td>
                                <form action="SvEditarC" method="get" style="display:inline;">
                                    <input type="hidden" name="id" value="<%= c.getIdCliente() %>">
                                    <button type="submit" class="btn-accion editar-btn">Modificar</button>
                                </form>
                                <form action="SvEliminarC" method="post" style="display:inline;" onsubmit="return confirm('¿Estás seguro de que deseas eliminar este cliente?');">
                                    <input type="hidden" name="id" value="<%= c.getIdCliente() %>">
                                    <button type="submit" class="btn-accion eliminar-btn">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>