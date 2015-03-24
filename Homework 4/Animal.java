import java.util.Random;

public class Animal extends Creature{

   public void notifyCreature(){

      if(getRoom().getState().equals("clean")){

         Random r = new Random();
         Room chosen_room;
         while((chosen_room = getRoom().getRoom(r.nextInt(4))) == null);
         moveRoom(chosen_room);
         System.out.println(toString() + " moved to the " + getRoom().name() + " room.");

      }

   }

   Animal(String n, String d){

      super(n,d);

   }

}
