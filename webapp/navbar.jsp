<nav class="navbar navbar-expand-lg navbar-dark bg-dark"">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>">
            Inicio
            <!-- comment<img src="codoacodo.png" alt="CaC Logo" class="img-header"> -->
        </a>
       
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/alta.jsp">Alta</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/api/ListadoController">Listado</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Trabajos anteriores
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item" href="tpboostrap.html" target="_blank">TP Boostrap</a></li>
                        <li><a class="dropdown-item" href="./pages/tickets.html" target="_blank">TP Javascript</a></li>
                    </ul>
                </li>

            </ul>
            <form class="d-flex"	
                  action="<%=request.getContextPath()%>/api/BuscarController" 
                  method="get">
                <input name="clave" class="form-control me-2" type="search" placeholder="Nombre Orador" aria-label="Search">
                <button class="btn btn-success" type="submit">Buscar</button>
            </form>
        </div>
    </div>
</nav>