package future;

import java.util.Arrays;
import java.util.Scanner;

public class Combine {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,7,9};
        System.out.println(Arrays.toString(findCouple(arr,9)));
    }
    static int[] findCouple(int [] arr,int val){
        int half=val/2;
        int pos = findPos(arr, half);
        for(int i=pos,j=pos+1;i>=0&&j<arr.length;){
            if(arr[i]+arr[j]==val){
                return new int[]{arr[i],arr[j]};
            }
            if(arr[i]+arr[j]<val){
                ++j;
            }
            if(arr[i]+arr[j]>val){
                --i;
            }
        }
        return new int[2];
    }
    static int findPos(int[] arr,int val){
        for(int i=0;i<arr.length-1;++i){
            if(val>=arr[i]&&val<arr[i+1]){
                return i;
            }
        }
        return -1;
    }
}
