
public class Game{

   public static void main(String[] a){

      Room room = new Room("test");
      System.out.println(room.toString());
      Animal pig = new Animal("pig");
      System.out.println(pig.toString());
      room.addAnimal(pig);
      System.out.println(room.toString());
      room.addAnimal(new Animal("cow"));
      room.addAnimal(new Animal("sheep"));
      room.addAnimal(new Animal("dog"));
      room.addAnimal(new Animal("cat"));
      room.addAnimal(new Animal("bird"));
      room.addAnimal(new Animal("chicken"));
      room.addAnimal(new Animal("rooster"));
      room.addAnimal(new Animal("lizard"));
      room.addAnimal(new Animal("crow"));
      room.addAnimal(new Animal("moose"));
      room.addAnimal(new Animal("aligator"));
      System.out.println(room.toString());
   }

}
