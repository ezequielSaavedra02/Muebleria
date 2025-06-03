<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Producto"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Productos - Carpintería</title>
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
        <h1>Productos</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevoProducto.jsp'">Agregar Producto</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Stock</th>
                        <th>Precio Unitario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Producto> productos = (List<Producto>) request.getAttribute("listarProductos");
                        if (productos != null && !productos.isEmpty()) {
                            for (Producto p : productos) {
                    %>
                        <tr>
                            <td><%= p.getIdProducto() %></td>
                            <td><%= p.getNombre() %></td>
                            <td><%= p.getDescripcion() %></td>
                            <td><%= p.getStock() %></td>
                            <td>$<%= p.getPrecioUnitario() %></td>
                            <td>
                                <form action="svProductoEditar" method="get" style="display:inline;">
                                    <input type="hidden" name="id" value="<%= p.getIdProducto() %>">
                                    <button type="submit" class="btn-accion editar-btn">Editar</button>
                                </form>
                                <form action="svProductoEliminar" method="post" style="display:inline;" onsubmit="return confirm('¿Estás seguro de eliminar este producto?');">
                                    <input type="hidden" name="id" value="<%= p.getIdProducto() %>">
                                    <button type="submit" class="btn-accion eliminar-btn">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="6" style="text-align: center;">No hay productos registrados</td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <button class="volver-btn" onclick="location.href='index.jsp'">Volver al Inicio</button>
    </main>
</body>
</html>
