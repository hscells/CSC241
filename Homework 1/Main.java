public class Main {
  public static void main(String[] a) {
    Room r = new Room("Violet");
    System.out.println(r.toString()); //prints Room Violet, containing:
    Animal a1 = new Animal("Pig");
    r.addAnimal(a1);
    System.out.println(r.toString()); //prints Room Violet, containing: animal Pig
    for (int i = 0; i < 10; i++) {
      r.addAnimal(new Animal("animal" + i)); //the last iteration prints The room is full
    }
    System.out.println(r.toString()); //prints Room Violet, containing: animal Pig, animal animal0, animal animal1, animal animal2, animal animal3...
  }
}
