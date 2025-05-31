<%-- 
    Document   : nuevoProducto
    Created on : 26 abr 2025, 20:07:06
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Producto</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
</head>
<body>

<header>
    <h1>Nuevo Producto</h1>
</header>

<main>
    <div class="actions">
    <form action="GuardarProducto" method="post">
        <input type="text" name="nombre" placeholder="Nombre del Producto" required>
        <input type="text" name="tipo" placeholder="Tipo" required>
        <input type="text" name="material" placeholder="Material" required>
        <input type="number" name="precio" step="0.01" placeholder="Precio" required>


    </form>
        </div>

    <div class="actions">
                <button type="submit">Guardar Producto</button>
        <button onclick="location.href='Productos.jsp'">Volver atrás</button>
    </div>
</main>

</body>
</html>

