/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.dao;

import com.myapp.struts.dao.beans.Mail;
import com.myapp.struts.dao.beans.roudmapper.MailMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PrincipalDAO {

    private Connection generateConnection() {
        System.out.println("MySql");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySql JDBC Driver");
            e.printStackTrace();
            return null;
        }
        System.out.println("Driver registered");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/correos", "root", "C1C3_Root");
            //.getConnection("jdbc:mysql://localhost/escuela_db?" +
            // "user=root&password=C1C3_Root");                    
        } catch (SQLException e) {
            System.out.println("Connection failed!" + e.getMessage());
            e.printStackTrace();
            return null;
        }
        if (connection != null) {
            System.out.println("You made it!,");
        } else {
            System.out.println("Failed to make connect");
        }
        return connection;
    }

    public List<Mail> dameCorreos() throws SQLException {
        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;
        List<Mail> lista = null;
        String selectQuery = "SELECT remitente,asunto,contenido FROM mail";
        try {
            conexion = generateConnection();
            sentenciaPreparada = conexion.prepareStatement(selectQuery);
            ResultSet rs = sentenciaPreparada.executeQuery();
            if (rs.isBeforeFirst()) {
                lista = new ArrayList<Mail>();
                while (rs.next()) {
                    Mail mail = MailMapper.mapRow(rs);
                    lista.add(mail);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en conexion ->" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error -> " + e.getMessage());
        }
        return lista;
    }

    public void nuevoCorreo(Mail mail) throws SQLException {
        PreparedStatement sentenciaPreparada = null;
        Connection conex = null;
        try {
            conex = generateConnection();
            //  INSERT INTO mail (contenido,asunto,remitente,id_usuario,status) VALUES ('Cuarto contenido','Prueba I','Juan',1,1)
            String sqlInsert = "INSERT INTO mail (contenido,asunto,remitente,id_usuario,status) VALUES (?, ?, 'Juan',1,1)";
            sentenciaPreparada = conex.prepareStatement(sqlInsert);

            sentenciaPreparada.setString(1, mail.getContenido());
            sentenciaPreparada.setString(2, mail.getAsunto());
//            sentenciaPreparada.setString(3, mail.getRemitente());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en conexion -> " + e.getMessage());
        } finally {
            if (sentenciaPreparada != null) {
                sentenciaPreparada.close();
            }
            if (conex != null) {
                conex.close();
            }
        }
    }
}
