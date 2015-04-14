/**
 * Linked List implementation which stores the reference to the creatures in
 * each of the rooms
 * @author Harry Scells
 */
public class LinkedList<Creature>{

   private Node<Creature> head;
   private Node<Creature> tail;

   LinkedList(){

      tail = head = null;

   }

   LinkedList(Creature c){

      tail = head = new Node<Creature>(c);

   }

   /**
    * Prepend a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void prepend(Creature n){

      head = new Node<Creature>(n, head);

   }

   /**
    * Prepend a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void append(Creature n){

      tail = tail.next = new Node<Creature>(n);

   }

   /**
    * Node data structure which the linked list refers to
    * @author Harry Scells
    */
   private class Node<T>{

      private T object;
      public Node<T> next;
      public Node<T> prev;

      Node(){

         object = null;

      }

      Node(T o){

         object = o;

      }

      Node(T p, Node<T> q){

         object = p;
         next = q;

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

   }

}
