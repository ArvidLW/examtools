import java.util.Scanner;

public class Sougou2
{
    static double max=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            max=0;
            int n=in.nextInt();
            double[] data=new double[n];
            for(int i=0;i<n;++i){
                data[i]=Double.parseDouble(in.next());
            }
            maxDis(data);
            System.out.printf("%.8f%n",max);
        }
    }
    public static int findPos(double[] data){
        int p=0;
        for(int i=0;i<data.length;++i){
            double m=data[i]-data[0];
            if(data[i]-data[0]>180.0){
                break;
            }
            if(m>=max){
                max=m;
                p=i;
            }
        }
        return p;
    }
    public static void maxDis(double[] data){
        int p=findPos(data);
        for(int i=0;i<data.length;++i){
            for(int j=p+i;j<data.length;++j){
                double tmp=data[j]-data[i];
                if(tmp>=max){
                    if(tmp<=180.0){
                        max=tmp;
                    }
                    else if(max<=360.0-tmp){
                        max=360.0-tmp;
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
}