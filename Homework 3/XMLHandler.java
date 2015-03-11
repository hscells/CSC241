import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class XMLHandler extends DefaultHandler {

   public void startDocument() {

      System.out.println("Document parsing started.");

   }

   public void endDocument() {

      System.out.println("Document parsing ended.");

   }

   public void startElement(String uri, String localName, String qName, Attributes attributes) {

      System.out.println("Starting tag " + qName);

   }

   public void endElement(String uri, String localName, String qName) {

      System.out.println("Ending tag " + qName);

   }

}
