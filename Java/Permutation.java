import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


public class Permutation {
   
    public static void main(String[] args) {

        RandomizedQueue newRQ = new RandomizedQueue<String>();
        
        // jvm在调用主函数的时候，传入的是args[0]
        int k = Integer.parseInt (args[0]);
        int i = 0;
        // System.out.println("k: "+k);
        while(!StdIn.isEmpty()){
            String str = StdIn.readString();
            if(i<k) newRQ.enqueue(str);
            else {
                boolean replace = StdRandom.bernoulli((double)k/(i+1));
                // int pos = StdRandom.uniformInt(k);
                if(replace) {
                    newRQ.dequeue();
                    newRQ.enqueue(str);
                }
            }
            i++;
        }
        for(int j=0; j<k; j++) {
            System.out.println(newRQ.dequeue());
            // System.out.println(newRQ.size());
        }
    }

}




// iterator of randomQ
