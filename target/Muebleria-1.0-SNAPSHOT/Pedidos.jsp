<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Logica.Pedido" %>
<%@ page import="Logica.Producto" %>
<%@ page import="Logica.Cliente" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Pedidos</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 0; }
        header { background: #2e7d32; color: white; padding: 20px; text-align: center; }
        main { padding: 30px; }
        .container {
            width: 90%;
            margin: auto;
            padding: 20px 0;
            text-align: center;
        }
        .actions button {
            background-color: #2e7d32;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
            margin: 5px;
        }
        .actions button:hover {
            opacity: 0.9;
        }
        table {
            width: 90%; margin: auto; border-collapse: collapse;
            background: white; box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        th, td {
            border: 1px solid #ccc; padding: 12px; text-align: left;
        }
        th {
            background: #2e7d32; color: white;
        }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .btn-accion {
            margin: 0 5px;
            padding: 5px 10px;
            font-size: 0.9em;
            cursor: pointer;
            border-radius: 3px;
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
        .btn-accion:hover {
            opacity: 0.85;
        }
    </style>
</head>
<body>

<header>
    <h1>Listado de Pedidos</h1>
</header>

<main>
    <div class="container">
        <div class="actions">
            <button onclick="location.href='SvPedidos?action=nuevo'">Nuevo Pedido</button>
            <button onclick="location.href='SvPedidos'">Actualizar Lista</button>
            <button onclick="history.back()">Volver Atrás</button>
            <button onclick="location.href='index.jsp'">Volver al Inicio</button>
        </div>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID Pedido</th>
                <th>Cliente</th>
                <th>Producto</th>
                <th>Cantidad</th>
                <th>Fecha</th>
                <th>Total</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Pedido> listaPedidos = (List<Pedido>) request.getAttribute("pedidos");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                if (listaPedidos != null && !listaPedidos.isEmpty()) {
                    for (Pedido p : listaPedidos) {
            %>
            <tr>
                <td><%= p.getIdPedido() %></td>
                <td><%= p.getCliente() != null ? p.getCliente().getNombre() : "Sin cliente" %></td>
                <td><%= p.getProducto() != null ? p.getProducto().getNombre() : "Sin producto" %></td>
                <td><%= p.getCantidad() %></td>
                <td><%= p.getFechaPedido() != null ? p.getFechaPedido().format(formatter) : "Sin fecha" %></td>
                <td>$<%= String.format("%.2f", p.getTotal()) %></td>
                <td>
                    <form action="SvEditarP" method="GET" style="display:inline;">
                        <input type="hidden" name="id" value="<%= p.getIdPedido() %>">
                        <button type="submit" class="btn-accion editar-btn">Editar</button>
                    </form>
                    <form action="SvEliminarP" method="POST" style="display:inline;">
                        <input type="hidden" name="id" value="<%= p.getIdPedido() %>">
                        <button type="submit" class="btn-accion eliminar-btn"
                            onclick="return confirm('¿Estás seguro de que quieres eliminar este pedido?');">
                            Eliminar
                        </button>
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="7">No hay pedidos disponibles.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</main>

</body>
</html>
