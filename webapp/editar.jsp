<%@page import="com.codoacodo.model.Orador"%>
<html>
    <head>
        <%@include file="head.jsp" %>	
        <title>
            Editar Orador
        </title>
    </head>

    <body>
        <%@include file="navbar.jsp" %>
        <main>

            <!-- ACA VA EL NAVBAR  -->

            <br>
            <div class="container">
                <section class="border border-success rounded-4 col-6 mx-auto" style="background-color: black">
                    <section>
                        <%

                            Orador orador = (Orador) request.getAttribute("orador");

                        %>

                        <h1 class="text-center my-3">Editar Orador</h1>
                        <!--  JSP -->
                        <form method="POST"
                              action="<%=request.getContextPath()%>/api/EditarController">
                            <div class="my-3 mx-4" style="display: none" >
                                <label for="exampleFormControlInput1" class="form-label">ID</label>
                                <input name="id"
                                       value="<%=orador.getId()%>"  
                                       type="text" class="form-control" id="exampleFormControlInput1"/>
                            </div>
                            <div class="my-3 mx-4">
                                <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                                <input name="nombre"
                                       value="<%=orador.getNombre()%>"  
                                       type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre" maxlength="50">
                            </div>
                            <div class="my-3 mx-4">
                                <label for="exampleFormControlTextarea1" class="form-label">Apellido</label>
                                <input name="apellido"
                                       value="<%=orador.getApellido()%>" 
                                       type="text" class="form-control" id="exampleFormControlTextarea1">
                            </div>
                            <div class="my-3 mx-4">
                                <label for="mail" class="form-label">Mail</label>
                                <input value="<%=orador.getMail()%>" name="mail" type="text" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="50">
                            </div>
                            <div class="my-3 mx-4">
                                <label for="exampleFormControlTextarea" class="form-label">Tema</label>
                                <input name="tema"
                                       type="text" class="form-control" id="exampleFormControlTextarea" 
                                       value= "<%=orador.getTema()%>" >

                            </div>
                            <div class="text-center">
                                <button class="btn btn-dark">
                                    Guardar
                                </button>
                                <button class="btn btn-dark" onclick="history.back()">
                                    Cancelar
                                </button>
                            </div>
                        </form>
                    </section>
                </section>
            </div>

        </main>
    </body>	
</html>