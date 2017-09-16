import java.util.Random;

public class Tools {
    public static int[] geneArr(int n){
        int[] arr=new int[n];
        for (int i=0;i<n;++i){
            arr[i]= new Double(Math.random()*1e8).intValue();
//            arr[i]= (int)(Math.random()*1e6);
        }
        return arr;
    }
}
