import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;



/* Here are a collection of problems from the 1 week preparation Kit in Haker rank, we have a main
 * function from where the subsequent functions will be called, however to keep the main clean we will move
 * to each function the prerequisites to run the function, all this will be comment out inside the function
 */
public class App {
    static boolean returnSomething(){
        return false;
    }


    public static void main(String[] args) throws Exception {
        String a = "GeeksforGeeks"; 
		String b = new String(a); 
		int value = 0; 
		value = (a==b) ? 1:2; 
		if(value == 1) 
		{ 
			System.out.println("GeeksforGeeks"); 
		} 
		else if(value == 2) 
		{ 
			System.out.println("Geeks for Geeks"); 
		} 
		else
		{ 
			System.out.println("GFG"); 
		} 
    }
 
    public static String caesarCipher(String s, int k) {
       // String str = caesarCipher("6DWV95HzxTCHP85dvv3NY2crzt1aO8j6g2zSDvFUiJj6XWDlZvNNr", 87);
       // System.out.println(str);

        // Write your code here
        String s_code  = "";
        int i_anscii = 0;
        while (k > 26)
        {
            k = k -26;
        }
        for (char c : s.toCharArray())
        {   
            i_anscii = (int) c;
            if ((i_anscii <= 90 && i_anscii >= 65))
            {
                //letter is upper case
                i_anscii = i_anscii+k;
                if (i_anscii > 90)
                {
                    i_anscii = i_anscii - 26;
                }
            } else if ((i_anscii >= 97) && (i_anscii <=122)) {
                //lower case
                i_anscii = i_anscii+k;
                if (i_anscii > 122){
                    i_anscii = i_anscii - 26;
                }
            }
            
            s_code = s_code + (char)i_anscii;   
            
        }

        return s_code;
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
        // ArrayList<Integer> myList = new ArrayList<>();
        // myList.add(1);
        // myList.add(2);
        // myList.add(3);
        // myList.add(4);
        // myList.add(3);
        // myList.add(2);
        // myList.add(1);

        // int val = lonelyInteger(myList);
        // System.out.println(val);
        
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

    public static int diagonalDifference(List<List<Integer>> arr) {
        // List<List<Integer>> muList = Arrays.asList(
        //     Arrays.asList(1,2,3,4),
        //     Arrays.asList(5,6,7,8),   
        //     Arrays.asList(9,10,11,12), 
        //     Arrays.asList(13,14,15,16)
        // );

        // System.out.println(diagonalDifference(muList));

        // Write your code here
        int size = arr.size();
        int lrSum = 0;  //left to right sum
        int rlSum = 0;
        for (int i=0; i < size; i++){
            for (int j=0; j < size; j++)
            {
                if (i==j){
                    lrSum += arr.get(i).get(j);
                }
                if (j == size-i-1)
                {
                    rlSum += arr.get(i).get(j);
                }
            }
        }
        int diagonalDifference = Math.abs(lrSum - rlSum);
        return diagonalDifference;
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // ArrayList<Integer> myList = new ArrayList<>();
        // myList.add(1);
        // myList.add(2);
        // myList.add(3);
        // myList.add(4);
        // myList.add(3);
        // myList.add(2);
        // myList.add(1);


        // ArrayList<Integer> sortedList = (ArrayList<Integer>) countingSort(myList);
        
        // System.out.println(sortedList);
        
        // Write your code here
   
        int mapVal[] = new int[100];

        arr.forEach(number ->{
            mapVal[number]++;
        });
        Integer[] integerArray = Arrays.stream(mapVal).boxed().toArray(Integer[]::new);
        List<Integer> sortedListL =  Arrays.asList(integerArray);
        ArrayList<Integer> sortedList = new ArrayList<>(sortedListL);

        return sortedList;

        // for(int i=0; i<= maxVal;i++ ){
        //     int count = mapVal[i];
        //     if (count > 0)
        //     {
        //         for(int j=0; j < count; j++)
        //         {
        //             sortedList.add(i);
        //         }
        //     }
        // }

        // return sortedList;

    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // List<List<Integer>> muList = Arrays.asList(
        //     Arrays.asList(112,42,83,119),
        //     Arrays.asList(56,125,56,49),   
        //     Arrays.asList(15,78,101,43), 
        //     Arrays.asList(62,98,114,108)
        // );

        // System.out.println(flippingMatrix(muList));
        // Write your code here
        int size = matrix.size();
        int upperLeftMatrixSize = size/2;
        int sum = 0;
        
        for (int i = 0; i < upperLeftMatrixSize; i++){
            for (int j = 0; j < upperLeftMatrixSize; j++){
                sum += getMax(i,j,matrix,size-1);
            }
        }
        
        return sum;
    }

    public static int getMax(int x, int y, List<List<Integer>> matrix, int size)
    {
        int maxVal = matrix.get(x).get(y);
        
        if (matrix.get(x).get(size-y) > maxVal ){
            maxVal = matrix.get(x).get(size-y);
        }
        if (matrix.get(size-x).get(y) > maxVal){
                maxVal = matrix.get(size-x).get(y);
        }
        if (matrix.get(size-x).get(size-y) > maxVal){
                maxVal = matrix.get(size-x).get(size-y);
        }
        
        return maxVal;
    }
}
