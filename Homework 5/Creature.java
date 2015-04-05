abstract class Creature{

   private String name;
   private String description;
   private Room room;
   private String state;

   abstract void notifyCreature();
   abstract void expressGladness();
   abstract void expressDiscontent();
   abstract void clean();
   abstract void dirty();

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

   public void moveDirection(int direction){

      if(!allRoomsFull()){

         Room new_room = getRoom().getRoom(direction);

         if (new_room != null){

            moveRoom(new_room);
            System.out.println(name() + " moved to the " + new_room.name() + " room.");

         } else {

            System.out.println(name() + " cannot move there.");

         }

      } else {

         drillThroughRoof();

      }

   }

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
      expressDiscontent();
      getRoom().removeCreature(this);
      for (Creature c : getRoom().getCreatures()){

         if (c != null){

            c.expressDiscontent();

         }

      }

   }

   public String toString(){

      return name + ", " + description;

   }

}
