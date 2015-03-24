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

   public void clean(){

      if(state.equals("dirty")){

         state = "half-dirty";

      } else if (state.equals("half-dirty")){

         state = "clean";

      }

      notifyAnimals();

   }

   public void dirty(){

      if(state.equals("clean")){

         state = "half-dirty";

      } else if (state.equals("half-dirty")){

         state = "dirty";

      }

      notifyAnimals();

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

   public void setDescription(String desc){

      description = desc;

   }

   public String getDescription(){

      return description;

   }

   /**
    * Notify all animals in the room of a state change
    */
   public void notifyAnimals(){

      for(int i = 0; i < num_creatures; i++){

         creatures[i].notifyCreature();

      }

   }


   /**
    * name
    * @return returns only the name of the room
    */
   public String name(){

      return name;

   }

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
      for (int i = 0; i < num_creatures; i++){

         names += " - (" + creatures[i].getClass().getName() + ") " + creatures[i].toString() + "\n";

      }
      for (int i = 0; i < 4; i++){

         if(rooms[i] != null){

            names += "Direction " + coerceDirection(i) + ": " + rooms[i].name() + "\n";

         }

      }
      return names;

   }

}
