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
      String input_file = input.next();

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();

      XMLHandler results = new XMLHandler();

      // load in the file for reading and parse it
      try {

         saxParser.parse(input_file,results);

      } catch (IOException e) {

         System.out.println("The specified file (" + input_file + ") does not exist.");
         System.exit(0);

      }

      // create a new variable so I don't have to write results.getRooms().get()
      HashMap<String, Room> rooms = results.getRooms();

      // let the user know what rooms were loaded in
      System.out.println("Rooms found in the input file: ");
      for (String key : rooms.keySet()){

         System.out.println(rooms.get(key).name());

      }

      // allow the user to query the rooms
      System.out.println("Type `q` to quit.");
      Boolean finished = false;
      while (!finished){

         System.out.print("Enter a room: ");
         input_file = input.next();

         if (rooms.containsKey(input_file)){

            System.out.println(rooms.get(input_file).toString());

         } else {

            System.out.println("Room does not exist.");

         }

         if (input_file.equals("q")){

            finished = true;

         }

      }

  }

}
