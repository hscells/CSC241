import java.util.Scanner;

public class PC extends Creature{

   private int respect = 40;

   /**
    * The main play method, which implements the commands present
    * @param  s Scanner to the input
    * @return   true if program should continue, false if not
    */
   public boolean play(Scanner s){

      String input = s.next();
      input = input.toLowerCase();
      Room room = getRoom();

      if (determineOutcome() != -1){

         return false;

      }

      if (input.equals("help")){

         System.out.println("Available commands:");
         System.out.println("help:\n\tDisplay this message");
         System.out.println("look:\n\tTake a look at your surroundings");
         System.out.println("north:\n\tmove north");
         System.out.println("east:\n\tmove east");
         System.out.println("south:\n\tmove south");
         System.out.println("west:\n\tmove west");
         System.out.println("respect:\n\tshows your current respect level");
         System.out.println("quit/exit:\n\tterminate the program");
         return true;

      } else if (input.equals("look")){

         System.out.println(room.toString());
         return true;

      } else if (input.equals("clean")){

         System.out.println("I tidy the room.");
         clean();
         return true;

      } else if (input.equals("dirty")){

         System.out.println("I mess up the room.");
         dirty();
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

      } else if (input.equals("respect")){

         System.out.println("Your respect is " + respect);
         return true;

      } else if (input.equals("quit") || input.equals("exit")){

         System.out.println("Bye!");
         return false;

      } else {

         if (input.contains(":")){

            String[] commands = input.split(":");
            Creature c = getRoom().searchCreature(commands[0]);

            if(c==null){

               System.out.println("That creature is not in this room");
               return true;

            }

            if (commands[1].equals("clean")){

               System.out.println(c.name() + " cleans the room.");
               c.clean();

            } else if (commands[1].equals("dirty")){

               System.out.println(c.name() + " dirties the room.");
               c.dirty();

            } else if (commands[1].equals("north")){

               c.moveDirection(0);

            } else if (commands[1].equals("east")){

               c.moveDirection(1);

            } else if (commands[1].equals("south")){

               c.moveDirection(2);

            } else if (commands[1].equals("west")){

               c.moveDirection(3);

            }

            return true;

         }

         System.out.println("I don't know how to " + input + ".");
         return true;

      }

   }

   /**
    * moves creature from one room to another
    * @param r The room to move to
    */
   @Override
   public boolean moveRoom(Room r){

      Room room = getRoom();
      if (room == null){

         System.out.println("The player has no room.");
         return false;

      } else {

         if (r.getNumberOfCreatures() < 10){

            room.removeCreature(this);
            r.addCreature(this);
            room.setPlayer(null);
            r.setPlayer(this);
            return true;

         }

         return false;

      }

   }

   /**
    * Try to attempt to move to another room
    * @param direction numerical direction
    */
   public void tryToMove(int direction){

      Room room = getRoom();
      if (room.getRoom(direction) != null){

         if (moveRoom(room.getRoom(direction))){

            room.getRoom(direction).sortRoom();
            System.out.println("I move to the " + room.getRoom(direction).name() + " room");

         } else {

            System.out.println("I can't move to the " + room.getRoom(direction).name() + " room, it is full.");

         }

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

   public void increaseRespect(){

      respect++;

   }

   public void decreaseRespect(){

      respect--;

   }

   public int determineOutcome(){

      if (respect <= 0){

         endGame(1);
         return 1;

      } else if (respect >= 80){

         endGame(0);
         return 0;

      }

      return -1;

   }

   public void endGame(int outcome){

      System.out.println((outcome>0)? "You lose!" : "You win!");

   }

   /**
    * Sets the respect value for the PC
    * @param r A respect value
    */
   public void setResepect(int r){

      respect = r;

   }

   public void notifyCreature(){}
   public void expressGladness(){}
   public void expressDiscontent(){}
   public void clean(){

      getRoom().clean();

   }
   public void dirty(){

      getRoom().dirty();

   }

   PC(String n, String d){

      super(n,d);

   }

}
