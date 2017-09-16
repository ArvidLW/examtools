package distance;

public class ShortestRoute {
    /**
     * floyd算法，经典动态规划思想。
     * 求任意两点之间最短距离.
     * 算法复杂度o(n^3).
     * 一个点到另一个点的最短距离，是这个点通过其它中间点到这个点的最短距离。
     * 数组中若节点到节点是不可达到则距离是无穷大。
     * @param arr
     */
    public void floyd(int[][] arr){
        //以第k个点为中间点，求任意两点的最短。这当所有k取完后就求出了最短距离。
        //不能把k放在里面，因为没有完全利用图的信息，而只是利用那时一行一列的信息，所以求的值是不准确的。
        for(int k=0;k<arr.length;++k){
            for(int i=0;i<arr.length;++i){
                for(int j=0;j<arr[0].length;++j){
                    if(arr[i][j]>arr[i][k]+arr[k][j]){
                        arr[i][j]=arr[i][k]+arr[k][j];
                    }
                }
            }
        }
    }

    /**
     * bellman-ford算法
     * 时间复杂度为o(n*v)
     */
    public void bellman_ford(){
        //伪代码
        /**
         * 初始化距离结构，距离数组or节点类数组的距离元素
         * intialize-single-source-dist(G,n)
         * 循环vNum-1次，因为源点到任意点的距离最多经过vNum-1条边，每循环一次则从源点向下扩展一层边。
         * for(int i=1;i< vNum,++i){
         *    //松驰边，更新dist,找到距离,即循环每条边
         *    Relax(u,v,w);
         * }
         * 检查是否有负环路
         * for(int i=0;i<eNum;++i){
         * 每条边有起点u,和终点v
         *    if(dist[v]>dist[u]+w(u,v)){
         *      return flase;
         *    }
         *  return ture;
         * }
         */

    }

    /**
     * dijkstra算法
     * 时间复杂度n^2
     * 用堆优化后为nlog2n
     * n个节点，源点每次选一个最近的节点，所以要选n次，每选一次要从节点中选一个近的所以要比较n次，所以为n^2
     * 若把选择最短的用二叉堆优化则，调整堆要log2(n),有更新了的新距离个数x要调整，所以为xlog2(n)，而总更新数为边的个数，所以为mlog2(n)
     * 故算法总时间复杂度(m+n)log2(n)
     */
    public void dijkstra(){
        /**
         * initialize-single-source-dist(G,s)
         * S=lis(empty);
         * Q=list(v);
         * while(Q!=empty){
         *   u=select-minDist(q);
         *   S=u add in S;
         *   for each v in Q
         *      relax(u,v,w);
         * }
         */

    }
}
