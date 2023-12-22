<html>
    <head>
        <%@include file="head.jsp" %>
        <title>
            Nuevo Orador
        </title>
    </head>

    <body>

        <%@include file="navbar.jsp" %>
        <main>  
            <br>
            <div class="container">
                <section class="border border-success rounded-4 col-6 mx-auto text-center" style="background-color: black">
                    <h1 class="text-center my-4">Nuevo Orador </h1>
                    <!--  JSP -->
                    <form method="post"
                          action="<%=request.getContextPath()%>/CreateController">
                        <div class="my-3 mx-3">
                            <input name="nombre"  type="text" class="form-control" id="nombreTextarea" placeholder="Nombre" maxlength="50" required>
                        </div>
                        <div class="my-3 mx-3">
                            <input name="apellido" type="text" class="form-control" id="apellidoTextarea" placeholder="Apellido" required>
                        </div>
                        <div class="my-3 mx-3">
                            <input name="mail" type="email" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="50"required >
                        </div>
                        <div class="my-3 mx-3">
                            <textarea name="tema" type="text" class="form-control" id="temaTextarea" maxlength="200" placeholder="Tema" rows="3" required></textarea>
                        </div>
                        <button class="btn btn-dark my-3">
                            Agregar
                        </button>
                        <button class="btn btn-dark my-3" type="reset">
                            Limpiar
                        </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>