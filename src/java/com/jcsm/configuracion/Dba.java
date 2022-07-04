/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcsm.configuracion;

import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juanc
 */
public class Dba {

    // Proporties
    public  String urlbitacora = "jdbc:mysql://localhost/serafiladmin";
    public  String urlprograma = "jdbc:mysql://localhost/serafil2022";
    public  String usuario = "root";
    public  String clave = "";
    public  String clase = "com.mysql.jdbc.Driver";
    public  Connection conec = null;
    PreparedStatement ps = null;
    public  PreparedStatement prest = null;
    public  CallableStatement cllst = null;
    public  Statement st = null;
    public  ResultSet rt = null;
    public  Statement query;

    // Functions
    public  Connection conectarbitacora() {
        //Connection conexion = null;
        try {
            Class.forName(clase);
            conec = (Connection) DriverManager.getConnection(urlbitacora, usuario, clave);
            query = conec.createStatement();
            System.out.println("Conexion establecida..");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conec;
    }

    public  Connection conectarprograma() {
        //Connection conexion = null;
        try {
            Class.forName(clase);
            conec = (Connection) DriverManager.getConnection(urlprograma, usuario, clave);
            query = conec.createStatement();
            System.out.println("Conexion establecida..");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conec;
    }

    public ResultSet ejecutarConsultabitacora(String sql) throws Exception {
        Statement st = null;
        st = conectarbitacora().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

    public ResultSet ejecutarConsultaprograma(String sql) throws Exception {
        Statement st = null;
        st = conectarprograma().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }

//    public int ejecutarActualizacionP(String sql, Object[] params) throws SQLException {
//        ps = conectarprograma().prepareStatement(sql);  //definir los valores para los argumentos  
//        for (int i = 0; i < params.length; i++) {
//            ps.setObject(i + 1, params[i]);
//        }
//
//        int r = ps.executeUpdate(); //retorna la cantidad de registros actualizados     
//        return r;
//
//    }
    public void commit(){
        try {
            conec.commit();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() throws SQLException {
        query.close();
        conectarbitacora().close();
        conectarprograma().close();
    }


}
