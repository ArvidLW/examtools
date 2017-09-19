package sort;

import java.util.Arrays;

public class QuickSort {
    /**快速排序，升序
     * 思想：取一个基准值，从数组两边开始扫描比较;
     * 经过一趟排序，将序列以基准值分为有序;
     * 然后再分别对此区域进行同样的排序;
     * 直到没有可以拆分比较的为止,即两边扫描指示位相遇(相等)
     */
    public static int oneSort(int[] arr,int beg,int end){
        //以arr[beg]位置为索引位
        int base=arr[beg];
        //进行扫描
        while (beg<end){
            //从后向前扫描,找到一个小于基准值的位置，让它覆盖基准值位置值
            //这里为大于等于，否则当等于时会陷入死循环
            while(arr[end]>=base && end>beg){
                --end;
            }
            arr[beg]=arr[end];
            //接下来从前向后扫描，找到一个大于基准值的位置，让它移到指示位end的地方。
            while(arr[beg]<=base && beg<end){
                ++beg;
            }
            arr[end]=arr[beg];
        }
        //将基准値放到beg或者end因为此时它们两相等
        arr[end]=base;
        return end;
    }
    public static void quickSort(int[] arr, int beg, int end){
        //如果开始指示位大于等于结束指示位，则不做任何操作返回。
        if(beg>=end){
            return;
        }
        //传入arr,beg,end，这样beg、end以形参方式进入oneSort，并不会改变quickSort中的beg和end值
        int  mid=oneSort(arr,beg,end);
        quickSort(arr,beg,mid-1);
        quickSort(arr,mid+1,end);
    }

    public static void main(String[] args) {
        int[] arr={5,1,2,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
