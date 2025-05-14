<%-- 
    Document   : MateriaPrima
    Created on : 26 abr 2025, 19:55:10
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Materia Prima - Carpintería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>

<body>
    <header>
        <h1>Materia Prima</h1>
    </header>

    <main>
        <div class="container">
            <div class="actions">
                <button onclick="location.href='nuevaMateriaPrima.jsp'">Nueva Materia Prima</button>
                <button>Registrar Compra</button>
                <button>Registrar Retiro</button>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Stock Disponible</th>
                        <th>Unidad</th>
                        <th>Última Compra</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Aquí se cargarán dinámicamente los materiales --%>
                    <% 
                        /*
                        List<MateriaPrima> materias = (List<MateriaPrima>) request.getAttribute("materias");
                        if (materias != null) {
                            for (MateriaPrima m : materias) {
                    %>
                        <tr>
                            <td><%= m.getId() %></td>
                            <td><%= m.getNombre() %></td>
                            <td><%= m.getStock() %></td>
                            <td><%= m.getUnidad() %></td>
                            <td><%= m.getUltimaCompra() %></td>
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

