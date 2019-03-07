/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import model.Book;
import model.PageSeller;

/**
 *
 * @author Geraldo
 */
public class TwoStepViewCommand extends FrontCommand {

    private final String PATH = "C:\\Users\\Geraldo.LAPTOP-09QGLT5H\\Documents\\NetBeansProjects\\AS1819\\BookTwoLife\\src\\java\\utilities\\";
    @Override
    public void process() {
        PageSeller pg = new PageSeller();
        pg.find(request.getParameter("name"));
        pg.toXml();
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xslFirstStage = new StreamSource(new File(PATH+"firststage.xsl"));
            StreamSource xslSecondStage = new StreamSource(new File(PATH+"secondstage.xsl"));
            Transformer firstTransformer = factory.newTransformer(xslFirstStage);
            StreamSource xml = new StreamSource(new File(PATH+"pageseller.xml"));
            PrintWriter writer = response.getWriter();
            SAXTransformerFactory factory1 = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler tfh = factory1.newTransformerHandler(xslSecondStage);
            tfh.setResult(new StreamResult(writer));

            firstTransformer.transform(xml, new SAXResult(tfh));

        } catch (TransformerConfigurationException | IOException ex) {
            Logger.getLogger(TwoStepViewCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(TwoStepViewCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    

}
