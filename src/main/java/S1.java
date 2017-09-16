import java.util.*;

public class S1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int[] pen=new int[2];
            int[] counts=new int[4];
            int[] prices=new int[3];
            pen[0]=in.nextInt();
            pen[1]=in.nextInt();
            for(int i=0;i<counts.length;++i){
                counts[i]=in.nextInt();
            }
            for(int i=0;i<prices.length;++i){
                prices[i]=in.nextInt();
            }
            int total=getMaxMoney(pen,counts,prices);
            System.out.println(total);
        }
    }
    public static int[] getMaxList(int[] p){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<p.length;++i){
            list.add(p[i]);
        }
        int[] x=new int[3];
        int j=0;
        while(list.size()>0){
            int k=0;
            for(int i=0;i<list.size();++i){
                if(list.get(k)<list.get(i)){
                    k=i;
                }
            }
            x[j++]=k;
            list.remove(k);
        }
        return x;
    }
    public static int findMaxPrice(int[] p){
        int k=0;
        for (int i=0;i<p.length;++i){
            if(p[k]<p[i]){
                k=i;
            }
        }
        return k;
    }
    public static int getMaxMoney(int[] pen,int[] counts, int[] prices){
        int flag=1;
        int total=0;
//        int[] list=getMaxList(prices);
        int[] list=new int[]{2,0,1};
        int i=0;
        while (flag==1){
            flag=0;
            int first=list[i++];

            if(first==0){
                while(pen[0]>=counts[0]&&pen[1]>=counts[1]){
                    pen[0]-=counts[0];
                    pen[1]-=counts[1];
                    total+=prices[0];
                    flag=1;
                }
            }else if (first==1&&pen[0]>=counts[2]){
                int b=pen[0]/counts[2];
                pen[0]=pen[0]-counts[2]*b;
                total+=b*prices[1];
            }else if(pen[1]>=counts[3]) {
                int b=pen[1]/counts[3];
                pen[1]=pen[1]-counts[3]*b;
                total+=b*prices[2];
                flag=1;
            }
        }
        return total;
    }
}
