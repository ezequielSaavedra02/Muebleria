<%-- 
    Document   : editarProducto
    Created on : 27 abr 2025, 21:46:43
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Editar Producto</title>
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
    <h1>Editar Producto</h1>
</header>

<main>
    <form action="ActualizarProducto" method="post">
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">

        <input type="text" name="nombre" placeholder="Nombre del Producto" value="<%= request.getParameter("nombre") %>" required>
        <input type="text" name="tipo" placeholder="Tipo" value="<%= request.getParameter("tipo") %>" required>
        <input type="text" name="material" placeholder="Material" value="<%= request.getParameter("material") %>" required>
        <input type="number" step="0.01" name="precio" placeholder="Precio" value="<%= request.getParameter("precio") %>" required>

        <button type="submit">Actualizar Producto</button>
    </form>

    <div class="volver">
        <button onclick="location.href='Productos.jsp'">Volver atrás</button>
    </div>
</main>

</body>
</html>

