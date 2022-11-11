public class Check 
{
    public static void main(String args[]) 
    {
        int arr[] = new int[] {0 , 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 8;
        n = arr[arr[n] / 2];
        System.out.println(arr[n] / 2);
    } 
}