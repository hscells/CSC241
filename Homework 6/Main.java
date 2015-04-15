import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Scanner;
import java.util.HashMap;
import java.io.IOException;

public class Main {

   public static void main(String[] a) throws Exception {

      Scanner input = new Scanner(System.in);
      //System.out.print("Enter an xml file for input: ");
      //String s = input.next();
      String s = "input.xml";

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

      //player.getRoom()._creatures.prepend(new Animal("poop","a poopy butt"));
      player.getRoom()._creatures.append(new Animal("Axe","a tree"));
      player.getRoom()._creatures.append(new Animal("Hampster","not a cat"));
      player.getRoom()._creatures.append(new Animal("Horse","loves carrots"));
      System.out.println(player.getRoom()._creatures.get(0));
      System.out.println(player.getRoom()._creatures.get(1));
      System.out.println(player.getRoom()._creatures.get(2));
      System.out.println(player.getRoom()._creatures.get(3));
      System.out.println(player.getRoom()._creatures.length());
      //player.getRoom()._creatures.append(new Animal("Kleeny", "A tissue or a closure"));
      player.getRoom()._creatures.insertAt(2, new Animal("Kleeny", "A tissue or a closure"));
      System.out.println(player.getRoom()._creatures.get(0));
      System.out.println(player.getRoom()._creatures.get(1));
      System.out.println(player.getRoom()._creatures.get(2));
      System.out.println(player.getRoom()._creatures.get(3));
      System.out.println(player.getRoom()._creatures.length());
      player.getRoom()._creatures.removeAt(3);
      System.out.println(player.getRoom()._creatures.get(0));
      System.out.println(player.getRoom()._creatures.get(1));
      System.out.println(player.getRoom()._creatures.get(2));
      System.out.println(player.getRoom()._creatures.get(3));
      System.out.println(player.getRoom()._creatures.length());
      System.exit(1);

      System.out.print("Type your commands here > ");

      while (player.play(input)){

         System.out.print("> ");

      }

  }

}
