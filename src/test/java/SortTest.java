import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sort.Sort;

import java.util.Arrays;
import java.util.Calendar;

public class SortTest {
    static Sort sort=new Sort();
    //一亿个数100000000排序需要42秒,14s,8s
    static int[] arr1= Tools.geneArr(10000000);
    static int[] arr2=Arrays.copyOf(arr1,arr1.length);
    static int[] arr3=Arrays.copyOf(arr1,arr1.length);
    static int[] arr4=Arrays.copyOf(arr1,arr1.length);
    static int[] arr5=Arrays.copyOf(arr1,arr1.length);
    /*@Test
    public void evaluatesExpression() {
        sort.test();
    }*/
    @Test
    public void quickSortTest(){
        int[] arr={14,3,14};
        sort.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void bubbleSortTest(){
        int[] arr={5,1,4,2,9,20,14,3};
        sort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void insertSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11};
        sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试冒泡和插入的性能，在随机生成10w个数中，冒泡用了23秒而插入只用了1秒
     * 结论：插入比冒泡慢很多
     * 由于插入排序的交换次数恰好为逆序数，而冒泡至少为逆序数，而且还有多余的比较与循环
     */
    @Test
    public void quickSortPerformanceTest(){
        long start= Calendar.getInstance().getTimeInMillis();
        sort.quickSort(arr2,0,arr2.length-1);//这里测试二分折半插入排序，结果还没有一般插入排序好，时间是普通的两倍
        long end=Calendar.getInstance().getTimeInMillis();
        System.out.println("quick执行时间(秒)："+(double)(end-start)/1000);
//        System.out.println(Arrays.toString(arr2));
    }
    @Test
    public void arraySortPerformanceTest(){
        long start= Calendar.getInstance().getTimeInMillis();
        Arrays.sort(arr5);//这里测试二分折半插入排序，结果还没有一般插入排序好，时间是普通的两倍
        long end=Calendar.getInstance().getTimeInMillis();
        System.out.println("arraySort执行时间(秒)："+(double)(end-start)/1000);
//        System.out.println(Arrays.toString(arr5));
    }
    @Test
    public void radixSortPerformanceTest(){
        long start= Calendar.getInstance().getTimeInMillis();
        sort.radixSort(arr3);
        long end=Calendar.getInstance().getTimeInMillis();
        System.out.println("radix执行时间(秒)："+(double)(end-start)/1000);
//        System.out.println(Arrays.toString(arr3));
    }
    @Test
    public void mergeSortPerformanceTest(){
        long start= Calendar.getInstance().getTimeInMillis();
        sort.mergeSort(arr1);
        long end=Calendar.getInstance().getTimeInMillis();
        System.out.println("merge执行时间(秒)："+(double)(end-start)/1000);
//        System.out.println(Arrays.toString(arr1));
    }
    @Test
    public void countSortPerformanceTest(){
        long start= Calendar.getInstance().getTimeInMillis();
        sort.countSort(arr4);
        long end=Calendar.getInstance().getTimeInMillis();
        System.out.println("count执行时间(秒)："+(double)(end-start)/1000);
//        System.out.println(Arrays.toString(arr4));
    }

    @Test
    public void binInsertSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11,19};
        sort.binInsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void shellSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11,19};
        sort.shellSort(arr);
        System.out.println("shellSort:"+Arrays.toString(arr));
    }
    @Test
    public void heapSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11,19};
        sort.heapSort(arr);
        System.out.println("heapSort:"+Arrays.toString(arr));
    }
    @Test
    public void mergeSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11,19};
        sort.mergeSort(arr);
        System.out.println("mergeSort:"+Arrays.toString(arr));
    }
    @Test
    public void countSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11,19};
        sort.countSort(arr);
        System.out.println("countSort:"+Arrays.toString(arr));
    }
    @Test
    public void radixSortTest(){
        int[] arr={5,1,4,2,9,20,14,3,11,11,6};
        sort.radixSort(arr);
        System.out.println("countSort:"+Arrays.toString(arr));
    }



}

