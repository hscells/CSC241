
public class ProjOne{

   public static class Room{

      private String name;
      private Animal[] animals = new Animal[10];
      private int num_animals = 0;

      Room(String n){

         name = n;

      }


      public void addAnimal(Animal animal){

         if (num_animals < 10){
            animal.setRoom(this);
            animals[num_animals] = animal;
            num_animals++;
         }

      }

      public String toString(){

         return name;

      }

   }

   public static class Animal{

      private String name;
      private Room room;

      Animal (String n){

         name = n;

      }

      public void setRoom(Room r){

         room = r;

      }

      public String toString(){

         return name;

      }

   }

   public static void main(String[] a){

      Room room = new Room("test");
      System.out.println(room.toString());
      Animal pig = new Animal("pig");
      System.out.println(pig.toString());
      room.addAnimal(pig);

   }

}
