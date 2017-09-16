import distance.ShortestRoute;
import org.junit.Test;

import java.util.Arrays;

public class ShortestRouteTest {
    static ShortestRoute shortestRoute= new ShortestRoute();
    static int[][] arr=new int[][]{
            {0,5,1000,1000},
            {50,0,15,5},
            {30,1000,0,15},
            {15,1000,5,0}
    };
    @Test
    public void floydTest(){
        shortestRoute.floyd(arr);
        for(int i=0;i<arr.length;++i){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
