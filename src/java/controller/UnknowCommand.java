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

/**
 *
 * @author Geraldo
 */
public class UnknowCommand extends FrontCommand{

    @Override
    public void process() {
        try {
            forward("/unknow.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UnknowCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
