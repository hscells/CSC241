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

   LinkedList(T o){

      tail = head = new Node<T>(o);
      length = 1;

   }

   /**
    * Prepend a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void prepend(T o){

      head = new Node<T>(o, head);
      length++;

   }

   /**
    * Append a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void append(T o){

      if (tail == null){

         tail = new Node<T>(o, null, head);

      } else {

         Node<T> tmp = new Node<T>(o, null, tail);
         tail.next(tmp);
         tail = tmp;

      }

      head = (head == null)? tail : head;
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
      private Node<T> prev;

      Node(){

         object = null;

      }

      Node(T o){

         object = o;

      }

      Node(T o, Node<T> n){

         object = o;
         next = n;
         prev = null;

      }

      Node(T o, Node<T> n, Node<T> p){

         object = o;
         next = n;
         prev = p;

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

      public void next(Node<T> n){

         next = n;

      }

      public Node<T> next(){

         return next;

      }

      public Node<T> prev(){

         return prev;

      }

   }

}
