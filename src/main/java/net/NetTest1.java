package net;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * n个地点以树状方式连接起来，l为步数
 * parent[i]是i+1节点的父结点
 */
class TNode{
    int me;
    int left=-1;
    int right=-1;
}
public class NetTest1 {
    static int mNum=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            mNum=0;
            int cityNum=in.nextInt();
            int l=in.nextInt();
            int[] parent=new int[cityNum-1];
            for(int i=0;i<parent.length;++i){
                parent[i]=in.nextInt();
            }
            TNode[] tree=new TNode[cityNum];
            for(int i=0;i<tree.length;++i){
                tree[i]=new TNode();
                tree[i].me=i;
            }
            knowChild(tree,cityNum,parent);
            Boolean[] flag=new Boolean[cityNum];
            for(int i=0;i<flag.length;++i){
                flag[i]=false;
            }
            getRoute(tree,0,l,flag);
            System.out.println(mNum);
        }
    }
    static void knowChild(TNode[] tree,int cityNum,int[] parent){
        for(int i=0;i<cityNum;++i){
            for(int j=0;j<parent.length;++j){
                if(tree[i].me==parent[j]){
                    if(tree[i].left==-1){
                       tree[i].left=j+1;
                    }else {
                        tree[i].right=j+1;
                    }
                }
            }
        }
    }

    static void getRoute(TNode[] tree,int start,int l,Boolean[] flag){
        if(l<=0){
            int tn=getTrueCount(flag);
            if(mNum<tn){
                mNum=tn;
            }
            return ;
        }
        if(tree[start].left!=-1){
            flag[tree[start].left]=true;
            --l;
            getRoute(tree,tree[start].left,l,flag);
            ++l;
            flag[tree[start].left]=false;
        }
        if(tree[start].right!=-1){
            flag[tree[start].right]=true;
            --l;
            getRoute(tree,tree[start].right,l,flag);
            ++l;
            flag[tree[start].right]=false;
        }
    }
    static int getTrueCount(Boolean[] flag){
        int n=0;
        for(int i=0;i<flag.length;++i){
            if(flag[i]){
                ++n;
            }
        }
        return n;
    }
}
