import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Scanner;
import java.util.HashMap;
import java.io.IOException;

public class Main {

   public static void main(String[] a) throws Exception {

      Scanner input = new Scanner(System.in);
      System.out.print("Enter an xml file for input: ");
      String s = input.next();

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();

      XMLHandler results = new XMLHandler();

      // load in the file for reading and parse it
      try {

         saxParser.parse(s,results);

      } catch (IOException e) {

         System.out.println("The specified file (" + s + ") does not exist.");
         System.exit(0);

      }

      // create a new variable so I don't have to write results.getRooms().get()
      HashMap<String, Room> rooms = results.getRooms();

      // create a nice player object to contain it from the xml
      PC player = results.getPlayer();
      player.getRoom().sortRoom();

      System.out.print("Type your commands here > ");

      while (player.play(input)){

         System.out.print("> ");

      }

  }

}
