import java.util.Arrays;

class SortTester{
    static final int LIST_SIZE = 50000;
    public static void main(String[] args){
        long start, end;
        int[] randomized = new int[LIST_SIZE];
        for (int i = 0; i<LIST_SIZE; i++){
            randomized[i] = (int)(Math.random()*1000000);
        }

        int[] bubble = randomized.clone();
        start = System.nanoTime();
        Sorts.bubbleSort(bubble);
        end = System.nanoTime();
        System.out.println((double)(end-start)/1000000 + "mS");

        int[] selection = randomized.clone();
        start = System.nanoTime();
        Sorts.selectionSort(selection);
        end = System.nanoTime();
        System.out.println((double)(end-start)/1000000 + "mS");

        int[] insertion = randomized.clone();
        start = System.nanoTime();
        Sorts.insertionSort(insertion);
        end = System.nanoTime();
        System.out.println((double)(end-start)/1000000 + "mS");

        int[] merge = randomized.clone();
        start = System.nanoTime();
        Sorts.mergeSort(merge);
        end = System.nanoTime();
        System.out.println((double)(end-start)/1000000 + "mS");

        int[] quick = randomized.clone();
        start = System.nanoTime();
        Sorts.quickSort(quick);
        end = System.nanoTime();
        System.out.println((double)(end-start)/1000000 + "mS");

        int[] builtin = randomized.clone();
        start = System.nanoTime();
        Arrays.sort(builtin);
        end = System.nanoTime();
        System.out.println((double)(end-start)/1000000 + "mS");

    }
    public static void printArray(int[] a){
        for (int i = 0; i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }
}