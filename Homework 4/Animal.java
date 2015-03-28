import java.util.Random;

public class Animal extends Creature{

   public void notifyCreature(){

      if(getRoom().getState().equals("dirty")){

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
            if (getRoom().getState() == "dirty"){

               getRoom().dirty();
               System.out.println(name() + " also cleaned it's new room.");

            }

         }

      }

   }

   Animal(String n, String d){

      super(n,d);

   }

}
