/**
 * Compares execution time of different search algorithms
 * @author ICS4U
 * @version Nov 2019
 */
import java.util.ArrayList;

public class SearchComparison{
    public static void main(String[] args){
        final int MAX = 1000000;
        final int REPEAT = 100;
        long start, end, executionTime;
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        //put MAX number of items in the list
        for (int i=0; i<MAX; i++){
            numbers.add(i);
        }
        
        int item = MAX - 1;             //worst case scenario is to search for the last item
        int index = 0;
        
        start = System.nanoTime();
        for (int i=0; i<REPEAT; i++)
            index = whileLoopSearch(item, numbers);
        end = System.nanoTime();
        executionTime = (end - start)/REPEAT;
        System.out.println("It took "+ executionTime +" nS to find "+ item +" at index "+ index +" using while-loop search.");  

        start = System.nanoTime();
        for (int i=0; i<REPEAT; i++)
            index = forLoopSearch(item, numbers);
        end = System.nanoTime();
        executionTime = (end - start)/REPEAT;
        System.out.println("It took "+ executionTime +" nS to find "+ item +" at index "+ index +" using for-loop search.");  
        
        start = System.nanoTime();
        for (int i=0; i<REPEAT; i++)        
            index = sentinelSearch(item, numbers);
        end = System.nanoTime();
        executionTime = (end - start)/REPEAT;
        System.out.println("It took "+ executionTime +" nS to find "+ item +" at index "+ index +" using sentinel search.");  

        start = System.nanoTime();
        for (int i=0; i<REPEAT; i++)        
            index = iterativeBinarySearch(item, numbers);
        end = System.nanoTime();
        executionTime = (end - start)/REPEAT;
        System.out.println("It took "+ executionTime +" nS to find "+ item +" at index "+ index +" using iterative binary search.");    

        start = System.nanoTime();
        for (int i=0; i<REPEAT; i++)        
            index = recursiveBinarySearch(item, numbers);
        end = System.nanoTime();
        executionTime = (end - start)/REPEAT;
        System.out.println("It took "+ executionTime +" nS to find "+ item +" at index "+ index +" using recursive binary search.");    

        start = System.nanoTime();
        for (int i=0; i<REPEAT; i++)        
            index = numbers.indexOf(item);
        end = System.nanoTime();
        executionTime = (end - start)/REPEAT;
        System.out.println("It took "+ executionTime +" nS to find "+ item +" at index "+ index +" using indexOf search.");        
    }
//------------------------------------------------------------------------------  
    //Linear search with while-loop
    public static int whileLoopSearch(int item, ArrayList<Integer> items){
        int i = 0;
        while (i < items.size() && items.get(i) != item){
            i = i + 1;
        }
        if (i == items.size()){return -1;}
        else{return i;}
    }
//------------------------------------------------------------------------------    
    //Linear search with for-loop
    public static int forLoopSearch(int item, ArrayList<Integer> items){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i) == item)
                return i;
        }
        return -1;
    }
//------------------------------------------------------------------------------    
    //Linear search with sentinel
    public static int sentinelSearch(int item, ArrayList<Integer> items){
        items.add(item);                //add the sentinel
        int i = 0;
        while (items.get(i) != item){
            i = i + 1;
        }
        items.remove(items.size()-1);   //remove the sentinel
        if (i == items.size()){return -1;}
        else{return i;}
    }
//------------------------------------------------------------------------------    
    //Iterative binary search
    public static int iterativeBinarySearch(int item, ArrayList<Integer> items){
        int left = 0;
        int right = items.size() - 1;
        while (left <= right){
            int middle = (left + right)/2;
            if (items.get(middle) == item)
                return middle;
            else if (items.get(middle) > item)
                right = middle - 1;     //ignore the right half
            else
                left = middle + 1;      //ignore the left half
        }
        return -1;
    }
//------------------------------------------------------------------------------    
    //Recursive binary search
    public static int recursiveBinarySearch(int item, ArrayList<Integer> items){
        int left = 0;
        int right = items.size() - 1;
        return recursiveBinarySearch(item, items, left, right);
    }
    public static int recursiveBinarySearch(int item, ArrayList<Integer> items, int left, int right){
        if (right < left)               //base case - the list was exhausted and the item was not found
            return -1;
        int middle = (left + right)/2;
        if (items.get(middle) == item)  //base case - the item was found
            return middle;
        else if (items.get(middle) > item)
            return recursiveBinarySearch(item, items, left, middle-1); //ignore the right half
        else
            return recursiveBinarySearch(item, items, middle+1, right); //ignore the left half
    }    
}

