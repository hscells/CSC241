import java.util.Scanner;

public class PC extends Creature{

   private int respect = 40;
   private Room room;

   public boolean play(Scanner s){

      if (s.equals("help")){

         System.out.println("This is not helpful");
         return true;

      } else if (s.equals("look")){

         System.out.println(room.toString());
         return true;

      } else {

         return false;

      }

   }

   public void setRoom(Room r){

      room = r;

   }

   /**
    * Gets the respect value for the PC
    * @return A respect value
    */
   public int getRespect(){

      return respect;

   }

   /**
    * Sets the respect value for the PC
    * @param r A respect value
    */
   public void setResepect(int r){

      respect = r;

   }

   public void notifyCreature(String s){

   }

   PC(String n, String d){

      super(n,d);

   }

}
