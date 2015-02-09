public class Room{

   private String name;
   private Animal[] animals = new Animal[10];
   private int num_animals = 0;

   Room(String n){

      name = n;

   }


   public void addAnimal(Animal a){

      if (num_animals < 10){
         a.setRoom(this);
         animals[num_animals] = a;
         num_animals++;
      }

   }

   public String toString(){

      String names = name + "\n";
      names += "----------\n";
      for(int i = 0; i < num_animals; i++){
         names += " - " + animals[i].toString() + "\n";
      }
      return names;

   }

}
