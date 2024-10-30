import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LecturaXMLburger3 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("../burger3.xml"));
        System.out.println("Todo correcto");
        doc.getDocumentElement().normalize();

        // Obtenemos el elemento raíz del XML
        Element nodoRaiz = doc.getDocumentElement();
        String atributoTitulo = nodoRaiz.getAttribute("title");
        System.out.println("Título: " + atributoTitulo);

        // Obtenemos todos los elementos "menu" en el documento
        NodeList nList = doc.getElementsByTagName("menu");
        System.out.println("Total de menús: " + nList.getLength());

        // Recorremos el NodeList de menús
        for (int i = 0; i < nList.getLength(); i++) {
            // Obtenemos el elemento "menu" actual
            Element menu = (Element) nList.item(i);

            // Verificamos el atributo "desc" del menú
            String atributoMenu = menu.getAttribute("desc");

            // Obtenemos el contenido del elemento "pan"
            String pan = menu.getElementsByTagName("pan").item(0).getTextContent();

            // Todos los panes del menú de tipo "parrilla"

            if (atributoMenu.equals("parrilla")) {
                // Obtenemos el elemento "salsa" dentro del menú actual
                Element salsa = (Element) menu.getElementsByTagName("salsa").item(0);

                // Obtenemos el atributo "cantidad" de la salsa
                String cantidadSalsa = salsa.getAttribute("cantidad");

                System.out.println("Menú tipo: " + atributoMenu);
                System.out.println("Pan: " + pan);
                System.out.println("Salsa: " + salsa.getTextContent());
                System.out.println("Cantidad de salsa: " + cantidadSalsa);
                System.out.println("-------------------");
            }

        }
    }
}
