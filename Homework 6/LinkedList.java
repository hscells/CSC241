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

   /**
    * The total number of nodes in the list
    * @return the length of the list
    */
   public int length(){

      return length;

   }

   /**
    * Insert an object o into the linked list at position index. The index must
    * reside within the bounds of the lenth of the linked list.
    * @param  the location which will take the place of the new object
    * @param  the object to insert
    */
   public void insertAt(int index, T o) throws LinkedListException{

      if (index == 0){

         prepend(o);

      } else if (index == length){

         append(o);

      } else if (index < length){

         Node<T> n = getNodeAtIndex(index);
         if (n != null){

            Node<T> node = new Node<T>(o, n, n.prev());
            node.prev().next(node);
            node.next().prev(node);
            length++;

         }

      } else {

         throw new LinkedListException("Index out of bounds");

      }

   }

   public boolean removeAt(int index){

      if (index == 0){

         head = head.next();
         length--;
         return true;

      } else if (index == length-1){

         tail = tail.prev();
         tail.next(null);
         length--;
         return true;

      } else {

         Node<T> n = getNodeAtIndex(index);
         if (n != null){

            n.prev().next(n.next());
            length--;
            return true;

         }

      }

      return false;

   }

   /**
    * Checks to see if the object o is inside the list
    * @param  o object to search for
    * @return   true if object is found, false if not
    */
   public boolean exists(T o){

      Node<T> n = head;
      for (int i = 0; n != null && i < length; n = n.next(), i++){

         if (n.get() == o){

            return true;

         }

      }

      return false;

   }

   /**
    * Gets the node at given index
    * @param  index the position in the list to look for
    * @return       a node
    */
   private Node<T> getNodeAtIndex(int index){

      Node<T> n = head;
      for (int i = 0; n != null && i < index; n = n.next(), i++);
      return n;

   }

   /**
    * Gets the object at given index
    * @param  index the position in the list to look for
    * @return       an object
    */
   public T getObjectAtIndex(int index){

      Node<T> n = head;
      for (int i = 0; n != null && i < index; n = n.next(), i++);
      return n.get();

   }

   /**
    * Gets the object at given index
    * @param  index the position in the list to look for
    * @return       an object
    */
   public int getIndexOfObject(T o){

      if (exists(o)){

         int i = 0;
         for (Node<T> n = head; n != null; n = n.next(), i++){

            if (n.get() == o){

               return i;

            }

         }

      }

      return -1;

   }

   public void swap(int i, int j){



   }

   public LinkedList<T> copy(){

      LinkedList<T> t = new LinkedList<T>();
      for(Node<T> n = head; n != null; n = n.next()){

         t.append(n.get());

      }

      return t;

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

      public void prev(Node<T> n){

         prev = n;

      }

      public Node<T> prev(){

         return prev;

      }

   }

}
