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

    private HttpSession session;

    @Override
    public void process() {
        session = request.getSession(true);
       
        String parameter = request.getParameter("name");
        Cart cart = getCart();

        addBookIn(cart, parameter);

        try {
            forward("/views/buyer/main.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Cart getCart() {
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
        session.setAttribute("cart", cart);
    }

    private Book createBook(String name) {

        switch (name) {
            case "Quijote":
                return new Book("Don Quijote", "En un lugar...", "Lírico", 3.f);
            case "Sombras":
                return new Book("50 Sombras de Gray", "Para mayores de 18", "Erótico", 3.f);
            default:
                return new Book("El Principito", "El principito es un cuento poético que viene acompañado\n"
                        + " de...", "Lirico", 3.0f);
        }
    }

    private void addBookIn(Cart cart, String parameter) {
        if (parameter != null && !parameter.isEmpty()) {
            Book book = createBook(parameter);
            cart.addBook(book);
            saveInSession(cart);
        }
    }
}
