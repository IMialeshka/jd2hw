package it.academy;

import java.util.List;

public class Average {
    public static double CountAverage(List<Integer> inArray){
        double result = 0.0;

        if (inArray.size() == 0)
            return result;

        for (Integer element : inArray) {
            result = result + element;
        }
        result = result/inArray.size();
        return result;
    }
}
