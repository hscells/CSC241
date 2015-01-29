
public class ProjOne{

   public class Room{

      private String name;
      private Animal[] animals = new Animal[10];

      Room(String room_name){
         name = room_name;
      }

      public void addAnimal(Animal animal){

      }

      public String toString(){
         return name;
      }

   }

   public class Animal{

      private String name;
      private Room room;

      Animal (Room room){

      }

   }

   public static void main(String[] a){


   }

}
