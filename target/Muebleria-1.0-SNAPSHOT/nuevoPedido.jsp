<%-- 
    Document   : nuevoPedido.jsp
    Created on : 27 abr 2025, 21:32:40
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Presupuesto</title>
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
    <h1>Nuevo Presupuesto</h1>
</header>

<main>
    <form action="GuardarPresupuesto" method="post">
        <input type="text" name="cliente" placeholder="Nombre del Cliente" required>
        <input type="text" name="producto" placeholder="Producto" required>
        <input type="number" name="cantidad" placeholder="Cantidad" required>
        <input type="number" name="total" step="0.01" placeholder="Total" required>

        <button type="submit">Guardar Presupuesto</button>
    </form>

    <div class="volver">
        <button onclick="location.href='Pedidos.jsp'">Volver atrás</button>
    </div>
</main>

</body>
</html>

