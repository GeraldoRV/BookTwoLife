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
public class TwoStepView extends FrontCommand {

    @Override
    public void process() {
        createExample();
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xslFirstStage = new StreamSource(new File("C:\\Users\\Geraldo.LAPTOP-09QGLT5H\\Documents\\NetBeansProjects\\AS1819\\BookTwoLife\\src\\java\\controller\\firststage.xsl"));
            StreamSource xslSecondStage = new StreamSource(new File("C:\\Users\\Geraldo.LAPTOP-09QGLT5H\\Documents\\NetBeansProjects\\AS1819\\BookTwoLife\\src\\java\\controller\\secondstage.xsl"));
            Transformer firstTransformer = factory.newTransformer(xslFirstStage);
            StreamSource xml = new StreamSource(new File("C:\\Users\\Geraldo.LAPTOP-09QGLT5H\\Documents\\NetBeansProjects\\AS1819\\BookTwoLife\\src\\java\\controller\\pageseller.xml"));
            PrintWriter writer = response.getWriter();
            SAXTransformerFactory factory1 = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler tfh = factory1.newTransformerHandler(xslSecondStage);
            tfh.setResult(new StreamResult(writer));

            firstTransformer.transform(xml, new SAXResult(tfh));

        } catch (TransformerConfigurationException | IOException ex) {
            Logger.getLogger(TwoStepView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(TwoStepView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createExample() {
      Book book = new Book();
      Book ook = new Book();
      book = book.find("s");
      ook = ook.find("s");
      PageSeller ju = new PageSeller();
      ju.setSellerName("Juan");
      ju.setBookList(Arrays.asList(book,ook));
      ju.toXml();
      
    }

}
