import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class FirstRecurringNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = random.ints(1000000).toArray();
        //int[] numbers = new int[]{1,2,3,5,5,2};
        long startTime = System.nanoTime();
        System.out.println(firstRecurringNumbers(numbers));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000000 ;

        System.out.println(duration);


    }


    public static Integer firstRecurringNumbers(int[] arr) {

        Map<Integer, Integer > map = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            if(map.containsValue(arr[i])){
                return arr[i];

            }
            map.put(i, arr[i]);
        }
        return null;
    }


}
