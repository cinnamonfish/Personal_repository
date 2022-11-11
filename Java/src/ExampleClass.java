class ExampleClass {

    public static String TraverseString(String myStr) {
        // Base case
        if (myStr.isEmpty()) {
            return myStr;
        }

        // Recursive case
        else {
            return TraverseString(myStr.substring(1)) + myStr.charAt(0);
        }
    }

    public static void main( String args[] ) {
        String string1 = "Hello World";
        
        String resultStr = TraverseString(string1);
        System.out.println(resultStr);

        int[][] arr;
arr = new int[3][];
arr[0] = {1,2};
System.out.println(arr[0][1]);
    }

}