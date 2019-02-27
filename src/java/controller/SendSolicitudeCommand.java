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
import model.Book;
import model.Cart;
import model.Solicitude;

/**
 *
 * @author Geraldo
 */
public class SendSolicitudeCommand extends FrontCommand {

    @Override
    public void process() {
        List<Solicitude> solicitudesList = getSolicitudeList();
        List<Book> books = getBooks();
        Solicitude newSolicitude = new Solicitude(solicitudesList.size() + 1, books, "Solicitud en proceso", "Fer");
        solicitudesList.add(newSolicitude);
        saveSolicitudeList(solicitudesList);
        cleanCart();
        try {
            forward("/views/buyer/cart.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Solicitude> createSolicitudeList() {
        return new ArrayList<>();
    }

    private List<Solicitude> getSolicitudeList() {
        HttpSession session = request.getSession(true);
        List<Solicitude> solicitudeList;
        if (session.isNew()) {
            solicitudeList = createSolicitudeList();
            session.setAttribute("solicitudeslist", solicitudeList);

        } else {
            if (session.getAttribute("solicitudeslist") == null) {
                solicitudeList = createSolicitudeList();

            } else {
                solicitudeList = (List<Solicitude>) session.getAttribute("solicitudeslist");

            }
        }
        return solicitudeList;
    }

    private void saveSolicitudeList(List<Solicitude> solicitudeList) {
        HttpSession session = request.getSession(true);
        session.setAttribute("solicitudeslist", solicitudeList);
    }

    private void cleanCart() {
        HttpSession session = request.getSession(true);
        session.setAttribute("cart", null);
    }

    private List<Book> getBooks() {
        HttpSession session = request.getSession(true);
        Cart cart = (Cart) session.getAttribute("cart");
        return cart.getBooks();
    }

}
