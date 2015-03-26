import java.util.Random;

public class NPC extends Creature{

   public void notifyCreature(){

      if(getRoom().getState().equals("dirty")){

         Random r = new Random();
         Room chosen_room;
         while((chosen_room = getRoom().getRoom(r.nextInt(4))) == null);
         moveRoom(chosen_room);
         System.out.println(toString() + " moved to the " + getRoom().name() + " room.");
         if (getRoom().getState() == "dirty"){

            getRoom().dirty();
            System.out.println(toString() + " also cleaned the room.");

         }

      }

   }

   NPC(String n, String d){

      super(n,d);

   }

}
