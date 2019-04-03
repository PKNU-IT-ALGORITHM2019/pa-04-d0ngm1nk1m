package Algorithm;

import java.util.Arrays;

public class Work04_1 {
    
    static int [] arr_Random;
    static int [] arr_Reverse;
    
    public static void main(String[] args) {
        
        int [] data = { 1000, 10000, 100000 };
        double result = 0;
        
        System.out.print("\t");
        for(int i = 0; i < 3; i++) {
            System.out.print("\t" + "Random" + data[i]);
            System.out.print("\t" + "Reverse" + data[i]);
        }
        
        System.out.println();
        
        System.out.print("Heap\t");    // heap_Sort();
        for(int i = 0; i < 3; i++) {
            result = 0;
            for(int j = 0; j < 10; j++) {
                Make_Array_Random(data[i]);
                long start_time = System.currentTimeMillis();
                heap_Sort(arr_Random);
                long end_time = System.currentTimeMillis();
                result += (end_time - start_time)/1000.0;
            }
            System.out.print("\t\t" + String.format("%.3f", (result/10)));
            Make_Array_Reverse(data[i]);
            long start_time = System.currentTimeMillis();
            heap_Sort(arr_Reverse);
            long end_time = System.currentTimeMillis();
            result = (end_time - start_time)/1000.0;
            System.out.print("\t\t" + String.format("%.3f",result));
        }
        
        System.out.println();
        
        System.out.print("Java\t");    // java_Sort();
        for(int i = 0; i < 3; i++) {
            result = 0;
            for(int j = 0; j < 10; j++) {
                Make_Array_Random(data[i]);
                long start_time = System.currentTimeMillis();
                Arrays.sort(arr_Random);
                long end_time = System.currentTimeMillis();
                result += (end_time - start_time)/1000.0;
            }
            System.out.print("\t\t" + String.format("%.3f", (result/10)));
            Make_Array_Reverse(data[i]);
            long start_time = System.currentTimeMillis();
            Arrays.sort(arr_Reverse);
            long end_time = System.currentTimeMillis();
            result = (end_time - start_time)/1000.0;
            System.out.print("\t\t" + String.format("%.3f",result));
        }
        
    }
    
    public static void Make_Array_Random(int num) {
        
        arr_Random = new int[num];
        for(int i = 0; i < num; i++)
            arr_Random[i] = (int)(Math.random()*num + 1);
        
    }
    
    public static void Make_Array_Reverse(int num) {
        
        arr_Reverse = new int[num];
        for(int i = 0; i < num; i++)
            arr_Reverse[i] = num - i;
        
    }
    
    public static void heap_Sort(int []arr) {
        
        int length = arr.length;
        
        buildMaxHeap(arr, length);
        
        for(int i = length - 1; i > 0; i--) {
            swap(0, i, arr);
            length--;
            maxHeapify(arr, 0, length);
        }
        
    }
    
    public static void swap(int i, int j, int []arr) {
        
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        
    }
    
    public static void maxHeapify(int []arr, int i, int length) {
        
        if (arr == null || length < 1)
            return;
        
        int leftChild = i * 2;
        int rightChild = leftChild + 1;
        int largest;
        
        if (leftChild < length && arr[leftChild] > arr[i])
            largest = leftChild;
        else
            largest = i;
        
        if (rightChild < length && arr[rightChild] > arr[largest])
            largest = rightChild;
        
        if (largest != i) {
            swap(i, largest, arr);
            maxHeapify(arr, largest, length);
        }
    }
    
    public static void buildMaxHeap(int []arr, int length) {
        
        if (arr == null || arr.length < 1)
            return;
        
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i, length);
        }
    }
    
}
