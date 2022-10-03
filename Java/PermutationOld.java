import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
   
    public static void main(String[] args) {

        RandomizedQueue newRQ = new RandomizedQueue<String>();
        
        // jvm在调用主函数的时候，传入的是args[0]
        int k = Integer.parseInt (args[0]);
        // System.out.println("k: "+k);
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            // if(s.equals("eol")) break;
            newRQ.enqueue(s);
        }
        for(int i=0; i<k; i++) {
            System.out.println(newRQ.dequeue());
            // System.out.println(newRQ.size());
        }
    }

}




// iterator of randomQ
