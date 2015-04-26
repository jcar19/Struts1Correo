/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.dao.beans.roudmapper;

import com.myapp.struts.dao.beans.Mail;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ASUS
 */
public class MailMapper {
    private static final String ID_FIELD = "id_mail";
    private static final String CONTENIDO_FIELD = "contenido";
    private static final String ASUNTO_FIELD = "asunto";
    private static final String REMITENTE_FIELD = "remitente";
    
    public static Mail mapRow(ResultSet rs) throws SQLException{
        Mail mail = new Mail();        
        mail.setContenido(rs.getString(CONTENIDO_FIELD));
        mail.setAsunto(rs.getString(ASUNTO_FIELD));
        mail.setRemitente(rs.getString(REMITENTE_FIELD));
        return mail;
    }
}
