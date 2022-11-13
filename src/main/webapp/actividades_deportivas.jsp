<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ActividadesDeportivas</title>
    <link rel="stylesheet" href="styles/actividadesdeportivas.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;700&family=Quicksand:wght@300;500;700&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container">
    <div class="container-titulo">
        <h1>Actividades Deportivas</h1>
    </div>
    <main>
        <div class="searchAndSelect">
            <div class="form-floating">
                <input type="text" class="form-control" id="text-nombre" placeholder="Buscar">
                <label for="text-nombre">Buscar</label>
            </div>
            <ol class="listaActividades">

            </ol>
        </div>
        <div class="data">
            <div class="subtitulo">
                <h2>Información</h2>
            </div>
            <div class="informacion row">
                <div class="col">
                    <div class="form-floating nombre">
                        <input type="nombre" class="form-control" id="actividaddeportiva_nombre" placeholder="Nombre">
                        <label for="text-nombre">Nombre</label>
                    </div>
                    <div class="form-floating costo">
                        <input type="text" class="form-control" id="actividaddeportiva_costo" placeholder="Costo">
                        <label for="text-costo">Costo</label>
                    </div>
                </div>
                <div class="col">
                    <div class="form-floating duracion">
                        <input type="duracion" class="form-control" id="actividaddeportiva_duracion" placeholder="Duracion">
                        <label for="text-duracion">Duracion</label>
                    </div>
                    <div class="form-floating costo">
                        <input type="text" class="form-control" id="actividaddeportiva_fecha" placeholder="Fecha">
                        <label for="text-nombre">Fecha</label>
                    </div>
                </div>
                <div class="col">
                    <div class="form-floating descripcion">
                        <input type="duracion" class="form-control" id="actividaddeportiva_descripcion" placeholder="Descripcion">
                        <label for="text-descripcion">Descripcion</label>
                    </div>
                </div>
            </div>
            <div class="carousel-clases row">

            </div>
        </div>

    </main>
</div>
</body>
<script src="JS/app.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</html>
