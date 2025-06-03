<%@ page import="java.util.List" %>
<%@ page import="Logica.MateriaPrima" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registrar Retiro de Materia Prima</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <h1>Registrar Retiro de Materia Prima</h1>
    </header>

    <main>
        <div class="container">
            <%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <div style="color: red; font-weight: bold;"><%= error %></div>
<%
    }
%>

            <form action="svRetirarMP" method="post">
                <label for="materiaPrimaId">Materia Prima:</label>
                <select name="materiaPrimaId" required>
                    <%
                        List<MateriaPrima> listaMaterias = (List<MateriaPrima>) request.getAttribute("materias");
                        if (listaMaterias != null && !listaMaterias.isEmpty()) {
                            for (MateriaPrima m : listaMaterias) {
                    %>
                        <option value="<%= m.getIdMateriaPrima() %>">
                            <%= m.getNombre() %> (Stock: <%= m.getStock() %>)
                        </option>
                    <%
                            }
                        } else {
                    %>
                        <option disabled selected>No hay materias primas disponibles</option>
                    <%
                        }
                    %>
                </select>
                <br><br>

                <label for="cantidad">Cantidad a retirar:</label>
                <input type="number" name="cantidad" min="1" required>
                <br><br>

                <label for="productoNombre">Producto generado:</label>
                <input type="text" name="productoNombre" required>
                <br><br>

                <button type="submit">Registrar Retiro</button>
            </form>
        </div>

        <button onclick="location.href='svMPAgregar'">Volver al inicio</button>
    </main>
</body>
</html>

