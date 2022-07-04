<%@page import="java.io.StringReader"%>
<%@page import="com.lowagie.text.html.simpleparser.HTMLWorker"%>
<%@page import="com.lowagie.text.pdf.PdfWriter"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.PdfPTable"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Date"%>
<%@page import="com.jcsm.configuracion.Dba"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.jcsm.entidades.TblPersonas"%>
<%

    int respuesta = 0;
    String sql = "";
    ResultSet rs = null;
    Dba cn = new Dba();
    String a1 = "", a2 = "", a3 = "", a4 = "", a5 = "", a6 = "", a7 = "", a8 = "", a9 = "";
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

        //configurar el header y el tipo
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "attachment; filename=\"reporte.pdf\"");
        try {
            //crear y abrir documento tipo pdf
            Document documentoPDF = new Document();
            PdfWriter.getInstance(documentoPDF, response.getOutputStream());
            documentoPDF.open();

            //algunos parametros
            documentoPDF.addAuthor(a5);
            documentoPDF.addCreator(a5);
            documentoPDF.addSubject("Diploma");
            documentoPDF.addCreationDate();
            documentoPDF.addTitle(a2);

            //insertar html
            HTMLWorker htmlWorker = new HTMLWorker(documentoPDF);
            String str = "<!DOCTYPE html>"
                    + "<html lang='en'>"
                    + "<head>"
                    + "<meta charset='UTF-8'>"
                    + "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
                    + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                    + "</head>"
                    + "<body>"
                    + "<div style='width:800px; height:600px; padding:20px; text-align:center; border: 10px solid #787878'>"
                    + "<div style='width:750px; height:550px; padding:20px; text-align:center; border: 5px solid #787878'>"
                    + "<img height='50px' width='150px' src='proyecto/certificados/web/images/logo2.png' alt=''/><br>"
                    + "<center><span style='font-size:30px; font-weight:bold; text-align:center'>Certificado de completacion</span></center>"
                    + "<br><br>"
                    + "<center><span style='font-size:25px text-align:center'><i>hacemos constar que </i></span></center>"
                    + "<br><br>"
                    + "<span style='font-size:30px text-align:center'><b>" + a4 + "</b></span><br/><br/>"
                    + "<span style='font-size:25px text-align:center'><i>ha completado el siguiente curso</i></span> <br/><br/>"
                    + "<span style='font-size:30px text-align:center'>" + a2 + "</span> <br/><br/>"
                    + "<span style='font-size:25px text-align:center'><i>instructor</i></span> <br/><br/>"
                    + "<span style='font-size:15px text-align:center'>" + a5 + "</span> <br/><br/>"
                    + "<span style='font-size:25px text-align:center'><i>Fecha de completacion</i></span><br>"
                    + a7
                    + "</div>"
                    + "</div>"
                    + "</body>"
                    + "</html>";

            htmlWorker.parse(new StringReader(str));

            // cerrar el documento
            documentoPDF.close();
        } catch (DocumentException de) {
            throw new IOException(de.getMessage());
        }
    }
%>