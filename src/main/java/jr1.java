import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class jr1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num=in.nextInt();
            List<int[]> listarr=new ArrayList<>();
            for(int i=0;i<num;++i){
                int[] point=new int[2];
                point[0]=in.nextInt();
                point[1]=in.nextInt();
                listarr.add(point);
            }

            List<int[]> maxlist=new ArrayList<>();
            for(int i=0;i<num;++i){
                int flag=0;
                for(int j=0;j<num;++j){
                    if(listarr.get(i)[0]<listarr.get(j)[0]&& listarr.get(i)[1]<listarr.get(j)[1]){
                       flag=1;
                    }
                }
                if(flag==0){
                    maxlist.add(listarr.get(i));
                }
            }
            for(int i=0;i<maxlist.size();){
//                System.out.println("size:"+maxlist.size());
                int index=0;
                int x=maxlist.get(0)[0];
                for(int j=0;j<maxlist.size();++j){
                    if(maxlist.get(j)[0]<x){
                        index=j;
                    }
                }
                System.out.println(maxlist.get(index)[0]+" "+maxlist.get(index)[1]);
                maxlist.remove(index);
            }
//            System.out.println(maxlist.get(0)[0]+" "+maxlist.get(0)[1]);
            //System.out.println(Arrays.toString(listarr.toArray()));
        }
    }
}
