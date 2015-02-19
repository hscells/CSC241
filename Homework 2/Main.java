public class Main {
  public static void main(String[] a) {
    Room r = new Room("Violet","A room.");
    System.out.println(r.toString()); //prints Room Violet, containing:
    Animal a1 = new Animal("Pig","A filthy piglett");
    r.addCreature(a1);
    System.out.println(r.toString()); //prints Room Violet, containing: animal Pig
    for (int i = 0; i < 10; i++) {
      r.addCreature(new Animal("animal" + i,"A generic animal.")); //the last iteration prints The room is full
    }
    System.out.println(r.toString()); //prints Room Violet, containing: animal Pig, animal animal0, animal animal1, animal animal2, animal animal3...
  }
}
