package xiaomi;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1=in.next();
            String pa=in.next();
            int[] re=sMatch(s1,pa);
            if(re[0]==-1){
                System.out.println("-1 -1");
            }else {
                System.out.println(re[0]+" "+re[pa.length()-1]);
            }
        }
    }
    static int[] sMatch(String s1,String pa){
        int[] re=new int[pa.length()];
        int pre=0;
        boolean flag=false;
        for(int i=0;i<pa.length();++i){
            for(int j=pre;j<s1.length();++j){
                if(pa.charAt(i)==s1.charAt(j)){
                    re[i]=j;
                    flag=true;
                }
            }
            if(flag==false){
               return new int[]{-1};
            }
            pre=re[i]+1;
        }
        return re;
    }
}
