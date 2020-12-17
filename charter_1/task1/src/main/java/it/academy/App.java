package it.academy;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> arrayList1 = new ArrayList<>();
        System.out.println(Average.CountAverage(arrayList1));
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(12);
        System.out.println(Average.CountAverage(arrayList1));
    }
}
