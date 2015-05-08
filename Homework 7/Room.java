import java.util.Arrays;
import java.util.HashMap;

public class Room{

   private String name;
   private String description;
   //private LinkedList<Creature> creatures = new LinkedList<Creature>();
   private HashMap<String, Creature> creatures = new HashMap<String, Creature>();

   private PC player;

   private String state = "clean";

   // 0 - N
   // 1 - E
   // 2 - S
   // 3 - W
   private Room[] rooms = new Room[4];

   Room(String n, String d){

      name = n;
      description = d;

   }

   Room(){

      name = "";
      description = "";

   }

   /**
    * I am unsure if a room is clean and then cleaning it should continue to
    * notfify the creatures
    */

   /**
    * clean the room by one state
    */
   public void clean(){

      if(state.equals("dirty")){

         state = "half-dirty";

      } else if (state.equals("half-dirty")){

         state = "clean";

      }

      notifyCreatures();

   }

   /**
    * dirty the room by one state
    */
   public void dirty(){

      if(state.equals("clean")){

         state = "half-dirty";

      } else if (state.equals("half-dirty")){

         state = "dirty";

      }

      notifyCreatures();

   }

   /**
    * Adds a creature to the Room
    * @param  c A creature
    * @return   True if creature added False if room was full
    */
   public Boolean addCreature(Creature c){

      if (creatures.size() < 10){

         creatures.put(c.name(),c);
         c.setRoom(this);
         return true;

      } else{

         System.out.println("The room is full.");
         return false;

      }

   }

   /**
    * Remove creature from Room
    * @param  c A creature
    * @return   True if creature was removed, False if it failed
    */
   public Boolean removeCreature(Creature c){

      if (creatures.remove(c.name()) != null){
         return true;
      }
      return false;

   }

   /**
    * Adds a room to the Room
    * @param  A room reference
    * @param  Direction inside the room
    */
   public void addRoom(Room room, int direction){

      rooms[direction] = room;

   }

   /**
    * Gets a room from a direction
    * @param  direction A NESW int direction
    * @return           a room
    */
   public Room getRoom(int direction){

      return rooms[direction];

   }

   /**
    * Sets the state of the Room
    * @param s State of the room
    */
   public void setState(String s){

      state = s;

   }

   /**
    * Gets the state of the Room
    * @return the state of the room
    */
   public String getState(){

      return state;

   }

   /**
    * Sets the description of the room
    * @param desc description
    */
   public void setDescription(String desc){

      description = desc;

   }

   /**
    * Get the description of the room
    * @return description
    */
   public String getDescription(){

      return description;

   }

   /**
    * Gets the player within the room
    * @return null if the player is in the room, otherwise the player
    */
   public PC getPlayer(){

      return player;

   }

   /**
    * Sets the player in the room or not
    * @param p null if removing, PC if adding
    */
   public void setPlayer(PC p){

      player = p;

   }


   /**
    * Notify all animals in the room of a state change
    */
   public void notifyCreatures(){

      //LinkedList<Creature> tmp = creatures.shallowCopy();
      HashMap<String, Creature> tmp = new HashMap<String, Creature>(creatures);
      for(String key: tmp.keySet()){

         Creature c = tmp.get(key);
         if (c != null){

            c.notifyCreature();

         }

      }

   }

   /**
    * return the total number of creatures currently in the room
    * @return # of creatures
    */
   public int getNumberOfCreatures(){

      return creatures.size();

   }

   /**
    * Get the array of creatures
    * @Deprecated
    */
   public HashMap<String, Creature> getCreatures(){

      return creatures;

   }

   @Deprecated
   private int searchCreature(String name, LinkedList<Creature> creature_array, int l, int h){

      // binary search
      if (h <= l){

         return -1;

      }
      int m = l + (h - l) / 2;
      int c = creature_array.getObjectAtIndex(m).compareTo(name);

      if (c > 0){

         return searchCreature(name,creature_array,l,m);

      } else if (c < 0){

         return searchCreature(name,creature_array,m+1,h);

      } else {

         return m;

      }

   }

   public String searchCreature(String name){

      int location = 0;
      // linear search
      for(String key : creatures.keySet()){

         Creature c = creatures.get(key);
         if(c != null && c.name().toLowerCase().equals(name.toLowerCase())){

            return c.name();

         }

         location++;

      }

      return "";

   }

   /**
    * Sort the creatures in the room using the Quicksort algorithm
    * @param  The list of creatures
    * @param  The low value
    * @param  The high value
    * @Deprecated
    */
   @Deprecated
   private void sortRoom(LinkedList<Creature> c, int l, int h){

      if(c.isEmpty()){

         return;

      }

      if (l >= h){

         return;

      }

      int m = l + (h - l) / 2;
      Creature p = c.getObjectAtIndex(m);

      int i = l;
      int j = h;

      while (i <= j){

         while (c.getObjectAtIndex(i).compareTo(p) < p.compareTo(c.getObjectAtIndex(i))){

            i++;

         }

         while (c.getObjectAtIndex(j).compareTo(p) > p.compareTo(c.getObjectAtIndex(j))){

            j--;

         }

         if (i <= j){

            c.swap(i,j);
            i++;
            j--;

         }

      }

      if (l < j){

         sortRoom(c,l,j);

      }

      if (h > i){

         sortRoom(c,i,h);

      }

   }

   /**
    * Override of the private sortRoom method which fills in the blanks for you
    * @Deprecated
    */
   @Deprecated
   public void sortRoom(){

      //sortRoom(creatures,0,creatures.length()-1);
      return;

   }

   /**
    * name
    * @return returns only the name of the room
    */
   public String name(){

      return name;

   }

   /**
    * represent the numerical direction as a string
    * @param  direction number of direction
    * @return           a string representation of the direction
    */
   private String coerceDirection(int direction){

      switch(direction){

         case 0:
            return "North";
         case 1:
            return "East";
         case 2:
            return "South";
         case 3:
            return "West";

      }

      return "????";

   }

   /**
    * Override method to print out the room name and animals in it
    * @return A formatted string of the room and animals in it
    */
   public String toString(){

      String names = "Room " + name + "\n";
      names += "Description: " + description + "\n";
      names += "State: " + state + "\n";
      for (String key : creatures.keySet()){

         Creature c = creatures.get(key);
         names += " - (" + c.getClass().getName() + ") " + c.toString() + "\n";

      }
      for (int i = 0; i < 4; i++){

         if(rooms[i] != null){

            names += "Direction " + coerceDirection(i) + ": " + rooms[i].name() + "\n";

         }

      }
      return names;

   }

}
