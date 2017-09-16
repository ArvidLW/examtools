package future;

import java.util.Arrays;

public class SortFuture {
    public static void insertSort(int[] arr){
        //第一个元素作为有序的序列
        for(int i=1;i<arr.length;++i){
            int tmp=arr[i];
            //标记前面有序序列的末尾索引
            int j=i-1;
            //从有序列尾部比较找到一个合适的位置，把比该数大的往后挪一位
            while(j>=0 && tmp<arr[j]){
                arr[j+1]=arr[j];
                --j;
            }
            //由于--j了所以在赋值的时要加上1,表示找到的要插入元素的位置。
            arr[j+1]=tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,8,3,4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
