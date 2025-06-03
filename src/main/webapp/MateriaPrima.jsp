<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Logica.MateriaPrima" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Materia Prima - Carpintería</title>
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
        <h1>Materia Prima</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevaMateriaPrima.jsp'">Nueva Materia Prima</button>
                <button onclick="location.href='svRetirarMP'">Registrar Retiro</button>
                <button onclick="location.href='svVerRetiros'">Ver Retiros</button>

            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Costo Unitario</th>
                        <th>Stock</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<MateriaPrima> materias = (List<MateriaPrima>) request.getAttribute("materias");
                        if (materias != null) {
                            for (MateriaPrima m : materias) {
                    %>
                        <tr>
                            <td><%= m.getIdMateriaPrima() %></td>
                            <td><%= m.getNombre() %></td>
                            <td>$<%= m.getCostoUnitario() %></td>
                            <td><%= m.getStock() %></td>
                            <td>
                                <form action="svMPEditar" method="get" style="display:inline;">
                                    <input type="hidden" name="id" value="<%= m.getIdMateriaPrima() %>">
                                    <button type="submit" class="btn-accion editar-btn">Editar</button>
                                </form>
                                <form action="svMPEliminar" method="post" style="display:inline;" onsubmit="return confirm('¿Estás seguro que deseas eliminar esta materia prima?');">
                                    <input type="hidden" name="id" value="<%= m.getIdMateriaPrima() %>">
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
        <button class="volver-btn" onclick="location.href='index.jsp'">Volver al Inicio</button>
    </main>
</body>
</html>
