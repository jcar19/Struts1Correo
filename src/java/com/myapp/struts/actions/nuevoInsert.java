/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.actions;

import com.myapp.struts.dao.PrincipalDAO;
import com.myapp.struts.dao.beans.Mail;
import com.myapp.struts.formbeans.ActionFormNuevo;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Aula E3
 */
public class nuevoInsert extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String destino = request.getParameter("destino");
        String asunto = request.getParameter("asunto");
        String mensage = request.getParameter("contenido");
        
        ActionFormNuevo nuevoForm = (ActionFormNuevo)form;
        
        
        PrincipalDAO dao = new PrincipalDAO();

        try {
            //List<Mail> mail = dao.nuevoCorreo();
            Mail nuevoMail = new Mail();
            //nuevoMail.setAsunto(asunto);
            //nuevoMail.setContenido(mensage);
            nuevoMail.setAsunto(nuevoForm.getAsunto());
            nuevoMail.setContenido(nuevoForm.getContenido());
            dao.nuevoCorreo(nuevoMail);
        } catch (SQLException e) {
            System.out.println("Error en conexión -> " + e.getMessage());
        }
        
        return mapping.findForward(SUCCESS);
    }
}
