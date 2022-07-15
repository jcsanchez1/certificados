<%@page import="net.sf.jasperreports.engine.JasperRunManager" %>
<%@page import="net.sf.jasperreports.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String dni = request.getParameter("dni");
            int idcur = Integer.parseInt(dni);
            Connection cn;
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/serafil2022", "root", "");
	
            File reportFile = new File(application.getRealPath("reportes/report1.jasper"));
            Map parameters = new HashMap();
              

            //parameters.put("nombre_del_parametro_jasper", "valor que se manda");
            parameters.put("dni",idcur);
            
            
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, cn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
            outputStream.close();

        %>

    </body>
</html>