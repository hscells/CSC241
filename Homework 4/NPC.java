import java.util.Random;

public class NPC extends Creature{

   public void notifyCreature(){

      if(getRoom().getState().equals("clean")){

         Random r = new Random();
         Room chosen_room = new Room();

         System.out.println(allRoomsFull());

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

      }

   }

   NPC(String n, String d){

      super(n,d);

   }

}
