package xunfei;

import java.util.Scanner;
/**
 * 相当于括号消除
 * )(()()
 */

public class TiOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s=in.next();
            System.out.println(getLeast(s));
        }
    }
    static int getLeast(String s){
        int rNum=0;
        int least=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='R'){
                ++rNum;
                ++least;
            }else
            if(s.charAt(i)=='L'){
                if(rNum>=2){
                    least-=rNum-1;
                    rNum=1;
                }
                else if(rNum==1){

                }
                else if(rNum<=0){
                    ++least;
                }
            }

        }
        return least;
    }
}
