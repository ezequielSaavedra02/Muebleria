<%-- 
    Document   : Productos
    Created on : 26 abr 2025, 19:42:30
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>

<body>
     <header>
        <h1>Productos</h1>
    </header>
    
    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevoProducto.jsp'">Agregar Producto</button>
                <button>Modificar Producto</button>
                <button>Eliminar Producto</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Tipo</th>
                        <th>Material</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí se cargarán dinámicamente los productos --%>
                    <% 
                        /*
                        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                        if (productos != null) {
                            for (Producto p : productos) {
                    %>
                        <tr>
                            <td><%= p.getId() %></td>
                            <td><%= p.getNombre() %></td>
                            <td><%= p.getTipo() %></td>
                            <td><%= p.getMaterial() %></td>
                            <td><%= p.getPrecio() %></td>
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
