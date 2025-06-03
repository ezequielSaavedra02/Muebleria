<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Logica.MateriaPrima" %>
<%
    MateriaPrima materia = (MateriaPrima) request.getAttribute("materia");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Materia Prima</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 0; }
        header { background: #2e7d32; color: white; padding: 20px; text-align: center; }
        main { padding: 30px; }
        form { background: white; padding: 20px; border-radius: 8px; max-width: 500px; margin: auto; box-shadow: 0 0 10px rgba(0,0,0,0.1);}
        input, select {
            width: 100%; padding: 10px; margin: 10px 0; border-radius: 5px; border: 1px solid #ccc;
        }
        button {
            background: #2e7d32; color: white; border: none; padding: 12px; width: 100%;
            margin-top: 10px; border-radius: 5px; font-size: 16px; cursor: pointer;
        }
        button:hover { background: #1b5e20; }
        .volver {
            margin-top: 20px; text-align: center;
        }
        .volver button {
            background: #4caf50;
        }
    </style>
</head>
<body>

<header>
    <h1>Editar Materia Prima</h1>
</header>

<main>
    <form action="svMPEditar" method="post">
        <input type="hidden" name="id" value="<%= materia.getIdMateriaPrima() %>">

        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%= materia.getNombre() %>" required>

        <label>Costo Unitario:</label>
        <input type="number" name="costoUnitario" step="0.01" value="<%= materia.getCostoUnitario() %>" required>

        <label>Stock:</label>
        <input type="number" name="stock" value="<%= materia.getStock() %>" required>

        <button type="submit">Guardar Cambios</button>
    </form>

    <div class="volver">
        <button onclick="location.href='MateriaPrima.jsp'">Volver atrás</button>
    </div>
</main>

</body>
</html>

