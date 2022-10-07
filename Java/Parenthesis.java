import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;

// uses Stack.java from Princeton
 
public class Parenthesis {
    

    private boolean isPaired;

    public static void main(String[] args) {
        Deque<Character> stack = new Deque<Character>();
        while(!StdIn.isEmpty()) {
            Character item = StdIn.readChar();
            if(item.equals('[')||item.equals('(')||item.equals('{')) stack.addLast(item);
            
            if(item.equals(']') && stack.peekLast().equals('[')) stack.removeLast();
            if(item.equals(')') && stack.peekLast().equals("\\(")) stack.removeLast();
            if(item.equals('}') && stack.peekLast().equals("\\{")) stack.removeLast();
            
            if(item.equals('a')) break;
            // System.out.println(item);
        }
        Parenthesis newParen = new Parenthesis();
        if(stack.isEmpty()) newParen.isPaired = true;
        else newParen.isPaired = false;
        System.out.println(newParen.isPaired);
        System.out.println("Is stack empty? "+ stack.isEmpty());
        // while(stack.iterator().hasNext()) System.out.println(stack.iterator().next());
    }
}