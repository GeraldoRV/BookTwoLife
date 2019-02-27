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
public class AddToCartCommand extends FrontCommand {

    @Override
    public void process() {
        String parameter = request.getParameter("name");
        List<String> cart = getCart();

        if (parameter != null && !parameter.isEmpty()) {
            cart.add(parameter);
            saveInSession(cart);
        }
        try {
            forward("/views/buyer/main.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private List getCart() {
        HttpSession session = request.getSession(true);
        List<String> cart;
        if (session.isNew()) {
            cart = createCart();
            session.setAttribute("cart", cart);

        } else {
            if (session.getAttribute("cart") == null) {
                cart = createCart();
            } else {

                cart = (List) session.getAttribute("cart");
            }
        }
        return cart;
    }

    private List createCart() {
        return new ArrayList();
    }

    private void saveInSession(List cart) {
        HttpSession session = request.getSession(true);
        session.setAttribute("cart", cart);
    }

}
