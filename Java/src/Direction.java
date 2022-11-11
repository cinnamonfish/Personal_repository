import java.util.Arrays;
import java.util.List;

public class Direction{

    String berry = "blue";
    void juicy(String berry){
        this.berry = "rasp";
        System.out.println(berry+"berry");

    }
    public static void main(String[] args) {
        int a = 1;
        int b = 8;
        System.out.println(true&&false);
        System.out.println(true&&false||true);
        new Direction().juicy("straw");
    List<String> list = new ArrayList<String>(Arrays.asList("a","b","vv"));
    for(String s:list) {
        if(s.equals("a")) {
            list.remove(s);
        }
    }
    System.out.println(list);

   }

}
