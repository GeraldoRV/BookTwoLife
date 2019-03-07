package model;

import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Geraldo
 */
@XmlRootElement
@XmlType(propOrder = {"name","description","genre","sellerName","price"})
public class Book {

    private String name;
    private String description;
    private String genre;
    private String sellerName;

    private float price;

    public Book() {
    }

    public Book(String name, String description, String genre, float price) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void toXML() {
        try {
            File file = new File("C:\\Users\\Geraldo.LAPTOP-09QGLT5H\\"
                    + "Documents\\NetBeansProjects\\AS1819\\BookTwoLife\\src\\java\\utilities\\book.xml");
            JAXBContext jax = JAXBContext.newInstance(Book.class);
            Marshaller m = jax.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(this, file);

        } catch (JAXBException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public Book find(String name) {
        switch (name) {
            case "Quijote":
                return new Book("Don Quijote", "En un lugar...", "Lírico", 3.f);
            case "1":
                return new Book("Don Quijote", "En un lugar...", "Lírico", 3.f);
            case "Sombras":
                return new Book("50 Sombras de Gray", "Para mayores de 18", "Erótico", 3.f);
            case "3":
                return new Book("50 Sombras de Gray", "Para mayores de 18", "Erótico", 3.f);
            default:
                return new Book("El Principito", "El principito es un cuento poético que viene acompañado\n"
                        + " de...", "Lirico", 3.0f);
        }

    }
}
