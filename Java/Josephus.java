// Not finished yet --22-10-8

// using CircleQueue

// There are N people, with the M th person get eliminated during each round of procession.
// the N people's order ranges from 0 to N-1 . 

public class Josephus {
    
    // public CircledQueue<Item> cq;
    public static void main(String[] args) {

        CircledQueue<Integer> josef = new CircledQueue<Integer>();

        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        for(int i = 0; i < N; i++) josef.add(i);
        System.out.println(": "+N);
        
        while(!josef.isEmpty()) System.out.println(josef.removeM(M)+" ");
    }
}
