import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import java.util.HashMap;

/**
 * This class handles the XML parsing in what I think is the most efficient way.
 * There is only one pass of the file, and there are no loops. By creating half-
 * empty room objects and then populating them as we go, there is no need to
 * impliment logic for directions, it's all implicitly handled and the data
 * structure that contains everything is built from the ground up.
 */
public class XMLHandler extends DefaultHandler {

   private HashMap<String, Room> rooms = new HashMap<String, Room>();
   private String current_room;
   private PC player;

   public HashMap<String, Room> getRooms(){

      return rooms;

   }

   public PC getPlayer(){

      return player;

   }

   /**
    * Refactor of previously messy code to handle direction attributes for rooms
    * @param  Actual name of the room
    * @param  Number representation of the direction
    */
   private void handleDirection(String room, int direction){

      // if we have never seen the room in the directional attribute
      if (!rooms.containsKey(room)){

         // add a new room object to the current room
         rooms.get(current_room).addRoom(new Room(room,""),direction);
         // add that newly made room to the hashmap
         rooms.put(room,rooms.get(current_room).getRoom(direction));

      } else {

         // othersie, we have seen the room before and if we are here then it is
         // implicit that we have seen the room amd made an object for it
         // that way, we can simply add the already made room to the current room
         rooms.get(current_room).addRoom(rooms.get(room),direction);

      }

   }

   public void startElement(String uri, String localName, String qName, Attributes attributes) {

      // if we encounter a room
      if (qName.equals("room")){

         // set our current room to it
         current_room = attributes.getValue("name");

         // if we have never encountered the room before
         if (!rooms.containsKey(current_room)){

            // add the room to the hashmap
            rooms.put(current_room, new Room(current_room, attributes.getValue("description")));
            rooms.get(current_room).setState(attributes.getValue("state"));

         } else {

            // otherwise we have seen the room before and populate it's attributes
            rooms.get(current_room).setDescription(attributes.getValue("description"));
            rooms.get(current_room).setState(attributes.getValue("state"));

         }

         // handle the directional attributes for the rooms. If the room contains
         // a directional attribute, it will determine if the room has been
         // created or not and will do one of the following:
         //    1. Create an empty room object with just a name that will be
         //       populated later on
         //    2. Add an empty room object that only has a name which will be
         //       populated later on
         //    3. Add an existing, already populated room
         // Depending on if it knows about a room or not will it create a new one.
         if(attributes.getValue("north") != null){

            handleDirection(attributes.getValue("north"),0);

         }

         if(attributes.getValue("east") != null){

            handleDirection(attributes.getValue("east"),1);

         }

         if(attributes.getValue("south") != null){

            handleDirection(attributes.getValue("south"),2);

         }

         if(attributes.getValue("west") != null){

            handleDirection(attributes.getValue("west"),3);

         }

      } else if (qName.equals("NPC")){

         // otherwise we are looking at either an NPC, and we just add it to the
         // current room
         NPC npc = new NPC(attributes.getValue("name"), attributes.getValue("description"));
         rooms.get(current_room).addCreature(npc);
         npc.setState("dirty");

      } else if (qName.equals("animal")){

         // or we are looking at an animal and we just add it to the current room
         Animal animal = new Animal(attributes.getValue("name"), attributes.getValue("description"));
         rooms.get(current_room).addCreature(animal);
         animal.setState("clean");

      } else if (qName.equals("PC")){

         // or we are looking at an animal and we just add it to the current room
         PC pc = new PC(attributes.getValue("name"), attributes.getValue("description"));
         rooms.get(current_room).addCreature(pc);
         rooms.get(current_room).setPlayer(pc);
         pc.setRoom(rooms.get(current_room));
         player = pc;

      }

   }

}
