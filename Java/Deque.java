import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item> {

   private Node<Item> first;          // top of deque
   private Node<Item> last;            // end of deck
   private int n;                     // size of deck

   private static class Node<Item> {   // create a class
      private Item item;
      private Node<Item> next;
      private Node<Item> prev;
  }
   // construct an empty deque
   public Deque() {
      first = null;
      last = null;
      n = 0;
   }

   // is the deque empty?
   public boolean isEmpty() {
      return first == null;
   }

   // return the number of items on the deque
   public int size() {
      return n;
   }

   // add the item to the front
   public void addFirst(Item item) {
      if (item == null) throw new IllegalArgumentException("no item to be added");
      Node<Item> prevFirst = first;
      
      first = new Node<Item>();
      first.item = item;
      first.next = prevFirst;
      
      if(prevFirst != null) first.next.prev = first;
      // prevfirst -> second

      
      if(last==null) last = first;
                  // last.prev = first
      n++;
   }

   // add the item to the back
   public void addLast(Item item) {
      if (item==null) throw new IllegalArgumentException("no item to be added");
      Node<Item> prevLast = last;
      last = new Node<Item>();
      last.item = item;
      last.next = null;
      last.prev = prevLast;
      if (prevLast!=null) prevLast.next = last;
      if (first==null) first = last;
      
      n++;
   }

   // remove and return the item from the front
   public Item removeFirst() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
      
      Item item = first.item; 
      if (n!=1) {
         first = first.next;
         first.prev = null;
      }
      else {
         first = null;
         last = null;
      }
      n--;
      return item;
   }

   // remove and return the item from the back
   public Item removeLast() {
      if (isEmpty()) throw new NoSuchElementException("Stack underflow");
       
      Item item = last.item;
      if (n!=1) {
      Node<Item> newLast = last.prev;
      last = newLast;
      last.next = null;
      }
      else {
         first = null;
         last = null;
      }
      n--;
      return item;
     
   }

   // return an iterator over items in order from front to back
   public Iterator<Item> iterator() {
      return new LinkedIterator(first);
   }

   private class LinkedIterator implements Iterator<Item> {
      public Node<Item> current;
      public LinkedIterator(Node<Item> first) {current = first;}
      public boolean hasNext() {return current != null;}
      public Item next() {
         if (!hasNext()) throw new NoSuchElementException();
         Item currentItem = current.item;
         current = current.next;
         return currentItem;
      }
      public void remove() {throw new UnsupportedOperationException();}
   }
   // unit testing (required)
   public static void main(String[] args) {
      Deque<String> newDeck = new Deque<String>();
      
      while (!StdIn.isEmpty()) {
         String item = StdIn.readString();
         if(item.equals("eol")) break;
         if (item.equals("+")) StdOut.print(newDeck.removeFirst()+" ");
         else if (item.equals("-")) StdOut.print(newDeck.removeLast()+" ");
         else if (item.length()>=5) newDeck.addLast(item);
         else newDeck.addFirst(item);
      //    if (item.equals("+")) StdOut.print(newDeck.removeFirst()+" ");
      //    else if (item.equals("-")) StdOut.print(newDeck.removeLast()+" ");
      //   else if (item.length()>=5) newDeck.addLast(item);
      //   else newDeck.addFirst(item);
      // if (newDeck.first != null) {
      //    System.out.println("first: "+newDeck.first.prev +" "+ newDeck.first +" "+ newDeck.first.next);
      //    System.out.println("last: "+newDeck.last.prev +" "+ newDeck.last +" "+ newDeck.last.next);
      // }
      
      }

      Iterator<String> newIterator = newDeck.iterator() ;
      while(newIterator.hasNext()) {
         String s = newIterator.next();
         System.out.println(s);
      }   
      


   }

}