package net;

import java.util.Arrays;
import java.util.Scanner;

public class MagicCity {
    private static int maxNum=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            maxNum=0;
            int nc=in.nextInt();
            int time=in.nextInt();
            int[] parent=new int[nc];
            parent[0]=0;
            for(int i=1;i<parent.length;++i){
                parent[i]=in.nextInt();
            }
            Node[] link=new Node[nc];
            for(int i=0;i<link.length;++i){
                link[i]=new Node();
            }
            getTree(link,parent);
            boolean[] flag=new boolean[nc];
            visited(link,time,0,flag);
            System.out.println(maxNum);
        }
    }
    static void visited(Node[] link,int time,int start,boolean[] flag){
        boolean[] nflag= Arrays.copyOf(flag,flag.length);
        if(start!=-1){
            nflag[start]=true;
        }
        if(time==0||start==-1){
            int m=getMaxNum(nflag);
            if(maxNum<m){
                maxNum=m;
            }
            return;
        }
        time=time-1;
        visited(link,time,link[start].parent,nflag);
        visited(link,time,link[start].conn1,nflag);
        visited(link,time,link[start].conn2,nflag);
    }
    static void getTree(Node[] link,int[] parent){
        //这里有问题
        for(int i=1;i<parent.length;++i){
            link[i].parent=parent[i];
            if(link[parent[i]].conn1==-1){
                link[parent[i]].conn1=i;
            }else {
                link[parent[i]].conn2=i;
            }
        }
    }
    static int getMaxNum(boolean[] flag){
        int n=0;
        for(int i=0;i<flag.length;++i){
            if(flag[i]){
                ++n;
            }
        }
        return n;
    }
}
class Node{
    int parent=-1;
    int conn1=-1;
    int conn2=-1;
}
