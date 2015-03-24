import java.util.Scanner;

public class PC extends Creature{

   private int respect = 40;

   public boolean play(Scanner s){

      String input = s.next();
      input = input.toLowerCase();
      Room room = getRoom();

      if (input.equals("help")){

         System.out.println("Available commands:");
         System.out.println("help:\n\tDisplay this message");
         System.out.println("look:\n\tTake a look at your surroundings");
         System.out.println("north:\n\tmove north");
         System.out.println("east:\n\tmove east");
         System.out.println("south:\n\tmove south");
         System.out.println("west:\n\tmove west");
         System.out.println("quit/exit:\n\tterminate the program");
         return true;

      } else if (input.equals("look")){

         System.out.println(room.toString());
         return true;

      } else if (input.equals("clean")){

         System.out.println("I tidy the room.");
         room.clean();
         return true;

      } else if (input.equals("dirty")){

         System.out.println("I mess up the room.");
         room.dirty();
         return true;

      } else if (input.equals("north")){

         tryToMove(0);
         return true;

      } else if (input.equals("east")){

         tryToMove(1);
         return true;

      } else if (input.equals("south")){

         tryToMove(2);
         return true;

      } else if (input.equals("west")){

         tryToMove(3);
         return true;

      } else if (input.equals("quit") || input.equals("exit")){

         System.out.println("Bye!");
         return false;

      } else {

         System.out.println("I don't know how to " + input + ".");
         return true;

      }

   }

   public void tryToMove(int direction){

      Room room = getRoom();
      if (room.getRoom(direction) != null){

         moveRoom(room.getRoom(direction));
         System.out.println("I move to the " + room.getRoom(direction).name() + " room");

      } else {

         System.out.println("I can't move in that direction.");

      }

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
