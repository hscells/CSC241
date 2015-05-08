import java.util.Random;

public class Animal extends Creature{

   /**
    * increase the players respect
    */
   public void expressGladness(){

      System.out.println(name() + " licks your face.");
      getRoom().getPlayer().increaseRespect();

   }

   /**
    * Decrease the players respect
    */
   public void expressDiscontent(){

      System.out.println(name() + " growls.");
      getRoom().getPlayer().decreaseRespect();

   }

   /**
    * Do a whole heap of things, commented inline
    */
   public void notifyCreature(){

      if (getRoom().getState().equals("dirty")){

         // first up, growl at the player
         expressDiscontent();

         Random r = new Random();
         Room chosen_room = new Room();

         // need to check if the rooms are full before moving
         if (allRoomsFull()){

            // get the heck out of there
            drillThroughRoof();

         } else {

            // otherwise we can start looking for a suitable room
            boolean found_room = false;
            while (!found_room){

               // attempt to choose a random room
               chosen_room = getRoom().getRoom(r.nextInt(4));

               // if it satisfies these conditions, we are golden
               if (chosen_room != null && chosen_room.getNumberOfCreatures() < 10){

                  found_room = true;

               }

            }
            // move to the suitable room we found
            moveRoom(chosen_room);

            // let the user know that the creature made the move
            System.out.println(name() + " moved to the " + getRoom().name() + " room.");

            // if the room the creature moved to is dirty, tidy it up a bit
            if (getRoom().getState() == "dirty"){

               getRoom().dirty();
               System.out.println(name() + " also cleaned it's new room.");

            }

         }

      } else if (getRoom().getState().equals("clean")){

         // the room is really nice for this creature so it licks your face. ew.
         expressGladness();

      }

   }

   /**
    * Clean the room
    */
   public void clean(){

      if (getRoom().getState().equals("half-dirty") || getRoom().getState().equals("clean")){

         expressGladness();
         expressGladness();

      }
      getRoom().clean();

   }

   /**
    * Dirty the room
    */
   public void dirty(){

      if (getRoom().getState().equals("half-dirty") || getRoom().getState().equals("dirty")){

         expressDiscontent();
         expressDiscontent();

      }
      getRoom().dirty();

   }

   /**
    * Check to see if the room is suitable for the Animal to live in and then
    * clean the room if it doesn't like it
    */
   public void checkRoom(){

      if (getRoom().getState().equals("dirty")){

         System.out.println(name() + " cleans their new room.");
         getRoom().clean();

      }

   }

   Animal(String n, String d){

      super(n,d);

   }

}
