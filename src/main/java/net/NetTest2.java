package net;

import java.util.*;

public class NetTest2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //思路移动一个左括号，和一个右括号，这样得到的子序列为差一个的。
        //将其加入set中，计数个数
        while (in.hasNext()) {
            String s=in.next();
            Set<String> set=new HashSet<>();
            getSet(set,s);
            //System.out.println(Arrays.toString(set.toArray()));
            System.out.println(set.size()-1);
        }
    }
    static void getSet(Set<String> set,String s){
        int n=0;
        //先这个把字符取出来
        for(int p=0;p<s.length();++p){
            String w=s.substring(0,p)+s.substring(p+1,s.length());
            for(int i=0;i<w.length();++i){
                String u=w.substring(0,i)+s.substring(p,p+1)+w.substring(i,w.length());
                //验证是否是有效的
                int t=0;
                for(int j=0;j<u.length();++j){
                    if(u.charAt(j)=='('){
                        ++t;
                    }else {
                        --t;
                        if(t<0){
                            break;
                        }
                    }
                }
                if(t>=0){
                    set.add(u);
                }
            }
        }
    }
}
