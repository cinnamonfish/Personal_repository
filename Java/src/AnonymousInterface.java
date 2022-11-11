interface AnonymousInterface
{
    public int getValue();
    public int getData();
}

public class ImplementationClass 
{
    private int data = 15;
    public static void main(String[] args)
    {
        AnonymousInterface inner = new AnonymousInterface()
                {
                    int data = 5;
                    public int getValue()
                    {
                        return data;
                    }
                    public int getData()
                    {
                        return data;
                    }
                };
        ImplementationClass outer = new ImplementationClass();
        System.out.println(inner.getValue() + inner.getData() + ImplementationClass.data);
    }
}