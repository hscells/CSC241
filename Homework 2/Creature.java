public class Creature{

   private String name;
   private String description;
   private Room room;

   public Creature (String n, String d){

      name = n;
      description = d;

   }

   public void setRoom(Room r){

      if (r != null){

         room.removeCreature(this);

      } else {

         room = r;

      }

   }

   public void setRoomState(String s){

      room.setState(s);

   }

   public void setName(String n){

      name = n;

   }

   public void setDescription(String d){

      description = d;

   }

   public Room getRoom(){

      return room;

   }

   public void notify(String s){

      // act upon the state change

   }

   public String toString(){

      return name;

   }

}
