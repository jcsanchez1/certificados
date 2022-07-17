<%@page import="com.jcsm.configuracion.helpers"%>
<%@page import="com.jcsm.configuracion.Dba"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.jcsm.entidades.TblPersonas"%>
<%@include file="/comunes/deshabilitar.jsp" %>
<%

    int respuesta = 0;
    String sql = "";
    ResultSet rs = null;
    Dba cn = new Dba();
    helpers hp = new helpers();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/comunes/nead1.jsp" %>
    </head>
    <body class="app sidebar-mini">
        <!-- Navbar-->
        <!-- Navbar-->
        <%
            try {
                sql = "SELECT tbl_configuracion.logo, tbl_configuracion.logopeque, tbl_configuracion.nombre FROM tbl_configuracion";
                rs = cn.ejecutarConsultaprograma(sql);
                // TblConfiguracion tcon = new TblConfiguracion();
                String a1 = "", a2 = "", a3 = "";
                while (rs.next()) {
                    //  tcon.setLogo(rs.getString(1));
                    a1 = rs.getString(1);
                    //   tcon.setLogopeque(rs.getString(2));
                    a2 = rs.getString(2);
                    //   tcon.setNombre(rs.getString(3));
                    a3 = rs.getString(3);
                }
        %>


        <header class="app-header"><a class="app-header__logo" href="index.jsp"><img height="50px" width="150px" src="images/<%=a2%>" alt="<%=a3%>"/></a>
                <%
                    } catch (Exception e) {
                    } finally {
                        cn.desconectar();
                    }
                %>
            <!-- Sidebar toggle button<a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>-->
            <!-- Navbar Right Menu-->

        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <ul class="app-menu">
                <li><a class="app-menu__item" href="index.jsp"><i class="app-menu__icon fa fa-id-card"></i><span class="app-menu__label">Buscar Certificado</span></a></li>


            </ul>
            <div>
                <form action="index.jsp" method="POST">
                    <div class="form-group row">
                        <div class="offset-2 col-8">
                            <label for="dni" class="col-2 col-form-label text-white" >DNI</label> 
                        </div>
                        <div class="offset-2 col-8">
                            <input id="dni" name="dni" type="text" required="required" class="form-control">
                        </div>
                    </div>

                    <div class="form-group row text-center">
                        <div class="offset-2 col-8">
                            <button name="submit" type="submit" class="btn btn-primary">Buscar</button>

                        </div>
                        <br>
                        <br>                      
                    </div>
                </form>
            </div>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <div>
                    <h1><i class="fa fa-th-list"></i>Lista de certificados</h1>

                </div>

            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <div class="tile-body">
                            <div class="table-responsive">
                                <table class="table table-hover table-bordered" id="sampleTable">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Curso</th>
                                            <th>Certificacion</th>
                                            <th>Participante</th>
                                            <th>Instructor</th>
                                            <th>Fecha Inicio</th>
                                            <th>Fecha Final</th>
                                            <th>Descargar</th>
                                            <th>Ver</th>                                            
                                        </tr>
                                    </thead>
                                    <%
                                        if (request.getParameter("submit") != null) {
                                            try {
                                                String dni = request.getParameter("dni");
                                                sql = "SELECT tbl_personas.idafiliacion, tbl_cursos.nombrecurso, tbl_certificaciones.idcertificacion, CONCAT(tbl_personas.nombre, ' ', tbl_personas.apellido) AS participante, CONCAT(tbl_instructores.nombre, ' ', tbl_instructores.apellido) AS instructor, tbl_cursos.fechainicio, tbl_cursos.fechafinal,tbl_cursos.curid FROM tbl_cursos INNER JOIN tbl_certificaciones ON tbl_certificaciones.idcurso = tbl_cursos.curid INNER JOIN tbl_participantescursos ON tbl_participantescursos.cursoid = tbl_cursos.curid AND tbl_certificaciones.curparid = tbl_participantescursos.curparid INNER JOIN tbl_instructores ON tbl_cursos.instid = tbl_instructores.instid INNER JOIN tbl_personas ON tbl_participantescursos.personaid = tbl_personas.id WHERE tbl_personas.idafiliacion = " + dni + ";";
                                                rs = cn.ejecutarConsultaprograma(sql);
                                                String a1 = "", a2 = "", a3 = "", a4 = "", a5 = "", a6 = "", a7 = "", a8 = "", a9 = "";
                                    %>
                                    <tbody> 
                                        <%
                                            while (rs.next()) {
                                                a1 = rs.getString(1);
                                                a2 = rs.getString(2);
                                                a3 = rs.getString(3);
                                                a4 = rs.getString(4);
                                                a5 = rs.getString(5);
                                                a6 = rs.getString(6);
                                                a7 = rs.getString(7);
                                                a8 = rs.getString(8);
                                        %>
                                        <tr>
                                            <td><%=a1%></td>
                                            <td><%=a2%></td>
                                            <td><%=a3%></td>
                                            <td><%=a4%></td>
                                            <td><%=a5%></td>
                                            <td><%=a6%></td>
                                            <td><%=a7%></td>
                                            <td><a href="diploma2.jsp?dni=<%=a3%>" target="_blank">Descargar</a></td>                                    
                                            <td><a href="ver.jsp?dni=<%=a3%>" target="_blank">ver</td> 
                                        </tr>                                            
                                        <%  }  %>
                                    </tbody>                                         
                                    <%
                                            } catch (Exception e) {
                                            }
                                        }
                                    %>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="/comunes/footer2.jsp" %>
    </body>
</html>