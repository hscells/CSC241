public class Room{

   private String name;
   private String description;
   private Creature[] creatures = new Creature[10];
   private int num_creatures = 0;

   private String state = "clean";

   // 0 - N
   // 1 - E
   // 2 - S
   // 3 - W
   private Room[] rooms = new Room[4];

   Room(String n, String d){

      name = n;
      description = d;

   }


   public Boolean addCreature(Creature a){

      if (num_creatures < 10){

         a.setRoom(this);
         creatures[num_creatures] = a;
         num_creatures++;
         return true;

      } else{

         System.out.println("The room is full.");
         return false;

      }

   }

   public Boolean removeCreature(Creature c){

      int index = -1;
      for (int i = 0; i < num_creatures; i++){

            if (creatures[i] == c){

            index = i;
            break;

         }

      }

      if (index == -1){

         System.out.println("This creature is not in this room.");
         return false;

      }

      creatures[index] = creatures[num_creatures];
      creatures[num_creatures] = null;
      num_creatures--;
      return true;

   }


   public void setState(String s){

      state = s;

   }

   public String getState(){

      return state;

   }

   public void notifyAnimals(){

      for(int i = 0; i < num_creatures; i++){
         creatures[i].notify(state);
      }

   }

   public String toString(){

      String names = "Room " + name + "\n";
      names += "----------\n";
      for(int i = 0; i < num_creatures; i++){
         names += " - " + creatures[i].toString() + "\n";
      }
      return names;

   }

}
