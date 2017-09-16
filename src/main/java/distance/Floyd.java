package distance;

import java.util.List;

public class Floyd {

    public static void main(String[] args) {
        int[][] edge={{0,9,4},{9,0,4},{4,4,0}};
        int[][] mPath=new int[edge.length][edge.length];
        for(int i=0;i<mPath.length;++i){
            for (int j=0;j<mPath.length;++j){
                mPath[i][j]=i;//初始化为到自己
            }
        }
        floy(edge,mPath);
        System.out.println(edge[0][1]);
        System.out.println(getPath(mPath[0],0,1));
    }
    /**
     * 以k为中间点来求距离的动态规划方法，k=0,1,..,n
     * 记录path，以两点之间中间点来记录。mPath开始时要初始化
     */
    public static void floy(int[][] edge,int[][] mPath){
        //中间点
        for(int k=0;k<edge.length;++k){
            //以中间点k来找最短距离
            for(int i=0;i<edge.length;++i){
                for (int j=0;j<edge.length;++j){
                    if(edge[i][j]> edge[i][k]+edge[k][j]){
                        edge[i][j]=edge[i][k]+edge[k][j];
                        //记录路径
                        mPath[i][j]=mPath[k][j];
                    }
                }
            }
        }
    }
    public static String getPath(int[] path,int start,int end){
        StringBuilder sb=new StringBuilder();
        int mid=end;
        while(mid!=start){
            sb.insert(0,mid+",");
            mid=path[mid];
        }
        return sb.substring(0, sb.length() - 1);
    }
}
