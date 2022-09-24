<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <title>GymWeb - Clases</title>
    </head>
    <body>
    <jsp:include page="navbar.jsp" />
    <div class="list-group list-group-radio d-grid gap-2 border-0 w-auto text-bg-dark p-3">
        <span style="height:50px;"></span>
        <div class="container">
                    <% for(int i = 0; i < 10; i+=1) { %>
                        <div class="row">
                            <div class="col">
                                <div class="position-relative">
                                    <input class="form-check-input position-absolute top-50 end-0 me-3 fs-5" type="radio" name="listGroupRadioGrid" id="listGroupRadioGrid1" value="" checked="">
                                    <label class="list-group-item py-3 pe-5" for="listGroupRadioGrid1">
                                        <strong class="fw-semibold">Clase</strong>
                                        <span class="d-block small opacity-75">Descripcion de la clase</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col">
                                Test
                            </div>
                        </div>
                    <% } %>
                </div>
        </div>
    <jsp:include page="footer.jsp"/>
    </body>
</html>
