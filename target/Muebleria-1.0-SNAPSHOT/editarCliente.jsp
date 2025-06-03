<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.Cliente"%>
<%
    Cliente cliente = (Cliente) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Cliente</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 20px;
        }
        .container {
            max-width: 500px;
            background: white;
            padding: 20px;
            border-radius: 8px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            margin: 10px 0 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background: #007BFF;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Editar Cliente</h2>
    <form action="SvEditarC" method="post">
        <input type="hidden" name="id" value="<%= cliente.getIdCliente() %>">

        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" value="<%= cliente.getNombre() %>" required>

        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" value="<%= cliente.getApellido() %>" required>

        <label for="telefono">Teléfono:</label>
        <input type="text" name="telefono" value="<%= cliente.getTelefono() %>" required>

        <label for="email">Email:</label>
        <input type="email" name="email" value="<%= cliente.getEmail() %>" required>

        <label for="direccion">Dirección:</label>
        <input type="text" name="direccion" value="<%= cliente.getDireccion() %>" required>

        <input type="submit" value="Actualizar Cliente">
    </form>
</div>
</body>
</html>
