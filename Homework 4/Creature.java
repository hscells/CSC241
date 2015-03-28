abstract class Creature{

   private String name;
   private String description;
   private Room room;
   private String state;

   Creature (String n, String d){

      super();
      name = n;
      description = d;

   }

   public void setState(String s){

      state = s;

   }

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
    * Receive a notification and act upon it
    * When a creature receives a notification, it will have some logic that
    * needs to be implemented which it will do.
    * @param s A state
    */
   abstract void notifyCreature();

   abstract void expressGladness();

   abstract void expressDiscontent();

   public String name(){

      return name;

   }

   public boolean allRoomsFull(){

      int full_rooms = 0;
      for (int i = 0; i < 4; i++){

         if (getRoom().getRoom(i) != null && getRoom().getRoom(i).getNumberOfCreatures() == 10){

            full_rooms++;

         }

      }

      return (full_rooms == 4)? true : false;

   }

   public void drillThroughRoof(){

      System.out.println(name + " drills through the roof as it has no place to go.");
      getRoom().removeCreature(this);

   }

   public String toString(){

      return name + ", " + description;

   }

}
