public class Main {
   public static void main(String[] a) {
      Room room_1 = new Room("Violet","A room.");
      Room room_2 = new Room("Red","A red room");
      System.out.println(room_1.toString()); //prints Room Violet, containing:
      Animal a1 = new Animal("Pig","A filthy piglett");
      room_1.addCreature(a1);
      System.out.println(room_1.toString()); //prints Room Violet, containing: animal Pig
      for (int i = 0; i < 10; i++) {
         room_1.addCreature(new Animal("animal" + i,"A generic animal.")); //the last iteration prints The room is full
      }
      System.out.println(room_1.toString()); //prints Room Violet, containing: animal Pig, animal animal0, animal animal1, animal animal2, animal animal3...
      System.out.println(room_2.toString()); //prints Room Violet, containing: animal Pig, animal animal0, animal animal1, animal animal2, animal animal3...
      a1.moveRoom(room_2);
      System.out.println(room_1.toString());
      System.out.println(room_2.toString());
   }
}
