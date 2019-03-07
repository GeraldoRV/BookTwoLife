/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Geraldo
 */
@XmlRootElement
@XmlType(propOrder = {"sellerName","bookList"})
public class PageSeller {
    private List<Book> bookList;
    private String sellerName;

    public PageSeller() {
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public String getSellerName() {
        return sellerName;
    }
    public void toXml(){
        try {
            File file = new File("C:\\Users\\Geraldo.LAPTOP-09QGLT5H\\"
                    + "Documents\\NetBeansProjects\\AS1819\\BookTwoLife\\src\\java\\controller\\pageseller.xml");
            JAXBContext jax = JAXBContext.newInstance(PageSeller.class);
            Marshaller m = jax.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
            
            m.marshal(this, file); 
           
           
        } catch (JAXBException e) {
            System.out.println(e.getErrorCode());
        }
    }
    
}
