/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Geraldo
 */
public class SendSolicitudeCommand extends FrontCommand {

    @Override
    public void process() {
        List<String> solicitudeList = getSolicitudeList();
        solicitudeList.add("Solicitud en proceso");
        saveSolicitudeList(solicitudeList);
        cleanCart();
        try {
            forward("/views/buyer/cart.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<String> createSolicitudeList() {
        return new ArrayList<>();
    }

    private List<String> getSolicitudeList() {
        HttpSession session = request.getSession(true);
        List<String> solicitudeList;
        if (session.isNew()) {
            solicitudeList = createSolicitudeList();
            session.setAttribute("solicitudelist", solicitudeList);

        } else {
            if (session.getAttribute("solicitudelist") == null) {
                solicitudeList = createSolicitudeList();

            } else {
                solicitudeList = (List<String>) session.getAttribute("solicitudelist");

            }
        }
        return solicitudeList;
    }

    private void saveSolicitudeList(List<String> solicitudeList) {
        HttpSession session = request.getSession(true);
        session.setAttribute("solicitudelist", solicitudeList);
    }

    private void cleanCart() {
        HttpSession session = request.getSession(true);
        session.setAttribute("cart", null);
    }

}
