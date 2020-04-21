/**
 * Generates an array of random int numbers and sorts them with various sorting algorithms
 * @author ICS4UE
 * @version Mar 2020
 */
import java.util.Random;
import java.util.Arrays;

class SortComparisonTemplate {
    public static void main(String[] args) {     
        final int MAX = 5000;
        long start, end; 
        double executionTime;
        
        int data[] = generateNumberArray(MAX);
        int[] tempArray; //a temp holder for the array as it is passed to methods that alter it
        
        System.out.println("Generated array: ");
        displayArray(data);
        
        //Testing Bubble Sort
        System.out.println("\nSorting with Bubble sort:");  
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        start = System.nanoTime();
        bubbleSort(tempArray);
        end = System.nanoTime();
        executionTime = (end - start)/1000000.0;
        displayArray(tempArray);
        System.out.println("The sort took: " + executionTime + "ms");
        
        //Testing Selection Sort
        System.out.println("\nSorting with Selection sort:");
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        start = System.nanoTime();
        selectionSort(tempArray);
        end = System.nanoTime();
        executionTime = (end - start)/1000000.0;
        displayArray(tempArray);
        System.out.println("The sort took: " + executionTime + "ms");
        
        //Testing Insertion Sort
        System.out.println("\nSorting with Insertion sort:");  
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        start = System.nanoTime();
        insertionSort(tempArray);
        end = System.nanoTime();
        executionTime = (end - start)/1000000.0;
        displayArray(tempArray);
        System.out.println("The sort took: " + executionTime + "ms");
        
        //Testing Quick Sort
        System.out.println("\nSorting with Quick sort:");  
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        start = System.nanoTime();
        quickSort(tempArray);
        end = System.nanoTime();
        executionTime = (end - start)/1000000.0;
        displayArray(tempArray);
        System.out.println("The sort took: " + executionTime + "ms");
        
        //Testing Merge Sort
        System.out.println("\nSorting with Merge sort:");  
        tempArray = Arrays.copyOf(data,data.length); //to keep original arrays safe from modification
        start = System.nanoTime();
        mergeSort(tempArray);
        end = System.nanoTime();
        executionTime = (end - start)/1000000.0;
        displayArray(tempArray);
        System.out.println("The sort took: " + executionTime + "ms");
        
        //Testing Arrays.sort
        System.out.println("\nSorting with Arrays.sort:");
        tempArray = Arrays.copyOf(data,data.length);  //to keep original arrays safe from modification
        start = System.nanoTime();
        javaBuiltInSort(tempArray);
        end = System.nanoTime();
        executionTime = (end - start) / 1000000.0;
        displayArray(tempArray);
        System.out.println("The sort took: " + executionTime + "ms");
        
    } //end of main method
//------------------------------------------------------------------------------     
    public static int[] generateNumberArray(int numOfElements) { 
        int[] generated = new int[numOfElements];
        //add unique numbers into the array in order
        for (int i = 0 ; i< generated.length; i++)
            generated[i]=i;
        //shuffle the numbers randomly
        Random randomIndex = new Random();
        for (int i = 0 ; i< generated.length; i++) { 
            //pick two random indices
            int first = randomIndex.nextInt(generated.length);
            int second = randomIndex.nextInt(generated.length);
            //swap the numbers at those indices
            int temp = generated[first];
            generated[first] = generated[second];
            generated[second] = temp;
        }
        return generated;
    }
//------------------------------------------------------------------------------  
    public static void displayArray(int[] numbers) { 
        for (int i = 0 ; i< numbers.length;i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
//------------------------------------------------------------------------------     
    public static void bubbleSort(int[] a){
        boolean sorted = false;
        int temp;
        while (!sorted){
            sorted = true;
            for (int i = 0; i<a.length-1;i++){
                if (a[i] > a[i+1]){
                    temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                    sorted = false;
                }
            }
        }
    }
    //------------------------------------------------------------------------------
    public static void selectionSort(int[] a){
        int index = 0;
        int size = a.length;
        int max, maxindex, temp;
        while (index<size-1){
            max = Integer.MAX_VALUE;
            maxindex = -1;
            for (int i = index; i<size; i++){
                if (a[i]<max){
                    maxindex = i;
                    max = a[i];
                }
            }
            temp = a[maxindex];
            a[maxindex] = a[index];
            a[index] = temp;
            index++;
        }

    }
//------------------------------------------------------------------------------     
    public static void insertionSort(int[] a){
        int index = 1;
        int curr, temp;
        while (index<a.length){
            curr = index;
            while (curr!=0 && a[curr]<a[curr-1]){
                temp = a[curr];
                a[curr] = a[curr-1];
                a[curr-1] = temp;
                curr--;
            }
            index++;
        }
    }
//------------------------------------------------------------------------------      
    public static void quickSort(int[] numbers) { 
        quickSort(numbers, 0, numbers.length);
    }
    private static void quickSort(int[] a, int start, int end) {
        if (end - start > 1){
            int temp;
            int pivot = a[(start + end) / 2];
            int left = start;
            int right = end - 1;
            while (left <= right) {
                while (a[left] < pivot) {
                    left++;
                }
                while (a[right] > pivot) {
                    right--;
                }
                if (left <= right) {
                    temp = a[left];
                    a[left] = a[right];
                    a[right] = temp;
                    left++;
                    right--;
                }
            }
            quickSort(a, start, right+1);
            quickSort(a, left, end);
        }
    }
//------------------------------------------------------------------------------         
public static void mergeSort(int[] a){
    int mid = a.length/2;
    int[] left = Arrays.copyOfRange(a, 0, mid);
    int[] right = Arrays.copyOfRange(a, mid, a.length);
    if (left.length>1) {
        mergeSort(left);
    }
    if (right.length>1){
        mergeSort(right);
    }
    int[] b = merge(left, right);
    for (int i = 0; i<a.length; i++){
        a[i] = b[i];
    }
}

    private static int[] merge(int[] a, int[] b){
        int length = a.length+b.length;
        int[] result = new int[length];
        int aindex = 0;
        int bindex = 0;
        int rindex = 0;
        while (rindex<length){
            if (aindex<a.length && bindex<b.length){
                if (a[aindex]<b[bindex]){
                    result[rindex] = a[aindex];
                    aindex++;
                    rindex++;
                } else {
                    result[rindex] = b[bindex];
                    bindex++;
                    rindex++;
                }
            } else if (aindex<a.length){
                result[rindex] = a[aindex];
                aindex++;
                rindex++;
            } else {
                result[rindex] = b[bindex];
                bindex++;
                rindex++;
            }
        }
        return result;
    }
//------------------------------------------------------------------------------         
    public static void javaBuiltInSort( int[] numbers) { 
        Arrays.sort(numbers);
    }
//------------------------------------------------------------------------------             
}