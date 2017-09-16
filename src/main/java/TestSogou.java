import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSogou
{
    static double max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg=null;
        while ((msg=br.readLine())!=null) {
            max=0;
            int n=Integer.parseInt(msg);
            double[] data=new double[n];
            for(int i=0;i<n;++i){
                data[i]=Double.parseDouble(br.readLine());
            }
            maxDis(data);
            System.out.printf("%.8f%n",max);
        }
    }
    public static int findPos(double[] data){
        int p=0;
        for(int i=0;i<data.length;++i){
            double m=data[i]-data[0];
            if(data[i]-data[0]>180){
                break;
            }
            if(m>max){
                max=m;
                p=i;
            }
        }
        return p;
    }
    public static void maxDis(double[] data){
        int p=findPos(data);
        for(int i=1;i<data.length;++i){
            for(int j=p+1;j<data.length;++j){
                double tmp=data[j]-data[i];
                if(tmp>max && tmp<=180){
                    max=tmp;
                }
            }
        }
    }
}