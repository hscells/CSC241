import java.util.Scanner;

public class PC extends Creature{

   private int respect = 40;
   private Room room;

   public boolean play(Scanner s){

      String input = s.next();
      input = input.toLowerCase();

      if (input.equals("help")){

         System.out.println("This is not helpful");
         return true;

      } else if (input.equals("look")){

         System.out.println(room.toString());
         return true;

      } else if (input.equals("clean")){

         System.out.println("I am cleaning the room");
         return true;

      } else if (input.equals("dirty")){

         System.out.println("I am messing up the room");
         return true;

      } else if (input.equals("north")){

         System.out.println("I move north");
         return true;

      } else if (input.equals("east")){

         System.out.println("I move east");
         return true;

      } else if (input.equals("south")){

         System.out.println("I move south");
         return true;

      } else if (input.equals("west")){

         System.out.println("I move west");
         return true;

      } else if (input.equals("quit")){

         System.out.println("Bye!");
         return false;

      }

      return false;

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
