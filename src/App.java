import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/* Here are a collection of problems from the 1 week preparation Kit in Haker rank, we have a main
 * function from where the subsequent functions will be called, however to keep the main clean we will move
 * to each function the prerequisites to run the function, all this will be comment out inside the function
 */
public class App {
    public static void main(String[] args) throws Exception {



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

    } 
}
