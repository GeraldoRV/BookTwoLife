/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Book;
import model.Cart;

/**
 *
 * @author Geraldo
 */
public class AddToCartCommand extends FrontCommand {

    @Override
    public void process() {
        String parameter = request.getParameter("name");
        Cart cart = getCart();

        if (parameter != null && !parameter.isEmpty()) {
            Book book = createBook(parameter);
            cart.addBook(book);
            saveInSession(cart);
        }
        try {
            forward("/views/buyer/main.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Cart getCart() {
        HttpSession session = request.getSession(true);
        Cart cart;
        if (session.isNew()) {
            cart = createCart();
            session.setAttribute("cart", cart);

        } else {
            if (session.getAttribute("cart") == null) {
                cart = createCart();
            } else {

                cart = (Cart) session.getAttribute("cart");
            }
        }
        return cart;
    }

    private Cart createCart() {
        return new Cart();
    }

    private void saveInSession(Cart cart) {
        HttpSession session = request.getSession(true);
        session.setAttribute("cart", cart);
    }

    private Book createBook(String name) {
        return new Book(name, "En un lugar de la mancha", "Lirico",25.0f );
    }
}
