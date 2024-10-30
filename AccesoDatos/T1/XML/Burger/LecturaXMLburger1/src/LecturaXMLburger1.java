import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LecturaXMLburger1 {
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("../burger1.xml"));
        System.out.println("Todo correcto");
        doc.getDocumentElement().normalize();

        //TRABAJOS PARA EL EXAMEN .getDocumentElement()

        Element nodoRaiz = doc.getDocumentElement();
        // nodoRaiz coge todos los elementos del documento
        // Desde el elemento.. podemos acceder a los atributos

        String atributoTitulo = nodoRaiz.getAttribute("title");
        String atributoPrecio = nodoRaiz.getAttribute("precio");
        System.out.println(atributoTitulo);
        System.out.println(atributoPrecio);

        // Elementos hijos del DOM de un XML con .getElementsByTagName(String tagname); .getLength()
        // NodeList algo statico... no se puede cambiar.
        NodeList nList = doc.getElementsByTagName("menu");
        System.out.println(nList.getLength());

        //Empezar a recorrer el NodeList

        for (int i=0;i<nList.getLength();i++){
            // Element de cada uno de los hijos // API recoger elemento de NodeList
            Element menu = (Element) nList.item(i);
            //Element...
            //Contenido en String de un elemento
            //getElementByTagName(String).item(0).getTextContent()
            String nombre = menu.getElementsByTagName("nombre")
                    .item(0).getTextContent();

            String salsa = menu.getElementsByTagName("salsa")
                            .item(0).getTextContent();
            System.out.println(nombre+" "+salsa);
        }
    }
}