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
        <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
        <!-- Twitter meta-->
        <meta property="twitter:card" content="summary_large_image">
        <meta property="twitter:site" content="@pratikborsadiya">
        <meta property="twitter:creator" content="@pratikborsadiya">
        <!-- Open Graph Meta-->
        <meta property="og:type" content="website">
        <meta property="og:site_name" content="Vali Admin">
        <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
        <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
        <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
        <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
        <title>Diplomas</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body class="app sidebar-mini">
        <!-- Navbar-->
        <!-- Navbar-->
                        <%
                    try {
                        sql = "SELECT tbl_configuracion.logo, tbl_configuracion.logopeque, tbl_configuracion.nombre FROM tbl_configuracion";
                        rs = cn.ejecutarConsultaprograma(sql);
                       // TblConfiguracion tcon = new TblConfiguracion();
                        String a1="",a2="",a3="";
                        while (rs.next()) {
                          //  tcon.setLogo(rs.getString(1));
                            a1=rs.getString(1);
                         //   tcon.setLogopeque(rs.getString(2));
                            a2=rs.getString(2);
                         //   tcon.setNombre(rs.getString(3));
                            a3=rs.getString(3);
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
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
                    <li class="breadcrumb-item active"><a href="#">Certificados</a></li>
                </ul>
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
        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <!-- Data table plugin-->
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <!-- Google analytics script-->
        <script type="text/javascript">
            if (document.location.hostname == 'pratikborsadiya.in') {
                (function (i, s, o, g, r, a, m) {
                    i['GoogleAnalyticsObject'] = r;
                    i[r] = i[r] || function () {
                        (i[r].q = i[r].q || []).push(arguments)
                    }, i[r].l = 1 * new Date();
                    a = s.createElement(o),
                            m = s.getElementsByTagName(o)[0];
                    a.async = 1;
                    a.src = g;
                    m.parentNode.insertBefore(a, m)
                })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
                ga('create', 'UA-72504830-1', 'auto');
                ga('send', 'pageview');
            }
        </script>
    </body>
</html>