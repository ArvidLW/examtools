package lianjia;

import java.util.Arrays;
import java.util.Scanner;

public class avg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n=in.nextInt();
            int r=in.nextInt();
            int avg=in.nextInt();
            grade[] arr=new grade[n];
            for(int i=0;i<arr.length;++i){
                arr[i]=new grade(in.nextInt(),in.nextInt());
            }
            Arrays.sort(arr);
//            System.out.println(arr[0].costUnit);
            int cost = getCost(n, r, avg, arr);
            System.out.println(cost);
        }
    }
    static int getCost(int n,int r,int avg,grade[] arr){
        int need=needGrade(n,avg,arr);
        int cost=0;
        for(int i=0;i<arr.length;++i){
            int c=(r-arr[i].can);
            if(c>0 && c<need){
               cost+=c*arr[i].costUnit;
               need=need-c;
            }
            else {
                cost+=need*arr[i].costUnit;
                need=0;
                break;
            }
        }
        return cost;
    }
    static int needGrade(int n,int avg,grade[] arr){
        int total=avg*n;
        int now=0;
        for(int i=0;i<arr.length;++i){
            now+=arr[0].can;
        }
        return total-now;
    }
}
class grade implements Comparable{
    int can=-1;
    int costUnit=-1;
    boolean tag=false;
    grade(int i,int j){
        can=i;
        costUnit=j;
    }

    @Override
    public int compareTo(Object o) {
        if(costUnit<((grade)o).costUnit )
        {
            return -1;
        }
        return 1;
    }
}
