import java.util.Arrays;

public class Sorts{
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

    public static int[] merge(int[] a, int[] b){
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
    public static void quickSort(int[] a){
        quickSort(a, 0, a.length);
    }
    public static void quickSort(int[] a, int start, int end) {
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
}