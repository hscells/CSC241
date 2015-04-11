abstract class Creature{

   private String name;
   private String description;
   private Room room;
   private String state;

   abstract void notifyCreature();
   abstract void expressGladness();
   abstract void expressDiscontent();
   abstract void checkRoom();
   abstract void clean();
   abstract void dirty();

   Creature (String n, String d){

      super();
      name = n;
      description = d;

   }

   /**
    * Sets the state of the room
    * @param s String state of the room
    */
   public void setState(String s){

      state = s;

   }

   /**
    * Gets the state of the room
    * @return the state of the room
    */
   public String getState(){

      return state;

   }

   /**
    * Sets the current Room
    * @param r A room
    */
   public void setRoom(Room r){

      room = r;

   }

   /**
    * moves creature from one room to another
    * @param r The room to move to
    */
   public boolean moveRoom(Room r){

      if (room == null){

         System.out.println("This creature has no room.");
         return false;

      } else {

         if (r.getNumberOfCreatures() < 10){

            room.removeCreature(this);
            r.addCreature(this);
            return true;

         }

         return false;

      }



   }

   /**
    * Sets the state of the room
    * @param s The state
    */
   public void setRoomState(String s){

      room.setState(s);

   }

   /**
    * Sets the name of the creature
    * @param n The name
    */
   public void setName(String n){

      name = n;

   }

   /**
    * Sets the description of the creature
    * @param d A description
    */
   public void setDescription(String d){

      description = d;

   }

   /**
    * Gets the room the animal is in
    * @return A room object
    */
   public Room getRoom(){

      return room;

   }

   /**
    * Move the creature in a specified direction, based on the same movement
    * mechanic used in room
    * @param direction direction of movement (0 1 2 3) -> (N E S W)
    */
   public void moveDirection(int direction){

      if(!allRoomsFull()){

         Room new_room = getRoom().getRoom(direction);

         if (new_room != null){

            moveRoom(new_room);
            System.out.println(name() + " moved to the " + new_room.name() + " room.");
            checkRoom();

         } else {

            System.out.println(name() + " cannot move there.");

         }

      } else {

         drillThroughRoof();

      }

   }

   /**
    * Gets only the name of the Creature
    * @return the name of the creature
    */
   public String name(){

      return name;

   }

   /**
    * Determine if all of the adjacent rooms are full or not
    * @return True oif all the rooms are full, else False
    */
   public boolean allRoomsFull(){

      int full_rooms = 0;
      for (int i = 0; i < 4; i++){

         if (getRoom().getRoom(i) != null && getRoom().getRoom(i).getNumberOfCreatures() == 10){

            full_rooms++;

         }

      }

      return (full_rooms == 4)? true : false;

   }

   /**
    * Force the Creature to leave the house and remove all references of it
    */
   public void drillThroughRoof(){

      System.out.println(name + " drills through the roof as it has no place to go.");
      expressDiscontent();
      getRoom().removeCreature(this);
      for (Creature c : getRoom().getCreatures()){

         if (c != null){

            c.expressDiscontent();

         }

      }

   }

   /**
    * Compare one creature to another creature
    * @param  o The creature reference
    * @return   positive integer of location or -1 if not found
    */
   public int compareTo(Creature o) {
     return name.toLowerCase().compareTo(o.name().toLowerCase());
   }

   /**
    * Compare one creature to a string
    * @param  o The string being searched
    * @return   positive integer of location or -1 if not found
    */
   public int compareTo(String o) {
     return name.toLowerCase().compareTo(o);
   }


   @Override
   public String toString(){

      return name + ", " + description;

   }

}
