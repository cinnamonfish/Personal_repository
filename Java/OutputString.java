// 
import edu.princeton.cs.algs4.*;

public class OutputString {
    
    public static void main(String[] args) {
        Deque<String> OutDeck = new Deque<String>();
       int k = Integer.parseInt(args[0]);
       while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            OutDeck.addLast(item);
       }
       for(int i = 0; i<k; i++) {
            OutDeck.removeLast();
            
       }
    }
}
