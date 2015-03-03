public class PC extends Creature{

   private int respect = 40;

   PC(String n, String d){

      super(n,d);

   }

   /**
    * Gets the respect value for the PC
    * @return A respect value
    */
   public int getRespect(){

      return respect;

   }

   /**
    * Sets the respect value for the PC
    * @param r A respect value
    */
   public void setResepect(int r){

      respect = r;

   }


}
