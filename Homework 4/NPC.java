import java.util.Random;

public class NPC extends Creature{

   public void expressGladness(){

      System.out.println(name() + " smiles.");
      getRoom().getPlayer().increaseRespect();

   }

   public void expressDiscontent(){

      System.out.println(name() + " grumbles.");
      getRoom().getPlayer().decreaseRespect();

   }

   public void notifyCreature(){

      if (getRoom().getState().equals("clean")){

         expressDiscontent();

         Random r = new Random();
         Room chosen_room = new Room();

         if (allRoomsFull()){

            drillThroughRoof();
            for (Creature c : getRoom().getCreatures()){

               if (c != null){

                  c.expressDiscontent();

               }

            }

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


   NPC(String n, String d){

      super(n,d);

   }

}
