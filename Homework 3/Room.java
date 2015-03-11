public class Room{

   private String name;
   private String description;
   private Creature[] creatures = new Creature[10];
   private int num_creatures = 0;

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

   /**
    * Adds a creature to the Room
    * @param  c A creature
    * @return   True if creature added False if room was full
    */
   public Boolean addCreature(Creature c){

      if (num_creatures < 10){

         c.setRoom(this);
         creatures[num_creatures] = c;
         num_creatures++;
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

      int index = -1;
      for (int i = 0; i < num_creatures; i++){

            if (creatures[i] == c){

            index = i;
            break;

         }

      }

      if (index == -1){

         System.out.println("This creature is not in this room.");
         return false;

      }
      creatures[index] = creatures[num_creatures-1];
      creatures[num_creatures-1] = null;
      num_creatures--;
      return true;

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
    * Notify all animals in the room of a state change
    */
   public void notifyAnimals(){

      for(int i = 0; i < num_creatures; i++){
         creatures[i].notifyCreature(state);
      }

   }

   /**
    * Override method to print out the room name and animals in it
    * @return A formatted string of the room and animals in it
    */
   public String toString(){

      String names = "Room " + name + "\n";
      names += "Description: " + description + "\n";
      names += "State: " + state + "\n";
      for(int i = 0; i < num_creatures; i++){
         names += " - " + creatures[i].toString() + "\n";
      }
      return names;

   }

}
