<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Producto</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/tableStyle.css">
    <style>
        form {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 10px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .actions {
            margin-top: 20px;
            text-align: center;
        }
        .actions button {
            padding: 10px 20px;
            margin: 0 10px;
            font-size: 1em;
            cursor: pointer;
            border: none;
            border-radius: 5px;
        }
        .actions button:first-child {
            background-color: #4CAF50;
            color: white;
        }
        .actions button:last-child {
            background-color: #ccc;
        }
    </style>
</head>
<body>

<header>
    <h1>Nuevo Producto</h1>
</header>

<main>
    <form action="svProducto" method="post">
        <label for="nombre">Nombre del Producto</label>
        <input type="text" id="nombre" name="nombre" placeholder="Nombre del Producto" required>

        <label for="descripcion">Descripción</label>
        <input type="text" id="descripcion" name="descripcion" placeholder="Descripción">

        <label for="stock">Stock</label>
        <input type="number" id="stock" name="stock" placeholder="Cantidad en stock" min="0" required>

        <label for="precioUnitario">Precio Unitario</label>
        <input type="number" id="precioUnitario" name="precioUnitario" step="0.01" placeholder="Precio" required>

        <div class="actions">
            <button type="submit">Guardar Producto</button>
            <button type="button" onclick="location.href='svProducto'">Volver atrás</button>
        </div>
    </form>
</main>

</body>
</html>


