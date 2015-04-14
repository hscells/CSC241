/**
 * Linked List implementation which stores the reference to the creatures in
 * each of the rooms
 * @author Harry Scells
 */
public class LinkedList<T>{

   private Node<T> head;
   private Node<T> tail;
   private int length;

   LinkedList(){

      tail = head = null;
      length = 0;

   }

   LinkedList(T c){

      tail = head = new Node<T>(c);
      length = 1;

   }

   /**
    * Prepend a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void prepend(T n){

      head = new Node<T>(n, head);
      length++;

   }

   /**
    * Prepend a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void append(T n){

      tail = new Node<T>(n);
      Node<T> tmp = tail;

      tail.get();
      tail.next(n);
      tail = tail.next();
      length++;

   }

   public boolean isEmpty(){

      return head == null;

   }

   public int length(){

      return length;

   }

   public void insertAt(int index, T c){

      Node<T> n = head;
      for (int i = 0; n != null && i < index; n = n.next, i++);


   }

   public boolean removeAt(int index){

      return false;

   }

   public boolean exists(Node<T> n){

      for (int i = 0; n != null && i < length; n = n.next, i++);
      return !(n == null);

   }

   public Node<T> get(int index){

      Node<T> n = head;
      for (int i = 0; n != null && i < index; n = n.next, i++);
      return n;

   }

   /**
    * Node data structure which the linked list refers to
    * @author Harry Scells
    */
   private class Node<T>{

      private T object;
      private Node<T> next;

      Node(){

         object = null;

      }

      Node(T o){

         object = o;

      }

      Node(T o, Node<T> n){

         object = o;
         next = n;

      }

      public T get(){

         return object;

      }

      public void set(T o){

         object = o;

      }

      public String toString(){

         return "" + object;

      }

      public void next(T n){

         next = new Node<T>(n);

      }

      public Node<T> next(){

         return next;

      }

   }

}
