package distance;

class CalResult {
    int[] dist;
    int[] pre;
    String[] path;

    CalResult(int[] dist, int[] pre, String[] path) {
        this.dist = dist;
        this.pre = pre;
        this.path = path;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        int[][] edge = {{0, 9, 4}, {9, 0, 4}, {4, 4, 0}};
        CalResult calRe = dijs(edge, 0);
        System.out.println(calRe.dist[1]);
        System.out.println(calRe.path[1]);
    }

    public static CalResult dijs(int[][] edge, int start) {
        int n = edge.length;
        //建立三个数组，距离，前驱与访问标记
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] pre = new int[n];//可有可无，记录路径用
        String[] path = new String[n];//可有可无，记录路径用
        for (int i = 0; i < n; ++i) {
            visited[i] = false;
            dist[i] = edge[start][i];//写入初始距离值
            pre[i] = start;//初始前驱记录
            path[i] = start + " -> " + i;
        }
        //将起始点加入访问
        visited[start] = true;
        //要加入n-1个点
        for (int k = 0; k < n - 1; ++k) {
            //选择一个离起始点最近的加入到访问中
            int p = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if ((!visited[i]) && dist[i] < min) {
                    p = i;
                    min = dist[i];
                }
            }
            //将这个点加入访问
            visited[p] = true;
            dist[p] = min;
            //以新加入的点更新访问集到其它点的距离
            for (int i = 0; i < n; ++i) {
                if (!visited[i] && dist[p] + edge[p][i] < dist[i]) {
                    dist[i] = dist[p] + edge[p][i];
                    pre[i] = p;
                    path[i] = path[p] + " -> " + i;
                }
            }
        }
        //返回距离和前驱二维数组。
        return new CalResult(dist, pre, path);
    }
}
