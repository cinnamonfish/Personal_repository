import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private static final int INIT_CAPACITY = 2;
    private Item[] a;         // array of items
    private int n;            // number of elements on stack
    

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {return n;}

    // resize the array
    private Item[] resize(int newSize) {
        assert newSize > n;            // what does this mean
        Item[] copy = (Item[]) new Object[newSize];
        for (int i=0; i<n; i++) copy[i] = a[i];
        a = copy;
        return a;
    }
    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (n == a.length) a = resize(2*a.length);
        a[n] = item;
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int pos = StdRandom.uniformInt(n);
        Item item = a[pos];
        a[pos] = a[n-1];
        a[n-1] = null;
        n--;
        if (n>0 && n == a.length/4) a = resize(a.length/2);
        
        return item;
       
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (n==0) throw new NoSuchElementException();
        int pos = StdRandom.uniformInt(n);
        return a[pos];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<Item> {
        private int current = 0;
        final Item[] aCopy;
        
        public ArrayIterator() {
            aCopy = (Item[]) new Object[n];
            for (int i=0; i<n; i++) aCopy[i] = a[i];
            // for (int i=0; i<n; i++) System.out.println(aCopy[i]); 
            
            StdRandom.shuffle(aCopy);
        }

        public boolean hasNext() {return current < n;}

        public Item next() {
            // System.out.println("current: "+current);  
            // for (int i=0; i<n; i++) System.out.println(aCopy[i]); 
            if (current>=n) throw new NoSuchElementException();
            Item item = aCopy[current++]; 
            return item;
        }
        public void remove() {throw new UnsupportedOperationException(); }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue newRQ = new RandomizedQueue<String>();

        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("eol")) break;    
            if(item.equals("-")) newRQ.dequeue();
            else newRQ.enqueue(item);
            if(item.equals("sample")) System.out.println(newRQ.sample());    
        }
        System.out.println("Size: "+newRQ.size());
    Iterator<String> newIterator = newRQ.iterator() ;
    while(newIterator.hasNext()) {
         String s = newIterator.next();
         System.out.println(s);
      } 
    }
}
