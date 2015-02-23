public class Creature{

   private String name;
   private String description;
   private Room room;

   public Creature (String n, String d){

      name = n;
      description = d;

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
   public void moveRoom(Room r){

      if (room == null){

         System.out.println("This creature has no room.");

      } else {

         room.removeCreature(this);
         r.addCreature(this);

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
    * @param s A state
    */
   public void notifyAnimal(String s){

      // act upon the state change

   }

   public String toString(){

      return name;

   }

}
