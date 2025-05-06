<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Carpintería - Sistema de Gestión</title>
    <style>
        :root {
            --primary: #0a2f5c;
            --secondary: #f0f4fa;
            --accent: #1976d2;
            --white: #ffffff;
            --text: #1a1a1a;
            --hover-bg: #e3efff;
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--secondary);
            color: var(--text);
        }

        header {
            background-color: var(--primary);
            color: var(--white);
            padding: 2rem 1rem;
            text-align: center;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }

        header h1 {
            font-size: 2rem;
        }

        main {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 2rem;
            padding: 3rem 2rem;
            max-width: 1200px;
            margin: 0 auto;
        }

        .card {
            background-color: var(--white);
            border-radius: 12px;
            padding: 2rem;
            width: 280px;
            box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.25); /* más sombra derecha y abajo */
            text-align: center;
            transition: transform 0.4s ease, box-shadow 0.4s ease;
            border: 2px solid transparent;
            cursor: pointer;
            will-change: transform;
    
        }

        .card:hover {
            transform: perspective(1000px) translateY(-10px) rotateX(4deg);
            box-shadow: 14px 14px 30px rgba(0, 0, 0, 0.35); /* más sombra, más oscura en hover */
            border-color: var(--accent);
            background-color: var(--hover-bg);
        }

        .card h2 {
            color: var(--primary);
            margin-bottom: 0.5rem;
            font-size: 1.4rem;
        }

        .card p {
            font-size: 0.95rem;
            color: #555;
        }

        a {
            text-decoration: none;
            color: inherit;
        }

        footer {
            background-color: var(--primary);
            color: var(--white);
            text-align: center;
            padding: 1.5rem 1rem;
            font-size: 0.9rem;
        }

        @media (max-width: 600px) {
            header h1 {
                font-size: 1.5rem;
            }

            .card {
                width: 100%;
                max-width: 90vw;
            }

            main {
                padding: 2rem 1rem;
            }
        }
    </style>
</head>
<body>

<header>
    <h1>🪵 Sistema de Gestión - Carpintería 🪵</h1>
</header>

<main>
    <a href="Productos.jsp">
        <div class="card">
            <h2>🛠 Productos</h2>
            <p>Gestionar productos disponibles.</p>
        </div>
    </a>

    <a href="Presupuesto.jsp">
        <div class="card">
            <h2>📄 Presupuesto</h2>
            <p>Crear y modificar presupuestos.</p>
        </div>
    </a>

    <a href="Pedidos.jsp">
        <div class="card">
            <h2>📝 Pedidos</h2>
            <p>Registrar nuevos pedidos de clientes.</p>
        </div>
    </a>

    <a href="Entregas.jsp">
        <div class="card">
            <h2>🚚 Entregas</h2>
            <p>Control de entregas de productos.</p>
        </div>
    </a>

    <a href="MateriaPrima.jsp">
        <div class="card">
            <h2>📦 Materia Prima</h2>
            <p>Stock, compra y retiro de materiales.</p>
        </div>
    </a>

    <a href="Clientes.jsp">
        <div class="card">
            <h2>👥 Clientes</h2>
            <p>Administrar información de clientes.</p>
        </div>
    </a>
</main>

<footer>
    <p>© 2025 Carpintería | Todos los derechos reservados © </p>
</footer>

</body>
</html>
