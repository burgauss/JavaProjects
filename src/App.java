import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/* Here are a collection of problems from the 1 week preparation Kit in Haker rank, we have a main
 * function from where the subsequent functions will be called, however to keep the main clean we will move
 * to each function the prerequisites to run the function, all this will be comment out inside the function
 */
public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(3);
        myList.add(2);
        myList.add(1);

        int val = lonelyInteger(myList);
        System.out.println(val);

    }

    public static void plusMinus(List<Integer> arr) {
        /*MOVE THE FOLLOWING CODE TO THE MAIN TO RUN */
        // List<Integer> myList = new ArrayList<>();
        // myList.add(1);
        // myList.add(1);
        // myList.add(-1);
        // myList.add(-1);
        // myList.add(0);

        // plusMinus(myList);
        
        // Write your code here
        int counter[] = {0,0,0};
        float ratios[] = {0,0,0};
        int size = arr.size();
        
        arr.forEach(number -> {
            if (number > 0){
                counter[0]+=1;
            } else if (number < 0){
                counter[1]+=1;                
            } else
            {
                counter[2] +=1;
            }
        }) ;
        
        for(int i=0; i <3; i++)
        {
            ratios[i] = (float) counter[i] / size;
        }
        
        System.out.printf("%.6f \n", ratios[0]);
        System.out.printf("%.6f \n", ratios[1]);
        System.out.printf("%.6f \n", ratios[2]);
        
    }

    public static void miniMaxSum(List<Integer> arr)
    {
        // List<Integer> myList = new ArrayList<>();
        // myList.add(2);
        // myList.add(3);
        // myList.add(4);
        // myList.add(2);
        // myList.add(1);

        // miniMaxSum(myList);
        Collections.sort(arr);
        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < arr.size() - 1 ; i++)
        {
            minSum += arr.get(i);
        }
        for (int i = 1; i < arr.size() ; i++)
        {
            maxSum += arr.get(i);
        }

        System.out.printf("%d %d", minSum, maxSum);

    } 

    public static String timeConversion(String s)
    {
        // String militarTime = timeConversion("12:05:45AM");

        // System.out.println(militarTime);
        String codeTime = s.substring(8,10);
        String hh = s.substring(0, 2);
        String mm = s.substring(3, 5);
        String ss = s.substring(6, 8);
        String s1 = s.substring(0,8);
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // LocalTime time = LocalTime.parse(s1, formatter);
        if(codeTime.equals("AM"))
        {
            if (hh.equals("12"))
            {
                hh ="00"; 
            }
        } else if (codeTime.equals("PM")) {
            if (!hh.equals("12"))
            {
                int i_hh = Integer.parseInt(hh);
                i_hh = i_hh + 12;
                hh = String.valueOf(i_hh);
            }
        }


        return (hh+":"+mm+":"+ss);
    }

    public static int lonelyInteger(List<Integer> a){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int lonelyIntegerVal = 0;
        a.forEach(number-> {
            if (hm.containsKey(number)) {
                hm.replace(number, hm.get(number)+1);
            } else{

                hm.put(number, 1);
            }
        });

        Set<Integer> set = new LinkedHashSet<>(a);
        // Convert set back to list
        List<Integer> uniqueList = new ArrayList<>(set);

        for(int uniqueNumber : uniqueList){
            if (hm.get(uniqueNumber) ==   1){
                lonelyIntegerVal = uniqueNumber;
                break;
            }
        }
        
        return lonelyIntegerVal;

    }
}
