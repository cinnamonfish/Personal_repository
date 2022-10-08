// Not finished yet --22-10-8

import edu.princeton.cs.algs4.*;

public class CircledQueue<Item> {
    
    private static class Vertex<Item> {
        private Item item;
        private Vertex<Item> next;
        // private Vertex<Item> prev;
    }

    private Vertex<Item> last;
    private int N;
    

    public CircledQueue() {
        last = null;
        N = 0;
    }

    public void add(Item item) {
        if(item.equals(null)) throw new IllegalArgumentException();
        if(isEmpty()) {
            last = new Vertex<Item>();
            last.item = item;
            last.next = last;
        }
        else {
            Vertex<Item> oldLast = last;
            last = new Vertex<Item>();
            last.item = item;
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;
    }

    public Item remove() {
        if(isEmpty()) throw new IndexOutOfBoundsException();
        Item rem = last.next.item;
        last.next = last.next.next;
        N--;
        return rem;
    }

    public Item removeM(int M) {
        if(isEmpty()) throw new IndexOutOfBoundsException();
        Vertex<Item> midvar = last.next;
        for(int i = 1; i < M; i++) midvar = midvar.next;
        Item item = midvar.item;
        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public static void main(String[] args) {
        CircledQueue<String> cQueue = new CircledQueue<String>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(item.equals("eol")) break;
            cQueue.add(item);
        }
        System.out.println("N: "+cQueue.N);
        System.out.println("last: "+cQueue.last.item);
        System.out.println("first: "+cQueue.last.next.item);
        
    }
}
