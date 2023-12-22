<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.codoacodo.model.Orador"%>
<!DOCTYPE html>
<html lang="es-ar" data-bs-theme="light">
    <head>
        <%@include file="head.jsp" %>
        <title>
            Listado de Oradores
        </title>	
    </head>

    <body>

        <%@include file="navbar.jsp" %>
        <main>
            <div class="container">

                <section class="border rounded-5 m-4 px-2 pt-2 pb-3 col-12 mx-auto text-center" style="background-color: black" >
                    <h2 class="my-4">Listado Completo de Oradores</h2>
                    <table class="table table-sm table-striped table-hover border border-success">
                        <thead>
                            <tr>
                                <th scope="col" style="display:none;">ID</th>
                                <th scope="col">NOMBRE</th>
                                <th scope="col">APELLIDO</th>
                                <th scope="col">EMAIL</th>
                                <th scope="col">TEMA</th>
                                <th scope="col">FECHA ALTA</th>
                                <th scope="col">ACCIONES</th>
                            </tr>
                        </thead>
                        <%
                            //codigo java
                            //obtener el listado desde el request
                            //se guardo bajo el nombre de "listado"
                            List<Orador> listadoOradores = (List<Orador>) request.getAttribute("listado");
                        %>
                        <tbody>
                            <%
                                for (Orador unOrador : listadoOradores) {
                            %>

                            <tr>
                                <th scope="row" style="display:none;"> <%=unOrador.getId()%> </th>
                                <td><%=unOrador.getNombre()%></td>
                                <td><%=unOrador.getApellido()%></td>
                                <td><%=unOrador.getMail()%></td>
                                <td><%=unOrador.getTema()%></td>
                                <td><%=new SimpleDateFormat("dd-MM-yyyy").format(unOrador.getFechaAlta())%></td>
                                <td>

                                    <a class="btn btn-outline-success" href="<%=request.getContextPath()%>/api/EditarController?id=<%=unOrador.getId()%>" role="button">Editar</a>  
                                    <a class="btn btn-outline-danger" href="<%=request.getContextPath()%>/api/EliminarController?id=<%=unOrador.getId()%>" role="button">Borrar</a>  


                                </td>
                            </tr>
                            <%
                                }
                            %>

                        </tbody>
                    </table>
                </section>


            </div>
        </main>
    </body>	
</html>