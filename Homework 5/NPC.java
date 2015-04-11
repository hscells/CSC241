import java.util.Random;

public class NPC extends Creature{

   /**
    * increase the players respect
    */
   public void expressGladness(){

      System.out.println(name() + " smiles.");
      getRoom().getPlayer().increaseRespect();

   }

   /**
    * Decrease the players respect
    */
   public void expressDiscontent(){

      System.out.println(name() + " grumbles.");
      getRoom().getPlayer().decreaseRespect();

   }

   /**
    * Do a whole heap of things, commented inline (in Animal)
    * @see Animal
    */
   public void notifyCreature(){

      if (getRoom().getState().equals("clean")){

         expressDiscontent();

         Random r = new Random();
         Room chosen_room = new Room();

         if (allRoomsFull()){

            drillThroughRoof();

         } else {

            boolean found_room = false;
            while (!found_room){

               chosen_room = getRoom().getRoom(r.nextInt(4));
               if (chosen_room != null && chosen_room.getNumberOfCreatures() < 10){

                  found_room = true;

               }

            }
            moveRoom(chosen_room);

            System.out.println(name() + " moved to the " + getRoom().name() + " room.");
            if (getRoom().getState() == "clean"){

               getRoom().dirty();
               System.out.println(name() + " also dirtied it's new room.");

            }

         }

      } else if (getRoom().getState().equals("dirty")){

         expressGladness();

      }

   }

   /**
    * Clean the room
    */
   public void clean(){

      getRoom().clean();

   }

   /**
    * Dirty the room
    */
   public void dirty(){

      getRoom().dirty();

   }

   /**
    * Checks to see if the room is suitable for the NPC
    * @see Animal
    */
   public void checkRoom(){

      if (getRoom().getState().equals("clean")){

         System.out.println(name() + " dirties their new room.");
         clean();

      }

   }

   NPC(String n, String d){

      super(n,d);

   }

}
