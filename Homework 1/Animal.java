public class Animal{

   private String name;
   private Room room;

   Animal (String n){

      name = n;

   }

   public void setRoom(Room r){

      room = r;

   }

   public Room getRoom(){

      return room;

   }

   public String toString(){

      return name;

   }

}
