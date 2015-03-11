import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Scanner;

public class Main {

   public static void main(String[] a) throws Exception {

      Scanner input = new Scanner(System.in);
      String input_file = input.next();

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();
      try {

         saxParser.parse(input_file, new XMLHandler());

      } catch (Exception e) {

         System.out.println("The specified file (" + input_file + ") does not exist.");

      }

  }

}
