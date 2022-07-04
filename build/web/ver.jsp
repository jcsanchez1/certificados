<%@page import="com.jcsm.configuracion.Dba"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.jcsm.entidades.TblPersonas"%>
<%

    int respuesta = 0;
    String sql = "";
    ResultSet rs = null;
    Dba cn = new Dba();
    String a1 = "", a2 = "", a3 = "", a4 = "", a5 = "", a6 = "", a7 = "", a8 = "", a9 = "";
%>
<!DOCTYPE html>
<html lang='en'>
            <%
            if (request.getParameter("dni") != null) {
                try {
                    String dni = request.getParameter("dni");
                    sql = "SELECT ROW_COUNT() AS 'No', tbl_cursos.nombrecurso, tbl_certificaciones.idcertificacion, CONCAT(tbl_personas.nombre, tbl_personas.apellido) AS participante, CONCAT(tbl_instructores.nombre, tbl_instructores.apellido) AS instructor, tbl_cursos.fechainicio, tbl_cursos.fechafinal,tbl_cursos.curid FROM tbl_cursos INNER JOIN tbl_certificaciones ON tbl_certificaciones.idcurso = tbl_cursos.curid INNER JOIN tbl_participantescursos ON tbl_participantescursos.cursoid = tbl_cursos.curid AND tbl_certificaciones.curparid = tbl_participantescursos.curparid INNER JOIN tbl_instructores ON tbl_cursos.instid = tbl_instructores.instid INNER JOIN tbl_personas ON tbl_participantescursos.personaid = tbl_personas.id WHERE tbl_personas.idafiliacion = " + dni + ";";
                    rs = cn.ejecutarConsultaprograma(sql);

                    while (rs.next()) {
                        a1 = rs.getString(1);
                        a2 = rs.getString(2);
                        a3 = rs.getString(3);
                        a4 = rs.getString(4);
                        a5 = rs.getString(5);
                        a6 = rs.getString(6);
                        a7 = rs.getString(7);
                        a8 = rs.getString(8);
                    }
                } catch (Exception e) {
                }
            }
        %>
    <head>
        <meta charset='UTF-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <title>Diploma de <%=a2%> para <%=a4%></title>
    </head>
    <body>

        <div style='width:800px; height:600px; padding:20px; text-align:center; border: 10px solid #787878'>
            <div style='width:750px; height:550px; padding:20px; text-align:center; border: 5px solid #787878'>
                <img height='50px' width='150px' src='images/logo2.png' alt=''/><br>
                <span style='font-size:50px; font-weight:bold'>Certificado de completacion</span>
                <br><br>
                <span style='font-size:25px'><i>hacemos constar que </i></span>
                <br><br>
                <span style='font-size:30px'><b><%=a4%></b></span><br/><br/>
                <span style='font-size:25px'><i>ha completado el siguiente curso</i></span> <br/><br/>
                <span style='font-size:30px'><%=a2%></span> <br/><br/>
                <span style='font-size:25px'><i>instructor</i></span> <br/><br/>
                <span style='font-size:15px'><%=a5%></span> <br/><br/>
                <span style='font-size:25px'><i>Fecha de completacion</i></span><br>
                <%=a7%>
            </div>
        </div>
    </body>
</html>
