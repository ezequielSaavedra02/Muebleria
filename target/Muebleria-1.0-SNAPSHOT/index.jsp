<%-- 
    Document   : index
    Created on : 23 abr 2025, 11:28:58
    Author     : edeze_b1s78wk
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Carpintería - Sistema de Gestión</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #2e7d32;
            color: white;
            padding: 20px;
            text-align: center;
        }
        main {
            padding: 30px;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
        }
        a {
            text-decoration: none;
        }
        .card {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            transition: transform 0.2s;
            cursor: pointer;
        }
        .card:hover {
            transform: translateY(-5px);
            background-color: #e8f5e9;
        }
        .card h2 {
            color: #2e7d32;
            margin-bottom: 10px;
        }
        footer {
            background-color: #2e7d32;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 40px;
        }
    </style>
</head>
<body>

<header>
    <h1>Sistema de Gestión - Carpintería</h1>
</header>

<main>
    <a href="Productos.jsp">
        <div class="card">
            <h2>Productos</h2>
            <p>Gestionar productos disponibles.</p>
        </div>
    </a>

    <a href="Presupuesto.jsp">
        <div class="card">
            <h2>Presupuesto</h2>
            <p>Crear y modificar presupuestos.</p>
        </div>
    </a>

    <a href="Pedidos.jsp">
        <div class="card">
            <h2>Pedidos</h2>
            <p>Registrar nuevos pedidos de clientes.</p>
        </div>
    </a>

    <a href="Entregas.jsp">
        <div class="card">
            <h2>Entregas</h2>
            <p>Control de entregas de productos.</p>
        </div>
    </a>

    <a href="MateriaPrima.jsp">
        <div class="card">
            <h2>Materia Prima</h2>
            <p>Stock, compra y retiro de materiales.</p>
        </div>
    </a>

    <a href="Clientes.jsp">
        <div class="card">
            <h2>Clientes</h2>
            <p>Administrar información de clientes.</p>
        </div>
    </a>
</main>

<footer>
    <p>© 2025 Carpintería | Todos los derechos reservados</p>
</footer>

</body>
</html>

