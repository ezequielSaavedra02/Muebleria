<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Logica.DetalleProducto" %>
<%@ page import="Logica.MateriaPrima" %>
<%@ page import="Logica.Producto" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Retiros de Materia Prima</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>
<body>
    <header>
        <h1>Retiros de Materia Prima</h1>
    </header>

    <main>
        <div class="container">
            <table>
                <thead>
                    <tr>
                        <th>Materia Prima</th>
                        <th>Producto Asociado</th>
                        <th>Cantidad Usada</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<DetalleProducto> listaRetiros = (List<DetalleProducto>) request.getAttribute("detalleProductos");
                        if (listaRetiros != null && !listaRetiros.isEmpty()) {
                            for (DetalleProducto detalle : listaRetiros) {
                    %>
                    <tr>
                        <td><%= detalle.getMateriaPrima().getNombre() %></td>
                        <td><%= detalle.getProducto().getNombre() %></td>
                        <td><%= detalle.getCantidadUtilizada()%></td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="3">No se registraron retiros de materia prima.</td>
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

