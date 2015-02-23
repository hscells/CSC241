public class Creature{

   private String name;
   private String description;
   private Room room;

   public Creature (String n, String d){

      name = n;
      description = d;

   }

   public void setRoom(Room r){

      room = r;

   }

   public void moveRoom(Room r){

      if (room == null){

         System.out.println("This creature has no room.");

      } else {

         room.removeCreature(this);
         r.addCreature(this);

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
