package lianjia;

import java.util.Arrays;
import java.util.Scanner;

public class wanju {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            int n=in.nextInt();
            int m=in.nextInt();
            int[] power=new int[n];
            W[] wj=new W[n];
            for(int i=0;i<wj.length;++i){
                wj[i]=new W(i,in.nextInt());
                power[i]=wj[i].power;
            }
            boolean[][] flag=new boolean[n][n];
            boolean[] mark=new boolean[n];
            for(int i=0;i<m;++i){
                int x=in.nextInt()-1;
                int y=in.nextInt()-1;
                wj[x].tag=true;
                wj[y].tag=true;
                flag[x][y]=true;
                flag[y][x]=true;
            }
            Arrays.sort(wj);
            int min = getMin(n, m, wj, flag, power);
            System.out.println(min);
        }
    }
    static int getMin(int n,int m,W[] wj,
                      boolean[][] flag,int[] power) {
        //寻找连接中最大的
        int minCost=0;
        for(int k=0;k<wj.length;++k){
            if(wj[k].tag){
                int minwj=-1;
                int minpw=Integer.MAX_VALUE;
                for(int i=0;i<n;++i){
                    if(flag[wj[k].index][i]&& minpw >power[i]){
                        minpw=power[i];
                        minwj=i;
                    }
                }
                if(minwj!=-1){
                    minCost+=power[minwj];
                    flag[wj[k].index][minwj]=false;
                    flag[minwj][wj[k].index]=false;
                }
                else {
                    wj[k].tag=false;
                }
            }
        }

        //一个个访问消去
        return minCost;
    }
}
class W implements Comparable{
    int index=-1;
    int power=0;
    boolean tag=false;
    W(int i,int j){
        index=i;
        power=j;
    }

    @Override
    public int compareTo(Object o) {
        if(power<((W)o).power )
        {
            return 1;
        }
        return -1;
    }
}
/*4 3
10 20 30 40
        1 4
        1 2
        2 3*/
