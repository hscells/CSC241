import java.util.Iterator;

/**
 * Linked List implementation which stores the reference to the creatures in
 * each of the rooms. Must implement Iterable to allow the linked list to be
 * iterted over in a for each loop
 * @author Harry Scells
 */
public class LinkedList<E> implements Iterable<E>{

   private Node<E> head;
   private Node<E> tail;
   private int length;

   LinkedList(){

      tail = head = null;
      length = 0;

   }

   LinkedList(E o){

      tail = head = new Node<E>(o);
      length = 1;

   }

   /**
    * Prepend a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void prepend(E o){

      head = new Node<E>(o, head);
      if (tail == null){

         tail = head;

      }
      length++;

   }

   /**
    * Append a node containing a creature to the linked list
    * @param n A Creature reference
    */
   public void append(E o){

      if (isEmpty()){

         head = tail = new Node<E>(o, null, head);

      } else {

         Node<E> tmp = new Node<E>(o, null, tail);
         tail.next(tmp);
         tail = tmp;

      }
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
   public void insertAt(int index, E o) throws LinkedListException{

      if (index == 0){

         prepend(o);

      } else if (index == length){

         append(o);

      } else if (index < length){

         Node<E> n = getNodeAtIndex(index);
         if (n != null){

            Node<E> node = new Node<E>(o, n, n.prev());
            node.prev().next(node);
            node.next().prev(node);
            length++;

         }

      } else {

         throw new LinkedListException("Index out of bounds: " + index);

      }

   }

   public boolean remove(E object){

      return removeAt(getIndexOfObject(object));

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

         Node<E> n = getNodeAtIndex(index);
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
   public boolean exists(E o){

      Node<E> n = head;
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
   private Node<E> getNodeAtIndex(int index){

      Node<E> n = head;
      for (int i = 0; n != null && i < index; n = n.next(), i++);
      return n;

   }

   /**
    * Gets the object at given index
    * @param  index the position in the list to look for
    * @return       an object
    */
   public E getObjectAtIndex(int index){

      Node<E> n = head;
      for (int i = 0; n != null && i < index; n = n.next(), i++);
      return (n == null)? null : n.get();

   }

   /**
    * Gets the object at given index
    * @param  index the position in the list to look for
    * @return       an object
    */
   public int getIndexOfObject(E o){

      if (exists(o)){

         int i = 0;
         for (Node<E> n = head; n != null; n = n.next(), i++){

            if (n.get() == o){

               return i;

            }

         }

      }

      return -1;

   }

   /**
    * Make a copy of the data structure
    * @return the linked list you are copying
    */
   public LinkedList<E> copy(){

      LinkedList<E> t = new LinkedList<E>();
      for(Node<E> n = head; n != null; n = n.next()){

         t.append(n.get());

      }

      return t;

   }

   /**
    * Make a shallow copy of the data structure, only copying the reference
    * to each <E> rather than create a deep copy of each <E>
    * @return A copy of the linked list
    */
   public LinkedList<E> shallowCopy(){

      LinkedList<E> t = new LinkedList<E>();
      t = this;
      return t;

   }

   /**
    * Not enough time to implement this method
    */
   public void swap(int a, int b){}

   /**
    * Allow the linked list to be iterable
    * @return A new iterable object which can be used in for each loops
    */
   public Iterator<E> iterator(){

      return new LinkedListIterator<E>(this);

   }

   /**
    * Iterator class for better loop iteration
    * @author Harry Scells
    */
   private class LinkedListIterator<E> implements Iterator<E>{

      private LinkedList<E>.Node<E> current;
      private LinkedList<E> l;

      LinkedListIterator(LinkedList<E> l){

         current = null;
         this.l = l;

      }

      public boolean hasNext(){

         if (current == null){

            return !l.isEmpty();

         }
         return current.next != null;

      }

      public E next(){

         if (current == null){

            current = l.head;

         } else {

            current = current.next();

         }
         return current.get();

      }

      public void remove(){}

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
